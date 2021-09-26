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
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import vn.vnpt.data.cms.exception.CatalogTableNameException;
import vn.vnpt.data.cms.model.CatalogFieldName;
import vn.vnpt.data.cms.service.base.CatalogFieldNameLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the catalog field name local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>vn.vnpt.data.cms.service.CatalogFieldNameLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author vnpt
 * @see CatalogFieldNameLocalServiceBaseImpl
 */
@Component(
        property = "model.class.name=vn.vnpt.data.cms.model.CatalogFieldName",
        service = AopService.class
)
public class CatalogFieldNameLocalServiceImpl
        extends CatalogFieldNameLocalServiceBaseImpl {

    public CatalogFieldName addCatalogFieldName(long userId, long catalogId, String code,
                                                String name, String dataType, String defaultValue, boolean notNull, String format,
                                                boolean isSearch, boolean hiddenStatus, ServiceContext serviceContext) throws PortalException {
        long groupId = serviceContext.getScopeGroupId();

        User user = userLocalService.getUserById(userId);

        Date now = new Date();

        validate(name);

        long entryId = counterLocalService.increment();

        CatalogFieldName catalogFieldName = catalogFieldNamePersistence.create(entryId);

        catalogFieldName.setUserId(userId);
        catalogFieldName.setUserName(user.getFullName());
        catalogFieldName.setGroupId(groupId);
        catalogFieldName.setCompanyId(user.getCompanyId());
        catalogFieldName.setName(name);
        catalogFieldName.setCode(code);
        catalogFieldName.setCatalogId(catalogId);
        catalogFieldName.setCreateDate(serviceContext.getCreateDate(now));
        catalogFieldName.setModifiedDate(serviceContext.getModifiedDate(now));
        catalogFieldName.setDataType(dataType);
        catalogFieldName.setDefaultValue(defaultValue);
        catalogFieldName.setNotNull(notNull);
        catalogFieldName.setFormat(format);
        catalogFieldName.setIsSearch(isSearch);
        catalogFieldName.setHiddenStatus(hiddenStatus);
        catalogFieldName.setExpandoBridgeAttributes(serviceContext);

        catalogFieldNamePersistence.update(catalogFieldName);

        return catalogFieldName;
    }

    public List<CatalogFieldName> getList(long groupId, long catalogId, boolean status) {
        return catalogFieldNamePersistence.findByG_C_S(groupId, catalogId, status);
    }

    protected void validate(String name) throws PortalException {
        if (Validator.isNull(name)) {
            throw new CatalogTableNameException();
        }
    }
}