package vn.vnpt.data.cms.web.internal.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Component;
import vn.vnpt.data.cms.contansts.DataCmsPortletKeys;

import javax.portlet.Portlet;

/**
 * @author QuangChu
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.add-default-resource=true",
                "com.liferay.portlet.css-class-wrapper=data-cms-portlet",
                "com.liferay.portlet.display-category=category.cms",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.header-portlet-javascript=/js/common.js",
                "com.liferay.portlet.header-portlet-javascript=/js/app-message.js",
                "com.liferay.portlet.header-portlet-javascript=/js/dataset.js",
                "com.liferay.portlet.header-portlet-javascript=/js/catalog.js",
                "com.liferay.portlet.icon=/icons/article.png",
                "com.liferay.portlet.instanceable=true",
                "com.liferay.portlet.scopeable=true",
                "com.liferay.portlet.struts-path=data_cms",
                "javax.portlet.display-name=Catalog",
                "javax.portlet.expiration-cache=0",
                "javax.portlet.init-param.always-send-redirect=true",
                "javax.portlet.init-param.copy-request-parameters=true",
                "javax.portlet.init-param.template-path=/data-cms/",
                "javax.portlet.init-param.view-template=/data-cms/view.jsp",
                "javax.portlet.name=" + DataCmsPortletKeys.DATA_CMS_DISPLAY,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=administrator,guest,power-user,user",
                "javax.portlet.supported-public-render-parameter=categoryId",
                "javax.portlet.supported-public-render-parameter=catalogId",
                "javax.portlet.supported-public-render-parameter=tag"
        },
        service = Portlet.class
)
public class DataCmsPortlet extends MVCPortlet {
}