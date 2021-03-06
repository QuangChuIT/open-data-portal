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

import vn.vnpt.data.cms.model.Catalog;

/**
 * The persistence utility for the catalog service. This utility wraps <code>vn.vnpt.data.cms.service.persistence.impl.CatalogPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author vnpt
 * @see CatalogPersistence
 * @generated
 */
public class CatalogUtil {

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
	public static void clearCache(Catalog catalog) {
		getPersistence().clearCache(catalog);
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
	public static Map<Serializable, Catalog> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Catalog> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Catalog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Catalog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Catalog> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Catalog update(Catalog catalog) {
		return getPersistence().update(catalog);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Catalog update(
		Catalog catalog, ServiceContext serviceContext) {

		return getPersistence().update(catalog, serviceContext);
	}

	/**
	 * Returns all the catalogs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching catalogs
	 */
	public static List<Catalog> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the catalogs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @return the range of matching catalogs
	 */
	public static List<Catalog> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the catalogs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching catalogs
	 */
	public static List<Catalog> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Catalog> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the catalogs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching catalogs
	 */
	public static List<Catalog> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Catalog> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first catalog in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog
	 * @throws NoSuchCatalogException if a matching catalog could not be found
	 */
	public static Catalog findByUuid_First(
			String uuid, OrderByComparator<Catalog> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first catalog in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog, or <code>null</code> if a matching catalog could not be found
	 */
	public static Catalog fetchByUuid_First(
		String uuid, OrderByComparator<Catalog> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last catalog in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog
	 * @throws NoSuchCatalogException if a matching catalog could not be found
	 */
	public static Catalog findByUuid_Last(
			String uuid, OrderByComparator<Catalog> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last catalog in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog, or <code>null</code> if a matching catalog could not be found
	 */
	public static Catalog fetchByUuid_Last(
		String uuid, OrderByComparator<Catalog> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the catalogs before and after the current catalog in the ordered set where uuid = &#63;.
	 *
	 * @param catalogId the primary key of the current catalog
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog
	 * @throws NoSuchCatalogException if a catalog with the primary key could not be found
	 */
	public static Catalog[] findByUuid_PrevAndNext(
			long catalogId, String uuid,
			OrderByComparator<Catalog> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogException {

		return getPersistence().findByUuid_PrevAndNext(
			catalogId, uuid, orderByComparator);
	}

	/**
	 * Removes all the catalogs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of catalogs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching catalogs
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the catalog where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCatalogException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching catalog
	 * @throws NoSuchCatalogException if a matching catalog could not be found
	 */
	public static Catalog findByUUID_G(String uuid, long groupId)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the catalog where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching catalog, or <code>null</code> if a matching catalog could not be found
	 */
	public static Catalog fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the catalog where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching catalog, or <code>null</code> if a matching catalog could not be found
	 */
	public static Catalog fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the catalog where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the catalog that was removed
	 */
	public static Catalog removeByUUID_G(String uuid, long groupId)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of catalogs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching catalogs
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the catalogs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching catalogs
	 */
	public static List<Catalog> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the catalogs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @return the range of matching catalogs
	 */
	public static List<Catalog> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the catalogs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching catalogs
	 */
	public static List<Catalog> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Catalog> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the catalogs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching catalogs
	 */
	public static List<Catalog> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Catalog> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first catalog in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog
	 * @throws NoSuchCatalogException if a matching catalog could not be found
	 */
	public static Catalog findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Catalog> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first catalog in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog, or <code>null</code> if a matching catalog could not be found
	 */
	public static Catalog fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Catalog> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last catalog in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog
	 * @throws NoSuchCatalogException if a matching catalog could not be found
	 */
	public static Catalog findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Catalog> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last catalog in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog, or <code>null</code> if a matching catalog could not be found
	 */
	public static Catalog fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Catalog> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the catalogs before and after the current catalog in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param catalogId the primary key of the current catalog
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog
	 * @throws NoSuchCatalogException if a catalog with the primary key could not be found
	 */
	public static Catalog[] findByUuid_C_PrevAndNext(
			long catalogId, String uuid, long companyId,
			OrderByComparator<Catalog> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogException {

		return getPersistence().findByUuid_C_PrevAndNext(
			catalogId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the catalogs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of catalogs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching catalogs
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the catalogs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching catalogs
	 */
	public static List<Catalog> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the catalogs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @return the range of matching catalogs
	 */
	public static List<Catalog> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the catalogs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching catalogs
	 */
	public static List<Catalog> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Catalog> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the catalogs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching catalogs
	 */
	public static List<Catalog> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Catalog> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first catalog in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog
	 * @throws NoSuchCatalogException if a matching catalog could not be found
	 */
	public static Catalog findByGroupId_First(
			long groupId, OrderByComparator<Catalog> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first catalog in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog, or <code>null</code> if a matching catalog could not be found
	 */
	public static Catalog fetchByGroupId_First(
		long groupId, OrderByComparator<Catalog> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last catalog in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog
	 * @throws NoSuchCatalogException if a matching catalog could not be found
	 */
	public static Catalog findByGroupId_Last(
			long groupId, OrderByComparator<Catalog> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last catalog in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog, or <code>null</code> if a matching catalog could not be found
	 */
	public static Catalog fetchByGroupId_Last(
		long groupId, OrderByComparator<Catalog> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the catalogs before and after the current catalog in the ordered set where groupId = &#63;.
	 *
	 * @param catalogId the primary key of the current catalog
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog
	 * @throws NoSuchCatalogException if a catalog with the primary key could not be found
	 */
	public static Catalog[] findByGroupId_PrevAndNext(
			long catalogId, long groupId,
			OrderByComparator<Catalog> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogException {

		return getPersistence().findByGroupId_PrevAndNext(
			catalogId, groupId, orderByComparator);
	}

	/**
	 * Returns all the catalogs that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching catalogs that the user has permission to view
	 */
	public static List<Catalog> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	 * Returns a range of all the catalogs that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @return the range of matching catalogs that the user has permission to view
	 */
	public static List<Catalog> filterFindByGroupId(
		long groupId, int start, int end) {

		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the catalogs that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching catalogs that the user has permission to view
	 */
	public static List<Catalog> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Catalog> orderByComparator) {

		return getPersistence().filterFindByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the catalogs before and after the current catalog in the ordered set of catalogs that the user has permission to view where groupId = &#63;.
	 *
	 * @param catalogId the primary key of the current catalog
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog
	 * @throws NoSuchCatalogException if a catalog with the primary key could not be found
	 */
	public static Catalog[] filterFindByGroupId_PrevAndNext(
			long catalogId, long groupId,
			OrderByComparator<Catalog> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogException {

		return getPersistence().filterFindByGroupId_PrevAndNext(
			catalogId, groupId, orderByComparator);
	}

	/**
	 * Removes all the catalogs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of catalogs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching catalogs
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns the number of catalogs that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching catalogs that the user has permission to view
	 */
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	 * Returns all the catalogs where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching catalogs
	 */
	public static List<Catalog> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the catalogs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @return the range of matching catalogs
	 */
	public static List<Catalog> findByStatus(int status, int start, int end) {
		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the catalogs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching catalogs
	 */
	public static List<Catalog> findByStatus(
		int status, int start, int end,
		OrderByComparator<Catalog> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the catalogs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching catalogs
	 */
	public static List<Catalog> findByStatus(
		int status, int start, int end,
		OrderByComparator<Catalog> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first catalog in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog
	 * @throws NoSuchCatalogException if a matching catalog could not be found
	 */
	public static Catalog findByStatus_First(
			int status, OrderByComparator<Catalog> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first catalog in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog, or <code>null</code> if a matching catalog could not be found
	 */
	public static Catalog fetchByStatus_First(
		int status, OrderByComparator<Catalog> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last catalog in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog
	 * @throws NoSuchCatalogException if a matching catalog could not be found
	 */
	public static Catalog findByStatus_Last(
			int status, OrderByComparator<Catalog> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last catalog in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog, or <code>null</code> if a matching catalog could not be found
	 */
	public static Catalog fetchByStatus_Last(
		int status, OrderByComparator<Catalog> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the catalogs before and after the current catalog in the ordered set where status = &#63;.
	 *
	 * @param catalogId the primary key of the current catalog
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog
	 * @throws NoSuchCatalogException if a catalog with the primary key could not be found
	 */
	public static Catalog[] findByStatus_PrevAndNext(
			long catalogId, int status,
			OrderByComparator<Catalog> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogException {

		return getPersistence().findByStatus_PrevAndNext(
			catalogId, status, orderByComparator);
	}

	/**
	 * Removes all the catalogs where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of catalogs where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching catalogs
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the catalogs where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching catalogs
	 */
	public static List<Catalog> findByG_S(long groupId, int status) {
		return getPersistence().findByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the catalogs where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @return the range of matching catalogs
	 */
	public static List<Catalog> findByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().findByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the catalogs where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching catalogs
	 */
	public static List<Catalog> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<Catalog> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the catalogs where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching catalogs
	 */
	public static List<Catalog> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<Catalog> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first catalog in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog
	 * @throws NoSuchCatalogException if a matching catalog could not be found
	 */
	public static Catalog findByG_S_First(
			long groupId, int status,
			OrderByComparator<Catalog> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogException {

		return getPersistence().findByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first catalog in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog, or <code>null</code> if a matching catalog could not be found
	 */
	public static Catalog fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<Catalog> orderByComparator) {

		return getPersistence().fetchByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last catalog in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog
	 * @throws NoSuchCatalogException if a matching catalog could not be found
	 */
	public static Catalog findByG_S_Last(
			long groupId, int status,
			OrderByComparator<Catalog> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogException {

		return getPersistence().findByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last catalog in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog, or <code>null</code> if a matching catalog could not be found
	 */
	public static Catalog fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<Catalog> orderByComparator) {

		return getPersistence().fetchByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the catalogs before and after the current catalog in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param catalogId the primary key of the current catalog
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog
	 * @throws NoSuchCatalogException if a catalog with the primary key could not be found
	 */
	public static Catalog[] findByG_S_PrevAndNext(
			long catalogId, long groupId, int status,
			OrderByComparator<Catalog> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogException {

		return getPersistence().findByG_S_PrevAndNext(
			catalogId, groupId, status, orderByComparator);
	}

	/**
	 * Returns all the catalogs that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching catalogs that the user has permission to view
	 */
	public static List<Catalog> filterFindByG_S(long groupId, int status) {
		return getPersistence().filterFindByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the catalogs that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @return the range of matching catalogs that the user has permission to view
	 */
	public static List<Catalog> filterFindByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().filterFindByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the catalogs that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching catalogs that the user has permission to view
	 */
	public static List<Catalog> filterFindByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<Catalog> orderByComparator) {

		return getPersistence().filterFindByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the catalogs before and after the current catalog in the ordered set of catalogs that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param catalogId the primary key of the current catalog
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog
	 * @throws NoSuchCatalogException if a catalog with the primary key could not be found
	 */
	public static Catalog[] filterFindByG_S_PrevAndNext(
			long catalogId, long groupId, int status,
			OrderByComparator<Catalog> orderByComparator)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogException {

		return getPersistence().filterFindByG_S_PrevAndNext(
			catalogId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the catalogs where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByG_S(long groupId, int status) {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	 * Returns the number of catalogs where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching catalogs
	 */
	public static int countByG_S(long groupId, int status) {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	 * Returns the number of catalogs that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching catalogs that the user has permission to view
	 */
	public static int filterCountByG_S(long groupId, int status) {
		return getPersistence().filterCountByG_S(groupId, status);
	}

	/**
	 * Caches the catalog in the entity cache if it is enabled.
	 *
	 * @param catalog the catalog
	 */
	public static void cacheResult(Catalog catalog) {
		getPersistence().cacheResult(catalog);
	}

	/**
	 * Caches the catalogs in the entity cache if it is enabled.
	 *
	 * @param catalogs the catalogs
	 */
	public static void cacheResult(List<Catalog> catalogs) {
		getPersistence().cacheResult(catalogs);
	}

	/**
	 * Creates a new catalog with the primary key. Does not add the catalog to the database.
	 *
	 * @param catalogId the primary key for the new catalog
	 * @return the new catalog
	 */
	public static Catalog create(long catalogId) {
		return getPersistence().create(catalogId);
	}

	/**
	 * Removes the catalog with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param catalogId the primary key of the catalog
	 * @return the catalog that was removed
	 * @throws NoSuchCatalogException if a catalog with the primary key could not be found
	 */
	public static Catalog remove(long catalogId)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogException {

		return getPersistence().remove(catalogId);
	}

	public static Catalog updateImpl(Catalog catalog) {
		return getPersistence().updateImpl(catalog);
	}

	/**
	 * Returns the catalog with the primary key or throws a <code>NoSuchCatalogException</code> if it could not be found.
	 *
	 * @param catalogId the primary key of the catalog
	 * @return the catalog
	 * @throws NoSuchCatalogException if a catalog with the primary key could not be found
	 */
	public static Catalog findByPrimaryKey(long catalogId)
		throws vn.vnpt.data.cms.exception.NoSuchCatalogException {

		return getPersistence().findByPrimaryKey(catalogId);
	}

	/**
	 * Returns the catalog with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param catalogId the primary key of the catalog
	 * @return the catalog, or <code>null</code> if a catalog with the primary key could not be found
	 */
	public static Catalog fetchByPrimaryKey(long catalogId) {
		return getPersistence().fetchByPrimaryKey(catalogId);
	}

	/**
	 * Returns all the catalogs.
	 *
	 * @return the catalogs
	 */
	public static List<Catalog> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the catalogs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @return the range of catalogs
	 */
	public static List<Catalog> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the catalogs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of catalogs
	 */
	public static List<Catalog> findAll(
		int start, int end, OrderByComparator<Catalog> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the catalogs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatalogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of catalogs
	 */
	public static List<Catalog> findAll(
		int start, int end, OrderByComparator<Catalog> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the catalogs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of catalogs.
	 *
	 * @return the number of catalogs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CatalogPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CatalogPersistence, CatalogPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CatalogPersistence.class);

		ServiceTracker<CatalogPersistence, CatalogPersistence> serviceTracker =
			new ServiceTracker<CatalogPersistence, CatalogPersistence>(
				bundle.getBundleContext(), CatalogPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}