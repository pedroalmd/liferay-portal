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

package com.liferay.commerce.discount.service.base;

import com.liferay.commerce.discount.model.CommerceDiscountRule;
import com.liferay.commerce.discount.service.CommerceDiscountRuleService;
import com.liferay.commerce.discount.service.persistence.CommerceDiscountPersistence;
import com.liferay.commerce.discount.service.persistence.CommerceDiscountRelPersistence;
import com.liferay.commerce.discount.service.persistence.CommerceDiscountRulePersistence;
import com.liferay.commerce.discount.service.persistence.CommerceDiscountUsageEntryPersistence;
import com.liferay.commerce.discount.service.persistence.CommerceDiscountUserSegmentRelPersistence;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the commerce discount rule remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.commerce.discount.service.impl.CommerceDiscountRuleServiceImpl}.
 * </p>
 *
 * @author Marco Leo
 * @see com.liferay.commerce.discount.service.impl.CommerceDiscountRuleServiceImpl
 * @generated
 */
public abstract class CommerceDiscountRuleServiceBaseImpl
	extends BaseServiceImpl
	implements CommerceDiscountRuleService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CommerceDiscountRuleService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.commerce.discount.service.CommerceDiscountRuleServiceUtil</code>.
	 */

	/**
	 * Returns the commerce discount local service.
	 *
	 * @return the commerce discount local service
	 */
	public com.liferay.commerce.discount.service.CommerceDiscountLocalService
		getCommerceDiscountLocalService() {

		return commerceDiscountLocalService;
	}

	/**
	 * Sets the commerce discount local service.
	 *
	 * @param commerceDiscountLocalService the commerce discount local service
	 */
	public void setCommerceDiscountLocalService(
		com.liferay.commerce.discount.service.CommerceDiscountLocalService
			commerceDiscountLocalService) {

		this.commerceDiscountLocalService = commerceDiscountLocalService;
	}

	/**
	 * Returns the commerce discount remote service.
	 *
	 * @return the commerce discount remote service
	 */
	public com.liferay.commerce.discount.service.CommerceDiscountService
		getCommerceDiscountService() {

		return commerceDiscountService;
	}

	/**
	 * Sets the commerce discount remote service.
	 *
	 * @param commerceDiscountService the commerce discount remote service
	 */
	public void setCommerceDiscountService(
		com.liferay.commerce.discount.service.CommerceDiscountService
			commerceDiscountService) {

		this.commerceDiscountService = commerceDiscountService;
	}

	/**
	 * Returns the commerce discount persistence.
	 *
	 * @return the commerce discount persistence
	 */
	public CommerceDiscountPersistence getCommerceDiscountPersistence() {
		return commerceDiscountPersistence;
	}

	/**
	 * Sets the commerce discount persistence.
	 *
	 * @param commerceDiscountPersistence the commerce discount persistence
	 */
	public void setCommerceDiscountPersistence(
		CommerceDiscountPersistence commerceDiscountPersistence) {

		this.commerceDiscountPersistence = commerceDiscountPersistence;
	}

	/**
	 * Returns the commerce discount rel local service.
	 *
	 * @return the commerce discount rel local service
	 */
	public com.liferay.commerce.discount.service.CommerceDiscountRelLocalService
		getCommerceDiscountRelLocalService() {

		return commerceDiscountRelLocalService;
	}

	/**
	 * Sets the commerce discount rel local service.
	 *
	 * @param commerceDiscountRelLocalService the commerce discount rel local service
	 */
	public void setCommerceDiscountRelLocalService(
		com.liferay.commerce.discount.service.CommerceDiscountRelLocalService
			commerceDiscountRelLocalService) {

		this.commerceDiscountRelLocalService = commerceDiscountRelLocalService;
	}

	/**
	 * Returns the commerce discount rel remote service.
	 *
	 * @return the commerce discount rel remote service
	 */
	public com.liferay.commerce.discount.service.CommerceDiscountRelService
		getCommerceDiscountRelService() {

		return commerceDiscountRelService;
	}

	/**
	 * Sets the commerce discount rel remote service.
	 *
	 * @param commerceDiscountRelService the commerce discount rel remote service
	 */
	public void setCommerceDiscountRelService(
		com.liferay.commerce.discount.service.CommerceDiscountRelService
			commerceDiscountRelService) {

		this.commerceDiscountRelService = commerceDiscountRelService;
	}

	/**
	 * Returns the commerce discount rel persistence.
	 *
	 * @return the commerce discount rel persistence
	 */
	public CommerceDiscountRelPersistence getCommerceDiscountRelPersistence() {
		return commerceDiscountRelPersistence;
	}

	/**
	 * Sets the commerce discount rel persistence.
	 *
	 * @param commerceDiscountRelPersistence the commerce discount rel persistence
	 */
	public void setCommerceDiscountRelPersistence(
		CommerceDiscountRelPersistence commerceDiscountRelPersistence) {

		this.commerceDiscountRelPersistence = commerceDiscountRelPersistence;
	}

	/**
	 * Returns the commerce discount rule local service.
	 *
	 * @return the commerce discount rule local service
	 */
	public
		com.liferay.commerce.discount.service.CommerceDiscountRuleLocalService
			getCommerceDiscountRuleLocalService() {

		return commerceDiscountRuleLocalService;
	}

	/**
	 * Sets the commerce discount rule local service.
	 *
	 * @param commerceDiscountRuleLocalService the commerce discount rule local service
	 */
	public void setCommerceDiscountRuleLocalService(
		com.liferay.commerce.discount.service.CommerceDiscountRuleLocalService
			commerceDiscountRuleLocalService) {

		this.commerceDiscountRuleLocalService =
			commerceDiscountRuleLocalService;
	}

	/**
	 * Returns the commerce discount rule remote service.
	 *
	 * @return the commerce discount rule remote service
	 */
	public CommerceDiscountRuleService getCommerceDiscountRuleService() {
		return commerceDiscountRuleService;
	}

	/**
	 * Sets the commerce discount rule remote service.
	 *
	 * @param commerceDiscountRuleService the commerce discount rule remote service
	 */
	public void setCommerceDiscountRuleService(
		CommerceDiscountRuleService commerceDiscountRuleService) {

		this.commerceDiscountRuleService = commerceDiscountRuleService;
	}

	/**
	 * Returns the commerce discount rule persistence.
	 *
	 * @return the commerce discount rule persistence
	 */
	public CommerceDiscountRulePersistence
		getCommerceDiscountRulePersistence() {

		return commerceDiscountRulePersistence;
	}

	/**
	 * Sets the commerce discount rule persistence.
	 *
	 * @param commerceDiscountRulePersistence the commerce discount rule persistence
	 */
	public void setCommerceDiscountRulePersistence(
		CommerceDiscountRulePersistence commerceDiscountRulePersistence) {

		this.commerceDiscountRulePersistence = commerceDiscountRulePersistence;
	}

	/**
	 * Returns the commerce discount usage entry local service.
	 *
	 * @return the commerce discount usage entry local service
	 */
	public
		com.liferay.commerce.discount.service.
			CommerceDiscountUsageEntryLocalService
				getCommerceDiscountUsageEntryLocalService() {

		return commerceDiscountUsageEntryLocalService;
	}

	/**
	 * Sets the commerce discount usage entry local service.
	 *
	 * @param commerceDiscountUsageEntryLocalService the commerce discount usage entry local service
	 */
	public void setCommerceDiscountUsageEntryLocalService(
		com.liferay.commerce.discount.service.
			CommerceDiscountUsageEntryLocalService
				commerceDiscountUsageEntryLocalService) {

		this.commerceDiscountUsageEntryLocalService =
			commerceDiscountUsageEntryLocalService;
	}

	/**
	 * Returns the commerce discount usage entry persistence.
	 *
	 * @return the commerce discount usage entry persistence
	 */
	public CommerceDiscountUsageEntryPersistence
		getCommerceDiscountUsageEntryPersistence() {

		return commerceDiscountUsageEntryPersistence;
	}

	/**
	 * Sets the commerce discount usage entry persistence.
	 *
	 * @param commerceDiscountUsageEntryPersistence the commerce discount usage entry persistence
	 */
	public void setCommerceDiscountUsageEntryPersistence(
		CommerceDiscountUsageEntryPersistence
			commerceDiscountUsageEntryPersistence) {

		this.commerceDiscountUsageEntryPersistence =
			commerceDiscountUsageEntryPersistence;
	}

	/**
	 * Returns the commerce discount user segment rel local service.
	 *
	 * @return the commerce discount user segment rel local service
	 */
	public com.liferay.commerce.discount.service.
		CommerceDiscountUserSegmentRelLocalService
			getCommerceDiscountUserSegmentRelLocalService() {

		return commerceDiscountUserSegmentRelLocalService;
	}

	/**
	 * Sets the commerce discount user segment rel local service.
	 *
	 * @param commerceDiscountUserSegmentRelLocalService the commerce discount user segment rel local service
	 */
	public void setCommerceDiscountUserSegmentRelLocalService(
		com.liferay.commerce.discount.service.
			CommerceDiscountUserSegmentRelLocalService
				commerceDiscountUserSegmentRelLocalService) {

		this.commerceDiscountUserSegmentRelLocalService =
			commerceDiscountUserSegmentRelLocalService;
	}

	/**
	 * Returns the commerce discount user segment rel remote service.
	 *
	 * @return the commerce discount user segment rel remote service
	 */
	public
		com.liferay.commerce.discount.service.
			CommerceDiscountUserSegmentRelService
				getCommerceDiscountUserSegmentRelService() {

		return commerceDiscountUserSegmentRelService;
	}

	/**
	 * Sets the commerce discount user segment rel remote service.
	 *
	 * @param commerceDiscountUserSegmentRelService the commerce discount user segment rel remote service
	 */
	public void setCommerceDiscountUserSegmentRelService(
		com.liferay.commerce.discount.service.
			CommerceDiscountUserSegmentRelService
				commerceDiscountUserSegmentRelService) {

		this.commerceDiscountUserSegmentRelService =
			commerceDiscountUserSegmentRelService;
	}

	/**
	 * Returns the commerce discount user segment rel persistence.
	 *
	 * @return the commerce discount user segment rel persistence
	 */
	public CommerceDiscountUserSegmentRelPersistence
		getCommerceDiscountUserSegmentRelPersistence() {

		return commerceDiscountUserSegmentRelPersistence;
	}

	/**
	 * Sets the commerce discount user segment rel persistence.
	 *
	 * @param commerceDiscountUserSegmentRelPersistence the commerce discount user segment rel persistence
	 */
	public void setCommerceDiscountUserSegmentRelPersistence(
		CommerceDiscountUserSegmentRelPersistence
			commerceDiscountUserSegmentRelPersistence) {

		this.commerceDiscountUserSegmentRelPersistence =
			commerceDiscountUserSegmentRelPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService
		getCounterLocalService() {

		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService
			counterLocalService) {

		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService
		getClassNameLocalService() {

		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService
			classNameLocalService) {

		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService
		getClassNameService() {

		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {

		this.classNameService = classNameService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {

		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService
		getResourceLocalService() {

		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService
			resourceLocalService) {

		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService
		getUserLocalService() {

		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {

		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {

		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CommerceDiscountRuleService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CommerceDiscountRule.class;
	}

	protected String getModelClassName() {
		return CommerceDiscountRule.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				commerceDiscountRulePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(
		type = com.liferay.commerce.discount.service.CommerceDiscountLocalService.class
	)
	protected com.liferay.commerce.discount.service.CommerceDiscountLocalService
		commerceDiscountLocalService;

	@BeanReference(
		type = com.liferay.commerce.discount.service.CommerceDiscountService.class
	)
	protected com.liferay.commerce.discount.service.CommerceDiscountService
		commerceDiscountService;

	@BeanReference(type = CommerceDiscountPersistence.class)
	protected CommerceDiscountPersistence commerceDiscountPersistence;

	@BeanReference(
		type = com.liferay.commerce.discount.service.CommerceDiscountRelLocalService.class
	)
	protected
		com.liferay.commerce.discount.service.CommerceDiscountRelLocalService
			commerceDiscountRelLocalService;

	@BeanReference(
		type = com.liferay.commerce.discount.service.CommerceDiscountRelService.class
	)
	protected com.liferay.commerce.discount.service.CommerceDiscountRelService
		commerceDiscountRelService;

	@BeanReference(type = CommerceDiscountRelPersistence.class)
	protected CommerceDiscountRelPersistence commerceDiscountRelPersistence;

	@BeanReference(
		type = com.liferay.commerce.discount.service.CommerceDiscountRuleLocalService.class
	)
	protected
		com.liferay.commerce.discount.service.CommerceDiscountRuleLocalService
			commerceDiscountRuleLocalService;

	@BeanReference(type = CommerceDiscountRuleService.class)
	protected CommerceDiscountRuleService commerceDiscountRuleService;

	@BeanReference(type = CommerceDiscountRulePersistence.class)
	protected CommerceDiscountRulePersistence commerceDiscountRulePersistence;

	@BeanReference(
		type = com.liferay.commerce.discount.service.CommerceDiscountUsageEntryLocalService.class
	)
	protected
		com.liferay.commerce.discount.service.
			CommerceDiscountUsageEntryLocalService
				commerceDiscountUsageEntryLocalService;

	@BeanReference(type = CommerceDiscountUsageEntryPersistence.class)
	protected CommerceDiscountUsageEntryPersistence
		commerceDiscountUsageEntryPersistence;

	@BeanReference(
		type = com.liferay.commerce.discount.service.CommerceDiscountUserSegmentRelLocalService.class
	)
	protected com.liferay.commerce.discount.service.
		CommerceDiscountUserSegmentRelLocalService
			commerceDiscountUserSegmentRelLocalService;

	@BeanReference(
		type = com.liferay.commerce.discount.service.CommerceDiscountUserSegmentRelService.class
	)
	protected
		com.liferay.commerce.discount.service.
			CommerceDiscountUserSegmentRelService
				commerceDiscountUserSegmentRelService;

	@BeanReference(type = CommerceDiscountUserSegmentRelPersistence.class)
	protected CommerceDiscountUserSegmentRelPersistence
		commerceDiscountUserSegmentRelPersistence;

	@ServiceReference(
		type = com.liferay.counter.kernel.service.CounterLocalService.class
	)
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ClassNameLocalService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ClassNameService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ResourceLocalService.class
	)
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.UserLocalService.class
	)
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.UserService.class
	)
	protected com.liferay.portal.kernel.service.UserService userService;

	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;

}