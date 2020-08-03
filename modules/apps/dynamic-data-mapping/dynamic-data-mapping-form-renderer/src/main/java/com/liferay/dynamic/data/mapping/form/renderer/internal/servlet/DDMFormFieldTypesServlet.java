/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.dynamic.data.mapping.form.renderer.internal.servlet;

import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldType;
import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldTypeServicesTracker;
import com.liferay.frontend.js.loader.modules.extender.npm.NPMResolver;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.events.EventsProcessorUtil;
import com.liferay.portal.json.JSONObjectImpl;
import com.liferay.portal.kernel.editor.configuration.EditorConfiguration;
import com.liferay.portal.kernel.editor.configuration.EditorConfigurationFactoryUtil;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.util.PropsValues;

import java.io.IOException;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Matuzalem Teles
 */
@Component(
	immediate = true,
	property = {
		"osgi.http.whiteboard.context.path=/dynamic-data-mapping-form-field-types",
		"osgi.http.whiteboard.servlet.name=com.liferay.dynamic.data.mapping.form.renderer.internal.servlet.DDMFormFieldTypesServlet",
		"osgi.http.whiteboard.servlet.pattern=/dynamic-data-mapping-form-field-types/*"
	},
	service = Servlet.class
)
public class DDMFormFieldTypesServlet extends HttpServlet {

	@Override
	public void service(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws IOException, ServletException {

		createContext(httpServletRequest, httpServletResponse);

		super.service(httpServletRequest, httpServletResponse);
	}

	protected void createContext(
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse) {

		try {
			EventsProcessorUtil.process(
				PropsKeys.SERVLET_SERVICE_EVENTS_PRE,
				PropsValues.SERVLET_SERVICE_EVENTS_PRE, httpServletRequest,
				httpServletResponse);
		}
		catch (ActionException actionException) {
			if (_log.isDebugEnabled()) {
				_log.debug(actionException, actionException);
			}
		}
	}

	@Override
	protected void doGet(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws IOException {

		JSONArray fieldTypesJSONArray = _jsonFactory.createJSONArray();

		Set<String> ddmFormFieldTypeNames =
			_ddmFormFieldTypeServicesTracker.getDDMFormFieldTypeNames();

		Stream<String> stream = ddmFormFieldTypeNames.stream();

		stream.map(
			ddmFormFieldTypeName -> getFieldTypeMetadataJSONObject(
				ddmFormFieldTypeName,
				getFieldConfiguration(ddmFormFieldTypeName, httpServletRequest))
		).forEach(
			fieldTypesJSONArray::put
		);

		httpServletResponse.setContentType(ContentTypes.APPLICATION_JSON);
		httpServletResponse.setStatus(HttpServletResponse.SC_OK);

		ServletResponseUtil.write(
			httpServletResponse, fieldTypesJSONArray.toJSONString());
	}

	protected Map<String, Object> getFieldConfiguration(
		String ddmFormFieldName, HttpServletRequest httpServletRequest) {

		if (StringUtil.equals(ddmFormFieldName, "rich_text")) {
			EditorConfiguration richTextEditorConfiguration =
				EditorConfigurationFactoryUtil.getEditorConfiguration(
					StringPool.BLANK, ddmFormFieldName, "ckeditor_classic",
					Collections.emptyMap(),
					(ThemeDisplay)httpServletRequest.getAttribute(
						WebKeys.THEME_DISPLAY),
					RequestBackedPortletURLFactoryUtil.create(
						httpServletRequest));

			return richTextEditorConfiguration.getData();
		}

		return Collections.emptyMap();
	}

	protected JSONObject getFieldTypeMetadataJSONObject(
		String ddmFormFieldName, Map<String, Object> configuration) {

		JSONObject jsonObject = new JSONObjectImpl();

		if (!configuration.isEmpty()) {
			jsonObject.put("configuration", configuration);
		}

		return jsonObject.put(
			"javaScriptModule",
			resolveModuleName(
				_ddmFormFieldTypeServicesTracker.getDDMFormFieldType(
					ddmFormFieldName))
		).put(
			"name", ddmFormFieldName
		);
	}

	protected String resolveModuleName(DDMFormFieldType ddmFormFieldType) {
		if (Validator.isNull(ddmFormFieldType.getModuleName())) {
			return StringPool.BLANK;
		}

		if (ddmFormFieldType.isCustomDDMFormFieldType()) {
			return ddmFormFieldType.getModuleName();
		}

		return npmResolver.resolveModuleName(ddmFormFieldType.getModuleName());
	}

	@Reference
	protected NPMResolver npmResolver;

	private static final Log _log = LogFactoryUtil.getLog(
		DDMFormFieldTypesServlet.class);

	@Reference
	private DDMFormFieldTypeServicesTracker _ddmFormFieldTypeServicesTracker;

	@Reference
	private JSONFactory _jsonFactory;

}