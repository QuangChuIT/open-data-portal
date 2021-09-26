package vn.vnpt.data.cms.internal.security.permission.resource;

import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.permission.resource.*;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.workflow.permission.WorkflowPermission;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import vn.vnpt.data.cms.contansts.DataCmsConstants;
import vn.vnpt.data.cms.contansts.DataCmsPortletKeys;
import vn.vnpt.data.cms.model.Catalog;
import vn.vnpt.data.cms.service.CatalogLocalService;

import java.util.Dictionary;

@Component(immediate = true, service = {})
public class DataCmsCatalogModelResourcePermissionRegistrar {
    @Activate
    protected void activate(BundleContext bundleContext) {
        Dictionary<String, Object> properties = new HashMapDictionary<>();

        properties.put("model.class.name", Catalog.class.getName());
        _serviceRegistration = bundleContext.registerService(
                (Class<ModelResourcePermission<Catalog>>)
                        (Class<?>) ModelResourcePermission.class,
                ModelResourcePermissionFactory.create(
                        Catalog.class, Catalog::getCatalogId,
                        _catalogLocalService::getCatalog,
                        _portletResourcePermission,
                        (modelResourcePermission, consumer) -> {
                            consumer.accept(
                                    new StagedModelPermissionLogic<>(
                                            _stagingPermission, DataCmsPortletKeys.DATA_CMS_ADMIN,
                                            Catalog::getCatalogId));
                            consumer.accept(
                                    new WorkflowedModelPermissionLogic<>(
                                            _workflowPermission, modelResourcePermission,
                                            _groupLocalService, Catalog::getCatalogId));
                        }),
                properties);
        _log.info(DataCmsCatalogModelResourcePermissionRegistrar.class.getName() + " activated !!!!");
    }

    @Deactivate
    protected void deactivate() {
        _serviceRegistration.unregister();
    }

    @Reference
    private CatalogLocalService _catalogLocalService;

    @Reference(
            target = "(resource.name=" + DataCmsConstants.RESOURCE_NAME_ADMIN + ")"
    )
    private PortletResourcePermission _portletResourcePermission;

    private ServiceRegistration<ModelResourcePermission<Catalog>>
            _serviceRegistration;

    @Reference
    private WorkflowPermission _workflowPermission;

    @Reference
    private GroupLocalService _groupLocalService;

    @Reference
    private StagingPermission _stagingPermission;

    private final static Log _log = LogFactoryUtil.getLog(DataCmsCatalogModelResourcePermissionRegistrar.class);
}
