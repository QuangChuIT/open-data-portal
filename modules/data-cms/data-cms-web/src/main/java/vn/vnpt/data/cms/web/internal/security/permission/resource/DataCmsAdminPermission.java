package vn.vnpt.data.cms.web.internal.security.permission.resource;

import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import vn.vnpt.data.cms.contansts.DataCmsConstants;

@Component(immediate = true, service = {})
public class DataCmsAdminPermission {

    public static boolean contains(
            PermissionChecker permissionChecker, long groupId, String actionId) {

        return _portletResourcePermission.contains(
                permissionChecker, groupId, actionId);
    }

    @Reference(
            target = "(resource.name=" + DataCmsConstants.RESOURCE_NAME_ADMIN + ")",
            unbind = "-"
    )
    protected void setPortletResourcePermission(
            PortletResourcePermission portletResourcePermission) {
        _portletResourcePermission = portletResourcePermission;
    }

    private static PortletResourcePermission _portletResourcePermission;
}
