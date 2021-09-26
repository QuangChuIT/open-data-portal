/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package vn.vnpt.data.cms.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.permission.ModelPermissions;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import vn.vnpt.data.cms.exception.CatalogTileException;
import vn.vnpt.data.cms.model.Catalog;
import vn.vnpt.data.cms.service.base.CatalogLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * The implementation of the catalog local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>vn.vnpt.data.cms.service.CatalogLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author vnpt
 * @see CatalogLocalServiceBaseImpl
 */
@Component(
        property = "model.class.name=vn.vnpt.data.cms.model.Catalog",
        service = AopService.class
)
public class CatalogLocalServiceImpl extends CatalogLocalServiceBaseImpl {

    public Catalog addCatalog(long userId, String tableName,
                              String title, String description, String version, boolean visibility, ServiceContext serviceContext) throws PortalException {
        _log.info("Starting add catalog to db !!!!");
        User user = userLocalService.getUserById(userId);

        long groupId = serviceContext.getScopeGroupId();

        Date now = new Date();

        validate(title);

        long catalogId = counterLocalService.increment();

        Catalog catalog = catalogPersistence.create(catalogId);
        catalog.setUuid(UUID.randomUUID().toString());
        catalog.setUserId(userId);
        catalog.setUserName(user.getFullName());
        catalog.setCompanyId(user.getCompanyId());
        catalog.setCreateDate(serviceContext.getCreateDate(now));
        catalog.setModifiedDate(serviceContext.getModifiedDate(now));
        catalog.setExpandoBridgeAttributes(serviceContext);
        catalog.setGroupId(groupId);
        catalog.setTitle(title);
        catalog.setDescription(description);
        catalog.setVersion(version);
        catalog.setTableName(tableName);
        catalog.setVisibility(visibility);

        catalogPersistence.update(catalog);

        // resource
        if (serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()) {
            addCatalogResources(catalog, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
        } else {
            addCatalogResources(catalog, serviceContext.getModelPermissions());
        }
        return catalog;
    }

    public List<Catalog> findByGroupId(long groupId) {
        return catalogPersistence.findByGroupId(groupId);
    }

    public List<Catalog> findByGroupId(long groupId, int start, int end) {
        return catalogPersistence.findByGroupId(groupId, start, end);
    }

    public void addCatalogResources(long catalogId, boolean addGroupPermissions, boolean addGuestPermission) throws PortalException {
        Catalog catalog = catalogPersistence.findByPrimaryKey(catalogId);
        addCatalogResources(catalog, addGroupPermissions, addGuestPermission);
    }

    public void addCatalogResources(long catalogId, ModelPermissions modelPermissions) throws PortalException {
        Catalog catalog = catalogPersistence.findByPrimaryKey(catalogId);
        addCatalogResources(catalog, modelPermissions);
    }

    public void addCatalogResources(Catalog catalog, boolean addGroupPermission, boolean addGuestPermissions) throws PortalException {
        resourceLocalService.addResources(catalog.getCompanyId(), catalog.getGroupId(), catalog.getUserId(),
                Catalog.class.getName(), catalog.getCatalogId(), false, addGroupPermission, addGuestPermissions);
    }

    public void addCatalogResources(Catalog catalog, ModelPermissions modelPermissions) throws PortalException {
        resourceLocalService.addModelResources(catalog.getCompanyId(), catalog.getGroupId(),
                catalog.getUserId(), Catalog.class.getName(), catalog.getCatalogId(), modelPermissions);
    }

    public List<Catalog> search(
            long groupId, int start, int end,
            OrderByComparator<Catalog> orderByComparator) {

        return catalogPersistence.findByGroupId(
                groupId, start, end, orderByComparator);
    }

    protected void validate(String title) throws PortalException {
        if (Validator.isNull(title)) {
            throw new CatalogTileException();
        }
    }

    public int searchCount(long groupId) {
        return catalogPersistence.countByGroupId(groupId);
    }

    private final static Log _log = LogFactoryUtil.getLog(CatalogLocalServiceImpl.class);
}