package vn.vnpt.portlet.navigation.routes;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
import org.osgi.service.component.annotations.Component;

@Component(
        property = {
                "com.liferay.portlet.friendly-url-routes=META-INF/routes/navigation-friendly-url-routes.xml",
                "javax.portlet.name=vn_vnpt_portlet_navigation_NavigationPortlet"
        },
        service = FriendlyURLMapper.class
)
public class NavigationRoutesMapper extends DefaultFriendlyURLMapper {

        @Override
        public String getMapping() {
                return "navigation";
        }
}
