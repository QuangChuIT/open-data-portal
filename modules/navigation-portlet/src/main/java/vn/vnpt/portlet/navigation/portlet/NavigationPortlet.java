package vn.vnpt.portlet.navigation.portlet;

import vn.vnpt.portlet.navigation.constants.NavigationPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author chuva
 */
@Component(
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
}