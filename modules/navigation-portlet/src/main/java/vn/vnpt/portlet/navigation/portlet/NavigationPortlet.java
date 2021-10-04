package vn.vnpt.portlet.navigation.portlet;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import vn.vnpt.portlet.navigation.configuration.NavigationConfiguration;
import vn.vnpt.portlet.navigation.constants.NavigationPortletKeys;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author chuva
 */
@Component(
        configurationPid = NavigationPortletKeys.CONFIGURATION_ID,
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.cms",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=Navigation",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + NavigationPortletKeys.NAVIGATION,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class NavigationPortlet extends MVCPortlet {
    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        renderRequest.setAttribute(NavigationConfiguration.class.getName(), _navigationConfiguration);
        super.doView(renderRequest, renderResponse);
    }

    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
        _log.info("Navigation Portlet activate !!!!");
        _navigationConfiguration = ConfigurableUtil.createConfigurable(
                NavigationConfiguration.class, properties);
    }

    private volatile NavigationConfiguration _navigationConfiguration;
    private final static Log _log = LogFactoryUtil.getLog(NavigationPortlet.class);
}