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

package com.liferay.data.engine.rest.internal.dto.v1_0.util;

import com.liferay.data.engine.rest.dto.v1_0.DataDefinition;
import com.liferay.data.engine.rest.dto.v1_0.DataDefinitionField;
import com.liferay.data.engine.rest.dto.v1_0.LocalizedValue;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Jeyvison Nascimento
 */
public class DataDefinitionDeserializer {

	public static DataDefinition toDataDefinition(String json) throws Exception {
		return new DataDefinition() {
			{
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject(
					json);

				dataDefinitionFields = _toDataDefinitionFields(
					jsonObject.getJSONArray("fields"));
			}
		};
	}

	private static DataDefinitionField _toDataDefinitionField(JSONObject jsonObject)
		throws Exception {

		List<LocalizedValue> labels = new ArrayList<>();

		if (jsonObject.has("label")) {
			JSONObject labelJSONObject = jsonObject.getJSONObject("label");

			if (labelJSONObject == null) {
				throw new Exception(
					"Label property must contain localized values");
			}

			Iterator<String> keys = labelJSONObject.keys();

			while (keys.hasNext()) {
				String key = keys.next();

				LocalizedValue localizedValue = new LocalizedValue();

				localizedValue.setKey(key);
				localizedValue.setValue(labelJSONObject.getString(key));

				labels.add(localizedValue);
			}
		}

		if (!jsonObject.has("name")) {
			throw new Exception("Name property is required");
		}

		if (!jsonObject.has("type")) {
			throw new Exception("Type property is required");
		}

		List<LocalizedValue> tips = new ArrayList<>();

		if (jsonObject.has("tip")) {
			JSONObject tipJSONObject = jsonObject.getJSONObject("tip");

			if (tipJSONObject == null) {
				throw new Exception(
					"Tip property must contain localized values");
			}

			Iterator<String> keys = tipJSONObject.keys();

			while (keys.hasNext()) {
				String key = keys.next();

				LocalizedValue localizedValue = new LocalizedValue();

				localizedValue.setKey(key);
				localizedValue.setValue(tipJSONObject.getString(key));

				tips.add(localizedValue);
			}
		}

		return new DataDefinitionField() {
			{
				defaultValue = jsonObject.getString("defaultValue");
				fieldType = jsonObject.getString("type");
				indexable = jsonObject.getBoolean("indexable", true);
				label = labels.toArray(new LocalizedValue[0]);
				localizable = jsonObject.getBoolean("localizable", false);
				name = jsonObject.getString("name");
				repeatable = jsonObject.getBoolean("repeatable", false);
				tip = tips.toArray(new LocalizedValue[0]);
			}
		};
	}

	private static DataDefinitionField[] _toDataDefinitionFields(JSONArray jsonArray)
		throws Exception {

		List<DataDefinitionField> dataDefinitionFields = new ArrayList<>(
			jsonArray.length());

		for (int i = 0; i < jsonArray.length(); i++) {
			DataDefinitionField dataDefinitionField = _toDataDefinitionField(
				jsonArray.getJSONObject(i));

			dataDefinitionFields.add(dataDefinitionField);
		}

		return dataDefinitionFields.toArray(new DataDefinitionField[0]);
	}

}