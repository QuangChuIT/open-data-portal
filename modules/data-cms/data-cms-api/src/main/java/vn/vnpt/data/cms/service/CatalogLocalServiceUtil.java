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

import vn.vnpt.data.cms.model.Catalog;

/**
 * Provides the local service utility for Catalog. This utility wraps
 * <code>vn.vnpt.data.cms.service.impl.CatalogLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author vnpt
 * @see CatalogLocalService
 * @generated
 */
public class CatalogLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>vn.vnpt.data.cms.service.impl.CatalogLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static Catalog addCatalog(Catalog catalog) {
		return getService().addCatalog(catalog);
	}

	public static Catalog addCatalog(
			long userId, String tableName, String title, String description,
			String version, boolean visibility,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addCatalog(
			userId, tableName, title, description, version, visibility,
			serviceContext);
	}

	public static void addCatalogResources(
			Catalog catalog, boolean addGroupPermission,
			boolean addGuestPermissions)
		throws PortalException {

		getService().addCatalogResources(
			catalog, addGroupPermission, addGuestPermissions);
	}

	public static void addCatalogResources(
			Catalog catalog,
			com.liferay.portal.kernel.service.permission.ModelPermissions
				modelPermissions)
		throws PortalException {

		getService().addCatalogResources(catalog, modelPermissions);
	}

	public static void addCatalogResources(
			long catalogId, boolean addGroupPermissions,
			boolean addGuestPermission)
		throws PortalException {

		getService().addCatalogResources(
			catalogId, addGroupPermissions, addGuestPermission);
	}

	public static void addCatalogResources(
			long catalogId,
			com.liferay.portal.kernel.service.permission.ModelPermissions
				modelPermissions)
		throws PortalException {

		getService().addCatalogResources(catalogId, modelPermissions);
	}

	/**
	 * Creates a new catalog with the primary key. Does not add the catalog to the database.
	 *
	 * @param catalogId the primary key for the new catalog
	 * @return the new catalog
	 */
	public static Catalog createCatalog(long catalogId) {
		return getService().createCatalog(catalogId);
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
	 * Deletes the catalog from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CatalogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param catalog the catalog
	 * @return the catalog that was removed
	 */
	public static Catalog deleteCatalog(Catalog catalog) {
		return getService().deleteCatalog(catalog);
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
	public static Catalog deleteCatalog(long catalogId) throws PortalException {
		return getService().deleteCatalog(catalogId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.vnpt.data.cms.model.impl.CatalogModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.vnpt.data.cms.model.impl.CatalogModelImpl</code>.
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

	public static Catalog fetchCatalog(long catalogId) {
		return getService().fetchCatalog(catalogId);
	}

	/**
	 * Returns the catalog matching the UUID and group.
	 *
	 * @param uuid the catalog's UUID
	 * @param groupId the primary key of the group
	 * @return the matching catalog, or <code>null</code> if a matching catalog could not be found
	 */
	public static Catalog fetchCatalogByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchCatalogByUuidAndGroupId(uuid, groupId);
	}

	public static List<Catalog> findByGroupId(long groupId) {
		return getService().findByGroupId(groupId);
	}

	public static List<Catalog> findByGroupId(
		long groupId, int start, int end) {

		return getService().findByGroupId(groupId, start, end);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the catalog with the primary key.
	 *
	 * @param catalogId the primary key of the catalog
	 * @return the catalog
	 * @throws PortalException if a catalog with the primary key could not be found
	 */
	public static Catalog getCatalog(long catalogId) throws PortalException {
		return getService().getCatalog(catalogId);
	}

	/**
	 * Returns the catalog matching the UUID and group.
	 *
	 * @param uuid the catalog's UUID
	 * @param groupId the primary key of the group
	 * @return the matching catalog
	 * @throws PortalException if a matching catalog could not be found
	 */
	public static Catalog getCatalogByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getCatalogByUuidAndGroupId(uuid, groupId);
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
	public static List<Catalog> getCatalogs(int start, int end) {
		return getService().getCatalogs(start, end);
	}

	/**
	 * Returns all the catalogs matching the UUID and company.
	 *
	 * @param uuid the UUID of the catalogs
	 * @param companyId the primary key of the company
	 * @return the matching catalogs, or an empty list if no matches were found
	 */
	public static List<Catalog> getCatalogsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getCatalogsByUuidAndCompanyId(uuid, companyId);
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
	public static List<Catalog> getCatalogsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Catalog> orderByComparator) {

		return getService().getCatalogsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of catalogs.
	 *
	 * @return the number of catalogs
	 */
	public static int getCatalogsCount() {
		return getService().getCatalogsCount();
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

	public static List<Catalog> search(
		long groupId, int start, int end,
		OrderByComparator<Catalog> orderByComparator) {

		return getService().search(groupId, start, end, orderByComparator);
	}

	public static int searchCount(long groupId) {
		return getService().searchCount(groupId);
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
	public static Catalog updateCatalog(Catalog catalog) {
		return getService().updateCatalog(catalog);
	}

	public static CatalogLocalService getService() {
		return _service;
	}

	private static volatile CatalogLocalService _service;

}