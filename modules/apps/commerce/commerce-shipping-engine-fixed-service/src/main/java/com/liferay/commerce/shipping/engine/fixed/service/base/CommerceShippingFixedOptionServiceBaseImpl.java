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

package com.liferay.commerce.shipping.engine.fixed.service.base;

import com.liferay.commerce.shipping.engine.fixed.model.CommerceShippingFixedOption;
import com.liferay.commerce.shipping.engine.fixed.service.CommerceShippingFixedOptionService;
import com.liferay.commerce.shipping.engine.fixed.service.persistence.CommerceShippingFixedOptionPersistence;
import com.liferay.commerce.shipping.engine.fixed.service.persistence.CommerceShippingFixedOptionRelFinder;
import com.liferay.commerce.shipping.engine.fixed.service.persistence.CommerceShippingFixedOptionRelPersistence;
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
 * Provides the base implementation for the commerce shipping fixed option remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.commerce.shipping.engine.fixed.service.impl.CommerceShippingFixedOptionServiceImpl}.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see com.liferay.commerce.shipping.engine.fixed.service.impl.CommerceShippingFixedOptionServiceImpl
 * @generated
 */
public abstract class CommerceShippingFixedOptionServiceBaseImpl
	extends BaseServiceImpl
	implements CommerceShippingFixedOptionService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CommerceShippingFixedOptionService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.commerce.shipping.engine.fixed.service.CommerceShippingFixedOptionServiceUtil</code>.
	 */

	/**
	 * Returns the commerce shipping fixed option local service.
	 *
	 * @return the commerce shipping fixed option local service
	 */
	public com.liferay.commerce.shipping.engine.fixed.service.
		CommerceShippingFixedOptionLocalService
			getCommerceShippingFixedOptionLocalService() {

		return commerceShippingFixedOptionLocalService;
	}

	/**
	 * Sets the commerce shipping fixed option local service.
	 *
	 * @param commerceShippingFixedOptionLocalService the commerce shipping fixed option local service
	 */
	public void setCommerceShippingFixedOptionLocalService(
		com.liferay.commerce.shipping.engine.fixed.service.
			CommerceShippingFixedOptionLocalService
				commerceShippingFixedOptionLocalService) {

		this.commerceShippingFixedOptionLocalService =
			commerceShippingFixedOptionLocalService;
	}

	/**
	 * Returns the commerce shipping fixed option remote service.
	 *
	 * @return the commerce shipping fixed option remote service
	 */
	public CommerceShippingFixedOptionService
		getCommerceShippingFixedOptionService() {

		return commerceShippingFixedOptionService;
	}

	/**
	 * Sets the commerce shipping fixed option remote service.
	 *
	 * @param commerceShippingFixedOptionService the commerce shipping fixed option remote service
	 */
	public void setCommerceShippingFixedOptionService(
		CommerceShippingFixedOptionService commerceShippingFixedOptionService) {

		this.commerceShippingFixedOptionService =
			commerceShippingFixedOptionService;
	}

	/**
	 * Returns the commerce shipping fixed option persistence.
	 *
	 * @return the commerce shipping fixed option persistence
	 */
	public CommerceShippingFixedOptionPersistence
		getCommerceShippingFixedOptionPersistence() {

		return commerceShippingFixedOptionPersistence;
	}

	/**
	 * Sets the commerce shipping fixed option persistence.
	 *
	 * @param commerceShippingFixedOptionPersistence the commerce shipping fixed option persistence
	 */
	public void setCommerceShippingFixedOptionPersistence(
		CommerceShippingFixedOptionPersistence
			commerceShippingFixedOptionPersistence) {

		this.commerceShippingFixedOptionPersistence =
			commerceShippingFixedOptionPersistence;
	}

	/**
	 * Returns the commerce shipping fixed option rel local service.
	 *
	 * @return the commerce shipping fixed option rel local service
	 */
	public com.liferay.commerce.shipping.engine.fixed.service.
		CommerceShippingFixedOptionRelLocalService
			getCommerceShippingFixedOptionRelLocalService() {

		return commerceShippingFixedOptionRelLocalService;
	}

	/**
	 * Sets the commerce shipping fixed option rel local service.
	 *
	 * @param commerceShippingFixedOptionRelLocalService the commerce shipping fixed option rel local service
	 */
	public void setCommerceShippingFixedOptionRelLocalService(
		com.liferay.commerce.shipping.engine.fixed.service.
			CommerceShippingFixedOptionRelLocalService
				commerceShippingFixedOptionRelLocalService) {

		this.commerceShippingFixedOptionRelLocalService =
			commerceShippingFixedOptionRelLocalService;
	}

	/**
	 * Returns the commerce shipping fixed option rel remote service.
	 *
	 * @return the commerce shipping fixed option rel remote service
	 */
	public com.liferay.commerce.shipping.engine.fixed.service.
		CommerceShippingFixedOptionRelService
			getCommerceShippingFixedOptionRelService() {

		return commerceShippingFixedOptionRelService;
	}

	/**
	 * Sets the commerce shipping fixed option rel remote service.
	 *
	 * @param commerceShippingFixedOptionRelService the commerce shipping fixed option rel remote service
	 */
	public void setCommerceShippingFixedOptionRelService(
		com.liferay.commerce.shipping.engine.fixed.service.
			CommerceShippingFixedOptionRelService
				commerceShippingFixedOptionRelService) {

		this.commerceShippingFixedOptionRelService =
			commerceShippingFixedOptionRelService;
	}

	/**
	 * Returns the commerce shipping fixed option rel persistence.
	 *
	 * @return the commerce shipping fixed option rel persistence
	 */
	public CommerceShippingFixedOptionRelPersistence
		getCommerceShippingFixedOptionRelPersistence() {

		return commerceShippingFixedOptionRelPersistence;
	}

	/**
	 * Sets the commerce shipping fixed option rel persistence.
	 *
	 * @param commerceShippingFixedOptionRelPersistence the commerce shipping fixed option rel persistence
	 */
	public void setCommerceShippingFixedOptionRelPersistence(
		CommerceShippingFixedOptionRelPersistence
			commerceShippingFixedOptionRelPersistence) {

		this.commerceShippingFixedOptionRelPersistence =
			commerceShippingFixedOptionRelPersistence;
	}

	/**
	 * Returns the commerce shipping fixed option rel finder.
	 *
	 * @return the commerce shipping fixed option rel finder
	 */
	public CommerceShippingFixedOptionRelFinder
		getCommerceShippingFixedOptionRelFinder() {

		return commerceShippingFixedOptionRelFinder;
	}

	/**
	 * Sets the commerce shipping fixed option rel finder.
	 *
	 * @param commerceShippingFixedOptionRelFinder the commerce shipping fixed option rel finder
	 */
	public void setCommerceShippingFixedOptionRelFinder(
		CommerceShippingFixedOptionRelFinder
			commerceShippingFixedOptionRelFinder) {

		this.commerceShippingFixedOptionRelFinder =
			commerceShippingFixedOptionRelFinder;
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
		return CommerceShippingFixedOptionService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CommerceShippingFixedOption.class;
	}

	protected String getModelClassName() {
		return CommerceShippingFixedOption.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				commerceShippingFixedOptionPersistence.getDataSource();

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
		type = com.liferay.commerce.shipping.engine.fixed.service.CommerceShippingFixedOptionLocalService.class
	)
	protected com.liferay.commerce.shipping.engine.fixed.service.
		CommerceShippingFixedOptionLocalService
			commerceShippingFixedOptionLocalService;

	@BeanReference(type = CommerceShippingFixedOptionService.class)
	protected CommerceShippingFixedOptionService
		commerceShippingFixedOptionService;

	@BeanReference(type = CommerceShippingFixedOptionPersistence.class)
	protected CommerceShippingFixedOptionPersistence
		commerceShippingFixedOptionPersistence;

	@BeanReference(
		type = com.liferay.commerce.shipping.engine.fixed.service.CommerceShippingFixedOptionRelLocalService.class
	)
	protected com.liferay.commerce.shipping.engine.fixed.service.
		CommerceShippingFixedOptionRelLocalService
			commerceShippingFixedOptionRelLocalService;

	@BeanReference(
		type = com.liferay.commerce.shipping.engine.fixed.service.CommerceShippingFixedOptionRelService.class
	)
	protected com.liferay.commerce.shipping.engine.fixed.service.
		CommerceShippingFixedOptionRelService
			commerceShippingFixedOptionRelService;

	@BeanReference(type = CommerceShippingFixedOptionRelPersistence.class)
	protected CommerceShippingFixedOptionRelPersistence
		commerceShippingFixedOptionRelPersistence;

	@BeanReference(type = CommerceShippingFixedOptionRelFinder.class)
	protected CommerceShippingFixedOptionRelFinder
		commerceShippingFixedOptionRelFinder;

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