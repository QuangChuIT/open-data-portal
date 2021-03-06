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

package vn.vnpt.data.cms.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;

import java.lang.reflect.Field;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import vn.vnpt.data.cms.model.CatalogFieldName;
import vn.vnpt.data.cms.service.CatalogFieldNameService;
import vn.vnpt.data.cms.service.CatalogFieldNameServiceUtil;
import vn.vnpt.data.cms.service.persistence.CatalogFieldNamePersistence;
import vn.vnpt.data.cms.service.persistence.CatalogPersistence;
import vn.vnpt.data.cms.service.persistence.DicDataTypePersistence;

/**
 * Provides the base implementation for the catalog field name remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link vn.vnpt.data.cms.service.impl.CatalogFieldNameServiceImpl}.
 * </p>
 *
 * @author vnpt
 * @see vn.vnpt.data.cms.service.impl.CatalogFieldNameServiceImpl
 * @generated
 */
public abstract class CatalogFieldNameServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, CatalogFieldNameService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CatalogFieldNameService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>CatalogFieldNameServiceUtil</code>.
	 */
	@Deactivate
	protected void deactivate() {
		_setServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			CatalogFieldNameService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		catalogFieldNameService = (CatalogFieldNameService)aopProxy;

		_setServiceUtilService(catalogFieldNameService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CatalogFieldNameService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CatalogFieldName.class;
	}

	protected String getModelClassName() {
		return CatalogFieldName.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = catalogFieldNamePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setServiceUtilService(
		CatalogFieldNameService catalogFieldNameService) {

		try {
			Field field = CatalogFieldNameServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, catalogFieldNameService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected CatalogPersistence catalogPersistence;

	@Reference
	protected vn.vnpt.data.cms.service.CatalogFieldNameLocalService
		catalogFieldNameLocalService;

	protected CatalogFieldNameService catalogFieldNameService;

	@Reference
	protected CatalogFieldNamePersistence catalogFieldNamePersistence;

	@Reference
	protected DicDataTypePersistence dicDataTypePersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

}