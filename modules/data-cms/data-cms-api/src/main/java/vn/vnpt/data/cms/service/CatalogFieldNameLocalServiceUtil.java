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

import vn.vnpt.data.cms.model.CatalogFieldName;

/**
 * Provides the local service utility for CatalogFieldName. This utility wraps
 * <code>vn.vnpt.data.cms.service.impl.CatalogFieldNameLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author vnpt
 * @see CatalogFieldNameLocalService
 * @generated
 */
public class CatalogFieldNameLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>vn.vnpt.data.cms.service.impl.CatalogFieldNameLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static CatalogFieldName addCatalogFieldName(
		CatalogFieldName catalogFieldName) {

		return getService().addCatalogFieldName(catalogFieldName);
	}

	public static CatalogFieldName addCatalogFieldName(
			long userId, long catalogId, String code, String name,
			String dataType, String defaultValue, boolean notNull,
			String format, boolean isSearch, boolean hiddenStatus,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addCatalogFieldName(
			userId, catalogId, code, name, dataType, defaultValue, notNull,
			format, isSearch, hiddenStatus, serviceContext);
	}

	/**
	 * Creates a new catalog field name with the primary key. Does not add the catalog field name to the database.
	 *
	 * @param entryId the primary key for the new catalog field name
	 * @return the new catalog field name
	 */
	public static CatalogFieldName createCatalogFieldName(long entryId) {
		return getService().createCatalogFieldName(entryId);
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
	 * Deletes the catalog field name from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CatalogFieldNameLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param catalogFieldName the catalog field name
	 * @return the catalog field name that was removed
	 */
	public static CatalogFieldName deleteCatalogFieldName(
		CatalogFieldName catalogFieldName) {

		return getService().deleteCatalogFieldName(catalogFieldName);
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
	public static CatalogFieldName deleteCatalogFieldName(long entryId)
		throws PortalException {

		return getService().deleteCatalogFieldName(entryId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.vnpt.data.cms.model.impl.CatalogFieldNameModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.vnpt.data.cms.model.impl.CatalogFieldNameModelImpl</code>.
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

	public static CatalogFieldName fetchCatalogFieldName(long entryId) {
		return getService().fetchCatalogFieldName(entryId);
	}

	/**
	 * Returns the catalog field name matching the UUID and group.
	 *
	 * @param uuid the catalog field name's UUID
	 * @param groupId the primary key of the group
	 * @return the matching catalog field name, or <code>null</code> if a matching catalog field name could not be found
	 */
	public static CatalogFieldName fetchCatalogFieldNameByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchCatalogFieldNameByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the catalog field name with the primary key.
	 *
	 * @param entryId the primary key of the catalog field name
	 * @return the catalog field name
	 * @throws PortalException if a catalog field name with the primary key could not be found
	 */
	public static CatalogFieldName getCatalogFieldName(long entryId)
		throws PortalException {

		return getService().getCatalogFieldName(entryId);
	}

	/**
	 * Returns the catalog field name matching the UUID and group.
	 *
	 * @param uuid the catalog field name's UUID
	 * @param groupId the primary key of the group
	 * @return the matching catalog field name
	 * @throws PortalException if a matching catalog field name could not be found
	 */
	public static CatalogFieldName getCatalogFieldNameByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getCatalogFieldNameByUuidAndGroupId(uuid, groupId);
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
	public static List<CatalogFieldName> getCatalogFieldNames(
		int start, int end) {

		return getService().getCatalogFieldNames(start, end);
	}

	/**
	 * Returns all the catalog field names matching the UUID and company.
	 *
	 * @param uuid the UUID of the catalog field names
	 * @param companyId the primary key of the company
	 * @return the matching catalog field names, or an empty list if no matches were found
	 */
	public static List<CatalogFieldName> getCatalogFieldNamesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getCatalogFieldNamesByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<CatalogFieldName> getCatalogFieldNamesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CatalogFieldName> orderByComparator) {

		return getService().getCatalogFieldNamesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of catalog field names.
	 *
	 * @return the number of catalog field names
	 */
	public static int getCatalogFieldNamesCount() {
		return getService().getCatalogFieldNamesCount();
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

	public static List<CatalogFieldName> getList(
		long groupId, long catalogId, boolean status) {

		return getService().getList(groupId, catalogId, status);
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
	 * Updates the catalog field name in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CatalogFieldNameLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param catalogFieldName the catalog field name
	 * @return the catalog field name that was updated
	 */
	public static CatalogFieldName updateCatalogFieldName(
		CatalogFieldName catalogFieldName) {

		return getService().updateCatalogFieldName(catalogFieldName);
	}

	public static CatalogFieldNameLocalService getService() {
		return _service;
	}

	private static volatile CatalogFieldNameLocalService _service;

}