package vn.vnpt.data.cms.internal.security.permission.resource;

import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.StagedPortletPermissionLogic;
import com.liferay.portal.kernel.util.HashMapDictionary;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import vn.vnpt.data.cms.contansts.DataCmsConstants;
import vn.vnpt.data.cms.contansts.DataCmsPortletKeys;

import java.util.Dictionary;

@Component(immediate = true, service = {})
public class DataCmsPortletResourcePermissionRegistrar {

    @Activate
    protected void activate(BundleContext bundleContext) {
        Dictionary<String, Object> properties = new HashMapDictionary<>();
        properties.put("resource.name", DataCmsConstants.RESOURCE_NAME_ADMIN);

        _serviceRegistration = bundleContext.registerService(
                PortletResourcePermission.class,
                PortletResourcePermissionFactory.create(
                        DataCmsConstants.RESOURCE_NAME_ADMIN,
                        new StagedPortletPermissionLogic(
                                _stagingPermission, DataCmsPortletKeys.DATA_CMS_ADMIN)),
                properties);
        _log.info(DataCmsPortletResourcePermissionRegistrar.class.getName() + " activated !!!!!!!");
    }

    @Deactivate
    protected void deactivate() {
        _serviceRegistration.unregister();
    }

    private ServiceRegistration<PortletResourcePermission> _serviceRegistration;

    @Reference
    private StagingPermission _stagingPermission;

    private final static Log _log = LogFactoryUtil.getLog(DataCmsPortletResourcePermissionRegistrar.class);
}
