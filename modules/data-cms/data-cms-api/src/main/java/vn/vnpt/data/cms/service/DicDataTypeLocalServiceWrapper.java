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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DicDataTypeLocalService}.
 *
 * @author vnpt
 * @see DicDataTypeLocalService
 * @generated
 */
public class DicDataTypeLocalServiceWrapper
	implements DicDataTypeLocalService,
			   ServiceWrapper<DicDataTypeLocalService> {

	public DicDataTypeLocalServiceWrapper(
		DicDataTypeLocalService dicDataTypeLocalService) {

		_dicDataTypeLocalService = dicDataTypeLocalService;
	}

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
	@Override
	public vn.vnpt.data.cms.model.DicDataType addDicDataType(
		vn.vnpt.data.cms.model.DicDataType dicDataType) {

		return _dicDataTypeLocalService.addDicDataType(dicDataType);
	}

	/**
	 * Creates a new dic data type with the primary key. Does not add the dic data type to the database.
	 *
	 * @param dicDataTypeId the primary key for the new dic data type
	 * @return the new dic data type
	 */
	@Override
	public vn.vnpt.data.cms.model.DicDataType createDicDataType(
		long dicDataTypeId) {

		return _dicDataTypeLocalService.createDicDataType(dicDataTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dicDataTypeLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public vn.vnpt.data.cms.model.DicDataType deleteDicDataType(
		vn.vnpt.data.cms.model.DicDataType dicDataType) {

		return _dicDataTypeLocalService.deleteDicDataType(dicDataType);
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
	@Override
	public vn.vnpt.data.cms.model.DicDataType deleteDicDataType(
			long dicDataTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dicDataTypeLocalService.deleteDicDataType(dicDataTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dicDataTypeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dicDataTypeLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _dicDataTypeLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _dicDataTypeLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _dicDataTypeLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _dicDataTypeLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _dicDataTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public vn.vnpt.data.cms.model.DicDataType fetchDicDataType(
		long dicDataTypeId) {

		return _dicDataTypeLocalService.fetchDicDataType(dicDataTypeId);
	}

	/**
	 * Returns the dic data type matching the UUID and group.
	 *
	 * @param uuid the dic data type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dic data type, or <code>null</code> if a matching dic data type could not be found
	 */
	@Override
	public vn.vnpt.data.cms.model.DicDataType fetchDicDataTypeByUuidAndGroupId(
		String uuid, long groupId) {

		return _dicDataTypeLocalService.fetchDicDataTypeByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dicDataTypeLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the dic data type with the primary key.
	 *
	 * @param dicDataTypeId the primary key of the dic data type
	 * @return the dic data type
	 * @throws PortalException if a dic data type with the primary key could not be found
	 */
	@Override
	public vn.vnpt.data.cms.model.DicDataType getDicDataType(long dicDataTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dicDataTypeLocalService.getDicDataType(dicDataTypeId);
	}

	/**
	 * Returns the dic data type matching the UUID and group.
	 *
	 * @param uuid the dic data type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dic data type
	 * @throws PortalException if a matching dic data type could not be found
	 */
	@Override
	public vn.vnpt.data.cms.model.DicDataType getDicDataTypeByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dicDataTypeLocalService.getDicDataTypeByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<vn.vnpt.data.cms.model.DicDataType> getDicDataTypes(
		int start, int end) {

		return _dicDataTypeLocalService.getDicDataTypes(start, end);
	}

	/**
	 * Returns all the dic data types matching the UUID and company.
	 *
	 * @param uuid the UUID of the dic data types
	 * @param companyId the primary key of the company
	 * @return the matching dic data types, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<vn.vnpt.data.cms.model.DicDataType>
		getDicDataTypesByUuidAndCompanyId(String uuid, long companyId) {

		return _dicDataTypeLocalService.getDicDataTypesByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<vn.vnpt.data.cms.model.DicDataType>
		getDicDataTypesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<vn.vnpt.data.cms.model.DicDataType> orderByComparator) {

		return _dicDataTypeLocalService.getDicDataTypesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of dic data types.
	 *
	 * @return the number of dic data types
	 */
	@Override
	public int getDicDataTypesCount() {
		return _dicDataTypeLocalService.getDicDataTypesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _dicDataTypeLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dicDataTypeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dicDataTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dicDataTypeLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public vn.vnpt.data.cms.model.DicDataType updateDicDataType(
		vn.vnpt.data.cms.model.DicDataType dicDataType) {

		return _dicDataTypeLocalService.updateDicDataType(dicDataType);
	}

	@Override
	public DicDataTypeLocalService getWrappedService() {
		return _dicDataTypeLocalService;
	}

	@Override
	public void setWrappedService(
		DicDataTypeLocalService dicDataTypeLocalService) {

		_dicDataTypeLocalService = dicDataTypeLocalService;
	}

	private DicDataTypeLocalService _dicDataTypeLocalService;

}