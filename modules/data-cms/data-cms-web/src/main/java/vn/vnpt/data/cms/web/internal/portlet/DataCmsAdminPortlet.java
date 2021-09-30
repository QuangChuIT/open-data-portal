package vn.vnpt.data.cms.web.internal.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import vn.vnpt.data.cms.contansts.DataCmsPortletKeys;
import vn.vnpt.data.cms.service.CatalogLocalService;
import vn.vnpt.data.cms.web.internal.display.context.DataCmsAdminManagementToolbarDisplayContext;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;

@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.hidden",
                "com.liferay.portlet.css-class-wrapper=data-cms-admin-portlet",
                "com.liferay.portlet.header-portlet-css=/admin/css/main.css",
                "com.liferay.portlet.header-portlet-javascript=/js/app-message.js",
                "com.liferay.portlet.header-portlet-javascript=/admin/js/notify.min.js",
                "com.liferay.portlet.header-portlet-javascript=/admin/js/upload-data.js",
                "com.liferay.portlet.header-portlet-javascript=/js/dataset.js",
                "com.liferay.portlet.header-portlet-javascript=/js/catalog.js",
                "com.liferay.portlet.icon=/icons/polls.png",
                "com.liferay.portlet.preferences-unique-per-layout=false",
                "com.liferay.portlet.preferences-owned-by-group=true",
                "com.liferay.portlet.private-request-attributes=false",
                "com.liferay.portlet.private-session-attributes=false",
                "com.liferay.portlet.struts-path=catalog",
                "com.liferay.portlet.scopeable=true",
                "com.liferay.portlet.use-default-template=true",
                "javax.portlet.display-name=" + DataCmsPortletKeys.DATA_CMS_ADMIN,
                "javax.portlet.expiration-cache=0",
                "javax.portlet.info.keywords=Catalog",
                "javax.portlet.info.short-title=Catalog",
                "javax.portlet.info.title=Catalog",
                "javax.portlet.init-param.portlet-title-based-navigation=true",
                "javax.portlet.init-param.template-path=/META-INF/resources/",
                "javax.portlet.init-param.view-action=/admin/view",
                "javax.portlet.init-param.view-template=/admin/view.jsp",
                "javax.portlet.name=" + DataCmsPortletKeys.DATA_CMS_ADMIN,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=administrator",
                "javax.portlet.supports.mime-type=text/html",
                "com.liferay.portlet.add-default-resource=true"
        },
        service = Portlet.class
)
public class DataCmsAdminPortlet extends BaseDataCmsPortlet {
    @Override
    public void render(
            RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {

        try {
            setRenderRequestAttributes(renderRequest, renderResponse);
        } catch (Exception exception) {
            if (isSessionErrorException(exception)) {
                SessionErrors.add(renderRequest, exception.getClass());
            } else {
                throw new PortletException(exception);
            }
        }

        hideDefaultErrorMessage(renderRequest);

        super.render(renderRequest, renderResponse);
    }

    protected void setRenderRequestAttributes(
            RenderRequest renderRequest, RenderResponse renderResponse)
            throws PortalException {

        renderRequest.setAttribute(
                WebKeys.PORTLET_DISPLAY_CONTEXT,
                new DataCmsAdminManagementToolbarDisplayContext(
                        renderRequest, renderResponse, _catalogLocalService));
    }

    @Reference
    private CatalogLocalService _catalogLocalService;
}
