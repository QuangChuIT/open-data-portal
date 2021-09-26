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
 * Provides a wrapper for {@link CatalogLocalService}.
 *
 * @author vnpt
 * @see CatalogLocalService
 * @generated
 */
public class CatalogLocalServiceWrapper
	implements CatalogLocalService, ServiceWrapper<CatalogLocalService> {

	public CatalogLocalServiceWrapper(CatalogLocalService catalogLocalService) {
		_catalogLocalService = catalogLocalService;
	}

	/**
	 * Adds the catalog to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CatalogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param catalog the catalog
	 * @return the catalog that was added
	 */
	@Override
	public vn.vnpt.data.cms.model.Catalog addCatalog(
		vn.vnpt.data.cms.model.Catalog catalog) {

		return _catalogLocalService.addCatalog(catalog);
	}

	@Override
	public vn.vnpt.data.cms.model.Catalog addCatalog(
			long userId, String tableName, String title, String description,
			String version, boolean visibility,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _catalogLocalService.addCatalog(
			userId, tableName, title, description, version, visibility,
			serviceContext);
	}

	@Override
	public void addCatalogResources(
			vn.vnpt.data.cms.model.Catalog catalog, boolean addGroupPermission,
			boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_catalogLocalService.addCatalogResources(
			catalog, addGroupPermission, addGuestPermissions);
	}

	@Override
	public void addCatalogResources(
			vn.vnpt.data.cms.model.Catalog catalog,
			com.liferay.portal.kernel.service.permission.ModelPermissions
				modelPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_catalogLocalService.addCatalogResources(catalog, modelPermissions);
	}

	@Override
	public void addCatalogResources(
			long catalogId, boolean addGroupPermissions,
			boolean addGuestPermission)
		throws com.liferay.portal.kernel.exception.PortalException {

		_catalogLocalService.addCatalogResources(
			catalogId, addGroupPermissions, addGuestPermission);
	}

	@Override
	public void addCatalogResources(
			long catalogId,
			com.liferay.portal.kernel.service.permission.ModelPermissions
				modelPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_catalogLocalService.addCatalogResources(catalogId, modelPermissions);
	}

	/**
	 * Creates a new catalog with the primary key. Does not add the catalog to the database.
	 *
	 * @param catalogId the primary key for the new catalog
	 * @return the new catalog
	 */
	@Override
	public vn.vnpt.data.cms.model.Catalog createCatalog(long catalogId) {
		return _catalogLocalService.createCatalog(catalogId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _catalogLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the catalog from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CatalogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param catalog the catalog
	 * @return the catalog that was removed
	 */
	@Override
	public vn.vnpt.data.cms.model.Catalog deleteCatalog(
		vn.vnpt.data.cms.model.Catalog catalog) {

		return _catalogLocalService.deleteCatalog(catalog);
	}

	/**
	 * Deletes the catalog with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CatalogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param catalogId the primary key of the catalog
	 * @return the catalog that was removed
	 * @throws PortalException if a catalog with the primary key could not be found
	 */
	@Override
	public vn.vnpt.data.cms.model.Catalog deleteCatalog(long catalogId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _catalogLocalService.deleteCatalog(catalogId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _catalogLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _catalogLocalService.dynamicQuery();
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

		return _catalogLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.vnpt.data.cms.model.impl.CatalogModelImpl</code>.
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

		return _catalogLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.vnpt.data.cms.model.impl.CatalogModelImpl</code>.
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

		return _catalogLocalService.dynamicQuery(
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

		return _catalogLocalService.dynamicQueryCount(dynamicQuery);
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

		return _catalogLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public vn.vnpt.data.cms.model.Catalog fetchCatalog(long catalogId) {
		return _catalogLocalService.fetchCatalog(catalogId);
	}

	/**
	 * Returns the catalog matching the UUID and group.
	 *
	 * @param uuid the catalog's UUID
	 * @param groupId the primary key of the group
	 * @return the matching catalog, or <code>null</code> if a matching catalog could not be found
	 */
	@Override
	public vn.vnpt.data.cms.model.Catalog fetchCatalogByUuidAndGroupId(
		String uuid, long groupId) {

		return _catalogLocalService.fetchCatalogByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<vn.vnpt.data.cms.model.Catalog> findByGroupId(
		long groupId) {

		return _catalogLocalService.findByGroupId(groupId);
	}

	@Override
	public java.util.List<vn.vnpt.data.cms.model.Catalog> findByGroupId(
		long groupId, int start, int end) {

		return _catalogLocalService.findByGroupId(groupId, start, end);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _catalogLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the catalog with the primary key.
	 *
	 * @param catalogId the primary key of the catalog
	 * @return the catalog
	 * @throws PortalException if a catalog with the primary key could not be found
	 */
	@Override
	public vn.vnpt.data.cms.model.Catalog getCatalog(long catalogId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _catalogLocalService.getCatalog(catalogId);
	}

	/**
	 * Returns the catalog matching the UUID and group.
	 *
	 * @param uuid the catalog's UUID
	 * @param groupId the primary key of the group
	 * @return the matching catalog
	 * @throws PortalException if a matching catalog could not be found
	 */
	@Override
	public vn.vnpt.data.cms.model.Catalog getCatalogByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _catalogLocalService.getCatalogByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the catalogs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.vnpt.data.cms.model.impl.CatalogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @return the range of catalogs
	 */
	@Override
	public java.util.List<vn.vnpt.data.cms.model.Catalog> getCatalogs(
		int start, int end) {

		return _catalogLocalService.getCatalogs(start, end);
	}

	/**
	 * Returns all the catalogs matching the UUID and company.
	 *
	 * @param uuid the UUID of the catalogs
	 * @param companyId the primary key of the company
	 * @return the matching catalogs, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<vn.vnpt.data.cms.model.Catalog>
		getCatalogsByUuidAndCompanyId(String uuid, long companyId) {

		return _catalogLocalService.getCatalogsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of catalogs matching the UUID and company.
	 *
	 * @param uuid the UUID of the catalogs
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching catalogs, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<vn.vnpt.data.cms.model.Catalog>
		getCatalogsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<vn.vnpt.data.cms.model.Catalog> orderByComparator) {

		return _catalogLocalService.getCatalogsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of catalogs.
	 *
	 * @return the number of catalogs
	 */
	@Override
	public int getCatalogsCount() {
		return _catalogLocalService.getCatalogsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _catalogLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _catalogLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _catalogLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _catalogLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<vn.vnpt.data.cms.model.Catalog> search(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<vn.vnpt.data.cms.model.Catalog> orderByComparator) {

		return _catalogLocalService.search(
			groupId, start, end, orderByComparator);
	}

	@Override
	public int searchCount(long groupId) {
		return _catalogLocalService.searchCount(groupId);
	}

	/**
	 * Updates the catalog in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CatalogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param catalog the catalog
	 * @return the catalog that was updated
	 */
	@Override
	public vn.vnpt.data.cms.model.Catalog updateCatalog(
		vn.vnpt.data.cms.model.Catalog catalog) {

		return _catalogLocalService.updateCatalog(catalog);
	}

	@Override
	public CatalogLocalService getWrappedService() {
		return _catalogLocalService;
	}

	@Override
	public void setWrappedService(CatalogLocalService catalogLocalService) {
		_catalogLocalService = catalogLocalService;
	}

	private CatalogLocalService _catalogLocalService;

}