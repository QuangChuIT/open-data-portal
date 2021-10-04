package vn.vnpt.portlet.navigation.configuration;

import aQute.bnd.annotation.metatype.Configurable;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;
import vn.vnpt.portlet.navigation.constants.NavigationPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component(
        configurationPid = NavigationPortletKeys.CONFIGURATION_ID,
        configurationPolicy = ConfigurationPolicy.OPTIONAL,
        immediate = true,
        property = {
                "javax.portlet.name=" + NavigationPortletKeys.NAVIGATION
        },
        service = ConfigurationAction.class
)
public class NavigationConfigurationAction extends DefaultConfigurationAction {


    @Override
    public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
                        HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setAttribute(NavigationConfigurationAction.class.getName(),
                _navigationConfiguration);

        super.include(portletConfig, httpServletRequest, httpServletResponse);
    }

    @Override
    public void processAction(PortletConfig portletConfig, ActionRequest actionRequest,
                              ActionResponse actionResponse) throws Exception {
    }

    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
        _navigationConfiguration = Configurable.createConfigurable(NavigationConfiguration.class, properties);
    }

    private volatile NavigationConfiguration _navigationConfiguration;
    private final static Log _log = LogFactoryUtil.getLog(NavigationConfiguration.class);
}
