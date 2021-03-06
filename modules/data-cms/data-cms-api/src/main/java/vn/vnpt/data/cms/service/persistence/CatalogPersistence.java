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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import vn.vnpt.data.cms.exception.NoSuchCatalogException;
import vn.vnpt.data.cms.model.Catalog;

/**
 * The persistence interface for the catalog service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author vnpt
 * @see CatalogUtil
 * @generated
 */
@ProviderType
public interface CatalogPersistence extends BasePersistence<Catalog> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CatalogUtil} to access the catalog persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the catalogs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching catalogs
	 */
	public java.util.List<Catalog> findByUuid(String uuid);

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
	public java.util.List<Catalog> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Catalog> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Catalog>
			orderByComparator);

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
	public java.util.List<Catalog> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Catalog>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first catalog in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog
	 * @throws NoSuchCatalogException if a matching catalog could not be found
	 */
	public Catalog findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Catalog>
				orderByComparator)
		throws NoSuchCatalogException;

	/**
	 * Returns the first catalog in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog, or <code>null</code> if a matching catalog could not be found
	 */
	public Catalog fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Catalog>
			orderByComparator);

	/**
	 * Returns the last catalog in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog
	 * @throws NoSuchCatalogException if a matching catalog could not be found
	 */
	public Catalog findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Catalog>
				orderByComparator)
		throws NoSuchCatalogException;

	/**
	 * Returns the last catalog in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog, or <code>null</code> if a matching catalog could not be found
	 */
	public Catalog fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Catalog>
			orderByComparator);

	/**
	 * Returns the catalogs before and after the current catalog in the ordered set where uuid = &#63;.
	 *
	 * @param catalogId the primary key of the current catalog
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog
	 * @throws NoSuchCatalogException if a catalog with the primary key could not be found
	 */
	public Catalog[] findByUuid_PrevAndNext(
			long catalogId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Catalog>
				orderByComparator)
		throws NoSuchCatalogException;

	/**
	 * Removes all the catalogs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of catalogs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching catalogs
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the catalog where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCatalogException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching catalog
	 * @throws NoSuchCatalogException if a matching catalog could not be found
	 */
	public Catalog findByUUID_G(String uuid, long groupId)
		throws NoSuchCatalogException;

	/**
	 * Returns the catalog where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching catalog, or <code>null</code> if a matching catalog could not be found
	 */
	public Catalog fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the catalog where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching catalog, or <code>null</code> if a matching catalog could not be found
	 */
	public Catalog fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the catalog where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the catalog that was removed
	 */
	public Catalog removeByUUID_G(String uuid, long groupId)
		throws NoSuchCatalogException;

	/**
	 * Returns the number of catalogs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching catalogs
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the catalogs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching catalogs
	 */
	public java.util.List<Catalog> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Catalog> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Catalog> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Catalog>
			orderByComparator);

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
	public java.util.List<Catalog> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Catalog>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first catalog in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog
	 * @throws NoSuchCatalogException if a matching catalog could not be found
	 */
	public Catalog findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Catalog>
				orderByComparator)
		throws NoSuchCatalogException;

	/**
	 * Returns the first catalog in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog, or <code>null</code> if a matching catalog could not be found
	 */
	public Catalog fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Catalog>
			orderByComparator);

	/**
	 * Returns the last catalog in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog
	 * @throws NoSuchCatalogException if a matching catalog could not be found
	 */
	public Catalog findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Catalog>
				orderByComparator)
		throws NoSuchCatalogException;

	/**
	 * Returns the last catalog in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog, or <code>null</code> if a matching catalog could not be found
	 */
	public Catalog fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Catalog>
			orderByComparator);

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
	public Catalog[] findByUuid_C_PrevAndNext(
			long catalogId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Catalog>
				orderByComparator)
		throws NoSuchCatalogException;

	/**
	 * Removes all the catalogs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of catalogs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching catalogs
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the catalogs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching catalogs
	 */
	public java.util.List<Catalog> findByGroupId(long groupId);

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
	public java.util.List<Catalog> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<Catalog> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Catalog>
			orderByComparator);

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
	public java.util.List<Catalog> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Catalog>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first catalog in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog
	 * @throws NoSuchCatalogException if a matching catalog could not be found
	 */
	public Catalog findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Catalog>
				orderByComparator)
		throws NoSuchCatalogException;

	/**
	 * Returns the first catalog in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog, or <code>null</code> if a matching catalog could not be found
	 */
	public Catalog fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Catalog>
			orderByComparator);

	/**
	 * Returns the last catalog in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog
	 * @throws NoSuchCatalogException if a matching catalog could not be found
	 */
	public Catalog findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Catalog>
				orderByComparator)
		throws NoSuchCatalogException;

	/**
	 * Returns the last catalog in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog, or <code>null</code> if a matching catalog could not be found
	 */
	public Catalog fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Catalog>
			orderByComparator);

	/**
	 * Returns the catalogs before and after the current catalog in the ordered set where groupId = &#63;.
	 *
	 * @param catalogId the primary key of the current catalog
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog
	 * @throws NoSuchCatalogException if a catalog with the primary key could not be found
	 */
	public Catalog[] findByGroupId_PrevAndNext(
			long catalogId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Catalog>
				orderByComparator)
		throws NoSuchCatalogException;

	/**
	 * Returns all the catalogs that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching catalogs that the user has permission to view
	 */
	public java.util.List<Catalog> filterFindByGroupId(long groupId);

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
	public java.util.List<Catalog> filterFindByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<Catalog> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Catalog>
			orderByComparator);

	/**
	 * Returns the catalogs before and after the current catalog in the ordered set of catalogs that the user has permission to view where groupId = &#63;.
	 *
	 * @param catalogId the primary key of the current catalog
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog
	 * @throws NoSuchCatalogException if a catalog with the primary key could not be found
	 */
	public Catalog[] filterFindByGroupId_PrevAndNext(
			long catalogId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Catalog>
				orderByComparator)
		throws NoSuchCatalogException;

	/**
	 * Removes all the catalogs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of catalogs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching catalogs
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of catalogs that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching catalogs that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns all the catalogs where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching catalogs
	 */
	public java.util.List<Catalog> findByStatus(int status);

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
	public java.util.List<Catalog> findByStatus(int status, int start, int end);

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
	public java.util.List<Catalog> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Catalog>
			orderByComparator);

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
	public java.util.List<Catalog> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Catalog>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first catalog in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog
	 * @throws NoSuchCatalogException if a matching catalog could not be found
	 */
	public Catalog findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Catalog>
				orderByComparator)
		throws NoSuchCatalogException;

	/**
	 * Returns the first catalog in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog, or <code>null</code> if a matching catalog could not be found
	 */
	public Catalog fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Catalog>
			orderByComparator);

	/**
	 * Returns the last catalog in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog
	 * @throws NoSuchCatalogException if a matching catalog could not be found
	 */
	public Catalog findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Catalog>
				orderByComparator)
		throws NoSuchCatalogException;

	/**
	 * Returns the last catalog in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog, or <code>null</code> if a matching catalog could not be found
	 */
	public Catalog fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Catalog>
			orderByComparator);

	/**
	 * Returns the catalogs before and after the current catalog in the ordered set where status = &#63;.
	 *
	 * @param catalogId the primary key of the current catalog
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog
	 * @throws NoSuchCatalogException if a catalog with the primary key could not be found
	 */
	public Catalog[] findByStatus_PrevAndNext(
			long catalogId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Catalog>
				orderByComparator)
		throws NoSuchCatalogException;

	/**
	 * Removes all the catalogs where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of catalogs where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching catalogs
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the catalogs where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching catalogs
	 */
	public java.util.List<Catalog> findByG_S(long groupId, int status);

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
	public java.util.List<Catalog> findByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<Catalog> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Catalog>
			orderByComparator);

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
	public java.util.List<Catalog> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Catalog>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first catalog in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog
	 * @throws NoSuchCatalogException if a matching catalog could not be found
	 */
	public Catalog findByG_S_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Catalog>
				orderByComparator)
		throws NoSuchCatalogException;

	/**
	 * Returns the first catalog in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog, or <code>null</code> if a matching catalog could not be found
	 */
	public Catalog fetchByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Catalog>
			orderByComparator);

	/**
	 * Returns the last catalog in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog
	 * @throws NoSuchCatalogException if a matching catalog could not be found
	 */
	public Catalog findByG_S_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Catalog>
				orderByComparator)
		throws NoSuchCatalogException;

	/**
	 * Returns the last catalog in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog, or <code>null</code> if a matching catalog could not be found
	 */
	public Catalog fetchByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Catalog>
			orderByComparator);

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
	public Catalog[] findByG_S_PrevAndNext(
			long catalogId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Catalog>
				orderByComparator)
		throws NoSuchCatalogException;

	/**
	 * Returns all the catalogs that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching catalogs that the user has permission to view
	 */
	public java.util.List<Catalog> filterFindByG_S(long groupId, int status);

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
	public java.util.List<Catalog> filterFindByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<Catalog> filterFindByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Catalog>
			orderByComparator);

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
	public Catalog[] filterFindByG_S_PrevAndNext(
			long catalogId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Catalog>
				orderByComparator)
		throws NoSuchCatalogException;

	/**
	 * Removes all the catalogs where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByG_S(long groupId, int status);

	/**
	 * Returns the number of catalogs where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching catalogs
	 */
	public int countByG_S(long groupId, int status);

	/**
	 * Returns the number of catalogs that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching catalogs that the user has permission to view
	 */
	public int filterCountByG_S(long groupId, int status);

	/**
	 * Caches the catalog in the entity cache if it is enabled.
	 *
	 * @param catalog the catalog
	 */
	public void cacheResult(Catalog catalog);

	/**
	 * Caches the catalogs in the entity cache if it is enabled.
	 *
	 * @param catalogs the catalogs
	 */
	public void cacheResult(java.util.List<Catalog> catalogs);

	/**
	 * Creates a new catalog with the primary key. Does not add the catalog to the database.
	 *
	 * @param catalogId the primary key for the new catalog
	 * @return the new catalog
	 */
	public Catalog create(long catalogId);

	/**
	 * Removes the catalog with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param catalogId the primary key of the catalog
	 * @return the catalog that was removed
	 * @throws NoSuchCatalogException if a catalog with the primary key could not be found
	 */
	public Catalog remove(long catalogId) throws NoSuchCatalogException;

	public Catalog updateImpl(Catalog catalog);

	/**
	 * Returns the catalog with the primary key or throws a <code>NoSuchCatalogException</code> if it could not be found.
	 *
	 * @param catalogId the primary key of the catalog
	 * @return the catalog
	 * @throws NoSuchCatalogException if a catalog with the primary key could not be found
	 */
	public Catalog findByPrimaryKey(long catalogId)
		throws NoSuchCatalogException;

	/**
	 * Returns the catalog with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param catalogId the primary key of the catalog
	 * @return the catalog, or <code>null</code> if a catalog with the primary key could not be found
	 */
	public Catalog fetchByPrimaryKey(long catalogId);

	/**
	 * Returns all the catalogs.
	 *
	 * @return the catalogs
	 */
	public java.util.List<Catalog> findAll();

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
	public java.util.List<Catalog> findAll(int start, int end);

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
	public java.util.List<Catalog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Catalog>
			orderByComparator);

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
	public java.util.List<Catalog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Catalog>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the catalogs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of catalogs.
	 *
	 * @return the number of catalogs
	 */
	public int countAll();

}