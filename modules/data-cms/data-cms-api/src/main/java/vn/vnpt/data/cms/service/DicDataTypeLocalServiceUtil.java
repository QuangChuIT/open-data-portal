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

package vn.vnpt.data.cms.service;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import vn.vnpt.data.cms.model.DicDataType;

/**
 * Provides the local service utility for DicDataType. This utility wraps
 * <code>vn.vnpt.data.cms.service.impl.DicDataTypeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author vnpt
 * @see DicDataTypeLocalService
 * @generated
 */
public class DicDataTypeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>vn.vnpt.data.cms.service.impl.DicDataTypeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the dic data type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DicDataTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dicDataType the dic data type
	 * @return the dic data type that was added
	 */
	public static DicDataType addDicDataType(DicDataType dicDataType) {
		return getService().addDicDataType(dicDataType);
	}

	/**
	 * Creates a new dic data type with the primary key. Does not add the dic data type to the database.
	 *
	 * @param dicDataTypeId the primary key for the new dic data type
	 * @return the new dic data type
	 */
	public static DicDataType createDicDataType(long dicDataTypeId) {
		return getService().createDicDataType(dicDataTypeId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the dic data type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DicDataTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dicDataType the dic data type
	 * @return the dic data type that was removed
	 */
	public static DicDataType deleteDicDataType(DicDataType dicDataType) {
		return getService().deleteDicDataType(dicDataType);
	}

	/**
	 * Deletes the dic data type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DicDataTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dicDataTypeId the primary key of the dic data type
	 * @return the dic data type that was removed
	 * @throws PortalException if a dic data type with the primary key could not be found
	 */
	public static DicDataType deleteDicDataType(long dicDataTypeId)
		throws PortalException {

		return getService().deleteDicDataType(dicDataTypeId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.vnpt.data.cms.model.impl.DicDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.vnpt.data.cms.model.impl.DicDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static DicDataType fetchDicDataType(long dicDataTypeId) {
		return getService().fetchDicDataType(dicDataTypeId);
	}

	/**
	 * Returns the dic data type matching the UUID and group.
	 *
	 * @param uuid the dic data type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dic data type, or <code>null</code> if a matching dic data type could not be found
	 */
	public static DicDataType fetchDicDataTypeByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchDicDataTypeByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the dic data type with the primary key.
	 *
	 * @param dicDataTypeId the primary key of the dic data type
	 * @return the dic data type
	 * @throws PortalException if a dic data type with the primary key could not be found
	 */
	public static DicDataType getDicDataType(long dicDataTypeId)
		throws PortalException {

		return getService().getDicDataType(dicDataTypeId);
	}

	/**
	 * Returns the dic data type matching the UUID and group.
	 *
	 * @param uuid the dic data type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dic data type
	 * @throws PortalException if a matching dic data type could not be found
	 */
	public static DicDataType getDicDataTypeByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getDicDataTypeByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the dic data types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.vnpt.data.cms.model.impl.DicDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dic data types
	 * @param end the upper bound of the range of dic data types (not inclusive)
	 * @return the range of dic data types
	 */
	public static List<DicDataType> getDicDataTypes(int start, int end) {
		return getService().getDicDataTypes(start, end);
	}

	/**
	 * Returns all the dic data types matching the UUID and company.
	 *
	 * @param uuid the UUID of the dic data types
	 * @param companyId the primary key of the company
	 * @return the matching dic data types, or an empty list if no matches were found
	 */
	public static List<DicDataType> getDicDataTypesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getDicDataTypesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of dic data types matching the UUID and company.
	 *
	 * @param uuid the UUID of the dic data types
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of dic data types
	 * @param end the upper bound of the range of dic data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching dic data types, or an empty list if no matches were found
	 */
	public static List<DicDataType> getDicDataTypesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DicDataType> orderByComparator) {

		return getService().getDicDataTypesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of dic data types.
	 *
	 * @return the number of dic data types
	 */
	public static int getDicDataTypesCount() {
		return getService().getDicDataTypesCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the dic data type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DicDataTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dicDataType the dic data type
	 * @return the dic data type that was updated
	 */
	public static DicDataType updateDicDataType(DicDataType dicDataType) {
		return getService().updateDicDataType(dicDataType);
	}

	public static DicDataTypeLocalService getService() {
		return _service;
	}

	private static volatile DicDataTypeLocalService _service;

}