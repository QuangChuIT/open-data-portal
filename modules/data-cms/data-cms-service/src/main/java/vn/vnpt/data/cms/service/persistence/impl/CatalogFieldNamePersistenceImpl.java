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

package vn.vnpt.data.cms.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import vn.vnpt.data.cms.exception.NoSuchCatalogFieldNameException;
import vn.vnpt.data.cms.model.CatalogFieldName;
import vn.vnpt.data.cms.model.impl.CatalogFieldNameImpl;
import vn.vnpt.data.cms.model.impl.CatalogFieldNameModelImpl;
import vn.vnpt.data.cms.service.persistence.CatalogFieldNamePersistence;
import vn.vnpt.data.cms.service.persistence.impl.constants.VNPTPersistenceConstants;

/**
 * The persistence implementation for the catalog field name service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author vnpt
 * @generated
 */
@Component(service = CatalogFieldNamePersistence.class)
public class CatalogFieldNamePersistenceImpl
	extends BasePersistenceImpl<CatalogFieldName>
	implements CatalogFieldNamePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CatalogFieldNameUtil</code> to access the catalog field name persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CatalogFieldNameImpl.class.getName();

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
	 * Returns all the catalog field names where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching catalog field names
	 */
	@Override
	public List<CatalogFieldName> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the catalog field names where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogFieldNameModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of catalog field names
	 * @param end the upper bound of the range of catalog field names (not inclusive)
	 * @return the range of matching catalog field names
	 */
	@Override
	public List<CatalogFieldName> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the catalog field names where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogFieldNameModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of catalog field names
	 * @param end the upper bound of the range of catalog field names (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching catalog field names
	 */
	@Override
	public List<CatalogFieldName> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CatalogFieldName> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the catalog field names where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogFieldNameModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of catalog field names
	 * @param end the upper bound of the range of catalog field names (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching catalog field names
	 */
	@Override
	public List<CatalogFieldName> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CatalogFieldName> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<CatalogFieldName> list = null;

		if (useFinderCache) {
			list = (List<CatalogFieldName>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CatalogFieldName catalogFieldName : list) {
					if (!uuid.equals(catalogFieldName.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CATALOGFIELDNAME_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CatalogFieldNameModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<CatalogFieldName>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first catalog field name in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog field name
	 * @throws NoSuchCatalogFieldNameException if a matching catalog field name could not be found
	 */
	@Override
	public CatalogFieldName findByUuid_First(
			String uuid, OrderByComparator<CatalogFieldName> orderByComparator)
		throws NoSuchCatalogFieldNameException {

		CatalogFieldName catalogFieldName = fetchByUuid_First(
			uuid, orderByComparator);

		if (catalogFieldName != null) {
			return catalogFieldName;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCatalogFieldNameException(sb.toString());
	}

	/**
	 * Returns the first catalog field name in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	@Override
	public CatalogFieldName fetchByUuid_First(
		String uuid, OrderByComparator<CatalogFieldName> orderByComparator) {

		List<CatalogFieldName> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last catalog field name in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog field name
	 * @throws NoSuchCatalogFieldNameException if a matching catalog field name could not be found
	 */
	@Override
	public CatalogFieldName findByUuid_Last(
			String uuid, OrderByComparator<CatalogFieldName> orderByComparator)
		throws NoSuchCatalogFieldNameException {

		CatalogFieldName catalogFieldName = fetchByUuid_Last(
			uuid, orderByComparator);

		if (catalogFieldName != null) {
			return catalogFieldName;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCatalogFieldNameException(sb.toString());
	}

	/**
	 * Returns the last catalog field name in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	@Override
	public CatalogFieldName fetchByUuid_Last(
		String uuid, OrderByComparator<CatalogFieldName> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CatalogFieldName> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the catalog field names before and after the current catalog field name in the ordered set where uuid = &#63;.
	 *
	 * @param entryId the primary key of the current catalog field name
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog field name
	 * @throws NoSuchCatalogFieldNameException if a catalog field name with the primary key could not be found
	 */
	@Override
	public CatalogFieldName[] findByUuid_PrevAndNext(
			long entryId, String uuid,
			OrderByComparator<CatalogFieldName> orderByComparator)
		throws NoSuchCatalogFieldNameException {

		uuid = Objects.toString(uuid, "");

		CatalogFieldName catalogFieldName = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			CatalogFieldName[] array = new CatalogFieldNameImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, catalogFieldName, uuid, orderByComparator, true);

			array[1] = catalogFieldName;

			array[2] = getByUuid_PrevAndNext(
				session, catalogFieldName, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CatalogFieldName getByUuid_PrevAndNext(
		Session session, CatalogFieldName catalogFieldName, String uuid,
		OrderByComparator<CatalogFieldName> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CATALOGFIELDNAME_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CatalogFieldNameModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						catalogFieldName)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CatalogFieldName> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the catalog field names where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CatalogFieldName catalogFieldName :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(catalogFieldName);
		}
	}

	/**
	 * Returns the number of catalog field names where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching catalog field names
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CATALOGFIELDNAME_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"catalogFieldName.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(catalogFieldName.uuid IS NULL OR catalogFieldName.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the catalog field name where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCatalogFieldNameException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching catalog field name
	 * @throws NoSuchCatalogFieldNameException if a matching catalog field name could not be found
	 */
	@Override
	public CatalogFieldName findByUUID_G(String uuid, long groupId)
		throws NoSuchCatalogFieldNameException {

		CatalogFieldName catalogFieldName = fetchByUUID_G(uuid, groupId);

		if (catalogFieldName == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCatalogFieldNameException(sb.toString());
		}

		return catalogFieldName;
	}

	/**
	 * Returns the catalog field name where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	@Override
	public CatalogFieldName fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the catalog field name where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	@Override
	public CatalogFieldName fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof CatalogFieldName) {
			CatalogFieldName catalogFieldName = (CatalogFieldName)result;

			if (!Objects.equals(uuid, catalogFieldName.getUuid()) ||
				(groupId != catalogFieldName.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CATALOGFIELDNAME_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<CatalogFieldName> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					CatalogFieldName catalogFieldName = list.get(0);

					result = catalogFieldName;

					cacheResult(catalogFieldName);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (CatalogFieldName)result;
		}
	}

	/**
	 * Removes the catalog field name where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the catalog field name that was removed
	 */
	@Override
	public CatalogFieldName removeByUUID_G(String uuid, long groupId)
		throws NoSuchCatalogFieldNameException {

		CatalogFieldName catalogFieldName = findByUUID_G(uuid, groupId);

		return remove(catalogFieldName);
	}

	/**
	 * Returns the number of catalog field names where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching catalog field names
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CATALOGFIELDNAME_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"catalogFieldName.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(catalogFieldName.uuid IS NULL OR catalogFieldName.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"catalogFieldName.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the catalog field names where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching catalog field names
	 */
	@Override
	public List<CatalogFieldName> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the catalog field names where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogFieldNameModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of catalog field names
	 * @param end the upper bound of the range of catalog field names (not inclusive)
	 * @return the range of matching catalog field names
	 */
	@Override
	public List<CatalogFieldName> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the catalog field names where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogFieldNameModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of catalog field names
	 * @param end the upper bound of the range of catalog field names (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching catalog field names
	 */
	@Override
	public List<CatalogFieldName> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CatalogFieldName> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the catalog field names where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogFieldNameModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of catalog field names
	 * @param end the upper bound of the range of catalog field names (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching catalog field names
	 */
	@Override
	public List<CatalogFieldName> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CatalogFieldName> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<CatalogFieldName> list = null;

		if (useFinderCache) {
			list = (List<CatalogFieldName>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CatalogFieldName catalogFieldName : list) {
					if (!uuid.equals(catalogFieldName.getUuid()) ||
						(companyId != catalogFieldName.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_CATALOGFIELDNAME_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CatalogFieldNameModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<CatalogFieldName>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first catalog field name in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog field name
	 * @throws NoSuchCatalogFieldNameException if a matching catalog field name could not be found
	 */
	@Override
	public CatalogFieldName findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CatalogFieldName> orderByComparator)
		throws NoSuchCatalogFieldNameException {

		CatalogFieldName catalogFieldName = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (catalogFieldName != null) {
			return catalogFieldName;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCatalogFieldNameException(sb.toString());
	}

	/**
	 * Returns the first catalog field name in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	@Override
	public CatalogFieldName fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CatalogFieldName> orderByComparator) {

		List<CatalogFieldName> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last catalog field name in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog field name
	 * @throws NoSuchCatalogFieldNameException if a matching catalog field name could not be found
	 */
	@Override
	public CatalogFieldName findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CatalogFieldName> orderByComparator)
		throws NoSuchCatalogFieldNameException {

		CatalogFieldName catalogFieldName = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (catalogFieldName != null) {
			return catalogFieldName;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCatalogFieldNameException(sb.toString());
	}

	/**
	 * Returns the last catalog field name in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	@Override
	public CatalogFieldName fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CatalogFieldName> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<CatalogFieldName> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the catalog field names before and after the current catalog field name in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param entryId the primary key of the current catalog field name
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog field name
	 * @throws NoSuchCatalogFieldNameException if a catalog field name with the primary key could not be found
	 */
	@Override
	public CatalogFieldName[] findByUuid_C_PrevAndNext(
			long entryId, String uuid, long companyId,
			OrderByComparator<CatalogFieldName> orderByComparator)
		throws NoSuchCatalogFieldNameException {

		uuid = Objects.toString(uuid, "");

		CatalogFieldName catalogFieldName = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			CatalogFieldName[] array = new CatalogFieldNameImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, catalogFieldName, uuid, companyId, orderByComparator,
				true);

			array[1] = catalogFieldName;

			array[2] = getByUuid_C_PrevAndNext(
				session, catalogFieldName, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CatalogFieldName getByUuid_C_PrevAndNext(
		Session session, CatalogFieldName catalogFieldName, String uuid,
		long companyId, OrderByComparator<CatalogFieldName> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CATALOGFIELDNAME_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CatalogFieldNameModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						catalogFieldName)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CatalogFieldName> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the catalog field names where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (CatalogFieldName catalogFieldName :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(catalogFieldName);
		}
	}

	/**
	 * Returns the number of catalog field names where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching catalog field names
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CATALOGFIELDNAME_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"catalogFieldName.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(catalogFieldName.uuid IS NULL OR catalogFieldName.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"catalogFieldName.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByCatalogId;
	private FinderPath _finderPathWithoutPaginationFindByCatalogId;
	private FinderPath _finderPathCountByCatalogId;

	/**
	 * Returns all the catalog field names where catalogId = &#63;.
	 *
	 * @param catalogId the catalog ID
	 * @return the matching catalog field names
	 */
	@Override
	public List<CatalogFieldName> findByCatalogId(long catalogId) {
		return findByCatalogId(
			catalogId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the catalog field names where catalogId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogFieldNameModelImpl</code>.
	 * </p>
	 *
	 * @param catalogId the catalog ID
	 * @param start the lower bound of the range of catalog field names
	 * @param end the upper bound of the range of catalog field names (not inclusive)
	 * @return the range of matching catalog field names
	 */
	@Override
	public List<CatalogFieldName> findByCatalogId(
		long catalogId, int start, int end) {

		return findByCatalogId(catalogId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the catalog field names where catalogId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogFieldNameModelImpl</code>.
	 * </p>
	 *
	 * @param catalogId the catalog ID
	 * @param start the lower bound of the range of catalog field names
	 * @param end the upper bound of the range of catalog field names (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching catalog field names
	 */
	@Override
	public List<CatalogFieldName> findByCatalogId(
		long catalogId, int start, int end,
		OrderByComparator<CatalogFieldName> orderByComparator) {

		return findByCatalogId(catalogId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the catalog field names where catalogId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogFieldNameModelImpl</code>.
	 * </p>
	 *
	 * @param catalogId the catalog ID
	 * @param start the lower bound of the range of catalog field names
	 * @param end the upper bound of the range of catalog field names (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching catalog field names
	 */
	@Override
	public List<CatalogFieldName> findByCatalogId(
		long catalogId, int start, int end,
		OrderByComparator<CatalogFieldName> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCatalogId;
				finderArgs = new Object[] {catalogId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCatalogId;
			finderArgs = new Object[] {
				catalogId, start, end, orderByComparator
			};
		}

		List<CatalogFieldName> list = null;

		if (useFinderCache) {
			list = (List<CatalogFieldName>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CatalogFieldName catalogFieldName : list) {
					if (catalogId != catalogFieldName.getCatalogId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CATALOGFIELDNAME_WHERE);

			sb.append(_FINDER_COLUMN_CATALOGID_CATALOGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CatalogFieldNameModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(catalogId);

				list = (List<CatalogFieldName>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first catalog field name in the ordered set where catalogId = &#63;.
	 *
	 * @param catalogId the catalog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog field name
	 * @throws NoSuchCatalogFieldNameException if a matching catalog field name could not be found
	 */
	@Override
	public CatalogFieldName findByCatalogId_First(
			long catalogId,
			OrderByComparator<CatalogFieldName> orderByComparator)
		throws NoSuchCatalogFieldNameException {

		CatalogFieldName catalogFieldName = fetchByCatalogId_First(
			catalogId, orderByComparator);

		if (catalogFieldName != null) {
			return catalogFieldName;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("catalogId=");
		sb.append(catalogId);

		sb.append("}");

		throw new NoSuchCatalogFieldNameException(sb.toString());
	}

	/**
	 * Returns the first catalog field name in the ordered set where catalogId = &#63;.
	 *
	 * @param catalogId the catalog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	@Override
	public CatalogFieldName fetchByCatalogId_First(
		long catalogId, OrderByComparator<CatalogFieldName> orderByComparator) {

		List<CatalogFieldName> list = findByCatalogId(
			catalogId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last catalog field name in the ordered set where catalogId = &#63;.
	 *
	 * @param catalogId the catalog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog field name
	 * @throws NoSuchCatalogFieldNameException if a matching catalog field name could not be found
	 */
	@Override
	public CatalogFieldName findByCatalogId_Last(
			long catalogId,
			OrderByComparator<CatalogFieldName> orderByComparator)
		throws NoSuchCatalogFieldNameException {

		CatalogFieldName catalogFieldName = fetchByCatalogId_Last(
			catalogId, orderByComparator);

		if (catalogFieldName != null) {
			return catalogFieldName;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("catalogId=");
		sb.append(catalogId);

		sb.append("}");

		throw new NoSuchCatalogFieldNameException(sb.toString());
	}

	/**
	 * Returns the last catalog field name in the ordered set where catalogId = &#63;.
	 *
	 * @param catalogId the catalog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	@Override
	public CatalogFieldName fetchByCatalogId_Last(
		long catalogId, OrderByComparator<CatalogFieldName> orderByComparator) {

		int count = countByCatalogId(catalogId);

		if (count == 0) {
			return null;
		}

		List<CatalogFieldName> list = findByCatalogId(
			catalogId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the catalog field names before and after the current catalog field name in the ordered set where catalogId = &#63;.
	 *
	 * @param entryId the primary key of the current catalog field name
	 * @param catalogId the catalog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog field name
	 * @throws NoSuchCatalogFieldNameException if a catalog field name with the primary key could not be found
	 */
	@Override
	public CatalogFieldName[] findByCatalogId_PrevAndNext(
			long entryId, long catalogId,
			OrderByComparator<CatalogFieldName> orderByComparator)
		throws NoSuchCatalogFieldNameException {

		CatalogFieldName catalogFieldName = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			CatalogFieldName[] array = new CatalogFieldNameImpl[3];

			array[0] = getByCatalogId_PrevAndNext(
				session, catalogFieldName, catalogId, orderByComparator, true);

			array[1] = catalogFieldName;

			array[2] = getByCatalogId_PrevAndNext(
				session, catalogFieldName, catalogId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CatalogFieldName getByCatalogId_PrevAndNext(
		Session session, CatalogFieldName catalogFieldName, long catalogId,
		OrderByComparator<CatalogFieldName> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CATALOGFIELDNAME_WHERE);

		sb.append(_FINDER_COLUMN_CATALOGID_CATALOGID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CatalogFieldNameModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(catalogId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						catalogFieldName)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CatalogFieldName> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the catalog field names where catalogId = &#63; from the database.
	 *
	 * @param catalogId the catalog ID
	 */
	@Override
	public void removeByCatalogId(long catalogId) {
		for (CatalogFieldName catalogFieldName :
				findByCatalogId(
					catalogId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(catalogFieldName);
		}
	}

	/**
	 * Returns the number of catalog field names where catalogId = &#63;.
	 *
	 * @param catalogId the catalog ID
	 * @return the number of matching catalog field names
	 */
	@Override
	public int countByCatalogId(long catalogId) {
		FinderPath finderPath = _finderPathCountByCatalogId;

		Object[] finderArgs = new Object[] {catalogId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CATALOGFIELDNAME_WHERE);

			sb.append(_FINDER_COLUMN_CATALOGID_CATALOGID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(catalogId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CATALOGID_CATALOGID_2 =
		"catalogFieldName.catalogId = ?";

	private FinderPath _finderPathWithPaginationFindByG_C;
	private FinderPath _finderPathWithoutPaginationFindByG_C;
	private FinderPath _finderPathCountByG_C;

	/**
	 * Returns all the catalog field names where groupId = &#63; and catalogId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @return the matching catalog field names
	 */
	@Override
	public List<CatalogFieldName> findByG_C(long groupId, long catalogId) {
		return findByG_C(
			groupId, catalogId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the catalog field names where groupId = &#63; and catalogId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogFieldNameModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param start the lower bound of the range of catalog field names
	 * @param end the upper bound of the range of catalog field names (not inclusive)
	 * @return the range of matching catalog field names
	 */
	@Override
	public List<CatalogFieldName> findByG_C(
		long groupId, long catalogId, int start, int end) {

		return findByG_C(groupId, catalogId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the catalog field names where groupId = &#63; and catalogId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogFieldNameModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param start the lower bound of the range of catalog field names
	 * @param end the upper bound of the range of catalog field names (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching catalog field names
	 */
	@Override
	public List<CatalogFieldName> findByG_C(
		long groupId, long catalogId, int start, int end,
		OrderByComparator<CatalogFieldName> orderByComparator) {

		return findByG_C(
			groupId, catalogId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the catalog field names where groupId = &#63; and catalogId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogFieldNameModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param start the lower bound of the range of catalog field names
	 * @param end the upper bound of the range of catalog field names (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching catalog field names
	 */
	@Override
	public List<CatalogFieldName> findByG_C(
		long groupId, long catalogId, int start, int end,
		OrderByComparator<CatalogFieldName> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_C;
				finderArgs = new Object[] {groupId, catalogId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_C;
			finderArgs = new Object[] {
				groupId, catalogId, start, end, orderByComparator
			};
		}

		List<CatalogFieldName> list = null;

		if (useFinderCache) {
			list = (List<CatalogFieldName>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CatalogFieldName catalogFieldName : list) {
					if ((groupId != catalogFieldName.getGroupId()) ||
						(catalogId != catalogFieldName.getCatalogId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_CATALOGFIELDNAME_WHERE);

			sb.append(_FINDER_COLUMN_G_C_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_C_CATALOGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CatalogFieldNameModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(catalogId);

				list = (List<CatalogFieldName>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first catalog field name in the ordered set where groupId = &#63; and catalogId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog field name
	 * @throws NoSuchCatalogFieldNameException if a matching catalog field name could not be found
	 */
	@Override
	public CatalogFieldName findByG_C_First(
			long groupId, long catalogId,
			OrderByComparator<CatalogFieldName> orderByComparator)
		throws NoSuchCatalogFieldNameException {

		CatalogFieldName catalogFieldName = fetchByG_C_First(
			groupId, catalogId, orderByComparator);

		if (catalogFieldName != null) {
			return catalogFieldName;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", catalogId=");
		sb.append(catalogId);

		sb.append("}");

		throw new NoSuchCatalogFieldNameException(sb.toString());
	}

	/**
	 * Returns the first catalog field name in the ordered set where groupId = &#63; and catalogId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	@Override
	public CatalogFieldName fetchByG_C_First(
		long groupId, long catalogId,
		OrderByComparator<CatalogFieldName> orderByComparator) {

		List<CatalogFieldName> list = findByG_C(
			groupId, catalogId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last catalog field name in the ordered set where groupId = &#63; and catalogId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog field name
	 * @throws NoSuchCatalogFieldNameException if a matching catalog field name could not be found
	 */
	@Override
	public CatalogFieldName findByG_C_Last(
			long groupId, long catalogId,
			OrderByComparator<CatalogFieldName> orderByComparator)
		throws NoSuchCatalogFieldNameException {

		CatalogFieldName catalogFieldName = fetchByG_C_Last(
			groupId, catalogId, orderByComparator);

		if (catalogFieldName != null) {
			return catalogFieldName;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", catalogId=");
		sb.append(catalogId);

		sb.append("}");

		throw new NoSuchCatalogFieldNameException(sb.toString());
	}

	/**
	 * Returns the last catalog field name in the ordered set where groupId = &#63; and catalogId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	@Override
	public CatalogFieldName fetchByG_C_Last(
		long groupId, long catalogId,
		OrderByComparator<CatalogFieldName> orderByComparator) {

		int count = countByG_C(groupId, catalogId);

		if (count == 0) {
			return null;
		}

		List<CatalogFieldName> list = findByG_C(
			groupId, catalogId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the catalog field names before and after the current catalog field name in the ordered set where groupId = &#63; and catalogId = &#63;.
	 *
	 * @param entryId the primary key of the current catalog field name
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog field name
	 * @throws NoSuchCatalogFieldNameException if a catalog field name with the primary key could not be found
	 */
	@Override
	public CatalogFieldName[] findByG_C_PrevAndNext(
			long entryId, long groupId, long catalogId,
			OrderByComparator<CatalogFieldName> orderByComparator)
		throws NoSuchCatalogFieldNameException {

		CatalogFieldName catalogFieldName = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			CatalogFieldName[] array = new CatalogFieldNameImpl[3];

			array[0] = getByG_C_PrevAndNext(
				session, catalogFieldName, groupId, catalogId,
				orderByComparator, true);

			array[1] = catalogFieldName;

			array[2] = getByG_C_PrevAndNext(
				session, catalogFieldName, groupId, catalogId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CatalogFieldName getByG_C_PrevAndNext(
		Session session, CatalogFieldName catalogFieldName, long groupId,
		long catalogId, OrderByComparator<CatalogFieldName> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CATALOGFIELDNAME_WHERE);

		sb.append(_FINDER_COLUMN_G_C_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_C_CATALOGID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CatalogFieldNameModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(catalogId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						catalogFieldName)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CatalogFieldName> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the catalog field names where groupId = &#63; and catalogId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 */
	@Override
	public void removeByG_C(long groupId, long catalogId) {
		for (CatalogFieldName catalogFieldName :
				findByG_C(
					groupId, catalogId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(catalogFieldName);
		}
	}

	/**
	 * Returns the number of catalog field names where groupId = &#63; and catalogId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @return the number of matching catalog field names
	 */
	@Override
	public int countByG_C(long groupId, long catalogId) {
		FinderPath finderPath = _finderPathCountByG_C;

		Object[] finderArgs = new Object[] {groupId, catalogId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CATALOGFIELDNAME_WHERE);

			sb.append(_FINDER_COLUMN_G_C_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_C_CATALOGID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(catalogId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_C_GROUPID_2 =
		"catalogFieldName.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_CATALOGID_2 =
		"catalogFieldName.catalogId = ?";

	private FinderPath _finderPathWithPaginationFindByG_C_S;
	private FinderPath _finderPathWithoutPaginationFindByG_C_S;
	private FinderPath _finderPathCountByG_C_S;

	/**
	 * Returns all the catalog field names where groupId = &#63; and catalogId = &#63; and hiddenStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param hiddenStatus the hidden status
	 * @return the matching catalog field names
	 */
	@Override
	public List<CatalogFieldName> findByG_C_S(
		long groupId, long catalogId, boolean hiddenStatus) {

		return findByG_C_S(
			groupId, catalogId, hiddenStatus, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the catalog field names where groupId = &#63; and catalogId = &#63; and hiddenStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogFieldNameModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param hiddenStatus the hidden status
	 * @param start the lower bound of the range of catalog field names
	 * @param end the upper bound of the range of catalog field names (not inclusive)
	 * @return the range of matching catalog field names
	 */
	@Override
	public List<CatalogFieldName> findByG_C_S(
		long groupId, long catalogId, boolean hiddenStatus, int start,
		int end) {

		return findByG_C_S(groupId, catalogId, hiddenStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the catalog field names where groupId = &#63; and catalogId = &#63; and hiddenStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogFieldNameModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param hiddenStatus the hidden status
	 * @param start the lower bound of the range of catalog field names
	 * @param end the upper bound of the range of catalog field names (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching catalog field names
	 */
	@Override
	public List<CatalogFieldName> findByG_C_S(
		long groupId, long catalogId, boolean hiddenStatus, int start, int end,
		OrderByComparator<CatalogFieldName> orderByComparator) {

		return findByG_C_S(
			groupId, catalogId, hiddenStatus, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the catalog field names where groupId = &#63; and catalogId = &#63; and hiddenStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogFieldNameModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param hiddenStatus the hidden status
	 * @param start the lower bound of the range of catalog field names
	 * @param end the upper bound of the range of catalog field names (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching catalog field names
	 */
	@Override
	public List<CatalogFieldName> findByG_C_S(
		long groupId, long catalogId, boolean hiddenStatus, int start, int end,
		OrderByComparator<CatalogFieldName> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_C_S;
				finderArgs = new Object[] {groupId, catalogId, hiddenStatus};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_C_S;
			finderArgs = new Object[] {
				groupId, catalogId, hiddenStatus, start, end, orderByComparator
			};
		}

		List<CatalogFieldName> list = null;

		if (useFinderCache) {
			list = (List<CatalogFieldName>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CatalogFieldName catalogFieldName : list) {
					if ((groupId != catalogFieldName.getGroupId()) ||
						(catalogId != catalogFieldName.getCatalogId()) ||
						(hiddenStatus != catalogFieldName.isHiddenStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_CATALOGFIELDNAME_WHERE);

			sb.append(_FINDER_COLUMN_G_C_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_C_S_CATALOGID_2);

			sb.append(_FINDER_COLUMN_G_C_S_HIDDENSTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CatalogFieldNameModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(catalogId);

				queryPos.add(hiddenStatus);

				list = (List<CatalogFieldName>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first catalog field name in the ordered set where groupId = &#63; and catalogId = &#63; and hiddenStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param hiddenStatus the hidden status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog field name
	 * @throws NoSuchCatalogFieldNameException if a matching catalog field name could not be found
	 */
	@Override
	public CatalogFieldName findByG_C_S_First(
			long groupId, long catalogId, boolean hiddenStatus,
			OrderByComparator<CatalogFieldName> orderByComparator)
		throws NoSuchCatalogFieldNameException {

		CatalogFieldName catalogFieldName = fetchByG_C_S_First(
			groupId, catalogId, hiddenStatus, orderByComparator);

		if (catalogFieldName != null) {
			return catalogFieldName;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", catalogId=");
		sb.append(catalogId);

		sb.append(", hiddenStatus=");
		sb.append(hiddenStatus);

		sb.append("}");

		throw new NoSuchCatalogFieldNameException(sb.toString());
	}

	/**
	 * Returns the first catalog field name in the ordered set where groupId = &#63; and catalogId = &#63; and hiddenStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param hiddenStatus the hidden status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	@Override
	public CatalogFieldName fetchByG_C_S_First(
		long groupId, long catalogId, boolean hiddenStatus,
		OrderByComparator<CatalogFieldName> orderByComparator) {

		List<CatalogFieldName> list = findByG_C_S(
			groupId, catalogId, hiddenStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last catalog field name in the ordered set where groupId = &#63; and catalogId = &#63; and hiddenStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param hiddenStatus the hidden status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog field name
	 * @throws NoSuchCatalogFieldNameException if a matching catalog field name could not be found
	 */
	@Override
	public CatalogFieldName findByG_C_S_Last(
			long groupId, long catalogId, boolean hiddenStatus,
			OrderByComparator<CatalogFieldName> orderByComparator)
		throws NoSuchCatalogFieldNameException {

		CatalogFieldName catalogFieldName = fetchByG_C_S_Last(
			groupId, catalogId, hiddenStatus, orderByComparator);

		if (catalogFieldName != null) {
			return catalogFieldName;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", catalogId=");
		sb.append(catalogId);

		sb.append(", hiddenStatus=");
		sb.append(hiddenStatus);

		sb.append("}");

		throw new NoSuchCatalogFieldNameException(sb.toString());
	}

	/**
	 * Returns the last catalog field name in the ordered set where groupId = &#63; and catalogId = &#63; and hiddenStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param hiddenStatus the hidden status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	@Override
	public CatalogFieldName fetchByG_C_S_Last(
		long groupId, long catalogId, boolean hiddenStatus,
		OrderByComparator<CatalogFieldName> orderByComparator) {

		int count = countByG_C_S(groupId, catalogId, hiddenStatus);

		if (count == 0) {
			return null;
		}

		List<CatalogFieldName> list = findByG_C_S(
			groupId, catalogId, hiddenStatus, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the catalog field names before and after the current catalog field name in the ordered set where groupId = &#63; and catalogId = &#63; and hiddenStatus = &#63;.
	 *
	 * @param entryId the primary key of the current catalog field name
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param hiddenStatus the hidden status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog field name
	 * @throws NoSuchCatalogFieldNameException if a catalog field name with the primary key could not be found
	 */
	@Override
	public CatalogFieldName[] findByG_C_S_PrevAndNext(
			long entryId, long groupId, long catalogId, boolean hiddenStatus,
			OrderByComparator<CatalogFieldName> orderByComparator)
		throws NoSuchCatalogFieldNameException {

		CatalogFieldName catalogFieldName = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			CatalogFieldName[] array = new CatalogFieldNameImpl[3];

			array[0] = getByG_C_S_PrevAndNext(
				session, catalogFieldName, groupId, catalogId, hiddenStatus,
				orderByComparator, true);

			array[1] = catalogFieldName;

			array[2] = getByG_C_S_PrevAndNext(
				session, catalogFieldName, groupId, catalogId, hiddenStatus,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CatalogFieldName getByG_C_S_PrevAndNext(
		Session session, CatalogFieldName catalogFieldName, long groupId,
		long catalogId, boolean hiddenStatus,
		OrderByComparator<CatalogFieldName> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_CATALOGFIELDNAME_WHERE);

		sb.append(_FINDER_COLUMN_G_C_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_C_S_CATALOGID_2);

		sb.append(_FINDER_COLUMN_G_C_S_HIDDENSTATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CatalogFieldNameModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(catalogId);

		queryPos.add(hiddenStatus);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						catalogFieldName)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CatalogFieldName> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the catalog field names where groupId = &#63; and catalogId = &#63; and hiddenStatus = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param hiddenStatus the hidden status
	 */
	@Override
	public void removeByG_C_S(
		long groupId, long catalogId, boolean hiddenStatus) {

		for (CatalogFieldName catalogFieldName :
				findByG_C_S(
					groupId, catalogId, hiddenStatus, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(catalogFieldName);
		}
	}

	/**
	 * Returns the number of catalog field names where groupId = &#63; and catalogId = &#63; and hiddenStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param hiddenStatus the hidden status
	 * @return the number of matching catalog field names
	 */
	@Override
	public int countByG_C_S(
		long groupId, long catalogId, boolean hiddenStatus) {

		FinderPath finderPath = _finderPathCountByG_C_S;

		Object[] finderArgs = new Object[] {groupId, catalogId, hiddenStatus};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_CATALOGFIELDNAME_WHERE);

			sb.append(_FINDER_COLUMN_G_C_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_C_S_CATALOGID_2);

			sb.append(_FINDER_COLUMN_G_C_S_HIDDENSTATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(catalogId);

				queryPos.add(hiddenStatus);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_C_S_GROUPID_2 =
		"catalogFieldName.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_S_CATALOGID_2 =
		"catalogFieldName.catalogId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_S_HIDDENSTATUS_2 =
		"catalogFieldName.hiddenStatus = ?";

	private FinderPath _finderPathWithPaginationFindByG_C_H;
	private FinderPath _finderPathWithoutPaginationFindByG_C_H;
	private FinderPath _finderPathCountByG_C_H;

	/**
	 * Returns all the catalog field names where groupId = &#63; and catalogId = &#63; and isSearch = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param isSearch the is search
	 * @return the matching catalog field names
	 */
	@Override
	public List<CatalogFieldName> findByG_C_H(
		long groupId, long catalogId, boolean isSearch) {

		return findByG_C_H(
			groupId, catalogId, isSearch, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the catalog field names where groupId = &#63; and catalogId = &#63; and isSearch = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogFieldNameModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param isSearch the is search
	 * @param start the lower bound of the range of catalog field names
	 * @param end the upper bound of the range of catalog field names (not inclusive)
	 * @return the range of matching catalog field names
	 */
	@Override
	public List<CatalogFieldName> findByG_C_H(
		long groupId, long catalogId, boolean isSearch, int start, int end) {

		return findByG_C_H(groupId, catalogId, isSearch, start, end, null);
	}

	/**
	 * Returns an ordered range of all the catalog field names where groupId = &#63; and catalogId = &#63; and isSearch = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogFieldNameModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param isSearch the is search
	 * @param start the lower bound of the range of catalog field names
	 * @param end the upper bound of the range of catalog field names (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching catalog field names
	 */
	@Override
	public List<CatalogFieldName> findByG_C_H(
		long groupId, long catalogId, boolean isSearch, int start, int end,
		OrderByComparator<CatalogFieldName> orderByComparator) {

		return findByG_C_H(
			groupId, catalogId, isSearch, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the catalog field names where groupId = &#63; and catalogId = &#63; and isSearch = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogFieldNameModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param isSearch the is search
	 * @param start the lower bound of the range of catalog field names
	 * @param end the upper bound of the range of catalog field names (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching catalog field names
	 */
	@Override
	public List<CatalogFieldName> findByG_C_H(
		long groupId, long catalogId, boolean isSearch, int start, int end,
		OrderByComparator<CatalogFieldName> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_C_H;
				finderArgs = new Object[] {groupId, catalogId, isSearch};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_C_H;
			finderArgs = new Object[] {
				groupId, catalogId, isSearch, start, end, orderByComparator
			};
		}

		List<CatalogFieldName> list = null;

		if (useFinderCache) {
			list = (List<CatalogFieldName>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CatalogFieldName catalogFieldName : list) {
					if ((groupId != catalogFieldName.getGroupId()) ||
						(catalogId != catalogFieldName.getCatalogId()) ||
						(isSearch != catalogFieldName.isIsSearch())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_CATALOGFIELDNAME_WHERE);

			sb.append(_FINDER_COLUMN_G_C_H_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_C_H_CATALOGID_2);

			sb.append(_FINDER_COLUMN_G_C_H_ISSEARCH_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CatalogFieldNameModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(catalogId);

				queryPos.add(isSearch);

				list = (List<CatalogFieldName>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first catalog field name in the ordered set where groupId = &#63; and catalogId = &#63; and isSearch = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param isSearch the is search
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog field name
	 * @throws NoSuchCatalogFieldNameException if a matching catalog field name could not be found
	 */
	@Override
	public CatalogFieldName findByG_C_H_First(
			long groupId, long catalogId, boolean isSearch,
			OrderByComparator<CatalogFieldName> orderByComparator)
		throws NoSuchCatalogFieldNameException {

		CatalogFieldName catalogFieldName = fetchByG_C_H_First(
			groupId, catalogId, isSearch, orderByComparator);

		if (catalogFieldName != null) {
			return catalogFieldName;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", catalogId=");
		sb.append(catalogId);

		sb.append(", isSearch=");
		sb.append(isSearch);

		sb.append("}");

		throw new NoSuchCatalogFieldNameException(sb.toString());
	}

	/**
	 * Returns the first catalog field name in the ordered set where groupId = &#63; and catalogId = &#63; and isSearch = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param isSearch the is search
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	@Override
	public CatalogFieldName fetchByG_C_H_First(
		long groupId, long catalogId, boolean isSearch,
		OrderByComparator<CatalogFieldName> orderByComparator) {

		List<CatalogFieldName> list = findByG_C_H(
			groupId, catalogId, isSearch, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last catalog field name in the ordered set where groupId = &#63; and catalogId = &#63; and isSearch = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param isSearch the is search
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog field name
	 * @throws NoSuchCatalogFieldNameException if a matching catalog field name could not be found
	 */
	@Override
	public CatalogFieldName findByG_C_H_Last(
			long groupId, long catalogId, boolean isSearch,
			OrderByComparator<CatalogFieldName> orderByComparator)
		throws NoSuchCatalogFieldNameException {

		CatalogFieldName catalogFieldName = fetchByG_C_H_Last(
			groupId, catalogId, isSearch, orderByComparator);

		if (catalogFieldName != null) {
			return catalogFieldName;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", catalogId=");
		sb.append(catalogId);

		sb.append(", isSearch=");
		sb.append(isSearch);

		sb.append("}");

		throw new NoSuchCatalogFieldNameException(sb.toString());
	}

	/**
	 * Returns the last catalog field name in the ordered set where groupId = &#63; and catalogId = &#63; and isSearch = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param isSearch the is search
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	@Override
	public CatalogFieldName fetchByG_C_H_Last(
		long groupId, long catalogId, boolean isSearch,
		OrderByComparator<CatalogFieldName> orderByComparator) {

		int count = countByG_C_H(groupId, catalogId, isSearch);

		if (count == 0) {
			return null;
		}

		List<CatalogFieldName> list = findByG_C_H(
			groupId, catalogId, isSearch, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the catalog field names before and after the current catalog field name in the ordered set where groupId = &#63; and catalogId = &#63; and isSearch = &#63;.
	 *
	 * @param entryId the primary key of the current catalog field name
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param isSearch the is search
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog field name
	 * @throws NoSuchCatalogFieldNameException if a catalog field name with the primary key could not be found
	 */
	@Override
	public CatalogFieldName[] findByG_C_H_PrevAndNext(
			long entryId, long groupId, long catalogId, boolean isSearch,
			OrderByComparator<CatalogFieldName> orderByComparator)
		throws NoSuchCatalogFieldNameException {

		CatalogFieldName catalogFieldName = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			CatalogFieldName[] array = new CatalogFieldNameImpl[3];

			array[0] = getByG_C_H_PrevAndNext(
				session, catalogFieldName, groupId, catalogId, isSearch,
				orderByComparator, true);

			array[1] = catalogFieldName;

			array[2] = getByG_C_H_PrevAndNext(
				session, catalogFieldName, groupId, catalogId, isSearch,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CatalogFieldName getByG_C_H_PrevAndNext(
		Session session, CatalogFieldName catalogFieldName, long groupId,
		long catalogId, boolean isSearch,
		OrderByComparator<CatalogFieldName> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_CATALOGFIELDNAME_WHERE);

		sb.append(_FINDER_COLUMN_G_C_H_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_C_H_CATALOGID_2);

		sb.append(_FINDER_COLUMN_G_C_H_ISSEARCH_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CatalogFieldNameModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(catalogId);

		queryPos.add(isSearch);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						catalogFieldName)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CatalogFieldName> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the catalog field names where groupId = &#63; and catalogId = &#63; and isSearch = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param isSearch the is search
	 */
	@Override
	public void removeByG_C_H(long groupId, long catalogId, boolean isSearch) {
		for (CatalogFieldName catalogFieldName :
				findByG_C_H(
					groupId, catalogId, isSearch, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(catalogFieldName);
		}
	}

	/**
	 * Returns the number of catalog field names where groupId = &#63; and catalogId = &#63; and isSearch = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param isSearch the is search
	 * @return the number of matching catalog field names
	 */
	@Override
	public int countByG_C_H(long groupId, long catalogId, boolean isSearch) {
		FinderPath finderPath = _finderPathCountByG_C_H;

		Object[] finderArgs = new Object[] {groupId, catalogId, isSearch};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_CATALOGFIELDNAME_WHERE);

			sb.append(_FINDER_COLUMN_G_C_H_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_C_H_CATALOGID_2);

			sb.append(_FINDER_COLUMN_G_C_H_ISSEARCH_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(catalogId);

				queryPos.add(isSearch);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_C_H_GROUPID_2 =
		"catalogFieldName.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_H_CATALOGID_2 =
		"catalogFieldName.catalogId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_H_ISSEARCH_2 =
		"catalogFieldName.isSearch = ?";

	public CatalogFieldNamePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CatalogFieldName.class);

		setModelImplClass(CatalogFieldNameImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the catalog field name in the entity cache if it is enabled.
	 *
	 * @param catalogFieldName the catalog field name
	 */
	@Override
	public void cacheResult(CatalogFieldName catalogFieldName) {
		entityCache.putResult(
			CatalogFieldNameImpl.class, catalogFieldName.getPrimaryKey(),
			catalogFieldName);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				catalogFieldName.getUuid(), catalogFieldName.getGroupId()
			},
			catalogFieldName);
	}

	/**
	 * Caches the catalog field names in the entity cache if it is enabled.
	 *
	 * @param catalogFieldNames the catalog field names
	 */
	@Override
	public void cacheResult(List<CatalogFieldName> catalogFieldNames) {
		for (CatalogFieldName catalogFieldName : catalogFieldNames) {
			if (entityCache.getResult(
					CatalogFieldNameImpl.class,
					catalogFieldName.getPrimaryKey()) == null) {

				cacheResult(catalogFieldName);
			}
		}
	}

	/**
	 * Clears the cache for all catalog field names.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CatalogFieldNameImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the catalog field name.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CatalogFieldName catalogFieldName) {
		entityCache.removeResult(CatalogFieldNameImpl.class, catalogFieldName);
	}

	@Override
	public void clearCache(List<CatalogFieldName> catalogFieldNames) {
		for (CatalogFieldName catalogFieldName : catalogFieldNames) {
			entityCache.removeResult(
				CatalogFieldNameImpl.class, catalogFieldName);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CatalogFieldNameImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CatalogFieldNameModelImpl catalogFieldNameModelImpl) {

		Object[] args = new Object[] {
			catalogFieldNameModelImpl.getUuid(),
			catalogFieldNameModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, catalogFieldNameModelImpl, false);
	}

	/**
	 * Creates a new catalog field name with the primary key. Does not add the catalog field name to the database.
	 *
	 * @param entryId the primary key for the new catalog field name
	 * @return the new catalog field name
	 */
	@Override
	public CatalogFieldName create(long entryId) {
		CatalogFieldName catalogFieldName = new CatalogFieldNameImpl();

		catalogFieldName.setNew(true);
		catalogFieldName.setPrimaryKey(entryId);

		String uuid = PortalUUIDUtil.generate();

		catalogFieldName.setUuid(uuid);

		catalogFieldName.setCompanyId(CompanyThreadLocal.getCompanyId());

		return catalogFieldName;
	}

	/**
	 * Removes the catalog field name with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the catalog field name
	 * @return the catalog field name that was removed
	 * @throws NoSuchCatalogFieldNameException if a catalog field name with the primary key could not be found
	 */
	@Override
	public CatalogFieldName remove(long entryId)
		throws NoSuchCatalogFieldNameException {

		return remove((Serializable)entryId);
	}

	/**
	 * Removes the catalog field name with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the catalog field name
	 * @return the catalog field name that was removed
	 * @throws NoSuchCatalogFieldNameException if a catalog field name with the primary key could not be found
	 */
	@Override
	public CatalogFieldName remove(Serializable primaryKey)
		throws NoSuchCatalogFieldNameException {

		Session session = null;

		try {
			session = openSession();

			CatalogFieldName catalogFieldName = (CatalogFieldName)session.get(
				CatalogFieldNameImpl.class, primaryKey);

			if (catalogFieldName == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCatalogFieldNameException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(catalogFieldName);
		}
		catch (NoSuchCatalogFieldNameException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected CatalogFieldName removeImpl(CatalogFieldName catalogFieldName) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(catalogFieldName)) {
				catalogFieldName = (CatalogFieldName)session.get(
					CatalogFieldNameImpl.class,
					catalogFieldName.getPrimaryKeyObj());
			}

			if (catalogFieldName != null) {
				session.delete(catalogFieldName);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (catalogFieldName != null) {
			clearCache(catalogFieldName);
		}

		return catalogFieldName;
	}

	@Override
	public CatalogFieldName updateImpl(CatalogFieldName catalogFieldName) {
		boolean isNew = catalogFieldName.isNew();

		if (!(catalogFieldName instanceof CatalogFieldNameModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(catalogFieldName.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					catalogFieldName);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in catalogFieldName proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CatalogFieldName implementation " +
					catalogFieldName.getClass());
		}

		CatalogFieldNameModelImpl catalogFieldNameModelImpl =
			(CatalogFieldNameModelImpl)catalogFieldName;

		if (Validator.isNull(catalogFieldName.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			catalogFieldName.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (catalogFieldName.getCreateDate() == null)) {
			if (serviceContext == null) {
				catalogFieldName.setCreateDate(now);
			}
			else {
				catalogFieldName.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!catalogFieldNameModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				catalogFieldName.setModifiedDate(now);
			}
			else {
				catalogFieldName.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(catalogFieldName);
			}
			else {
				catalogFieldName = (CatalogFieldName)session.merge(
					catalogFieldName);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CatalogFieldNameImpl.class, catalogFieldNameModelImpl, false, true);

		cacheUniqueFindersCache(catalogFieldNameModelImpl);

		if (isNew) {
			catalogFieldName.setNew(false);
		}

		catalogFieldName.resetOriginalValues();

		return catalogFieldName;
	}

	/**
	 * Returns the catalog field name with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the catalog field name
	 * @return the catalog field name
	 * @throws NoSuchCatalogFieldNameException if a catalog field name with the primary key could not be found
	 */
	@Override
	public CatalogFieldName findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCatalogFieldNameException {

		CatalogFieldName catalogFieldName = fetchByPrimaryKey(primaryKey);

		if (catalogFieldName == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCatalogFieldNameException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return catalogFieldName;
	}

	/**
	 * Returns the catalog field name with the primary key or throws a <code>NoSuchCatalogFieldNameException</code> if it could not be found.
	 *
	 * @param entryId the primary key of the catalog field name
	 * @return the catalog field name
	 * @throws NoSuchCatalogFieldNameException if a catalog field name with the primary key could not be found
	 */
	@Override
	public CatalogFieldName findByPrimaryKey(long entryId)
		throws NoSuchCatalogFieldNameException {

		return findByPrimaryKey((Serializable)entryId);
	}

	/**
	 * Returns the catalog field name with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entryId the primary key of the catalog field name
	 * @return the catalog field name, or <code>null</code> if a catalog field name with the primary key could not be found
	 */
	@Override
	public CatalogFieldName fetchByPrimaryKey(long entryId) {
		return fetchByPrimaryKey((Serializable)entryId);
	}

	/**
	 * Returns all the catalog field names.
	 *
	 * @return the catalog field names
	 */
	@Override
	public List<CatalogFieldName> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the catalog field names.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogFieldNameModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of catalog field names
	 * @param end the upper bound of the range of catalog field names (not inclusive)
	 * @return the range of catalog field names
	 */
	@Override
	public List<CatalogFieldName> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the catalog field names.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogFieldNameModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of catalog field names
	 * @param end the upper bound of the range of catalog field names (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of catalog field names
	 */
	@Override
	public List<CatalogFieldName> findAll(
		int start, int end,
		OrderByComparator<CatalogFieldName> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the catalog field names.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogFieldNameModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of catalog field names
	 * @param end the upper bound of the range of catalog field names (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of catalog field names
	 */
	@Override
	public List<CatalogFieldName> findAll(
		int start, int end,
		OrderByComparator<CatalogFieldName> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<CatalogFieldName> list = null;

		if (useFinderCache) {
			list = (List<CatalogFieldName>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CATALOGFIELDNAME);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CATALOGFIELDNAME;

				sql = sql.concat(CatalogFieldNameModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CatalogFieldName>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the catalog field names from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CatalogFieldName catalogFieldName : findAll()) {
			remove(catalogFieldName);
		}
	}

	/**
	 * Returns the number of catalog field names.
	 *
	 * @return the number of catalog field names
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CATALOGFIELDNAME);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "entryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CATALOGFIELDNAME;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CatalogFieldNameModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the catalog field name persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new CatalogFieldNameModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", CatalogFieldName.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByCatalogId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCatalogId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"catalogId"}, true);

		_finderPathWithoutPaginationFindByCatalogId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCatalogId",
			new String[] {Long.class.getName()}, new String[] {"catalogId"},
			true);

		_finderPathCountByCatalogId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCatalogId",
			new String[] {Long.class.getName()}, new String[] {"catalogId"},
			false);

		_finderPathWithPaginationFindByG_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"groupId", "catalogId"}, true);

		_finderPathWithoutPaginationFindByG_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "catalogId"}, true);

		_finderPathCountByG_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "catalogId"}, false);

		_finderPathWithPaginationFindByG_C_S = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId", "catalogId", "hiddenStatus"}, true);

		_finderPathWithoutPaginationFindByG_C_S = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			new String[] {"groupId", "catalogId", "hiddenStatus"}, true);

		_finderPathCountByG_C_S = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			new String[] {"groupId", "catalogId", "hiddenStatus"}, false);

		_finderPathWithPaginationFindByG_C_H = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C_H",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId", "catalogId", "isSearch"}, true);

		_finderPathWithoutPaginationFindByG_C_H = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C_H",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			new String[] {"groupId", "catalogId", "isSearch"}, true);

		_finderPathCountByG_C_H = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C_H",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			new String[] {"groupId", "catalogId", "isSearch"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CatalogFieldNameImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = VNPTPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = VNPTPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = VNPTPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CATALOGFIELDNAME =
		"SELECT catalogFieldName FROM CatalogFieldName catalogFieldName";

	private static final String _SQL_SELECT_CATALOGFIELDNAME_WHERE =
		"SELECT catalogFieldName FROM CatalogFieldName catalogFieldName WHERE ";

	private static final String _SQL_COUNT_CATALOGFIELDNAME =
		"SELECT COUNT(catalogFieldName) FROM CatalogFieldName catalogFieldName";

	private static final String _SQL_COUNT_CATALOGFIELDNAME_WHERE =
		"SELECT COUNT(catalogFieldName) FROM CatalogFieldName catalogFieldName WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "catalogFieldName.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CatalogFieldName exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CatalogFieldName exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CatalogFieldNamePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "code"});

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class CatalogFieldNameModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			CatalogFieldNameModelImpl catalogFieldNameModelImpl =
				(CatalogFieldNameModelImpl)baseModel;

			long columnBitmask = catalogFieldNameModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					catalogFieldNameModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						catalogFieldNameModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					catalogFieldNameModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			CatalogFieldNameModelImpl catalogFieldNameModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						catalogFieldNameModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = catalogFieldNameModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

		private static final long _ORDER_BY_COLUMNS_BITMASK;

		static {
			long orderByColumnsBitmask = 0;

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}