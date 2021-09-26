package vn.vnpt.data.cms.web.internal.security.permission.resource;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import vn.vnpt.data.cms.model.Catalog;

@Component(immediate = true, service = {})
public class DataCmsCatalogPermission {

    public static boolean contains(
            PermissionChecker permissionChecker, Catalog catalog,
            String actionId)
            throws PortalException {

        return _catalogModelResourcePermission.contains(
                permissionChecker, catalog, actionId);
    }

    public static boolean contains(
            PermissionChecker permissionChecker, long catalogId, String actionId) throws PortalException {

        return _catalogModelResourcePermission.contains(
                permissionChecker, catalogId, actionId);
    }

    @Reference(
            target = "(model.class.name=vn.vnpt.data.cms.model.Catalog)",
            unbind = "-"
    )
    protected void setModelResourcePermission(
            ModelResourcePermission<Catalog> modelResourcePermission) {

        _catalogModelResourcePermission = modelResourcePermission;
    }

    private static ModelResourcePermission<Catalog> _catalogModelResourcePermission;

}
