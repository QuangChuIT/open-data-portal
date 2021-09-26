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

import vn.vnpt.data.cms.exception.NoSuchCatalogFieldNameException;
import vn.vnpt.data.cms.model.CatalogFieldName;

/**
 * The persistence interface for the catalog field name service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author vnpt
 * @see CatalogFieldNameUtil
 * @generated
 */
@ProviderType
public interface CatalogFieldNamePersistence
	extends BasePersistence<CatalogFieldName> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CatalogFieldNameUtil} to access the catalog field name persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the catalog field names where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching catalog field names
	 */
	public java.util.List<CatalogFieldName> findByUuid(String uuid);

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
	public java.util.List<CatalogFieldName> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<CatalogFieldName> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
			orderByComparator);

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
	public java.util.List<CatalogFieldName> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first catalog field name in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog field name
	 * @throws NoSuchCatalogFieldNameException if a matching catalog field name could not be found
	 */
	public CatalogFieldName findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
				orderByComparator)
		throws NoSuchCatalogFieldNameException;

	/**
	 * Returns the first catalog field name in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	public CatalogFieldName fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
			orderByComparator);

	/**
	 * Returns the last catalog field name in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog field name
	 * @throws NoSuchCatalogFieldNameException if a matching catalog field name could not be found
	 */
	public CatalogFieldName findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
				orderByComparator)
		throws NoSuchCatalogFieldNameException;

	/**
	 * Returns the last catalog field name in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	public CatalogFieldName fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
			orderByComparator);

	/**
	 * Returns the catalog field names before and after the current catalog field name in the ordered set where uuid = &#63;.
	 *
	 * @param entryId the primary key of the current catalog field name
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog field name
	 * @throws NoSuchCatalogFieldNameException if a catalog field name with the primary key could not be found
	 */
	public CatalogFieldName[] findByUuid_PrevAndNext(
			long entryId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
				orderByComparator)
		throws NoSuchCatalogFieldNameException;

	/**
	 * Removes all the catalog field names where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of catalog field names where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching catalog field names
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the catalog field name where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCatalogFieldNameException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching catalog field name
	 * @throws NoSuchCatalogFieldNameException if a matching catalog field name could not be found
	 */
	public CatalogFieldName findByUUID_G(String uuid, long groupId)
		throws NoSuchCatalogFieldNameException;

	/**
	 * Returns the catalog field name where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	public CatalogFieldName fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the catalog field name where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	public CatalogFieldName fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the catalog field name where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the catalog field name that was removed
	 */
	public CatalogFieldName removeByUUID_G(String uuid, long groupId)
		throws NoSuchCatalogFieldNameException;

	/**
	 * Returns the number of catalog field names where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching catalog field names
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the catalog field names where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching catalog field names
	 */
	public java.util.List<CatalogFieldName> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<CatalogFieldName> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<CatalogFieldName> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
			orderByComparator);

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
	public java.util.List<CatalogFieldName> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first catalog field name in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog field name
	 * @throws NoSuchCatalogFieldNameException if a matching catalog field name could not be found
	 */
	public CatalogFieldName findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
				orderByComparator)
		throws NoSuchCatalogFieldNameException;

	/**
	 * Returns the first catalog field name in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	public CatalogFieldName fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
			orderByComparator);

	/**
	 * Returns the last catalog field name in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog field name
	 * @throws NoSuchCatalogFieldNameException if a matching catalog field name could not be found
	 */
	public CatalogFieldName findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
				orderByComparator)
		throws NoSuchCatalogFieldNameException;

	/**
	 * Returns the last catalog field name in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	public CatalogFieldName fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
			orderByComparator);

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
	public CatalogFieldName[] findByUuid_C_PrevAndNext(
			long entryId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
				orderByComparator)
		throws NoSuchCatalogFieldNameException;

	/**
	 * Removes all the catalog field names where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of catalog field names where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching catalog field names
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the catalog field names where catalogId = &#63;.
	 *
	 * @param catalogId the catalog ID
	 * @return the matching catalog field names
	 */
	public java.util.List<CatalogFieldName> findByCatalogId(long catalogId);

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
	public java.util.List<CatalogFieldName> findByCatalogId(
		long catalogId, int start, int end);

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
	public java.util.List<CatalogFieldName> findByCatalogId(
		long catalogId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
			orderByComparator);

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
	public java.util.List<CatalogFieldName> findByCatalogId(
		long catalogId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first catalog field name in the ordered set where catalogId = &#63;.
	 *
	 * @param catalogId the catalog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog field name
	 * @throws NoSuchCatalogFieldNameException if a matching catalog field name could not be found
	 */
	public CatalogFieldName findByCatalogId_First(
			long catalogId,
			com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
				orderByComparator)
		throws NoSuchCatalogFieldNameException;

	/**
	 * Returns the first catalog field name in the ordered set where catalogId = &#63;.
	 *
	 * @param catalogId the catalog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	public CatalogFieldName fetchByCatalogId_First(
		long catalogId,
		com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
			orderByComparator);

	/**
	 * Returns the last catalog field name in the ordered set where catalogId = &#63;.
	 *
	 * @param catalogId the catalog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog field name
	 * @throws NoSuchCatalogFieldNameException if a matching catalog field name could not be found
	 */
	public CatalogFieldName findByCatalogId_Last(
			long catalogId,
			com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
				orderByComparator)
		throws NoSuchCatalogFieldNameException;

	/**
	 * Returns the last catalog field name in the ordered set where catalogId = &#63;.
	 *
	 * @param catalogId the catalog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	public CatalogFieldName fetchByCatalogId_Last(
		long catalogId,
		com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
			orderByComparator);

	/**
	 * Returns the catalog field names before and after the current catalog field name in the ordered set where catalogId = &#63;.
	 *
	 * @param entryId the primary key of the current catalog field name
	 * @param catalogId the catalog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog field name
	 * @throws NoSuchCatalogFieldNameException if a catalog field name with the primary key could not be found
	 */
	public CatalogFieldName[] findByCatalogId_PrevAndNext(
			long entryId, long catalogId,
			com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
				orderByComparator)
		throws NoSuchCatalogFieldNameException;

	/**
	 * Removes all the catalog field names where catalogId = &#63; from the database.
	 *
	 * @param catalogId the catalog ID
	 */
	public void removeByCatalogId(long catalogId);

	/**
	 * Returns the number of catalog field names where catalogId = &#63;.
	 *
	 * @param catalogId the catalog ID
	 * @return the number of matching catalog field names
	 */
	public int countByCatalogId(long catalogId);

	/**
	 * Returns all the catalog field names where groupId = &#63; and catalogId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @return the matching catalog field names
	 */
	public java.util.List<CatalogFieldName> findByG_C(
		long groupId, long catalogId);

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
	public java.util.List<CatalogFieldName> findByG_C(
		long groupId, long catalogId, int start, int end);

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
	public java.util.List<CatalogFieldName> findByG_C(
		long groupId, long catalogId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
			orderByComparator);

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
	public java.util.List<CatalogFieldName> findByG_C(
		long groupId, long catalogId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first catalog field name in the ordered set where groupId = &#63; and catalogId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog field name
	 * @throws NoSuchCatalogFieldNameException if a matching catalog field name could not be found
	 */
	public CatalogFieldName findByG_C_First(
			long groupId, long catalogId,
			com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
				orderByComparator)
		throws NoSuchCatalogFieldNameException;

	/**
	 * Returns the first catalog field name in the ordered set where groupId = &#63; and catalogId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	public CatalogFieldName fetchByG_C_First(
		long groupId, long catalogId,
		com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
			orderByComparator);

	/**
	 * Returns the last catalog field name in the ordered set where groupId = &#63; and catalogId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog field name
	 * @throws NoSuchCatalogFieldNameException if a matching catalog field name could not be found
	 */
	public CatalogFieldName findByG_C_Last(
			long groupId, long catalogId,
			com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
				orderByComparator)
		throws NoSuchCatalogFieldNameException;

	/**
	 * Returns the last catalog field name in the ordered set where groupId = &#63; and catalogId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	public CatalogFieldName fetchByG_C_Last(
		long groupId, long catalogId,
		com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
			orderByComparator);

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
	public CatalogFieldName[] findByG_C_PrevAndNext(
			long entryId, long groupId, long catalogId,
			com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
				orderByComparator)
		throws NoSuchCatalogFieldNameException;

	/**
	 * Removes all the catalog field names where groupId = &#63; and catalogId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 */
	public void removeByG_C(long groupId, long catalogId);

	/**
	 * Returns the number of catalog field names where groupId = &#63; and catalogId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @return the number of matching catalog field names
	 */
	public int countByG_C(long groupId, long catalogId);

	/**
	 * Returns all the catalog field names where groupId = &#63; and catalogId = &#63; and hiddenStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param hiddenStatus the hidden status
	 * @return the matching catalog field names
	 */
	public java.util.List<CatalogFieldName> findByG_C_S(
		long groupId, long catalogId, boolean hiddenStatus);

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
	public java.util.List<CatalogFieldName> findByG_C_S(
		long groupId, long catalogId, boolean hiddenStatus, int start, int end);

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
	public java.util.List<CatalogFieldName> findByG_C_S(
		long groupId, long catalogId, boolean hiddenStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
			orderByComparator);

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
	public java.util.List<CatalogFieldName> findByG_C_S(
		long groupId, long catalogId, boolean hiddenStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
			orderByComparator,
		boolean useFinderCache);

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
	public CatalogFieldName findByG_C_S_First(
			long groupId, long catalogId, boolean hiddenStatus,
			com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
				orderByComparator)
		throws NoSuchCatalogFieldNameException;

	/**
	 * Returns the first catalog field name in the ordered set where groupId = &#63; and catalogId = &#63; and hiddenStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param hiddenStatus the hidden status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	public CatalogFieldName fetchByG_C_S_First(
		long groupId, long catalogId, boolean hiddenStatus,
		com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
			orderByComparator);

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
	public CatalogFieldName findByG_C_S_Last(
			long groupId, long catalogId, boolean hiddenStatus,
			com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
				orderByComparator)
		throws NoSuchCatalogFieldNameException;

	/**
	 * Returns the last catalog field name in the ordered set where groupId = &#63; and catalogId = &#63; and hiddenStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param hiddenStatus the hidden status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	public CatalogFieldName fetchByG_C_S_Last(
		long groupId, long catalogId, boolean hiddenStatus,
		com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
			orderByComparator);

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
	public CatalogFieldName[] findByG_C_S_PrevAndNext(
			long entryId, long groupId, long catalogId, boolean hiddenStatus,
			com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
				orderByComparator)
		throws NoSuchCatalogFieldNameException;

	/**
	 * Removes all the catalog field names where groupId = &#63; and catalogId = &#63; and hiddenStatus = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param hiddenStatus the hidden status
	 */
	public void removeByG_C_S(
		long groupId, long catalogId, boolean hiddenStatus);

	/**
	 * Returns the number of catalog field names where groupId = &#63; and catalogId = &#63; and hiddenStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param hiddenStatus the hidden status
	 * @return the number of matching catalog field names
	 */
	public int countByG_C_S(long groupId, long catalogId, boolean hiddenStatus);

	/**
	 * Returns all the catalog field names where groupId = &#63; and catalogId = &#63; and isSearch = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param isSearch the is search
	 * @return the matching catalog field names
	 */
	public java.util.List<CatalogFieldName> findByG_C_H(
		long groupId, long catalogId, boolean isSearch);

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
	public java.util.List<CatalogFieldName> findByG_C_H(
		long groupId, long catalogId, boolean isSearch, int start, int end);

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
	public java.util.List<CatalogFieldName> findByG_C_H(
		long groupId, long catalogId, boolean isSearch, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
			orderByComparator);

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
	public java.util.List<CatalogFieldName> findByG_C_H(
		long groupId, long catalogId, boolean isSearch, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
			orderByComparator,
		boolean useFinderCache);

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
	public CatalogFieldName findByG_C_H_First(
			long groupId, long catalogId, boolean isSearch,
			com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
				orderByComparator)
		throws NoSuchCatalogFieldNameException;

	/**
	 * Returns the first catalog field name in the ordered set where groupId = &#63; and catalogId = &#63; and isSearch = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param isSearch the is search
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	public CatalogFieldName fetchByG_C_H_First(
		long groupId, long catalogId, boolean isSearch,
		com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
			orderByComparator);

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
	public CatalogFieldName findByG_C_H_Last(
			long groupId, long catalogId, boolean isSearch,
			com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
				orderByComparator)
		throws NoSuchCatalogFieldNameException;

	/**
	 * Returns the last catalog field name in the ordered set where groupId = &#63; and catalogId = &#63; and isSearch = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param isSearch the is search
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	public CatalogFieldName fetchByG_C_H_Last(
		long groupId, long catalogId, boolean isSearch,
		com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
			orderByComparator);

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
	public CatalogFieldName[] findByG_C_H_PrevAndNext(
			long entryId, long groupId, long catalogId, boolean isSearch,
			com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
				orderByComparator)
		throws NoSuchCatalogFieldNameException;

	/**
	 * Removes all the catalog field names where groupId = &#63; and catalogId = &#63; and isSearch = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param isSearch the is search
	 */
	public void removeByG_C_H(long groupId, long catalogId, boolean isSearch);

	/**
	 * Returns the number of catalog field names where groupId = &#63; and catalogId = &#63; and isSearch = &#63;.
	 *
	 * @param groupId the group ID
	 * @param catalogId the catalog ID
	 * @param isSearch the is search
	 * @return the number of matching catalog field names
	 */
	public int countByG_C_H(long groupId, long catalogId, boolean isSearch);

	/**
	 * Caches the catalog field name in the entity cache if it is enabled.
	 *
	 * @param catalogFieldName the catalog field name
	 */
	public void cacheResult(CatalogFieldName catalogFieldName);

	/**
	 * Caches the catalog field names in the entity cache if it is enabled.
	 *
	 * @param catalogFieldNames the catalog field names
	 */
	public void cacheResult(java.util.List<CatalogFieldName> catalogFieldNames);

	/**
	 * Creates a new catalog field name with the primary key. Does not add the catalog field name to the database.
	 *
	 * @param entryId the primary key for the new catalog field name
	 * @return the new catalog field name
	 */
	public CatalogFieldName create(long entryId);

	/**
	 * Removes the catalog field name with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the catalog field name
	 * @return the catalog field name that was removed
	 * @throws NoSuchCatalogFieldNameException if a catalog field name with the primary key could not be found
	 */
	public CatalogFieldName remove(long entryId)
		throws NoSuchCatalogFieldNameException;

	public CatalogFieldName updateImpl(CatalogFieldName catalogFieldName);

	/**
	 * Returns the catalog field name with the primary key or throws a <code>NoSuchCatalogFieldNameException</code> if it could not be found.
	 *
	 * @param entryId the primary key of the catalog field name
	 * @return the catalog field name
	 * @throws NoSuchCatalogFieldNameException if a catalog field name with the primary key could not be found
	 */
	public CatalogFieldName findByPrimaryKey(long entryId)
		throws NoSuchCatalogFieldNameException;

	/**
	 * Returns the catalog field name with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entryId the primary key of the catalog field name
	 * @return the catalog field name, or <code>null</code> if a catalog field name with the primary key could not be found
	 */
	public CatalogFieldName fetchByPrimaryKey(long entryId);

	/**
	 * Returns all the catalog field names.
	 *
	 * @return the catalog field names
	 */
	public java.util.List<CatalogFieldName> findAll();

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
	public java.util.List<CatalogFieldName> findAll(int start, int end);

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
	public java.util.List<CatalogFieldName> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
			orderByComparator);

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
	public java.util.List<CatalogFieldName> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CatalogFieldName>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the catalog field names from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of catalog field names.
	 *
	 * @return the number of catalog field names
	 */
	public int countAll();

}