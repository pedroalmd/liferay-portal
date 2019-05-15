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

package com.liferay.commerce.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.commerce.exception.NoSuchCountryException;
import com.liferay.commerce.model.CommerceCountry;
import com.liferay.commerce.model.impl.CommerceCountryImpl;
import com.liferay.commerce.model.impl.CommerceCountryModelImpl;
import com.liferay.commerce.service.persistence.CommerceCountryPersistence;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the commerce country service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @generated
 */
@ProviderType
public class CommerceCountryPersistenceImpl
	extends BasePersistenceImpl<CommerceCountry>
	implements CommerceCountryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CommerceCountryUtil</code> to access the commerce country persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CommerceCountryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the commerce countries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching commerce countries
	 */
	@Override
	public List<CommerceCountry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commerce countries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CommerceCountryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of commerce countries
	 * @param end the upper bound of the range of commerce countries (not inclusive)
	 * @return the range of matching commerce countries
	 */
	@Override
	public List<CommerceCountry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce countries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CommerceCountryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of commerce countries
	 * @param end the upper bound of the range of commerce countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce countries
	 */
	@Override
	public List<CommerceCountry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CommerceCountry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commerce countries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CommerceCountryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of commerce countries
	 * @param end the upper bound of the range of commerce countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching commerce countries
	 */
	@Override
	public List<CommerceCountry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CommerceCountry> orderByComparator,
		boolean retrieveFromCache) {

		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUuid;
			finderArgs = new Object[] {uuid};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<CommerceCountry> list = null;

		if (retrieveFromCache) {
			list = (List<CommerceCountry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommerceCountry commerceCountry : list) {
					if (!uuid.equals(commerceCountry.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_COMMERCECOUNTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CommerceCountryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<CommerceCountry>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CommerceCountry>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first commerce country in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce country
	 * @throws NoSuchCountryException if a matching commerce country could not be found
	 */
	@Override
	public CommerceCountry findByUuid_First(
			String uuid, OrderByComparator<CommerceCountry> orderByComparator)
		throws NoSuchCountryException {

		CommerceCountry commerceCountry = fetchByUuid_First(
			uuid, orderByComparator);

		if (commerceCountry != null) {
			return commerceCountry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchCountryException(msg.toString());
	}

	/**
	 * Returns the first commerce country in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce country, or <code>null</code> if a matching commerce country could not be found
	 */
	@Override
	public CommerceCountry fetchByUuid_First(
		String uuid, OrderByComparator<CommerceCountry> orderByComparator) {

		List<CommerceCountry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commerce country in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce country
	 * @throws NoSuchCountryException if a matching commerce country could not be found
	 */
	@Override
	public CommerceCountry findByUuid_Last(
			String uuid, OrderByComparator<CommerceCountry> orderByComparator)
		throws NoSuchCountryException {

		CommerceCountry commerceCountry = fetchByUuid_Last(
			uuid, orderByComparator);

		if (commerceCountry != null) {
			return commerceCountry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchCountryException(msg.toString());
	}

	/**
	 * Returns the last commerce country in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce country, or <code>null</code> if a matching commerce country could not be found
	 */
	@Override
	public CommerceCountry fetchByUuid_Last(
		String uuid, OrderByComparator<CommerceCountry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CommerceCountry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commerce countries before and after the current commerce country in the ordered set where uuid = &#63;.
	 *
	 * @param commerceCountryId the primary key of the current commerce country
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce country
	 * @throws NoSuchCountryException if a commerce country with the primary key could not be found
	 */
	@Override
	public CommerceCountry[] findByUuid_PrevAndNext(
			long commerceCountryId, String uuid,
			OrderByComparator<CommerceCountry> orderByComparator)
		throws NoSuchCountryException {

		uuid = Objects.toString(uuid, "");

		CommerceCountry commerceCountry = findByPrimaryKey(commerceCountryId);

		Session session = null;

		try {
			session = openSession();

			CommerceCountry[] array = new CommerceCountryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, commerceCountry, uuid, orderByComparator, true);

			array[1] = commerceCountry;

			array[2] = getByUuid_PrevAndNext(
				session, commerceCountry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CommerceCountry getByUuid_PrevAndNext(
		Session session, CommerceCountry commerceCountry, String uuid,
		OrderByComparator<CommerceCountry> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMMERCECOUNTRY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CommerceCountryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						commerceCountry)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CommerceCountry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commerce countries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CommerceCountry commerceCountry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(commerceCountry);
		}
	}

	/**
	 * Returns the number of commerce countries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching commerce countries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMMERCECOUNTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"commerceCountry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(commerceCountry.uuid IS NULL OR commerceCountry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the commerce country where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCountryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching commerce country
	 * @throws NoSuchCountryException if a matching commerce country could not be found
	 */
	@Override
	public CommerceCountry findByUUID_G(String uuid, long groupId)
		throws NoSuchCountryException {

		CommerceCountry commerceCountry = fetchByUUID_G(uuid, groupId);

		if (commerceCountry == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchCountryException(msg.toString());
		}

		return commerceCountry;
	}

	/**
	 * Returns the commerce country where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching commerce country, or <code>null</code> if a matching commerce country could not be found
	 */
	@Override
	public CommerceCountry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the commerce country where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching commerce country, or <code>null</code> if a matching commerce country could not be found
	 */
	@Override
	public CommerceCountry fetchByUUID_G(
		String uuid, long groupId, boolean retrieveFromCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = new Object[] {uuid, groupId};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof CommerceCountry) {
			CommerceCountry commerceCountry = (CommerceCountry)result;

			if (!Objects.equals(uuid, commerceCountry.getUuid()) ||
				(groupId != commerceCountry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_COMMERCECOUNTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<CommerceCountry> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByUUID_G, finderArgs, list);
				}
				else {
					CommerceCountry commerceCountry = list.get(0);

					result = commerceCountry;

					cacheResult(commerceCountry);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByUUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (CommerceCountry)result;
		}
	}

	/**
	 * Removes the commerce country where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the commerce country that was removed
	 */
	@Override
	public CommerceCountry removeByUUID_G(String uuid, long groupId)
		throws NoSuchCountryException {

		CommerceCountry commerceCountry = findByUUID_G(uuid, groupId);

		return remove(commerceCountry);
	}

	/**
	 * Returns the number of commerce countries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching commerce countries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COMMERCECOUNTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"commerceCountry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(commerceCountry.uuid IS NULL OR commerceCountry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"commerceCountry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the commerce countries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching commerce countries
	 */
	@Override
	public List<CommerceCountry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commerce countries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CommerceCountryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of commerce countries
	 * @param end the upper bound of the range of commerce countries (not inclusive)
	 * @return the range of matching commerce countries
	 */
	@Override
	public List<CommerceCountry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce countries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CommerceCountryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of commerce countries
	 * @param end the upper bound of the range of commerce countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce countries
	 */
	@Override
	public List<CommerceCountry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CommerceCountry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commerce countries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CommerceCountryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of commerce countries
	 * @param end the upper bound of the range of commerce countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching commerce countries
	 */
	@Override
	public List<CommerceCountry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CommerceCountry> orderByComparator,
		boolean retrieveFromCache) {

		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUuid_C;
			finderArgs = new Object[] {uuid, companyId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<CommerceCountry> list = null;

		if (retrieveFromCache) {
			list = (List<CommerceCountry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommerceCountry commerceCountry : list) {
					if (!uuid.equals(commerceCountry.getUuid()) ||
						(companyId != commerceCountry.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_COMMERCECOUNTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CommerceCountryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<CommerceCountry>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CommerceCountry>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first commerce country in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce country
	 * @throws NoSuchCountryException if a matching commerce country could not be found
	 */
	@Override
	public CommerceCountry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CommerceCountry> orderByComparator)
		throws NoSuchCountryException {

		CommerceCountry commerceCountry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (commerceCountry != null) {
			return commerceCountry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchCountryException(msg.toString());
	}

	/**
	 * Returns the first commerce country in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce country, or <code>null</code> if a matching commerce country could not be found
	 */
	@Override
	public CommerceCountry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CommerceCountry> orderByComparator) {

		List<CommerceCountry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commerce country in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce country
	 * @throws NoSuchCountryException if a matching commerce country could not be found
	 */
	@Override
	public CommerceCountry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CommerceCountry> orderByComparator)
		throws NoSuchCountryException {

		CommerceCountry commerceCountry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (commerceCountry != null) {
			return commerceCountry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchCountryException(msg.toString());
	}

	/**
	 * Returns the last commerce country in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce country, or <code>null</code> if a matching commerce country could not be found
	 */
	@Override
	public CommerceCountry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CommerceCountry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<CommerceCountry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commerce countries before and after the current commerce country in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param commerceCountryId the primary key of the current commerce country
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce country
	 * @throws NoSuchCountryException if a commerce country with the primary key could not be found
	 */
	@Override
	public CommerceCountry[] findByUuid_C_PrevAndNext(
			long commerceCountryId, String uuid, long companyId,
			OrderByComparator<CommerceCountry> orderByComparator)
		throws NoSuchCountryException {

		uuid = Objects.toString(uuid, "");

		CommerceCountry commerceCountry = findByPrimaryKey(commerceCountryId);

		Session session = null;

		try {
			session = openSession();

			CommerceCountry[] array = new CommerceCountryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, commerceCountry, uuid, companyId, orderByComparator,
				true);

			array[1] = commerceCountry;

			array[2] = getByUuid_C_PrevAndNext(
				session, commerceCountry, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CommerceCountry getByUuid_C_PrevAndNext(
		Session session, CommerceCountry commerceCountry, String uuid,
		long companyId, OrderByComparator<CommerceCountry> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_COMMERCECOUNTRY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CommerceCountryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						commerceCountry)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CommerceCountry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commerce countries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (CommerceCountry commerceCountry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(commerceCountry);
		}
	}

	/**
	 * Returns the number of commerce countries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching commerce countries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COMMERCECOUNTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"commerceCountry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(commerceCountry.uuid IS NULL OR commerceCountry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"commerceCountry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the commerce countries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching commerce countries
	 */
	@Override
	public List<CommerceCountry> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commerce countries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CommerceCountryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of commerce countries
	 * @param end the upper bound of the range of commerce countries (not inclusive)
	 * @return the range of matching commerce countries
	 */
	@Override
	public List<CommerceCountry> findByGroupId(
		long groupId, int start, int end) {

		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce countries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CommerceCountryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of commerce countries
	 * @param end the upper bound of the range of commerce countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce countries
	 */
	@Override
	public List<CommerceCountry> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CommerceCountry> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commerce countries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CommerceCountryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of commerce countries
	 * @param end the upper bound of the range of commerce countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching commerce countries
	 */
	@Override
	public List<CommerceCountry> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CommerceCountry> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByGroupId;
			finderArgs = new Object[] {groupId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<CommerceCountry> list = null;

		if (retrieveFromCache) {
			list = (List<CommerceCountry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommerceCountry commerceCountry : list) {
					if ((groupId != commerceCountry.getGroupId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_COMMERCECOUNTRY_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CommerceCountryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<CommerceCountry>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CommerceCountry>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first commerce country in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce country
	 * @throws NoSuchCountryException if a matching commerce country could not be found
	 */
	@Override
	public CommerceCountry findByGroupId_First(
			long groupId, OrderByComparator<CommerceCountry> orderByComparator)
		throws NoSuchCountryException {

		CommerceCountry commerceCountry = fetchByGroupId_First(
			groupId, orderByComparator);

		if (commerceCountry != null) {
			return commerceCountry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchCountryException(msg.toString());
	}

	/**
	 * Returns the first commerce country in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce country, or <code>null</code> if a matching commerce country could not be found
	 */
	@Override
	public CommerceCountry fetchByGroupId_First(
		long groupId, OrderByComparator<CommerceCountry> orderByComparator) {

		List<CommerceCountry> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commerce country in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce country
	 * @throws NoSuchCountryException if a matching commerce country could not be found
	 */
	@Override
	public CommerceCountry findByGroupId_Last(
			long groupId, OrderByComparator<CommerceCountry> orderByComparator)
		throws NoSuchCountryException {

		CommerceCountry commerceCountry = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (commerceCountry != null) {
			return commerceCountry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchCountryException(msg.toString());
	}

	/**
	 * Returns the last commerce country in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce country, or <code>null</code> if a matching commerce country could not be found
	 */
	@Override
	public CommerceCountry fetchByGroupId_Last(
		long groupId, OrderByComparator<CommerceCountry> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<CommerceCountry> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commerce countries before and after the current commerce country in the ordered set where groupId = &#63;.
	 *
	 * @param commerceCountryId the primary key of the current commerce country
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce country
	 * @throws NoSuchCountryException if a commerce country with the primary key could not be found
	 */
	@Override
	public CommerceCountry[] findByGroupId_PrevAndNext(
			long commerceCountryId, long groupId,
			OrderByComparator<CommerceCountry> orderByComparator)
		throws NoSuchCountryException {

		CommerceCountry commerceCountry = findByPrimaryKey(commerceCountryId);

		Session session = null;

		try {
			session = openSession();

			CommerceCountry[] array = new CommerceCountryImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, commerceCountry, groupId, orderByComparator, true);

			array[1] = commerceCountry;

			array[2] = getByGroupId_PrevAndNext(
				session, commerceCountry, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CommerceCountry getByGroupId_PrevAndNext(
		Session session, CommerceCountry commerceCountry, long groupId,
		OrderByComparator<CommerceCountry> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMMERCECOUNTRY_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CommerceCountryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						commerceCountry)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CommerceCountry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commerce countries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (CommerceCountry commerceCountry :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(commerceCountry);
		}
	}

	/**
	 * Returns the number of commerce countries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching commerce countries
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMMERCECOUNTRY_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"commerceCountry.groupId = ?";

	private FinderPath _finderPathFetchByG_Tw;
	private FinderPath _finderPathCountByG_Tw;

	/**
	 * Returns the commerce country where groupId = &#63; and twoLettersISOCode = &#63; or throws a <code>NoSuchCountryException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param twoLettersISOCode the two letters iso code
	 * @return the matching commerce country
	 * @throws NoSuchCountryException if a matching commerce country could not be found
	 */
	@Override
	public CommerceCountry findByG_Tw(long groupId, String twoLettersISOCode)
		throws NoSuchCountryException {

		CommerceCountry commerceCountry = fetchByG_Tw(
			groupId, twoLettersISOCode);

		if (commerceCountry == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", twoLettersISOCode=");
			msg.append(twoLettersISOCode);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchCountryException(msg.toString());
		}

		return commerceCountry;
	}

	/**
	 * Returns the commerce country where groupId = &#63; and twoLettersISOCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param twoLettersISOCode the two letters iso code
	 * @return the matching commerce country, or <code>null</code> if a matching commerce country could not be found
	 */
	@Override
	public CommerceCountry fetchByG_Tw(long groupId, String twoLettersISOCode) {
		return fetchByG_Tw(groupId, twoLettersISOCode, true);
	}

	/**
	 * Returns the commerce country where groupId = &#63; and twoLettersISOCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param twoLettersISOCode the two letters iso code
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching commerce country, or <code>null</code> if a matching commerce country could not be found
	 */
	@Override
	public CommerceCountry fetchByG_Tw(
		long groupId, String twoLettersISOCode, boolean retrieveFromCache) {

		twoLettersISOCode = Objects.toString(twoLettersISOCode, "");

		Object[] finderArgs = new Object[] {groupId, twoLettersISOCode};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByG_Tw, finderArgs, this);
		}

		if (result instanceof CommerceCountry) {
			CommerceCountry commerceCountry = (CommerceCountry)result;

			if ((groupId != commerceCountry.getGroupId()) ||
				!Objects.equals(
					twoLettersISOCode,
					commerceCountry.getTwoLettersISOCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_COMMERCECOUNTRY_WHERE);

			query.append(_FINDER_COLUMN_G_TW_GROUPID_2);

			boolean bindTwoLettersISOCode = false;

			if (twoLettersISOCode.isEmpty()) {
				query.append(_FINDER_COLUMN_G_TW_TWOLETTERSISOCODE_3);
			}
			else {
				bindTwoLettersISOCode = true;

				query.append(_FINDER_COLUMN_G_TW_TWOLETTERSISOCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindTwoLettersISOCode) {
					qPos.add(twoLettersISOCode);
				}

				List<CommerceCountry> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByG_Tw, finderArgs, list);
				}
				else {
					CommerceCountry commerceCountry = list.get(0);

					result = commerceCountry;

					cacheResult(commerceCountry);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByG_Tw, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (CommerceCountry)result;
		}
	}

	/**
	 * Removes the commerce country where groupId = &#63; and twoLettersISOCode = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param twoLettersISOCode the two letters iso code
	 * @return the commerce country that was removed
	 */
	@Override
	public CommerceCountry removeByG_Tw(long groupId, String twoLettersISOCode)
		throws NoSuchCountryException {

		CommerceCountry commerceCountry = findByG_Tw(
			groupId, twoLettersISOCode);

		return remove(commerceCountry);
	}

	/**
	 * Returns the number of commerce countries where groupId = &#63; and twoLettersISOCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param twoLettersISOCode the two letters iso code
	 * @return the number of matching commerce countries
	 */
	@Override
	public int countByG_Tw(long groupId, String twoLettersISOCode) {
		twoLettersISOCode = Objects.toString(twoLettersISOCode, "");

		FinderPath finderPath = _finderPathCountByG_Tw;

		Object[] finderArgs = new Object[] {groupId, twoLettersISOCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COMMERCECOUNTRY_WHERE);

			query.append(_FINDER_COLUMN_G_TW_GROUPID_2);

			boolean bindTwoLettersISOCode = false;

			if (twoLettersISOCode.isEmpty()) {
				query.append(_FINDER_COLUMN_G_TW_TWOLETTERSISOCODE_3);
			}
			else {
				bindTwoLettersISOCode = true;

				query.append(_FINDER_COLUMN_G_TW_TWOLETTERSISOCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindTwoLettersISOCode) {
					qPos.add(twoLettersISOCode);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_TW_GROUPID_2 =
		"commerceCountry.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_TW_TWOLETTERSISOCODE_2 =
		"commerceCountry.twoLettersISOCode = ?";

	private static final String _FINDER_COLUMN_G_TW_TWOLETTERSISOCODE_3 =
		"(commerceCountry.twoLettersISOCode IS NULL OR commerceCountry.twoLettersISOCode = '')";

	private FinderPath _finderPathFetchByG_N;
	private FinderPath _finderPathCountByG_N;

	/**
	 * Returns the commerce country where groupId = &#63; and numericISOCode = &#63; or throws a <code>NoSuchCountryException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param numericISOCode the numeric iso code
	 * @return the matching commerce country
	 * @throws NoSuchCountryException if a matching commerce country could not be found
	 */
	@Override
	public CommerceCountry findByG_N(long groupId, int numericISOCode)
		throws NoSuchCountryException {

		CommerceCountry commerceCountry = fetchByG_N(groupId, numericISOCode);

		if (commerceCountry == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", numericISOCode=");
			msg.append(numericISOCode);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchCountryException(msg.toString());
		}

		return commerceCountry;
	}

	/**
	 * Returns the commerce country where groupId = &#63; and numericISOCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param numericISOCode the numeric iso code
	 * @return the matching commerce country, or <code>null</code> if a matching commerce country could not be found
	 */
	@Override
	public CommerceCountry fetchByG_N(long groupId, int numericISOCode) {
		return fetchByG_N(groupId, numericISOCode, true);
	}

	/**
	 * Returns the commerce country where groupId = &#63; and numericISOCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param numericISOCode the numeric iso code
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching commerce country, or <code>null</code> if a matching commerce country could not be found
	 */
	@Override
	public CommerceCountry fetchByG_N(
		long groupId, int numericISOCode, boolean retrieveFromCache) {

		Object[] finderArgs = new Object[] {groupId, numericISOCode};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByG_N, finderArgs, this);
		}

		if (result instanceof CommerceCountry) {
			CommerceCountry commerceCountry = (CommerceCountry)result;

			if ((groupId != commerceCountry.getGroupId()) ||
				(numericISOCode != commerceCountry.getNumericISOCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_COMMERCECOUNTRY_WHERE);

			query.append(_FINDER_COLUMN_G_N_GROUPID_2);

			query.append(_FINDER_COLUMN_G_N_NUMERICISOCODE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(numericISOCode);

				List<CommerceCountry> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByG_N, finderArgs, list);
				}
				else {
					CommerceCountry commerceCountry = list.get(0);

					result = commerceCountry;

					cacheResult(commerceCountry);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByG_N, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (CommerceCountry)result;
		}
	}

	/**
	 * Removes the commerce country where groupId = &#63; and numericISOCode = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param numericISOCode the numeric iso code
	 * @return the commerce country that was removed
	 */
	@Override
	public CommerceCountry removeByG_N(long groupId, int numericISOCode)
		throws NoSuchCountryException {

		CommerceCountry commerceCountry = findByG_N(groupId, numericISOCode);

		return remove(commerceCountry);
	}

	/**
	 * Returns the number of commerce countries where groupId = &#63; and numericISOCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param numericISOCode the numeric iso code
	 * @return the number of matching commerce countries
	 */
	@Override
	public int countByG_N(long groupId, int numericISOCode) {
		FinderPath finderPath = _finderPathCountByG_N;

		Object[] finderArgs = new Object[] {groupId, numericISOCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COMMERCECOUNTRY_WHERE);

			query.append(_FINDER_COLUMN_G_N_GROUPID_2);

			query.append(_FINDER_COLUMN_G_N_NUMERICISOCODE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(numericISOCode);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_N_GROUPID_2 =
		"commerceCountry.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_N_NUMERICISOCODE_2 =
		"commerceCountry.numericISOCode = ?";

	private FinderPath _finderPathWithPaginationFindByG_A;
	private FinderPath _finderPathWithoutPaginationFindByG_A;
	private FinderPath _finderPathCountByG_A;

	/**
	 * Returns all the commerce countries where groupId = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @return the matching commerce countries
	 */
	@Override
	public List<CommerceCountry> findByG_A(long groupId, boolean active) {
		return findByG_A(
			groupId, active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commerce countries where groupId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CommerceCountryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param start the lower bound of the range of commerce countries
	 * @param end the upper bound of the range of commerce countries (not inclusive)
	 * @return the range of matching commerce countries
	 */
	@Override
	public List<CommerceCountry> findByG_A(
		long groupId, boolean active, int start, int end) {

		return findByG_A(groupId, active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce countries where groupId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CommerceCountryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param start the lower bound of the range of commerce countries
	 * @param end the upper bound of the range of commerce countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce countries
	 */
	@Override
	public List<CommerceCountry> findByG_A(
		long groupId, boolean active, int start, int end,
		OrderByComparator<CommerceCountry> orderByComparator) {

		return findByG_A(groupId, active, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commerce countries where groupId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CommerceCountryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param start the lower bound of the range of commerce countries
	 * @param end the upper bound of the range of commerce countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching commerce countries
	 */
	@Override
	public List<CommerceCountry> findByG_A(
		long groupId, boolean active, int start, int end,
		OrderByComparator<CommerceCountry> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByG_A;
			finderArgs = new Object[] {groupId, active};
		}
		else {
			finderPath = _finderPathWithPaginationFindByG_A;
			finderArgs = new Object[] {
				groupId, active, start, end, orderByComparator
			};
		}

		List<CommerceCountry> list = null;

		if (retrieveFromCache) {
			list = (List<CommerceCountry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommerceCountry commerceCountry : list) {
					if ((groupId != commerceCountry.getGroupId()) ||
						(active != commerceCountry.isActive())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_COMMERCECOUNTRY_WHERE);

			query.append(_FINDER_COLUMN_G_A_GROUPID_2);

			query.append(_FINDER_COLUMN_G_A_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CommerceCountryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(active);

				if (!pagination) {
					list = (List<CommerceCountry>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CommerceCountry>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first commerce country in the ordered set where groupId = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce country
	 * @throws NoSuchCountryException if a matching commerce country could not be found
	 */
	@Override
	public CommerceCountry findByG_A_First(
			long groupId, boolean active,
			OrderByComparator<CommerceCountry> orderByComparator)
		throws NoSuchCountryException {

		CommerceCountry commerceCountry = fetchByG_A_First(
			groupId, active, orderByComparator);

		if (commerceCountry != null) {
			return commerceCountry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", active=");
		msg.append(active);

		msg.append("}");

		throw new NoSuchCountryException(msg.toString());
	}

	/**
	 * Returns the first commerce country in the ordered set where groupId = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce country, or <code>null</code> if a matching commerce country could not be found
	 */
	@Override
	public CommerceCountry fetchByG_A_First(
		long groupId, boolean active,
		OrderByComparator<CommerceCountry> orderByComparator) {

		List<CommerceCountry> list = findByG_A(
			groupId, active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commerce country in the ordered set where groupId = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce country
	 * @throws NoSuchCountryException if a matching commerce country could not be found
	 */
	@Override
	public CommerceCountry findByG_A_Last(
			long groupId, boolean active,
			OrderByComparator<CommerceCountry> orderByComparator)
		throws NoSuchCountryException {

		CommerceCountry commerceCountry = fetchByG_A_Last(
			groupId, active, orderByComparator);

		if (commerceCountry != null) {
			return commerceCountry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", active=");
		msg.append(active);

		msg.append("}");

		throw new NoSuchCountryException(msg.toString());
	}

	/**
	 * Returns the last commerce country in the ordered set where groupId = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce country, or <code>null</code> if a matching commerce country could not be found
	 */
	@Override
	public CommerceCountry fetchByG_A_Last(
		long groupId, boolean active,
		OrderByComparator<CommerceCountry> orderByComparator) {

		int count = countByG_A(groupId, active);

		if (count == 0) {
			return null;
		}

		List<CommerceCountry> list = findByG_A(
			groupId, active, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commerce countries before and after the current commerce country in the ordered set where groupId = &#63; and active = &#63;.
	 *
	 * @param commerceCountryId the primary key of the current commerce country
	 * @param groupId the group ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce country
	 * @throws NoSuchCountryException if a commerce country with the primary key could not be found
	 */
	@Override
	public CommerceCountry[] findByG_A_PrevAndNext(
			long commerceCountryId, long groupId, boolean active,
			OrderByComparator<CommerceCountry> orderByComparator)
		throws NoSuchCountryException {

		CommerceCountry commerceCountry = findByPrimaryKey(commerceCountryId);

		Session session = null;

		try {
			session = openSession();

			CommerceCountry[] array = new CommerceCountryImpl[3];

			array[0] = getByG_A_PrevAndNext(
				session, commerceCountry, groupId, active, orderByComparator,
				true);

			array[1] = commerceCountry;

			array[2] = getByG_A_PrevAndNext(
				session, commerceCountry, groupId, active, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CommerceCountry getByG_A_PrevAndNext(
		Session session, CommerceCountry commerceCountry, long groupId,
		boolean active, OrderByComparator<CommerceCountry> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_COMMERCECOUNTRY_WHERE);

		query.append(_FINDER_COLUMN_G_A_GROUPID_2);

		query.append(_FINDER_COLUMN_G_A_ACTIVE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CommerceCountryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(active);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						commerceCountry)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CommerceCountry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commerce countries where groupId = &#63; and active = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 */
	@Override
	public void removeByG_A(long groupId, boolean active) {
		for (CommerceCountry commerceCountry :
				findByG_A(
					groupId, active, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(commerceCountry);
		}
	}

	/**
	 * Returns the number of commerce countries where groupId = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @return the number of matching commerce countries
	 */
	@Override
	public int countByG_A(long groupId, boolean active) {
		FinderPath finderPath = _finderPathCountByG_A;

		Object[] finderArgs = new Object[] {groupId, active};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COMMERCECOUNTRY_WHERE);

			query.append(_FINDER_COLUMN_G_A_GROUPID_2);

			query.append(_FINDER_COLUMN_G_A_ACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(active);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_A_GROUPID_2 =
		"commerceCountry.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_A_ACTIVE_2 =
		"commerceCountry.active = ?";

	private FinderPath _finderPathWithPaginationFindByG_B_A;
	private FinderPath _finderPathWithoutPaginationFindByG_B_A;
	private FinderPath _finderPathCountByG_B_A;

	/**
	 * Returns all the commerce countries where groupId = &#63; and billingAllowed = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param billingAllowed the billing allowed
	 * @param active the active
	 * @return the matching commerce countries
	 */
	@Override
	public List<CommerceCountry> findByG_B_A(
		long groupId, boolean billingAllowed, boolean active) {

		return findByG_B_A(
			groupId, billingAllowed, active, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commerce countries where groupId = &#63; and billingAllowed = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CommerceCountryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param billingAllowed the billing allowed
	 * @param active the active
	 * @param start the lower bound of the range of commerce countries
	 * @param end the upper bound of the range of commerce countries (not inclusive)
	 * @return the range of matching commerce countries
	 */
	@Override
	public List<CommerceCountry> findByG_B_A(
		long groupId, boolean billingAllowed, boolean active, int start,
		int end) {

		return findByG_B_A(groupId, billingAllowed, active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce countries where groupId = &#63; and billingAllowed = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CommerceCountryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param billingAllowed the billing allowed
	 * @param active the active
	 * @param start the lower bound of the range of commerce countries
	 * @param end the upper bound of the range of commerce countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce countries
	 */
	@Override
	public List<CommerceCountry> findByG_B_A(
		long groupId, boolean billingAllowed, boolean active, int start,
		int end, OrderByComparator<CommerceCountry> orderByComparator) {

		return findByG_B_A(
			groupId, billingAllowed, active, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the commerce countries where groupId = &#63; and billingAllowed = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CommerceCountryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param billingAllowed the billing allowed
	 * @param active the active
	 * @param start the lower bound of the range of commerce countries
	 * @param end the upper bound of the range of commerce countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching commerce countries
	 */
	@Override
	public List<CommerceCountry> findByG_B_A(
		long groupId, boolean billingAllowed, boolean active, int start,
		int end, OrderByComparator<CommerceCountry> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByG_B_A;
			finderArgs = new Object[] {groupId, billingAllowed, active};
		}
		else {
			finderPath = _finderPathWithPaginationFindByG_B_A;
			finderArgs = new Object[] {
				groupId, billingAllowed, active, start, end, orderByComparator
			};
		}

		List<CommerceCountry> list = null;

		if (retrieveFromCache) {
			list = (List<CommerceCountry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommerceCountry commerceCountry : list) {
					if ((groupId != commerceCountry.getGroupId()) ||
						(billingAllowed !=
							commerceCountry.isBillingAllowed()) ||
						(active != commerceCountry.isActive())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_COMMERCECOUNTRY_WHERE);

			query.append(_FINDER_COLUMN_G_B_A_GROUPID_2);

			query.append(_FINDER_COLUMN_G_B_A_BILLINGALLOWED_2);

			query.append(_FINDER_COLUMN_G_B_A_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CommerceCountryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(billingAllowed);

				qPos.add(active);

				if (!pagination) {
					list = (List<CommerceCountry>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CommerceCountry>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first commerce country in the ordered set where groupId = &#63; and billingAllowed = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param billingAllowed the billing allowed
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce country
	 * @throws NoSuchCountryException if a matching commerce country could not be found
	 */
	@Override
	public CommerceCountry findByG_B_A_First(
			long groupId, boolean billingAllowed, boolean active,
			OrderByComparator<CommerceCountry> orderByComparator)
		throws NoSuchCountryException {

		CommerceCountry commerceCountry = fetchByG_B_A_First(
			groupId, billingAllowed, active, orderByComparator);

		if (commerceCountry != null) {
			return commerceCountry;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", billingAllowed=");
		msg.append(billingAllowed);

		msg.append(", active=");
		msg.append(active);

		msg.append("}");

		throw new NoSuchCountryException(msg.toString());
	}

	/**
	 * Returns the first commerce country in the ordered set where groupId = &#63; and billingAllowed = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param billingAllowed the billing allowed
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce country, or <code>null</code> if a matching commerce country could not be found
	 */
	@Override
	public CommerceCountry fetchByG_B_A_First(
		long groupId, boolean billingAllowed, boolean active,
		OrderByComparator<CommerceCountry> orderByComparator) {

		List<CommerceCountry> list = findByG_B_A(
			groupId, billingAllowed, active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commerce country in the ordered set where groupId = &#63; and billingAllowed = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param billingAllowed the billing allowed
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce country
	 * @throws NoSuchCountryException if a matching commerce country could not be found
	 */
	@Override
	public CommerceCountry findByG_B_A_Last(
			long groupId, boolean billingAllowed, boolean active,
			OrderByComparator<CommerceCountry> orderByComparator)
		throws NoSuchCountryException {

		CommerceCountry commerceCountry = fetchByG_B_A_Last(
			groupId, billingAllowed, active, orderByComparator);

		if (commerceCountry != null) {
			return commerceCountry;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", billingAllowed=");
		msg.append(billingAllowed);

		msg.append(", active=");
		msg.append(active);

		msg.append("}");

		throw new NoSuchCountryException(msg.toString());
	}

	/**
	 * Returns the last commerce country in the ordered set where groupId = &#63; and billingAllowed = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param billingAllowed the billing allowed
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce country, or <code>null</code> if a matching commerce country could not be found
	 */
	@Override
	public CommerceCountry fetchByG_B_A_Last(
		long groupId, boolean billingAllowed, boolean active,
		OrderByComparator<CommerceCountry> orderByComparator) {

		int count = countByG_B_A(groupId, billingAllowed, active);

		if (count == 0) {
			return null;
		}

		List<CommerceCountry> list = findByG_B_A(
			groupId, billingAllowed, active, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commerce countries before and after the current commerce country in the ordered set where groupId = &#63; and billingAllowed = &#63; and active = &#63;.
	 *
	 * @param commerceCountryId the primary key of the current commerce country
	 * @param groupId the group ID
	 * @param billingAllowed the billing allowed
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce country
	 * @throws NoSuchCountryException if a commerce country with the primary key could not be found
	 */
	@Override
	public CommerceCountry[] findByG_B_A_PrevAndNext(
			long commerceCountryId, long groupId, boolean billingAllowed,
			boolean active,
			OrderByComparator<CommerceCountry> orderByComparator)
		throws NoSuchCountryException {

		CommerceCountry commerceCountry = findByPrimaryKey(commerceCountryId);

		Session session = null;

		try {
			session = openSession();

			CommerceCountry[] array = new CommerceCountryImpl[3];

			array[0] = getByG_B_A_PrevAndNext(
				session, commerceCountry, groupId, billingAllowed, active,
				orderByComparator, true);

			array[1] = commerceCountry;

			array[2] = getByG_B_A_PrevAndNext(
				session, commerceCountry, groupId, billingAllowed, active,
				orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CommerceCountry getByG_B_A_PrevAndNext(
		Session session, CommerceCountry commerceCountry, long groupId,
		boolean billingAllowed, boolean active,
		OrderByComparator<CommerceCountry> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_COMMERCECOUNTRY_WHERE);

		query.append(_FINDER_COLUMN_G_B_A_GROUPID_2);

		query.append(_FINDER_COLUMN_G_B_A_BILLINGALLOWED_2);

		query.append(_FINDER_COLUMN_G_B_A_ACTIVE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CommerceCountryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(billingAllowed);

		qPos.add(active);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						commerceCountry)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CommerceCountry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commerce countries where groupId = &#63; and billingAllowed = &#63; and active = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param billingAllowed the billing allowed
	 * @param active the active
	 */
	@Override
	public void removeByG_B_A(
		long groupId, boolean billingAllowed, boolean active) {

		for (CommerceCountry commerceCountry :
				findByG_B_A(
					groupId, billingAllowed, active, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(commerceCountry);
		}
	}

	/**
	 * Returns the number of commerce countries where groupId = &#63; and billingAllowed = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param billingAllowed the billing allowed
	 * @param active the active
	 * @return the number of matching commerce countries
	 */
	@Override
	public int countByG_B_A(
		long groupId, boolean billingAllowed, boolean active) {

		FinderPath finderPath = _finderPathCountByG_B_A;

		Object[] finderArgs = new Object[] {groupId, billingAllowed, active};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_COMMERCECOUNTRY_WHERE);

			query.append(_FINDER_COLUMN_G_B_A_GROUPID_2);

			query.append(_FINDER_COLUMN_G_B_A_BILLINGALLOWED_2);

			query.append(_FINDER_COLUMN_G_B_A_ACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(billingAllowed);

				qPos.add(active);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_B_A_GROUPID_2 =
		"commerceCountry.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_B_A_BILLINGALLOWED_2 =
		"commerceCountry.billingAllowed = ? AND ";

	private static final String _FINDER_COLUMN_G_B_A_ACTIVE_2 =
		"commerceCountry.active = ?";

	private FinderPath _finderPathWithPaginationFindByG_S_A;
	private FinderPath _finderPathWithoutPaginationFindByG_S_A;
	private FinderPath _finderPathCountByG_S_A;

	/**
	 * Returns all the commerce countries where groupId = &#63; and shippingAllowed = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param shippingAllowed the shipping allowed
	 * @param active the active
	 * @return the matching commerce countries
	 */
	@Override
	public List<CommerceCountry> findByG_S_A(
		long groupId, boolean shippingAllowed, boolean active) {

		return findByG_S_A(
			groupId, shippingAllowed, active, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commerce countries where groupId = &#63; and shippingAllowed = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CommerceCountryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param shippingAllowed the shipping allowed
	 * @param active the active
	 * @param start the lower bound of the range of commerce countries
	 * @param end the upper bound of the range of commerce countries (not inclusive)
	 * @return the range of matching commerce countries
	 */
	@Override
	public List<CommerceCountry> findByG_S_A(
		long groupId, boolean shippingAllowed, boolean active, int start,
		int end) {

		return findByG_S_A(groupId, shippingAllowed, active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce countries where groupId = &#63; and shippingAllowed = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CommerceCountryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param shippingAllowed the shipping allowed
	 * @param active the active
	 * @param start the lower bound of the range of commerce countries
	 * @param end the upper bound of the range of commerce countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce countries
	 */
	@Override
	public List<CommerceCountry> findByG_S_A(
		long groupId, boolean shippingAllowed, boolean active, int start,
		int end, OrderByComparator<CommerceCountry> orderByComparator) {

		return findByG_S_A(
			groupId, shippingAllowed, active, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the commerce countries where groupId = &#63; and shippingAllowed = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CommerceCountryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param shippingAllowed the shipping allowed
	 * @param active the active
	 * @param start the lower bound of the range of commerce countries
	 * @param end the upper bound of the range of commerce countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching commerce countries
	 */
	@Override
	public List<CommerceCountry> findByG_S_A(
		long groupId, boolean shippingAllowed, boolean active, int start,
		int end, OrderByComparator<CommerceCountry> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByG_S_A;
			finderArgs = new Object[] {groupId, shippingAllowed, active};
		}
		else {
			finderPath = _finderPathWithPaginationFindByG_S_A;
			finderArgs = new Object[] {
				groupId, shippingAllowed, active, start, end, orderByComparator
			};
		}

		List<CommerceCountry> list = null;

		if (retrieveFromCache) {
			list = (List<CommerceCountry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommerceCountry commerceCountry : list) {
					if ((groupId != commerceCountry.getGroupId()) ||
						(shippingAllowed !=
							commerceCountry.isShippingAllowed()) ||
						(active != commerceCountry.isActive())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_COMMERCECOUNTRY_WHERE);

			query.append(_FINDER_COLUMN_G_S_A_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_A_SHIPPINGALLOWED_2);

			query.append(_FINDER_COLUMN_G_S_A_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CommerceCountryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(shippingAllowed);

				qPos.add(active);

				if (!pagination) {
					list = (List<CommerceCountry>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CommerceCountry>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first commerce country in the ordered set where groupId = &#63; and shippingAllowed = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param shippingAllowed the shipping allowed
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce country
	 * @throws NoSuchCountryException if a matching commerce country could not be found
	 */
	@Override
	public CommerceCountry findByG_S_A_First(
			long groupId, boolean shippingAllowed, boolean active,
			OrderByComparator<CommerceCountry> orderByComparator)
		throws NoSuchCountryException {

		CommerceCountry commerceCountry = fetchByG_S_A_First(
			groupId, shippingAllowed, active, orderByComparator);

		if (commerceCountry != null) {
			return commerceCountry;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", shippingAllowed=");
		msg.append(shippingAllowed);

		msg.append(", active=");
		msg.append(active);

		msg.append("}");

		throw new NoSuchCountryException(msg.toString());
	}

	/**
	 * Returns the first commerce country in the ordered set where groupId = &#63; and shippingAllowed = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param shippingAllowed the shipping allowed
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce country, or <code>null</code> if a matching commerce country could not be found
	 */
	@Override
	public CommerceCountry fetchByG_S_A_First(
		long groupId, boolean shippingAllowed, boolean active,
		OrderByComparator<CommerceCountry> orderByComparator) {

		List<CommerceCountry> list = findByG_S_A(
			groupId, shippingAllowed, active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commerce country in the ordered set where groupId = &#63; and shippingAllowed = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param shippingAllowed the shipping allowed
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce country
	 * @throws NoSuchCountryException if a matching commerce country could not be found
	 */
	@Override
	public CommerceCountry findByG_S_A_Last(
			long groupId, boolean shippingAllowed, boolean active,
			OrderByComparator<CommerceCountry> orderByComparator)
		throws NoSuchCountryException {

		CommerceCountry commerceCountry = fetchByG_S_A_Last(
			groupId, shippingAllowed, active, orderByComparator);

		if (commerceCountry != null) {
			return commerceCountry;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", shippingAllowed=");
		msg.append(shippingAllowed);

		msg.append(", active=");
		msg.append(active);

		msg.append("}");

		throw new NoSuchCountryException(msg.toString());
	}

	/**
	 * Returns the last commerce country in the ordered set where groupId = &#63; and shippingAllowed = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param shippingAllowed the shipping allowed
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce country, or <code>null</code> if a matching commerce country could not be found
	 */
	@Override
	public CommerceCountry fetchByG_S_A_Last(
		long groupId, boolean shippingAllowed, boolean active,
		OrderByComparator<CommerceCountry> orderByComparator) {

		int count = countByG_S_A(groupId, shippingAllowed, active);

		if (count == 0) {
			return null;
		}

		List<CommerceCountry> list = findByG_S_A(
			groupId, shippingAllowed, active, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commerce countries before and after the current commerce country in the ordered set where groupId = &#63; and shippingAllowed = &#63; and active = &#63;.
	 *
	 * @param commerceCountryId the primary key of the current commerce country
	 * @param groupId the group ID
	 * @param shippingAllowed the shipping allowed
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce country
	 * @throws NoSuchCountryException if a commerce country with the primary key could not be found
	 */
	@Override
	public CommerceCountry[] findByG_S_A_PrevAndNext(
			long commerceCountryId, long groupId, boolean shippingAllowed,
			boolean active,
			OrderByComparator<CommerceCountry> orderByComparator)
		throws NoSuchCountryException {

		CommerceCountry commerceCountry = findByPrimaryKey(commerceCountryId);

		Session session = null;

		try {
			session = openSession();

			CommerceCountry[] array = new CommerceCountryImpl[3];

			array[0] = getByG_S_A_PrevAndNext(
				session, commerceCountry, groupId, shippingAllowed, active,
				orderByComparator, true);

			array[1] = commerceCountry;

			array[2] = getByG_S_A_PrevAndNext(
				session, commerceCountry, groupId, shippingAllowed, active,
				orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CommerceCountry getByG_S_A_PrevAndNext(
		Session session, CommerceCountry commerceCountry, long groupId,
		boolean shippingAllowed, boolean active,
		OrderByComparator<CommerceCountry> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_COMMERCECOUNTRY_WHERE);

		query.append(_FINDER_COLUMN_G_S_A_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_A_SHIPPINGALLOWED_2);

		query.append(_FINDER_COLUMN_G_S_A_ACTIVE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CommerceCountryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(shippingAllowed);

		qPos.add(active);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						commerceCountry)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CommerceCountry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commerce countries where groupId = &#63; and shippingAllowed = &#63; and active = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param shippingAllowed the shipping allowed
	 * @param active the active
	 */
	@Override
	public void removeByG_S_A(
		long groupId, boolean shippingAllowed, boolean active) {

		for (CommerceCountry commerceCountry :
				findByG_S_A(
					groupId, shippingAllowed, active, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(commerceCountry);
		}
	}

	/**
	 * Returns the number of commerce countries where groupId = &#63; and shippingAllowed = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param shippingAllowed the shipping allowed
	 * @param active the active
	 * @return the number of matching commerce countries
	 */
	@Override
	public int countByG_S_A(
		long groupId, boolean shippingAllowed, boolean active) {

		FinderPath finderPath = _finderPathCountByG_S_A;

		Object[] finderArgs = new Object[] {groupId, shippingAllowed, active};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_COMMERCECOUNTRY_WHERE);

			query.append(_FINDER_COLUMN_G_S_A_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_A_SHIPPINGALLOWED_2);

			query.append(_FINDER_COLUMN_G_S_A_ACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(shippingAllowed);

				qPos.add(active);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_S_A_GROUPID_2 =
		"commerceCountry.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_A_SHIPPINGALLOWED_2 =
		"commerceCountry.shippingAllowed = ? AND ";

	private static final String _FINDER_COLUMN_G_S_A_ACTIVE_2 =
		"commerceCountry.active = ?";

	public CommerceCountryPersistenceImpl() {
		setModelClass(CommerceCountry.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("active", "active_");

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
				"_dbColumnNames");

			field.setAccessible(true);

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the commerce country in the entity cache if it is enabled.
	 *
	 * @param commerceCountry the commerce country
	 */
	@Override
	public void cacheResult(CommerceCountry commerceCountry) {
		entityCache.putResult(
			CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
			CommerceCountryImpl.class, commerceCountry.getPrimaryKey(),
			commerceCountry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				commerceCountry.getUuid(), commerceCountry.getGroupId()
			},
			commerceCountry);

		finderCache.putResult(
			_finderPathFetchByG_Tw,
			new Object[] {
				commerceCountry.getGroupId(),
				commerceCountry.getTwoLettersISOCode()
			},
			commerceCountry);

		finderCache.putResult(
			_finderPathFetchByG_N,
			new Object[] {
				commerceCountry.getGroupId(),
				commerceCountry.getNumericISOCode()
			},
			commerceCountry);

		commerceCountry.resetOriginalValues();
	}

	/**
	 * Caches the commerce countries in the entity cache if it is enabled.
	 *
	 * @param commerceCountries the commerce countries
	 */
	@Override
	public void cacheResult(List<CommerceCountry> commerceCountries) {
		for (CommerceCountry commerceCountry : commerceCountries) {
			if (entityCache.getResult(
					CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
					CommerceCountryImpl.class,
					commerceCountry.getPrimaryKey()) == null) {

				cacheResult(commerceCountry);
			}
			else {
				commerceCountry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all commerce countries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CommerceCountryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the commerce country.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CommerceCountry commerceCountry) {
		entityCache.removeResult(
			CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
			CommerceCountryImpl.class, commerceCountry.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(CommerceCountryModelImpl)commerceCountry, true);
	}

	@Override
	public void clearCache(List<CommerceCountry> commerceCountries) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CommerceCountry commerceCountry : commerceCountries) {
			entityCache.removeResult(
				CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
				CommerceCountryImpl.class, commerceCountry.getPrimaryKey());

			clearUniqueFindersCache(
				(CommerceCountryModelImpl)commerceCountry, true);
		}
	}

	protected void cacheUniqueFindersCache(
		CommerceCountryModelImpl commerceCountryModelImpl) {

		Object[] args = new Object[] {
			commerceCountryModelImpl.getUuid(),
			commerceCountryModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, commerceCountryModelImpl, false);

		args = new Object[] {
			commerceCountryModelImpl.getGroupId(),
			commerceCountryModelImpl.getTwoLettersISOCode()
		};

		finderCache.putResult(
			_finderPathCountByG_Tw, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByG_Tw, args, commerceCountryModelImpl, false);

		args = new Object[] {
			commerceCountryModelImpl.getGroupId(),
			commerceCountryModelImpl.getNumericISOCode()
		};

		finderCache.putResult(
			_finderPathCountByG_N, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByG_N, args, commerceCountryModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		CommerceCountryModelImpl commerceCountryModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				commerceCountryModelImpl.getUuid(),
				commerceCountryModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((commerceCountryModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				commerceCountryModelImpl.getOriginalUuid(),
				commerceCountryModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				commerceCountryModelImpl.getGroupId(),
				commerceCountryModelImpl.getTwoLettersISOCode()
			};

			finderCache.removeResult(_finderPathCountByG_Tw, args);
			finderCache.removeResult(_finderPathFetchByG_Tw, args);
		}

		if ((commerceCountryModelImpl.getColumnBitmask() &
			 _finderPathFetchByG_Tw.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				commerceCountryModelImpl.getOriginalGroupId(),
				commerceCountryModelImpl.getOriginalTwoLettersISOCode()
			};

			finderCache.removeResult(_finderPathCountByG_Tw, args);
			finderCache.removeResult(_finderPathFetchByG_Tw, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				commerceCountryModelImpl.getGroupId(),
				commerceCountryModelImpl.getNumericISOCode()
			};

			finderCache.removeResult(_finderPathCountByG_N, args);
			finderCache.removeResult(_finderPathFetchByG_N, args);
		}

		if ((commerceCountryModelImpl.getColumnBitmask() &
			 _finderPathFetchByG_N.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				commerceCountryModelImpl.getOriginalGroupId(),
				commerceCountryModelImpl.getOriginalNumericISOCode()
			};

			finderCache.removeResult(_finderPathCountByG_N, args);
			finderCache.removeResult(_finderPathFetchByG_N, args);
		}
	}

	/**
	 * Creates a new commerce country with the primary key. Does not add the commerce country to the database.
	 *
	 * @param commerceCountryId the primary key for the new commerce country
	 * @return the new commerce country
	 */
	@Override
	public CommerceCountry create(long commerceCountryId) {
		CommerceCountry commerceCountry = new CommerceCountryImpl();

		commerceCountry.setNew(true);
		commerceCountry.setPrimaryKey(commerceCountryId);

		String uuid = PortalUUIDUtil.generate();

		commerceCountry.setUuid(uuid);

		commerceCountry.setCompanyId(companyProvider.getCompanyId());

		return commerceCountry;
	}

	/**
	 * Removes the commerce country with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commerceCountryId the primary key of the commerce country
	 * @return the commerce country that was removed
	 * @throws NoSuchCountryException if a commerce country with the primary key could not be found
	 */
	@Override
	public CommerceCountry remove(long commerceCountryId)
		throws NoSuchCountryException {

		return remove((Serializable)commerceCountryId);
	}

	/**
	 * Removes the commerce country with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the commerce country
	 * @return the commerce country that was removed
	 * @throws NoSuchCountryException if a commerce country with the primary key could not be found
	 */
	@Override
	public CommerceCountry remove(Serializable primaryKey)
		throws NoSuchCountryException {

		Session session = null;

		try {
			session = openSession();

			CommerceCountry commerceCountry = (CommerceCountry)session.get(
				CommerceCountryImpl.class, primaryKey);

			if (commerceCountry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCountryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(commerceCountry);
		}
		catch (NoSuchCountryException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected CommerceCountry removeImpl(CommerceCountry commerceCountry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(commerceCountry)) {
				commerceCountry = (CommerceCountry)session.get(
					CommerceCountryImpl.class,
					commerceCountry.getPrimaryKeyObj());
			}

			if (commerceCountry != null) {
				session.delete(commerceCountry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (commerceCountry != null) {
			clearCache(commerceCountry);
		}

		return commerceCountry;
	}

	@Override
	public CommerceCountry updateImpl(CommerceCountry commerceCountry) {
		boolean isNew = commerceCountry.isNew();

		if (!(commerceCountry instanceof CommerceCountryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(commerceCountry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					commerceCountry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in commerceCountry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CommerceCountry implementation " +
					commerceCountry.getClass());
		}

		CommerceCountryModelImpl commerceCountryModelImpl =
			(CommerceCountryModelImpl)commerceCountry;

		if (Validator.isNull(commerceCountry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			commerceCountry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (commerceCountry.getCreateDate() == null)) {
			if (serviceContext == null) {
				commerceCountry.setCreateDate(now);
			}
			else {
				commerceCountry.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!commerceCountryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				commerceCountry.setModifiedDate(now);
			}
			else {
				commerceCountry.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (commerceCountry.isNew()) {
				session.save(commerceCountry);

				commerceCountry.setNew(false);
			}
			else {
				commerceCountry = (CommerceCountry)session.merge(
					commerceCountry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!CommerceCountryModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {commerceCountryModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				commerceCountryModelImpl.getUuid(),
				commerceCountryModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {commerceCountryModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			args = new Object[] {
				commerceCountryModelImpl.getGroupId(),
				commerceCountryModelImpl.isActive()
			};

			finderCache.removeResult(_finderPathCountByG_A, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_A, args);

			args = new Object[] {
				commerceCountryModelImpl.getGroupId(),
				commerceCountryModelImpl.isBillingAllowed(),
				commerceCountryModelImpl.isActive()
			};

			finderCache.removeResult(_finderPathCountByG_B_A, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_B_A, args);

			args = new Object[] {
				commerceCountryModelImpl.getGroupId(),
				commerceCountryModelImpl.isShippingAllowed(),
				commerceCountryModelImpl.isActive()
			};

			finderCache.removeResult(_finderPathCountByG_S_A, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_S_A, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((commerceCountryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					commerceCountryModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {commerceCountryModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((commerceCountryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					commerceCountryModelImpl.getOriginalUuid(),
					commerceCountryModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					commerceCountryModelImpl.getUuid(),
					commerceCountryModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((commerceCountryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					commerceCountryModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {commerceCountryModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}

			if ((commerceCountryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_A.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					commerceCountryModelImpl.getOriginalGroupId(),
					commerceCountryModelImpl.getOriginalActive()
				};

				finderCache.removeResult(_finderPathCountByG_A, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_A, args);

				args = new Object[] {
					commerceCountryModelImpl.getGroupId(),
					commerceCountryModelImpl.isActive()
				};

				finderCache.removeResult(_finderPathCountByG_A, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_A, args);
			}

			if ((commerceCountryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_B_A.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					commerceCountryModelImpl.getOriginalGroupId(),
					commerceCountryModelImpl.getOriginalBillingAllowed(),
					commerceCountryModelImpl.getOriginalActive()
				};

				finderCache.removeResult(_finderPathCountByG_B_A, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_B_A, args);

				args = new Object[] {
					commerceCountryModelImpl.getGroupId(),
					commerceCountryModelImpl.isBillingAllowed(),
					commerceCountryModelImpl.isActive()
				};

				finderCache.removeResult(_finderPathCountByG_B_A, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_B_A, args);
			}

			if ((commerceCountryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_S_A.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					commerceCountryModelImpl.getOriginalGroupId(),
					commerceCountryModelImpl.getOriginalShippingAllowed(),
					commerceCountryModelImpl.getOriginalActive()
				};

				finderCache.removeResult(_finderPathCountByG_S_A, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_S_A, args);

				args = new Object[] {
					commerceCountryModelImpl.getGroupId(),
					commerceCountryModelImpl.isShippingAllowed(),
					commerceCountryModelImpl.isActive()
				};

				finderCache.removeResult(_finderPathCountByG_S_A, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_S_A, args);
			}
		}

		entityCache.putResult(
			CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
			CommerceCountryImpl.class, commerceCountry.getPrimaryKey(),
			commerceCountry, false);

		clearUniqueFindersCache(commerceCountryModelImpl, false);
		cacheUniqueFindersCache(commerceCountryModelImpl);

		commerceCountry.resetOriginalValues();

		return commerceCountry;
	}

	/**
	 * Returns the commerce country with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the commerce country
	 * @return the commerce country
	 * @throws NoSuchCountryException if a commerce country with the primary key could not be found
	 */
	@Override
	public CommerceCountry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCountryException {

		CommerceCountry commerceCountry = fetchByPrimaryKey(primaryKey);

		if (commerceCountry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCountryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return commerceCountry;
	}

	/**
	 * Returns the commerce country with the primary key or throws a <code>NoSuchCountryException</code> if it could not be found.
	 *
	 * @param commerceCountryId the primary key of the commerce country
	 * @return the commerce country
	 * @throws NoSuchCountryException if a commerce country with the primary key could not be found
	 */
	@Override
	public CommerceCountry findByPrimaryKey(long commerceCountryId)
		throws NoSuchCountryException {

		return findByPrimaryKey((Serializable)commerceCountryId);
	}

	/**
	 * Returns the commerce country with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the commerce country
	 * @return the commerce country, or <code>null</code> if a commerce country with the primary key could not be found
	 */
	@Override
	public CommerceCountry fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
			CommerceCountryImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CommerceCountry commerceCountry = (CommerceCountry)serializable;

		if (commerceCountry == null) {
			Session session = null;

			try {
				session = openSession();

				commerceCountry = (CommerceCountry)session.get(
					CommerceCountryImpl.class, primaryKey);

				if (commerceCountry != null) {
					cacheResult(commerceCountry);
				}
				else {
					entityCache.putResult(
						CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
						CommerceCountryImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
					CommerceCountryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return commerceCountry;
	}

	/**
	 * Returns the commerce country with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param commerceCountryId the primary key of the commerce country
	 * @return the commerce country, or <code>null</code> if a commerce country with the primary key could not be found
	 */
	@Override
	public CommerceCountry fetchByPrimaryKey(long commerceCountryId) {
		return fetchByPrimaryKey((Serializable)commerceCountryId);
	}

	@Override
	public Map<Serializable, CommerceCountry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CommerceCountry> map =
			new HashMap<Serializable, CommerceCountry>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CommerceCountry commerceCountry = fetchByPrimaryKey(primaryKey);

			if (commerceCountry != null) {
				map.put(primaryKey, commerceCountry);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
				CommerceCountryImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (CommerceCountry)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_COMMERCECOUNTRY_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (CommerceCountry commerceCountry :
					(List<CommerceCountry>)q.list()) {

				map.put(commerceCountry.getPrimaryKeyObj(), commerceCountry);

				cacheResult(commerceCountry);

				uncachedPrimaryKeys.remove(commerceCountry.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
					CommerceCountryImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the commerce countries.
	 *
	 * @return the commerce countries
	 */
	@Override
	public List<CommerceCountry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commerce countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CommerceCountryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce countries
	 * @param end the upper bound of the range of commerce countries (not inclusive)
	 * @return the range of commerce countries
	 */
	@Override
	public List<CommerceCountry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CommerceCountryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce countries
	 * @param end the upper bound of the range of commerce countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of commerce countries
	 */
	@Override
	public List<CommerceCountry> findAll(
		int start, int end,
		OrderByComparator<CommerceCountry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commerce countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CommerceCountryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce countries
	 * @param end the upper bound of the range of commerce countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of commerce countries
	 */
	@Override
	public List<CommerceCountry> findAll(
		int start, int end,
		OrderByComparator<CommerceCountry> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<CommerceCountry> list = null;

		if (retrieveFromCache) {
			list = (List<CommerceCountry>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_COMMERCECOUNTRY);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COMMERCECOUNTRY;

				if (pagination) {
					sql = sql.concat(CommerceCountryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CommerceCountry>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CommerceCountry>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the commerce countries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CommerceCountry commerceCountry : findAll()) {
			remove(commerceCountry);
		}
	}

	/**
	 * Returns the number of commerce countries.
	 *
	 * @return the number of commerce countries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COMMERCECOUNTRY);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CommerceCountryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the commerce country persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
			CommerceCountryModelImpl.FINDER_CACHE_ENABLED,
			CommerceCountryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
			CommerceCountryModelImpl.FINDER_CACHE_ENABLED,
			CommerceCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
			CommerceCountryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
			CommerceCountryModelImpl.FINDER_CACHE_ENABLED,
			CommerceCountryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
			CommerceCountryModelImpl.FINDER_CACHE_ENABLED,
			CommerceCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			CommerceCountryModelImpl.UUID_COLUMN_BITMASK |
			CommerceCountryModelImpl.PRIORITY_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
			CommerceCountryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
			CommerceCountryModelImpl.FINDER_CACHE_ENABLED,
			CommerceCountryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			CommerceCountryModelImpl.UUID_COLUMN_BITMASK |
			CommerceCountryModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
			CommerceCountryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
			CommerceCountryModelImpl.FINDER_CACHE_ENABLED,
			CommerceCountryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
			CommerceCountryModelImpl.FINDER_CACHE_ENABLED,
			CommerceCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			CommerceCountryModelImpl.UUID_COLUMN_BITMASK |
			CommerceCountryModelImpl.COMPANYID_COLUMN_BITMASK |
			CommerceCountryModelImpl.PRIORITY_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
			CommerceCountryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
			CommerceCountryModelImpl.FINDER_CACHE_ENABLED,
			CommerceCountryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
			CommerceCountryModelImpl.FINDER_CACHE_ENABLED,
			CommerceCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			CommerceCountryModelImpl.GROUPID_COLUMN_BITMASK |
			CommerceCountryModelImpl.PRIORITY_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
			CommerceCountryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

		_finderPathFetchByG_Tw = new FinderPath(
			CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
			CommerceCountryModelImpl.FINDER_CACHE_ENABLED,
			CommerceCountryImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByG_Tw",
			new String[] {Long.class.getName(), String.class.getName()},
			CommerceCountryModelImpl.GROUPID_COLUMN_BITMASK |
			CommerceCountryModelImpl.TWOLETTERSISOCODE_COLUMN_BITMASK);

		_finderPathCountByG_Tw = new FinderPath(
			CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
			CommerceCountryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_Tw",
			new String[] {Long.class.getName(), String.class.getName()});

		_finderPathFetchByG_N = new FinderPath(
			CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
			CommerceCountryModelImpl.FINDER_CACHE_ENABLED,
			CommerceCountryImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByG_N",
			new String[] {Long.class.getName(), Integer.class.getName()},
			CommerceCountryModelImpl.GROUPID_COLUMN_BITMASK |
			CommerceCountryModelImpl.NUMERICISOCODE_COLUMN_BITMASK);

		_finderPathCountByG_N = new FinderPath(
			CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
			CommerceCountryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_N",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByG_A = new FinderPath(
			CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
			CommerceCountryModelImpl.FINDER_CACHE_ENABLED,
			CommerceCountryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByG_A",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_A = new FinderPath(
			CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
			CommerceCountryModelImpl.FINDER_CACHE_ENABLED,
			CommerceCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_A",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			CommerceCountryModelImpl.GROUPID_COLUMN_BITMASK |
			CommerceCountryModelImpl.ACTIVE_COLUMN_BITMASK |
			CommerceCountryModelImpl.PRIORITY_COLUMN_BITMASK);

		_finderPathCountByG_A = new FinderPath(
			CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
			CommerceCountryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_A",
			new String[] {Long.class.getName(), Boolean.class.getName()});

		_finderPathWithPaginationFindByG_B_A = new FinderPath(
			CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
			CommerceCountryModelImpl.FINDER_CACHE_ENABLED,
			CommerceCountryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByG_B_A",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_B_A = new FinderPath(
			CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
			CommerceCountryModelImpl.FINDER_CACHE_ENABLED,
			CommerceCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_B_A",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			},
			CommerceCountryModelImpl.GROUPID_COLUMN_BITMASK |
			CommerceCountryModelImpl.BILLINGALLOWED_COLUMN_BITMASK |
			CommerceCountryModelImpl.ACTIVE_COLUMN_BITMASK |
			CommerceCountryModelImpl.PRIORITY_COLUMN_BITMASK);

		_finderPathCountByG_B_A = new FinderPath(
			CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
			CommerceCountryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_B_A",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			});

		_finderPathWithPaginationFindByG_S_A = new FinderPath(
			CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
			CommerceCountryModelImpl.FINDER_CACHE_ENABLED,
			CommerceCountryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByG_S_A",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_S_A = new FinderPath(
			CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
			CommerceCountryModelImpl.FINDER_CACHE_ENABLED,
			CommerceCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S_A",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			},
			CommerceCountryModelImpl.GROUPID_COLUMN_BITMASK |
			CommerceCountryModelImpl.SHIPPINGALLOWED_COLUMN_BITMASK |
			CommerceCountryModelImpl.ACTIVE_COLUMN_BITMASK |
			CommerceCountryModelImpl.PRIORITY_COLUMN_BITMASK);

		_finderPathCountByG_S_A = new FinderPath(
			CommerceCountryModelImpl.ENTITY_CACHE_ENABLED,
			CommerceCountryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S_A",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			});
	}

	public void destroy() {
		entityCache.removeCache(CommerceCountryImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_COMMERCECOUNTRY =
		"SELECT commerceCountry FROM CommerceCountry commerceCountry";

	private static final String _SQL_SELECT_COMMERCECOUNTRY_WHERE_PKS_IN =
		"SELECT commerceCountry FROM CommerceCountry commerceCountry WHERE commerceCountryId IN (";

	private static final String _SQL_SELECT_COMMERCECOUNTRY_WHERE =
		"SELECT commerceCountry FROM CommerceCountry commerceCountry WHERE ";

	private static final String _SQL_COUNT_COMMERCECOUNTRY =
		"SELECT COUNT(commerceCountry) FROM CommerceCountry commerceCountry";

	private static final String _SQL_COUNT_COMMERCECOUNTRY_WHERE =
		"SELECT COUNT(commerceCountry) FROM CommerceCountry commerceCountry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "commerceCountry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CommerceCountry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CommerceCountry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CommerceCountryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "active"});

}