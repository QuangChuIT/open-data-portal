package vn.vnpt.data.cms.web.portlet;

import com.liferay.frontend.js.loader.modules.extender.npm.JSPackage;
import com.liferay.frontend.js.loader.modules.extender.npm.NPMResolver;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import vn.vnpt.data.cms.web.constants.DataCmsAdminPortletKeys;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;

/**
 * @author QuangChu
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.hidden",
                "com.liferay.portlet.css-class-wrapper=portlet-catalog",
                "com.liferay.portlet.icon=/icons/polls.png",
                "com.liferay.portlet.preferences-unique-per-layout=false",
                "com.liferay.portlet.preferences-owned-by-group=true",
                "com.liferay.portlet.private-request-attributes=false",
                "com.liferay.portlet.private-session-attributes=false",
                "com.liferay.portlet.struts-path=catalog",
                "com.liferay.portlet.scopeable=true",
                "com.liferay.portlet.use-default-template=true",
                "javax.portlet.display-name=" + DataCmsAdminPortletKeys.PORTLET_ID,
                "javax.portlet.expiration-cache=0",
                "javax.portlet.info.keywords=Catalog",
                "javax.portlet.info.short-title=Catalog",
                "javax.portlet.info.title=Catalog",
                "javax.portlet.init-param.portlet-title-based-navigation=true",
                "javax.portlet.init-param.template-path=/META-INF/resources/",
                "javax.portlet.init-param.view-action=/view",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + DataCmsAdminPortletKeys.PORTLET_ID,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=administrator",
                "javax.portlet.supports.mime-type=text/html",
                "com.liferay.portlet.add-default-resource=true"
        },
        service = Portlet.class
)
public class DataCmsAdminPortlet extends MVCPortlet {

    @Override
    public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {
        JSPackage jsPackage = _npmResolver.getJSPackage();
        renderRequest.setAttribute(
                "mainRequire",
                jsPackage.getResolvedId() + " as main");

        super.doView(renderRequest, renderResponse);
    }

    @Reference
    private NPMResolver _npmResolver;

}