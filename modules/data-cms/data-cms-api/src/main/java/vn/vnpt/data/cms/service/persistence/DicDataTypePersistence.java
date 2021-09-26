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

import vn.vnpt.data.cms.exception.NoSuchDicDataTypeException;
import vn.vnpt.data.cms.model.DicDataType;

/**
 * The persistence interface for the dic data type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author vnpt
 * @see DicDataTypeUtil
 * @generated
 */
@ProviderType
public interface DicDataTypePersistence extends BasePersistence<DicDataType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DicDataTypeUtil} to access the dic data type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the dic data types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dic data types
	 */
	public java.util.List<DicDataType> findByUuid(String uuid);

	/**
	 * Returns a range of all the dic data types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DicDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dic data types
	 * @param end the upper bound of the range of dic data types (not inclusive)
	 * @return the range of matching dic data types
	 */
	public java.util.List<DicDataType> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the dic data types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DicDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dic data types
	 * @param end the upper bound of the range of dic data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dic data types
	 */
	public java.util.List<DicDataType> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DicDataType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dic data types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DicDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dic data types
	 * @param end the upper bound of the range of dic data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dic data types
	 */
	public java.util.List<DicDataType> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DicDataType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dic data type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dic data type
	 * @throws NoSuchDicDataTypeException if a matching dic data type could not be found
	 */
	public DicDataType findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DicDataType>
				orderByComparator)
		throws NoSuchDicDataTypeException;

	/**
	 * Returns the first dic data type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dic data type, or <code>null</code> if a matching dic data type could not be found
	 */
	public DicDataType fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DicDataType>
			orderByComparator);

	/**
	 * Returns the last dic data type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dic data type
	 * @throws NoSuchDicDataTypeException if a matching dic data type could not be found
	 */
	public DicDataType findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DicDataType>
				orderByComparator)
		throws NoSuchDicDataTypeException;

	/**
	 * Returns the last dic data type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dic data type, or <code>null</code> if a matching dic data type could not be found
	 */
	public DicDataType fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DicDataType>
			orderByComparator);

	/**
	 * Returns the dic data types before and after the current dic data type in the ordered set where uuid = &#63;.
	 *
	 * @param dicDataTypeId the primary key of the current dic data type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dic data type
	 * @throws NoSuchDicDataTypeException if a dic data type with the primary key could not be found
	 */
	public DicDataType[] findByUuid_PrevAndNext(
			long dicDataTypeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DicDataType>
				orderByComparator)
		throws NoSuchDicDataTypeException;

	/**
	 * Removes all the dic data types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of dic data types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dic data types
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the dic data type where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDicDataTypeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dic data type
	 * @throws NoSuchDicDataTypeException if a matching dic data type could not be found
	 */
	public DicDataType findByUUID_G(String uuid, long groupId)
		throws NoSuchDicDataTypeException;

	/**
	 * Returns the dic data type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dic data type, or <code>null</code> if a matching dic data type could not be found
	 */
	public DicDataType fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the dic data type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dic data type, or <code>null</code> if a matching dic data type could not be found
	 */
	public DicDataType fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the dic data type where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dic data type that was removed
	 */
	public DicDataType removeByUUID_G(String uuid, long groupId)
		throws NoSuchDicDataTypeException;

	/**
	 * Returns the number of dic data types where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dic data types
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the dic data types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dic data types
	 */
	public java.util.List<DicDataType> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the dic data types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DicDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dic data types
	 * @param end the upper bound of the range of dic data types (not inclusive)
	 * @return the range of matching dic data types
	 */
	public java.util.List<DicDataType> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the dic data types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DicDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dic data types
	 * @param end the upper bound of the range of dic data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dic data types
	 */
	public java.util.List<DicDataType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DicDataType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dic data types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DicDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dic data types
	 * @param end the upper bound of the range of dic data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dic data types
	 */
	public java.util.List<DicDataType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DicDataType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dic data type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dic data type
	 * @throws NoSuchDicDataTypeException if a matching dic data type could not be found
	 */
	public DicDataType findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DicDataType>
				orderByComparator)
		throws NoSuchDicDataTypeException;

	/**
	 * Returns the first dic data type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dic data type, or <code>null</code> if a matching dic data type could not be found
	 */
	public DicDataType fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DicDataType>
			orderByComparator);

	/**
	 * Returns the last dic data type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dic data type
	 * @throws NoSuchDicDataTypeException if a matching dic data type could not be found
	 */
	public DicDataType findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DicDataType>
				orderByComparator)
		throws NoSuchDicDataTypeException;

	/**
	 * Returns the last dic data type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dic data type, or <code>null</code> if a matching dic data type could not be found
	 */
	public DicDataType fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DicDataType>
			orderByComparator);

	/**
	 * Returns the dic data types before and after the current dic data type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param dicDataTypeId the primary key of the current dic data type
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dic data type
	 * @throws NoSuchDicDataTypeException if a dic data type with the primary key could not be found
	 */
	public DicDataType[] findByUuid_C_PrevAndNext(
			long dicDataTypeId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DicDataType>
				orderByComparator)
		throws NoSuchDicDataTypeException;

	/**
	 * Removes all the dic data types where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of dic data types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dic data types
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the dic data types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching dic data types
	 */
	public java.util.List<DicDataType> findByGroupId(long groupId);

	/**
	 * Returns a range of all the dic data types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DicDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dic data types
	 * @param end the upper bound of the range of dic data types (not inclusive)
	 * @return the range of matching dic data types
	 */
	public java.util.List<DicDataType> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the dic data types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DicDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dic data types
	 * @param end the upper bound of the range of dic data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dic data types
	 */
	public java.util.List<DicDataType> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DicDataType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dic data types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DicDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dic data types
	 * @param end the upper bound of the range of dic data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dic data types
	 */
	public java.util.List<DicDataType> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DicDataType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dic data type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dic data type
	 * @throws NoSuchDicDataTypeException if a matching dic data type could not be found
	 */
	public DicDataType findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DicDataType>
				orderByComparator)
		throws NoSuchDicDataTypeException;

	/**
	 * Returns the first dic data type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dic data type, or <code>null</code> if a matching dic data type could not be found
	 */
	public DicDataType fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DicDataType>
			orderByComparator);

	/**
	 * Returns the last dic data type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dic data type
	 * @throws NoSuchDicDataTypeException if a matching dic data type could not be found
	 */
	public DicDataType findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DicDataType>
				orderByComparator)
		throws NoSuchDicDataTypeException;

	/**
	 * Returns the last dic data type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dic data type, or <code>null</code> if a matching dic data type could not be found
	 */
	public DicDataType fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DicDataType>
			orderByComparator);

	/**
	 * Returns the dic data types before and after the current dic data type in the ordered set where groupId = &#63;.
	 *
	 * @param dicDataTypeId the primary key of the current dic data type
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dic data type
	 * @throws NoSuchDicDataTypeException if a dic data type with the primary key could not be found
	 */
	public DicDataType[] findByGroupId_PrevAndNext(
			long dicDataTypeId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DicDataType>
				orderByComparator)
		throws NoSuchDicDataTypeException;

	/**
	 * Removes all the dic data types where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of dic data types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching dic data types
	 */
	public int countByGroupId(long groupId);

	/**
	 * Caches the dic data type in the entity cache if it is enabled.
	 *
	 * @param dicDataType the dic data type
	 */
	public void cacheResult(DicDataType dicDataType);

	/**
	 * Caches the dic data types in the entity cache if it is enabled.
	 *
	 * @param dicDataTypes the dic data types
	 */
	public void cacheResult(java.util.List<DicDataType> dicDataTypes);

	/**
	 * Creates a new dic data type with the primary key. Does not add the dic data type to the database.
	 *
	 * @param dicDataTypeId the primary key for the new dic data type
	 * @return the new dic data type
	 */
	public DicDataType create(long dicDataTypeId);

	/**
	 * Removes the dic data type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dicDataTypeId the primary key of the dic data type
	 * @return the dic data type that was removed
	 * @throws NoSuchDicDataTypeException if a dic data type with the primary key could not be found
	 */
	public DicDataType remove(long dicDataTypeId)
		throws NoSuchDicDataTypeException;

	public DicDataType updateImpl(DicDataType dicDataType);

	/**
	 * Returns the dic data type with the primary key or throws a <code>NoSuchDicDataTypeException</code> if it could not be found.
	 *
	 * @param dicDataTypeId the primary key of the dic data type
	 * @return the dic data type
	 * @throws NoSuchDicDataTypeException if a dic data type with the primary key could not be found
	 */
	public DicDataType findByPrimaryKey(long dicDataTypeId)
		throws NoSuchDicDataTypeException;

	/**
	 * Returns the dic data type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dicDataTypeId the primary key of the dic data type
	 * @return the dic data type, or <code>null</code> if a dic data type with the primary key could not be found
	 */
	public DicDataType fetchByPrimaryKey(long dicDataTypeId);

	/**
	 * Returns all the dic data types.
	 *
	 * @return the dic data types
	 */
	public java.util.List<DicDataType> findAll();

	/**
	 * Returns a range of all the dic data types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DicDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dic data types
	 * @param end the upper bound of the range of dic data types (not inclusive)
	 * @return the range of dic data types
	 */
	public java.util.List<DicDataType> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dic data types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DicDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dic data types
	 * @param end the upper bound of the range of dic data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dic data types
	 */
	public java.util.List<DicDataType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DicDataType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dic data types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DicDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dic data types
	 * @param end the upper bound of the range of dic data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dic data types
	 */
	public java.util.List<DicDataType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DicDataType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dic data types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dic data types.
	 *
	 * @return the number of dic data types
	 */
	public int countAll();

}