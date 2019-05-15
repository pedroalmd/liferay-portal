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

package com.liferay.commerce.shipping.engine.fixed.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

/**
 * The base model interface for the CommerceShippingFixedOptionRel service. Represents a row in the &quot;CShippingFixedOptionRel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.commerce.shipping.engine.fixed.model.impl.CommerceShippingFixedOptionRelModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.commerce.shipping.engine.fixed.model.impl.CommerceShippingFixedOptionRelImpl</code>.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommerceShippingFixedOptionRel
 * @generated
 */
@ProviderType
public interface CommerceShippingFixedOptionRelModel
	extends BaseModel<CommerceShippingFixedOptionRel>, GroupedModel,
			ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a commerce shipping fixed option rel model instance should use the {@link CommerceShippingFixedOptionRel} interface instead.
	 */

	/**
	 * Returns the primary key of this commerce shipping fixed option rel.
	 *
	 * @return the primary key of this commerce shipping fixed option rel
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this commerce shipping fixed option rel.
	 *
	 * @param primaryKey the primary key of this commerce shipping fixed option rel
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the commerce shipping fixed option rel ID of this commerce shipping fixed option rel.
	 *
	 * @return the commerce shipping fixed option rel ID of this commerce shipping fixed option rel
	 */
	public long getCommerceShippingFixedOptionRelId();

	/**
	 * Sets the commerce shipping fixed option rel ID of this commerce shipping fixed option rel.
	 *
	 * @param commerceShippingFixedOptionRelId the commerce shipping fixed option rel ID of this commerce shipping fixed option rel
	 */
	public void setCommerceShippingFixedOptionRelId(
		long commerceShippingFixedOptionRelId);

	/**
	 * Returns the group ID of this commerce shipping fixed option rel.
	 *
	 * @return the group ID of this commerce shipping fixed option rel
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this commerce shipping fixed option rel.
	 *
	 * @param groupId the group ID of this commerce shipping fixed option rel
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this commerce shipping fixed option rel.
	 *
	 * @return the company ID of this commerce shipping fixed option rel
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this commerce shipping fixed option rel.
	 *
	 * @param companyId the company ID of this commerce shipping fixed option rel
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this commerce shipping fixed option rel.
	 *
	 * @return the user ID of this commerce shipping fixed option rel
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this commerce shipping fixed option rel.
	 *
	 * @param userId the user ID of this commerce shipping fixed option rel
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this commerce shipping fixed option rel.
	 *
	 * @return the user uuid of this commerce shipping fixed option rel
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this commerce shipping fixed option rel.
	 *
	 * @param userUuid the user uuid of this commerce shipping fixed option rel
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this commerce shipping fixed option rel.
	 *
	 * @return the user name of this commerce shipping fixed option rel
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this commerce shipping fixed option rel.
	 *
	 * @param userName the user name of this commerce shipping fixed option rel
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this commerce shipping fixed option rel.
	 *
	 * @return the create date of this commerce shipping fixed option rel
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this commerce shipping fixed option rel.
	 *
	 * @param createDate the create date of this commerce shipping fixed option rel
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this commerce shipping fixed option rel.
	 *
	 * @return the modified date of this commerce shipping fixed option rel
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this commerce shipping fixed option rel.
	 *
	 * @param modifiedDate the modified date of this commerce shipping fixed option rel
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the commerce shipping method ID of this commerce shipping fixed option rel.
	 *
	 * @return the commerce shipping method ID of this commerce shipping fixed option rel
	 */
	public long getCommerceShippingMethodId();

	/**
	 * Sets the commerce shipping method ID of this commerce shipping fixed option rel.
	 *
	 * @param commerceShippingMethodId the commerce shipping method ID of this commerce shipping fixed option rel
	 */
	public void setCommerceShippingMethodId(long commerceShippingMethodId);

	/**
	 * Returns the commerce shipping fixed option ID of this commerce shipping fixed option rel.
	 *
	 * @return the commerce shipping fixed option ID of this commerce shipping fixed option rel
	 */
	public long getCommerceShippingFixedOptionId();

	/**
	 * Sets the commerce shipping fixed option ID of this commerce shipping fixed option rel.
	 *
	 * @param commerceShippingFixedOptionId the commerce shipping fixed option ID of this commerce shipping fixed option rel
	 */
	public void setCommerceShippingFixedOptionId(
		long commerceShippingFixedOptionId);

	/**
	 * Returns the commerce warehouse ID of this commerce shipping fixed option rel.
	 *
	 * @return the commerce warehouse ID of this commerce shipping fixed option rel
	 */
	public long getCommerceWarehouseId();

	/**
	 * Sets the commerce warehouse ID of this commerce shipping fixed option rel.
	 *
	 * @param commerceWarehouseId the commerce warehouse ID of this commerce shipping fixed option rel
	 */
	public void setCommerceWarehouseId(long commerceWarehouseId);

	/**
	 * Returns the commerce country ID of this commerce shipping fixed option rel.
	 *
	 * @return the commerce country ID of this commerce shipping fixed option rel
	 */
	public long getCommerceCountryId();

	/**
	 * Sets the commerce country ID of this commerce shipping fixed option rel.
	 *
	 * @param commerceCountryId the commerce country ID of this commerce shipping fixed option rel
	 */
	public void setCommerceCountryId(long commerceCountryId);

	/**
	 * Returns the commerce region ID of this commerce shipping fixed option rel.
	 *
	 * @return the commerce region ID of this commerce shipping fixed option rel
	 */
	public long getCommerceRegionId();

	/**
	 * Sets the commerce region ID of this commerce shipping fixed option rel.
	 *
	 * @param commerceRegionId the commerce region ID of this commerce shipping fixed option rel
	 */
	public void setCommerceRegionId(long commerceRegionId);

	/**
	 * Returns the zip of this commerce shipping fixed option rel.
	 *
	 * @return the zip of this commerce shipping fixed option rel
	 */
	@AutoEscape
	public String getZip();

	/**
	 * Sets the zip of this commerce shipping fixed option rel.
	 *
	 * @param zip the zip of this commerce shipping fixed option rel
	 */
	public void setZip(String zip);

	/**
	 * Returns the weight from of this commerce shipping fixed option rel.
	 *
	 * @return the weight from of this commerce shipping fixed option rel
	 */
	public double getWeightFrom();

	/**
	 * Sets the weight from of this commerce shipping fixed option rel.
	 *
	 * @param weightFrom the weight from of this commerce shipping fixed option rel
	 */
	public void setWeightFrom(double weightFrom);

	/**
	 * Returns the weight to of this commerce shipping fixed option rel.
	 *
	 * @return the weight to of this commerce shipping fixed option rel
	 */
	public double getWeightTo();

	/**
	 * Sets the weight to of this commerce shipping fixed option rel.
	 *
	 * @param weightTo the weight to of this commerce shipping fixed option rel
	 */
	public void setWeightTo(double weightTo);

	/**
	 * Returns the fixed price of this commerce shipping fixed option rel.
	 *
	 * @return the fixed price of this commerce shipping fixed option rel
	 */
	public BigDecimal getFixedPrice();

	/**
	 * Sets the fixed price of this commerce shipping fixed option rel.
	 *
	 * @param fixedPrice the fixed price of this commerce shipping fixed option rel
	 */
	public void setFixedPrice(BigDecimal fixedPrice);

	/**
	 * Returns the rate unit weight price of this commerce shipping fixed option rel.
	 *
	 * @return the rate unit weight price of this commerce shipping fixed option rel
	 */
	public BigDecimal getRateUnitWeightPrice();

	/**
	 * Sets the rate unit weight price of this commerce shipping fixed option rel.
	 *
	 * @param rateUnitWeightPrice the rate unit weight price of this commerce shipping fixed option rel
	 */
	public void setRateUnitWeightPrice(BigDecimal rateUnitWeightPrice);

	/**
	 * Returns the rate percentage of this commerce shipping fixed option rel.
	 *
	 * @return the rate percentage of this commerce shipping fixed option rel
	 */
	public double getRatePercentage();

	/**
	 * Sets the rate percentage of this commerce shipping fixed option rel.
	 *
	 * @param ratePercentage the rate percentage of this commerce shipping fixed option rel
	 */
	public void setRatePercentage(double ratePercentage);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		CommerceShippingFixedOptionRel commerceShippingFixedOptionRel);

	@Override
	public int hashCode();

	@Override
	public CacheModel<CommerceShippingFixedOptionRel> toCacheModel();

	@Override
	public CommerceShippingFixedOptionRel toEscapedModel();

	@Override
	public CommerceShippingFixedOptionRel toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}