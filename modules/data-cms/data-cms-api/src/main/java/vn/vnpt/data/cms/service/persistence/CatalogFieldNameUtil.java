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

package vn.vnpt.data.cms.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import vn.vnpt.data.cms.model.CatalogFieldName;

/**
 * The persistence utility for the catalog field name service. This utility wraps <code>vn.vnpt.data.cms.service.persistence.impl.CatalogFieldNamePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author vnpt
 * @see CatalogFieldNamePersistence
 * @generated
 */
public class CatalogFieldNameUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(CatalogFieldName catalogFieldName) {
		getPersistence().clearCache(catalogFieldName);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, CatalogFieldName> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CatalogFieldName> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CatalogFieldName> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CatalogFieldName> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CatalogFieldName> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CatalogFieldName update(CatalogFieldName catalogFieldName) {
		return getPersistence().update(catalogFieldName);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CatalogFieldName update(
		CatalogFieldName catalogFieldName, ServiceContext serviceContext) {

		return getPersistence().update(catalogFieldName, serviceContext);
	}

	/**
	 * Returns all the catalog field names where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching catalog field names
	 */
	public static List<CatalogFieldName> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<CatalogFieldName> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<CatalogFieldName> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CatalogFieldName> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<CatalogFieldName> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CatalogFieldName> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first catalog field name in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog field name
	 * @throws NoSuchCatalogFieldNameException if a matching catalog field name could not be found
	 */
	public static CatalogFieldName findByUuid_First(
			String uuid, OrderByComparator<CatalogFieldName> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogFieldNameException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first catalog field name in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	public static CatalogFieldName fetchByUuid_First(
		String uuid, OrderByComparator<CatalogFieldName> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last catalog field name in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog field name
	 * @throws NoSuchCatalogFieldNameException if a matching catalog field name could not be found
	 */
	public static CatalogFieldName findByUuid_Last(
			String uuid, OrderByComparator<CatalogFieldName> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogFieldNameException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last catalog field name in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	public static CatalogFieldName fetchByUuid_Last(
		String uuid, OrderByComparator<CatalogFieldName> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static CatalogFieldName[] findByUuid_PrevAndNext(
			long entryId, String uuid,
			OrderByComparator<CatalogFieldName> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogFieldNameException {

		return getPersistence().findByUuid_PrevAndNext(
			entryId, uuid, orderByComparator);
	}

	/**
	 * Removes all the catalog field names where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of catalog field names where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching catalog field names
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the catalog field name where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCatalogFieldNameException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching catalog field name
	 * @throws NoSuchCatalogFieldNameException if a matching catalog field name could not be found
	 */
	public static CatalogFieldName findByUUID_G(String uuid, long groupId)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogFieldNameException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the catalog field name where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	public static CatalogFieldName fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the catalog field name where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	public static CatalogFieldName fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the catalog field name where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the catalog field name that was removed
	 */
	public static CatalogFieldName removeByUUID_G(String uuid, long groupId)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogFieldNameException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of catalog field names where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching catalog field names
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the catalog field names where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching catalog field names
	 */
	public static List<CatalogFieldName> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
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
	public static List<CatalogFieldName> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
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
	public static List<CatalogFieldName> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CatalogFieldName> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
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
	public static List<CatalogFieldName> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CatalogFieldName> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
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
	public static CatalogFieldName findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CatalogFieldName> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogFieldNameException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first catalog field name in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	public static CatalogFieldName fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CatalogFieldName> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
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
	public static CatalogFieldName findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CatalogFieldName> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogFieldNameException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last catalog field name in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	public static CatalogFieldName fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CatalogFieldName> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
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
	public static CatalogFieldName[] findByUuid_C_PrevAndNext(
			long entryId, String uuid, long companyId,
			OrderByComparator<CatalogFieldName> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogFieldNameException {

		return getPersistence().findByUuid_C_PrevAndNext(
			entryId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the catalog field names where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of catalog field names where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching catalog field names
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the catalog field names where catalogId = &#63;.
	 *
	 * @param catalogId the catalog ID
	 * @return the matching catalog field names
	 */
	public static List<CatalogFieldName> findByCatalogId(long catalogId) {
		return getPersistence().findByCatalogId(catalogId);
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
	public static List<CatalogFieldName> findByCatalogId(
		long catalogId, int start, int end) {

		return getPersistence().findByCatalogId(catalogId, start, end);
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
	public static List<CatalogFieldName> findByCatalogId(
		long catalogId, int start, int end,
		OrderByComparator<CatalogFieldName> orderByComparator) {

		return getPersistence().findByCatalogId(
			catalogId, start, end, orderByComparator);
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
	public static List<CatalogFieldName> findByCatalogId(
		long catalogId, int start, int end,
		OrderByComparator<CatalogFieldName> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCatalogId(
			catalogId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first catalog field name in the ordered set where catalogId = &#63;.
	 *
	 * @param catalogId the catalog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog field name
	 * @throws NoSuchCatalogFieldNameException if a matching catalog field name could not be found
	 */
	public static CatalogFieldName findByCatalogId_First(
			long catalogId,
			OrderByComparator<CatalogFieldName> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogFieldNameException {

		return getPersistence().findByCatalogId_First(
			catalogId, orderByComparator);
	}

	/**
	 * Returns the first catalog field name in the ordered set where catalogId = &#63;.
	 *
	 * @param catalogId the catalog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	public static CatalogFieldName fetchByCatalogId_First(
		long catalogId, OrderByComparator<CatalogFieldName> orderByComparator) {

		return getPersistence().fetchByCatalogId_First(
			catalogId, orderByComparator);
	}

	/**
	 * Returns the last catalog field name in the ordered set where catalogId = &#63;.
	 *
	 * @param catalogId the catalog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog field name
	 * @throws NoSuchCatalogFieldNameException if a matching catalog field name could not be found
	 */
	public static CatalogFieldName findByCatalogId_Last(
			long catalogId,
			OrderByComparator<CatalogFieldName> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogFieldNameException {

		return getPersistence().findByCatalogId_Last(
			catalogId, orderByComparator);
	}

	/**
	 * Returns the last catalog field name in the ordered set where catalogId = &#63;.
	 *
	 * @param catalogId the catalog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	public static CatalogFieldName fetchByCatalogId_Last(
		long catalogId, OrderByComparator<CatalogFieldName> orderByComparator) {

		return getPersistence().fetchByCatalogId_Last(
			catalogId, orderByComparator);
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
	public static CatalogFieldName[] findByCatalogId_PrevAndNext(
			long entryId, long catalogId,
			OrderByComparator<CatalogFieldName> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogFieldNameException {

		return getPersistence().findByCatalogId_PrevAndNext(
			entryId, catalogId, orderByComparator);
	}

	/**
	 * Removes all the catalog field names where catalogId = &#63; from the database.
	 *
	 * @param catalogId the catalog ID
	 */
	public static void removeByCatalogId(long catalogId) {
		getPersistence().removeByCatalogId(catalogId);
	}

	/**
	 * Returns the number of catalog field names where catalogId = &#63;.
	 *
	 * @param catalogId the catalog ID
	 * @return the number of matching catalog field names
	 */
	public static int countByCatalogId(long catalogId) {
		return getPersistence().countByCatalogId(catalogId);
	}

	/**
	 * Returns all the catalog field names where groupId = &#63; and catalogId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @return the matching catalog field names
	 */
	public static List<CatalogFieldName> findByG_C(
		long groupId, long catalogId) {

		return getPersistence().findByG_C(groupId, catalogId);
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
	public static List<CatalogFieldName> findByG_C(
		long groupId, long catalogId, int start, int end) {

		return getPersistence().findByG_C(groupId, catalogId, start, end);
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
	public static List<CatalogFieldName> findByG_C(
		long groupId, long catalogId, int start, int end,
		OrderByComparator<CatalogFieldName> orderByComparator) {

		return getPersistence().findByG_C(
			groupId, catalogId, start, end, orderByComparator);
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
	public static List<CatalogFieldName> findByG_C(
		long groupId, long catalogId, int start, int end,
		OrderByComparator<CatalogFieldName> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_C(
			groupId, catalogId, start, end, orderByComparator, useFinderCache);
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
	public static CatalogFieldName findByG_C_First(
			long groupId, long catalogId,
			OrderByComparator<CatalogFieldName> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogFieldNameException {

		return getPersistence().findByG_C_First(
			groupId, catalogId, orderByComparator);
	}

	/**
	 * Returns the first catalog field name in the ordered set where groupId = &#63; and catalogId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	public static CatalogFieldName fetchByG_C_First(
		long groupId, long catalogId,
		OrderByComparator<CatalogFieldName> orderByComparator) {

		return getPersistence().fetchByG_C_First(
			groupId, catalogId, orderByComparator);
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
	public static CatalogFieldName findByG_C_Last(
			long groupId, long catalogId,
			OrderByComparator<CatalogFieldName> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogFieldNameException {

		return getPersistence().findByG_C_Last(
			groupId, catalogId, orderByComparator);
	}

	/**
	 * Returns the last catalog field name in the ordered set where groupId = &#63; and catalogId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	public static CatalogFieldName fetchByG_C_Last(
		long groupId, long catalogId,
		OrderByComparator<CatalogFieldName> orderByComparator) {

		return getPersistence().fetchByG_C_Last(
			groupId, catalogId, orderByComparator);
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
	public static CatalogFieldName[] findByG_C_PrevAndNext(
			long entryId, long groupId, long catalogId,
			OrderByComparator<CatalogFieldName> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogFieldNameException {

		return getPersistence().findByG_C_PrevAndNext(
			entryId, groupId, catalogId, orderByComparator);
	}

	/**
	 * Removes all the catalog field names where groupId = &#63; and catalogId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 */
	public static void removeByG_C(long groupId, long catalogId) {
		getPersistence().removeByG_C(groupId, catalogId);
	}

	/**
	 * Returns the number of catalog field names where groupId = &#63; and catalogId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @return the number of matching catalog field names
	 */
	public static int countByG_C(long groupId, long catalogId) {
		return getPersistence().countByG_C(groupId, catalogId);
	}

	/**
	 * Returns all the catalog field names where groupId = &#63; and catalogId = &#63; and hiddenStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param hiddenStatus the hidden status
	 * @return the matching catalog field names
	 */
	public static List<CatalogFieldName> findByG_C_S(
		long groupId, long catalogId, boolean hiddenStatus) {

		return getPersistence().findByG_C_S(groupId, catalogId, hiddenStatus);
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
	public static List<CatalogFieldName> findByG_C_S(
		long groupId, long catalogId, boolean hiddenStatus, int start,
		int end) {

		return getPersistence().findByG_C_S(
			groupId, catalogId, hiddenStatus, start, end);
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
	public static List<CatalogFieldName> findByG_C_S(
		long groupId, long catalogId, boolean hiddenStatus, int start, int end,
		OrderByComparator<CatalogFieldName> orderByComparator) {

		return getPersistence().findByG_C_S(
			groupId, catalogId, hiddenStatus, start, end, orderByComparator);
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
	public static List<CatalogFieldName> findByG_C_S(
		long groupId, long catalogId, boolean hiddenStatus, int start, int end,
		OrderByComparator<CatalogFieldName> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_C_S(
			groupId, catalogId, hiddenStatus, start, end, orderByComparator,
			useFinderCache);
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
	public static CatalogFieldName findByG_C_S_First(
			long groupId, long catalogId, boolean hiddenStatus,
			OrderByComparator<CatalogFieldName> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogFieldNameException {

		return getPersistence().findByG_C_S_First(
			groupId, catalogId, hiddenStatus, orderByComparator);
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
	public static CatalogFieldName fetchByG_C_S_First(
		long groupId, long catalogId, boolean hiddenStatus,
		OrderByComparator<CatalogFieldName> orderByComparator) {

		return getPersistence().fetchByG_C_S_First(
			groupId, catalogId, hiddenStatus, orderByComparator);
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
	public static CatalogFieldName findByG_C_S_Last(
			long groupId, long catalogId, boolean hiddenStatus,
			OrderByComparator<CatalogFieldName> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogFieldNameException {

		return getPersistence().findByG_C_S_Last(
			groupId, catalogId, hiddenStatus, orderByComparator);
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
	public static CatalogFieldName fetchByG_C_S_Last(
		long groupId, long catalogId, boolean hiddenStatus,
		OrderByComparator<CatalogFieldName> orderByComparator) {

		return getPersistence().fetchByG_C_S_Last(
			groupId, catalogId, hiddenStatus, orderByComparator);
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
	public static CatalogFieldName[] findByG_C_S_PrevAndNext(
			long entryId, long groupId, long catalogId, boolean hiddenStatus,
			OrderByComparator<CatalogFieldName> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogFieldNameException {

		return getPersistence().findByG_C_S_PrevAndNext(
			entryId, groupId, catalogId, hiddenStatus, orderByComparator);
	}

	/**
	 * Removes all the catalog field names where groupId = &#63; and catalogId = &#63; and hiddenStatus = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param hiddenStatus the hidden status
	 */
	public static void removeByG_C_S(
		long groupId, long catalogId, boolean hiddenStatus) {

		getPersistence().removeByG_C_S(groupId, catalogId, hiddenStatus);
	}

	/**
	 * Returns the number of catalog field names where groupId = &#63; and catalogId = &#63; and hiddenStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param hiddenStatus the hidden status
	 * @return the number of matching catalog field names
	 */
	public static int countByG_C_S(
		long groupId, long catalogId, boolean hiddenStatus) {

		return getPersistence().countByG_C_S(groupId, catalogId, hiddenStatus);
	}

	/**
	 * Returns all the catalog field names where groupId = &#63; and catalogId = &#63; and isSearch = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param isSearch the is search
	 * @return the matching catalog field names
	 */
	public static List<CatalogFieldName> findByG_C_H(
		long groupId, long catalogId, boolean isSearch) {

		return getPersistence().findByG_C_H(groupId, catalogId, isSearch);
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
	public static List<CatalogFieldName> findByG_C_H(
		long groupId, long catalogId, boolean isSearch, int start, int end) {

		return getPersistence().findByG_C_H(
			groupId, catalogId, isSearch, start, end);
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
	public static List<CatalogFieldName> findByG_C_H(
		long groupId, long catalogId, boolean isSearch, int start, int end,
		OrderByComparator<CatalogFieldName> orderByComparator) {

		return getPersistence().findByG_C_H(
			groupId, catalogId, isSearch, start, end, orderByComparator);
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
	public static List<CatalogFieldName> findByG_C_H(
		long groupId, long catalogId, boolean isSearch, int start, int end,
		OrderByComparator<CatalogFieldName> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_C_H(
			groupId, catalogId, isSearch, start, end, orderByComparator,
			useFinderCache);
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
	public static CatalogFieldName findByG_C_H_First(
			long groupId, long catalogId, boolean isSearch,
			OrderByComparator<CatalogFieldName> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogFieldNameException {

		return getPersistence().findByG_C_H_First(
			groupId, catalogId, isSearch, orderByComparator);
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
	public static CatalogFieldName fetchByG_C_H_First(
		long groupId, long catalogId, boolean isSearch,
		OrderByComparator<CatalogFieldName> orderByComparator) {

		return getPersistence().fetchByG_C_H_First(
			groupId, catalogId, isSearch, orderByComparator);
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
	public static CatalogFieldName findByG_C_H_Last(
			long groupId, long catalogId, boolean isSearch,
			OrderByComparator<CatalogFieldName> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogFieldNameException {

		return getPersistence().findByG_C_H_Last(
			groupId, catalogId, isSearch, orderByComparator);
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
	public static CatalogFieldName fetchByG_C_H_Last(
		long groupId, long catalogId, boolean isSearch,
		OrderByComparator<CatalogFieldName> orderByComparator) {

		return getPersistence().fetchByG_C_H_Last(
			groupId, catalogId, isSearch, orderByComparator);
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
	public static CatalogFieldName[] findByG_C_H_PrevAndNext(
			long entryId, long groupId, long catalogId, boolean isSearch,
			OrderByComparator<CatalogFieldName> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogFieldNameException {

		return getPersistence().findByG_C_H_PrevAndNext(
			entryId, groupId, catalogId, isSearch, orderByComparator);
	}

	/**
	 * Removes all the catalog field names where groupId = &#63; and catalogId = &#63; and isSearch = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param isSearch the is search
	 */
	public static void removeByG_C_H(
		long groupId, long catalogId, boolean isSearch) {

		getPersistence().removeByG_C_H(groupId, catalogId, isSearch);
	}

	/**
	 * Returns the number of catalog field names where groupId = &#63; and catalogId = &#63; and isSearch = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param isSearch the is search
	 * @return the number of matching catalog field names
	 */
	public static int countByG_C_H(
		long groupId, long catalogId, boolean isSearch) {

		return getPersistence().countByG_C_H(groupId, catalogId, isSearch);
	}

	/**
	 * Caches the catalog field name in the entity cache if it is enabled.
	 *
	 * @param catalogFieldName the catalog field name
	 */
	public static void cacheResult(CatalogFieldName catalogFieldName) {
		getPersistence().cacheResult(catalogFieldName);
	}

	/**
	 * Caches the catalog field names in the entity cache if it is enabled.
	 *
	 * @param catalogFieldNames the catalog field names
	 */
	public static void cacheResult(List<CatalogFieldName> catalogFieldNames) {
		getPersistence().cacheResult(catalogFieldNames);
	}

	/**
	 * Creates a new catalog field name with the primary key. Does not add the catalog field name to the database.
	 *
	 * @param entryId the primary key for the new catalog field name
	 * @return the new catalog field name
	 */
	public static CatalogFieldName create(long entryId) {
		return getPersistence().create(entryId);
	}

	/**
	 * Removes the catalog field name with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the catalog field name
	 * @return the catalog field name that was removed
	 * @throws NoSuchCatalogFieldNameException if a catalog field name with the primary key could not be found
	 */
	public static CatalogFieldName remove(long entryId)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogFieldNameException {

		return getPersistence().remove(entryId);
	}

	public static CatalogFieldName updateImpl(
		CatalogFieldName catalogFieldName) {

		return getPersistence().updateImpl(catalogFieldName);
	}

	/**
	 * Returns the catalog field name with the primary key or throws a <code>NoSuchCatalogFieldNameException</code> if it could not be found.
	 *
	 * @param entryId the primary key of the catalog field name
	 * @return the catalog field name
	 * @throws NoSuchCatalogFieldNameException if a catalog field name with the primary key could not be found
	 */
	public static CatalogFieldName findByPrimaryKey(long entryId)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogFieldNameException {

		return getPersistence().findByPrimaryKey(entryId);
	}

	/**
	 * Returns the catalog field name with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entryId the primary key of the catalog field name
	 * @return the catalog field name, or <code>null</code> if a catalog field name with the primary key could not be found
	 */
	public static CatalogFieldName fetchByPrimaryKey(long entryId) {
		return getPersistence().fetchByPrimaryKey(entryId);
	}

	/**
	 * Returns all the catalog field names.
	 *
	 * @return the catalog field names
	 */
	public static List<CatalogFieldName> findAll() {
		return getPersistence().findAll();
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
	public static List<CatalogFieldName> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<CatalogFieldName> findAll(
		int start, int end,
		OrderByComparator<CatalogFieldName> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<CatalogFieldName> findAll(
		int start, int end,
		OrderByComparator<CatalogFieldName> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the catalog field names from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of catalog field names.
	 *
	 * @return the number of catalog field names
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CatalogFieldNamePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CatalogFieldNamePersistence, CatalogFieldNamePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CatalogFieldNamePersistence.class);

		ServiceTracker<CatalogFieldNamePersistence, CatalogFieldNamePersistence>
			serviceTracker =
				new ServiceTracker
					<CatalogFieldNamePersistence, CatalogFieldNamePersistence>(
						bundle.getBundleContext(),
						CatalogFieldNamePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}