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

package com.liferay.change.tracking.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.change.tracking.model.CTEntryAggregate;
import com.liferay.change.tracking.model.CTEntryAggregateModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.petra.string.StringBundler;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the CTEntryAggregate service. Represents a row in the &quot;CTEntryAggregate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>CTEntryAggregateModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CTEntryAggregateImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CTEntryAggregateImpl
 * @generated
 */
@ProviderType
public class CTEntryAggregateModelImpl extends BaseModelImpl<CTEntryAggregate>
	implements CTEntryAggregateModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ct entry aggregate model instance should use the <code>CTEntryAggregate</code> interface instead.
	 */
	public static final String TABLE_NAME = "CTEntryAggregate";
	public static final Object[][] TABLE_COLUMNS = {
			{ "ctEntryAggregateId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "ctCollectionId", Types.BIGINT },
			{ "ownerCTEntryId", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("ctEntryAggregateId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("ctCollectionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ownerCTEntryId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table CTEntryAggregate (ctEntryAggregateId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,ctCollectionId LONG,ownerCTEntryId LONG)";
	public static final String TABLE_SQL_DROP = "drop table CTEntryAggregate";
	public static final String ORDER_BY_JPQL = " ORDER BY ctEntryAggregate.ctEntryAggregateId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY CTEntryAggregate.ctEntryAggregateId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.change.tracking.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.change.tracking.model.CTEntryAggregate"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.change.tracking.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.change.tracking.model.CTEntryAggregate"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.change.tracking.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.change.tracking.model.CTEntryAggregate"),
			true);
	public static final long CTCOLLECTIONID_COLUMN_BITMASK = 1L;
	public static final long OWNERCTENTRYID_COLUMN_BITMASK = 2L;
	public static final long CTENTRYAGGREGATEID_COLUMN_BITMASK = 4L;
	public static final String MAPPING_TABLE_CTENTRYAGGREGATES_CTENTRIES_NAME = "CTEntryAggregates_CTEntries";
	public static final Object[][] MAPPING_TABLE_CTENTRYAGGREGATES_CTENTRIES_COLUMNS =
		{
			{ "companyId", Types.BIGINT },
			{ "ctEntryId", Types.BIGINT },
			{ "ctEntryAggregateId", Types.BIGINT }
		};
	public static final String MAPPING_TABLE_CTENTRYAGGREGATES_CTENTRIES_SQL_CREATE =
		"create table CTEntryAggregates_CTEntries (companyId LONG not null,ctEntryId LONG not null,ctEntryAggregateId LONG not null,primary key (ctEntryId, ctEntryAggregateId))";
	public static final boolean FINDER_CACHE_ENABLED_CTENTRYAGGREGATES_CTENTRIES =
		GetterUtil.getBoolean(com.liferay.change.tracking.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.CTEntryAggregates_CTEntries"),
			true);
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.change.tracking.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.change.tracking.model.CTEntryAggregate"));

	public CTEntryAggregateModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _ctEntryAggregateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCtEntryAggregateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ctEntryAggregateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CTEntryAggregate.class;
	}

	@Override
	public String getModelClassName() {
		return CTEntryAggregate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CTEntryAggregate, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CTEntryAggregate, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<CTEntryAggregate, Object> attributeGetterFunction = entry.getValue();

			attributes.put(attributeName,
				attributeGetterFunction.apply((CTEntryAggregate)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CTEntryAggregate, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CTEntryAggregate, Object> attributeSetterBiConsumer = attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((CTEntryAggregate)this,
					entry.getValue());
			}
		}
	}

	public Map<String, Function<CTEntryAggregate, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CTEntryAggregate, Object>> getAttributeSetterBiConsumers() {
		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<CTEntryAggregate, Object>> _attributeGetterFunctions;
	private static final Map<String, BiConsumer<CTEntryAggregate, Object>> _attributeSetterBiConsumers;

	static {
		Map<String, Function<CTEntryAggregate, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<CTEntryAggregate, Object>>();
		Map<String, BiConsumer<CTEntryAggregate, ?>> attributeSetterBiConsumers = new LinkedHashMap<String, BiConsumer<CTEntryAggregate, ?>>();


		attributeGetterFunctions.put("ctEntryAggregateId", CTEntryAggregate::getCtEntryAggregateId);
		attributeSetterBiConsumers.put("ctEntryAggregateId", (BiConsumer<CTEntryAggregate, Long>)CTEntryAggregate::setCtEntryAggregateId);
		attributeGetterFunctions.put("companyId", CTEntryAggregate::getCompanyId);
		attributeSetterBiConsumers.put("companyId", (BiConsumer<CTEntryAggregate, Long>)CTEntryAggregate::setCompanyId);
		attributeGetterFunctions.put("userId", CTEntryAggregate::getUserId);
		attributeSetterBiConsumers.put("userId", (BiConsumer<CTEntryAggregate, Long>)CTEntryAggregate::setUserId);
		attributeGetterFunctions.put("userName", CTEntryAggregate::getUserName);
		attributeSetterBiConsumers.put("userName", (BiConsumer<CTEntryAggregate, String>)CTEntryAggregate::setUserName);
		attributeGetterFunctions.put("createDate", CTEntryAggregate::getCreateDate);
		attributeSetterBiConsumers.put("createDate", (BiConsumer<CTEntryAggregate, Date>)CTEntryAggregate::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", CTEntryAggregate::getModifiedDate);
		attributeSetterBiConsumers.put("modifiedDate", (BiConsumer<CTEntryAggregate, Date>)CTEntryAggregate::setModifiedDate);
		attributeGetterFunctions.put("ctCollectionId", CTEntryAggregate::getCtCollectionId);
		attributeSetterBiConsumers.put("ctCollectionId", (BiConsumer<CTEntryAggregate, Long>)CTEntryAggregate::setCtCollectionId);
		attributeGetterFunctions.put("ownerCTEntryId", CTEntryAggregate::getOwnerCTEntryId);
		attributeSetterBiConsumers.put("ownerCTEntryId", (BiConsumer<CTEntryAggregate, Long>)CTEntryAggregate::setOwnerCTEntryId);


		_attributeGetterFunctions = Collections.unmodifiableMap(attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap((Map)attributeSetterBiConsumers);
	}

	@Override
	public long getCtEntryAggregateId() {
		return _ctEntryAggregateId;
	}

	@Override
	public void setCtEntryAggregateId(long ctEntryAggregateId) {
		_ctEntryAggregateId = ctEntryAggregateId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public long getCtCollectionId() {
		return _ctCollectionId;
	}

	@Override
	public void setCtCollectionId(long ctCollectionId) {
		_columnBitmask |= CTCOLLECTIONID_COLUMN_BITMASK;

		if (!_setOriginalCtCollectionId) {
			_setOriginalCtCollectionId = true;

			_originalCtCollectionId = _ctCollectionId;
		}

		_ctCollectionId = ctCollectionId;
	}

	public long getOriginalCtCollectionId() {
		return _originalCtCollectionId;
	}

	@Override
	public long getOwnerCTEntryId() {
		return _ownerCTEntryId;
	}

	@Override
	public void setOwnerCTEntryId(long ownerCTEntryId) {
		_columnBitmask |= OWNERCTENTRYID_COLUMN_BITMASK;

		if (!_setOriginalOwnerCTEntryId) {
			_setOriginalOwnerCTEntryId = true;

			_originalOwnerCTEntryId = _ownerCTEntryId;
		}

		_ownerCTEntryId = ownerCTEntryId;
	}

	public long getOriginalOwnerCTEntryId() {
		return _originalOwnerCTEntryId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			CTEntryAggregate.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CTEntryAggregate toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CTEntryAggregate)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CTEntryAggregateImpl ctEntryAggregateImpl = new CTEntryAggregateImpl();

		ctEntryAggregateImpl.setCtEntryAggregateId(getCtEntryAggregateId());
		ctEntryAggregateImpl.setCompanyId(getCompanyId());
		ctEntryAggregateImpl.setUserId(getUserId());
		ctEntryAggregateImpl.setUserName(getUserName());
		ctEntryAggregateImpl.setCreateDate(getCreateDate());
		ctEntryAggregateImpl.setModifiedDate(getModifiedDate());
		ctEntryAggregateImpl.setCtCollectionId(getCtCollectionId());
		ctEntryAggregateImpl.setOwnerCTEntryId(getOwnerCTEntryId());

		ctEntryAggregateImpl.resetOriginalValues();

		return ctEntryAggregateImpl;
	}

	@Override
	public int compareTo(CTEntryAggregate ctEntryAggregate) {
		long primaryKey = ctEntryAggregate.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CTEntryAggregate)) {
			return false;
		}

		CTEntryAggregate ctEntryAggregate = (CTEntryAggregate)obj;

		long primaryKey = ctEntryAggregate.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		CTEntryAggregateModelImpl ctEntryAggregateModelImpl = this;

		ctEntryAggregateModelImpl._setModifiedDate = false;

		ctEntryAggregateModelImpl._originalCtCollectionId = ctEntryAggregateModelImpl._ctCollectionId;

		ctEntryAggregateModelImpl._setOriginalCtCollectionId = false;

		ctEntryAggregateModelImpl._originalOwnerCTEntryId = ctEntryAggregateModelImpl._ownerCTEntryId;

		ctEntryAggregateModelImpl._setOriginalOwnerCTEntryId = false;

		ctEntryAggregateModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CTEntryAggregate> toCacheModel() {
		CTEntryAggregateCacheModel ctEntryAggregateCacheModel = new CTEntryAggregateCacheModel();

		ctEntryAggregateCacheModel.ctEntryAggregateId = getCtEntryAggregateId();

		ctEntryAggregateCacheModel.companyId = getCompanyId();

		ctEntryAggregateCacheModel.userId = getUserId();

		ctEntryAggregateCacheModel.userName = getUserName();

		String userName = ctEntryAggregateCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			ctEntryAggregateCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			ctEntryAggregateCacheModel.createDate = createDate.getTime();
		}
		else {
			ctEntryAggregateCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			ctEntryAggregateCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			ctEntryAggregateCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		ctEntryAggregateCacheModel.ctCollectionId = getCtCollectionId();

		ctEntryAggregateCacheModel.ownerCTEntryId = getOwnerCTEntryId();

		return ctEntryAggregateCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CTEntryAggregate, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler((4 * attributeGetterFunctions.size()) +
				2);

		sb.append("{");

		for (Map.Entry<String, Function<CTEntryAggregate, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<CTEntryAggregate, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((CTEntryAggregate)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<CTEntryAggregate, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler((5 * attributeGetterFunctions.size()) +
				4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CTEntryAggregate, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<CTEntryAggregate, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CTEntryAggregate)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = CTEntryAggregate.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			CTEntryAggregate.class, ModelWrapper.class
		};
	private long _ctEntryAggregateId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _ctCollectionId;
	private long _originalCtCollectionId;
	private boolean _setOriginalCtCollectionId;
	private long _ownerCTEntryId;
	private long _originalOwnerCTEntryId;
	private boolean _setOriginalOwnerCTEntryId;
	private long _columnBitmask;
	private CTEntryAggregate _escapedModel;
}