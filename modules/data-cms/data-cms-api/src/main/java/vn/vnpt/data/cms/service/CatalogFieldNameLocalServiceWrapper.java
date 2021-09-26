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
 * Provides a wrapper for {@link CatalogFieldNameLocalService}.
 *
 * @author vnpt
 * @see CatalogFieldNameLocalService
 * @generated
 */
public class CatalogFieldNameLocalServiceWrapper
	implements CatalogFieldNameLocalService,
			   ServiceWrapper<CatalogFieldNameLocalService> {

	public CatalogFieldNameLocalServiceWrapper(
		CatalogFieldNameLocalService catalogFieldNameLocalService) {

		_catalogFieldNameLocalService = catalogFieldNameLocalService;
	}

	/**
	 * Adds the catalog field name to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CatalogFieldNameLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param catalogFieldName the catalog field name
	 * @return the catalog field name that was added
	 */
	@Override
	public vn.vnpt.data.cms.model.CatalogFieldName addCatalogFieldName(
		vn.vnpt.data.cms.model.CatalogFieldName catalogFieldName) {

		return _catalogFieldNameLocalService.addCatalogFieldName(
			catalogFieldName);
	}

	@Override
	public vn.vnpt.data.cms.model.CatalogFieldName addCatalogFieldName(
			long userId, long catalogId, String code, String name,
			String dataType, String defaultValue, boolean notNull,
			String format, boolean isSearch, boolean hiddenStatus,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _catalogFieldNameLocalService.addCatalogFieldName(
			userId, catalogId, code, name, dataType, defaultValue, notNull,
			format, isSearch, hiddenStatus, serviceContext);
	}

	/**
	 * Creates a new catalog field name with the primary key. Does not add the catalog field name to the database.
	 *
	 * @param entryId the primary key for the new catalog field name
	 * @return the new catalog field name
	 */
	@Override
	public vn.vnpt.data.cms.model.CatalogFieldName createCatalogFieldName(
		long entryId) {

		return _catalogFieldNameLocalService.createCatalogFieldName(entryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _catalogFieldNameLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the catalog field name from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CatalogFieldNameLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param catalogFieldName the catalog field name
	 * @return the catalog field name that was removed
	 */
	@Override
	public vn.vnpt.data.cms.model.CatalogFieldName deleteCatalogFieldName(
		vn.vnpt.data.cms.model.CatalogFieldName catalogFieldName) {

		return _catalogFieldNameLocalService.deleteCatalogFieldName(
			catalogFieldName);
	}

	/**
	 * Deletes the catalog field name with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CatalogFieldNameLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param entryId the primary key of the catalog field name
	 * @return the catalog field name that was removed
	 * @throws PortalException if a catalog field name with the primary key could not be found
	 */
	@Override
	public vn.vnpt.data.cms.model.CatalogFieldName deleteCatalogFieldName(
			long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _catalogFieldNameLocalService.deleteCatalogFieldName(entryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _catalogFieldNameLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _catalogFieldNameLocalService.dynamicQuery();
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

		return _catalogFieldNameLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.vnpt.data.cms.model.impl.CatalogFieldNameModelImpl</code>.
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

		return _catalogFieldNameLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.vnpt.data.cms.model.impl.CatalogFieldNameModelImpl</code>.
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

		return _catalogFieldNameLocalService.dynamicQuery(
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

		return _catalogFieldNameLocalService.dynamicQueryCount(dynamicQuery);
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

		return _catalogFieldNameLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public vn.vnpt.data.cms.model.CatalogFieldName fetchCatalogFieldName(
		long entryId) {

		return _catalogFieldNameLocalService.fetchCatalogFieldName(entryId);
	}

	/**
	 * Returns the catalog field name matching the UUID and group.
	 *
	 * @param uuid the catalog field name's UUID
	 * @param groupId the primary key of the group
	 * @return the matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	@Override
	public vn.vnpt.data.cms.model.CatalogFieldName
		fetchCatalogFieldNameByUuidAndGroupId(String uuid, long groupId) {

		return _catalogFieldNameLocalService.
			fetchCatalogFieldNameByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _catalogFieldNameLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the catalog field name with the primary key.
	 *
	 * @param entryId the primary key of the catalog field name
	 * @return the catalog field name
	 * @throws PortalException if a catalog field name with the primary key could not be found
	 */
	@Override
	public vn.vnpt.data.cms.model.CatalogFieldName getCatalogFieldName(
			long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _catalogFieldNameLocalService.getCatalogFieldName(entryId);
	}

	/**
	 * Returns the catalog field name matching the UUID and group.
	 *
	 * @param uuid the catalog field name's UUID
	 * @param groupId the primary key of the group
	 * @return the matching catalog field name
	 * @throws PortalException if a matching catalog field name could not be found
	 */
	@Override
	public vn.vnpt.data.cms.model.CatalogFieldName
			getCatalogFieldNameByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _catalogFieldNameLocalService.
			getCatalogFieldNameByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the catalog field names.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.vnpt.data.cms.model.impl.CatalogFieldNameModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of catalog field names
	 * @param end the upper bound of the range of catalog field names (not inclusive)
	 * @return the range of catalog field names
	 */
	@Override
	public java.util.List<vn.vnpt.data.cms.model.CatalogFieldName>
		getCatalogFieldNames(int start, int end) {

		return _catalogFieldNameLocalService.getCatalogFieldNames(start, end);
	}

	/**
	 * Returns all the catalog field names matching the UUID and company.
	 *
	 * @param uuid the UUID of the catalog field names
	 * @param companyId the primary key of the company
	 * @return the matching catalog field names, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<vn.vnpt.data.cms.model.CatalogFieldName>
		getCatalogFieldNamesByUuidAndCompanyId(String uuid, long companyId) {

		return _catalogFieldNameLocalService.
			getCatalogFieldNamesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of catalog field names matching the UUID and company.
	 *
	 * @param uuid the UUID of the catalog field names
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of catalog field names
	 * @param end the upper bound of the range of catalog field names (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching catalog field names, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<vn.vnpt.data.cms.model.CatalogFieldName>
		getCatalogFieldNamesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<vn.vnpt.data.cms.model.CatalogFieldName> orderByComparator) {

		return _catalogFieldNameLocalService.
			getCatalogFieldNamesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of catalog field names.
	 *
	 * @return the number of catalog field names
	 */
	@Override
	public int getCatalogFieldNamesCount() {
		return _catalogFieldNameLocalService.getCatalogFieldNamesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _catalogFieldNameLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _catalogFieldNameLocalService.
			getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<vn.vnpt.data.cms.model.CatalogFieldName> getList(
		long groupId, long catalogId, boolean status) {

		return _catalogFieldNameLocalService.getList(
			groupId, catalogId, status);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _catalogFieldNameLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _catalogFieldNameLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the catalog field name in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CatalogFieldNameLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param catalogFieldName the catalog field name
	 * @return the catalog field name that was updated
	 */
	@Override
	public vn.vnpt.data.cms.model.CatalogFieldName updateCatalogFieldName(
		vn.vnpt.data.cms.model.CatalogFieldName catalogFieldName) {

		return _catalogFieldNameLocalService.updateCatalogFieldName(
			catalogFieldName);
	}

	@Override
	public CatalogFieldNameLocalService getWrappedService() {
		return _catalogFieldNameLocalService;
	}

	@Override
	public void setWrappedService(
		CatalogFieldNameLocalService catalogFieldNameLocalService) {

		_catalogFieldNameLocalService = catalogFieldNameLocalService;
	}

	private CatalogFieldNameLocalService _catalogFieldNameLocalService;

}