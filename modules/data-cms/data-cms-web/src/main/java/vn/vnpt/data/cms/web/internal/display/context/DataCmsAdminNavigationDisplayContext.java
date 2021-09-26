package vn.vnpt.data.cms.web.internal.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.NavigationItem;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.service.permission.PortletPermissionUtil;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import vn.vnpt.data.cms.contansts.DataCmsActionKeys;
import vn.vnpt.data.cms.web.internal.security.permission.resource.DataCmsAdminPermission;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class DataCmsAdminNavigationDisplayContext {
    public DataCmsAdminNavigationDisplayContext(
            HttpServletRequest httpServletRequest,
            LiferayPortletResponse liferayPortletResponse) {

        _httpServletRequest = httpServletRequest;
        _liferayPortletResponse = liferayPortletResponse;
    }

    public List<NavigationItem> getInfoPanelNavigationItems() {
        ThemeDisplay themeDisplay =
                (ThemeDisplay)_httpServletRequest.getAttribute(
                        WebKeys.THEME_DISPLAY);

        List<NavigationItem> navigationItems = new ArrayList<>();

        NavigationItem navigationItem = new NavigationItem();

        navigationItem.setActive(true);
        navigationItem.setHref(themeDisplay.getURLCurrent());
        navigationItem.setLabel(
                LanguageUtil.get(_httpServletRequest, "details"));

        navigationItems.add(navigationItem);

        return navigationItems;
    }

    public List<NavigationItem> getNavigationItems() throws PortalException {
        List<NavigationItem> navigationItems = new ArrayList<>();

        ThemeDisplay themeDisplay =
                (ThemeDisplay)_httpServletRequest.getAttribute(
                        WebKeys.THEME_DISPLAY);

        PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

        String mvcPath = ParamUtil.getString(_httpServletRequest, "mvcPath");

        if (PortletPermissionUtil.contains(
                themeDisplay.getPermissionChecker(), themeDisplay.getPlid(),
                portletDisplay.getId(), DataCmsActionKeys.VIEW)) {

            NavigationItem dcObjectsNavigationItem = new NavigationItem();

            boolean active = !mvcPath.equals("/admin/view_dataset.jsp");

            dcObjectsNavigationItem.setActive(active);

            PortletURL viewDCObjectsURL =
                    _liferayPortletResponse.createRenderURL();

            viewDCObjectsURL.setParameter("mvcPath", "/admin/view.jsp");

            dcObjectsNavigationItem.setHref(viewDCObjectsURL.toString());

            dcObjectsNavigationItem.setLabel(
                    LanguageUtil.get(_httpServletRequest, "data.cms.catalog"));

            navigationItems.add(dcObjectsNavigationItem);
        }
        int a = 1;
        if (a == 1/*DataCmsAdminPermission.contains(
                themeDisplay.getPermissionChecker(),
                themeDisplay.getScopeGroupId(),
                DataCmsActionKeys.VIEW_DATA_DATASET)*/) {

            NavigationItem dataSetNavigationItem = new NavigationItem();

            boolean active = mvcPath.equals("/admin/view_dataset.jsp");

            dataSetNavigationItem.setActive(active);

            PortletURL viewDatasetURL =
                    _liferayPortletResponse.createRenderURL();

            viewDatasetURL.setParameter(
                    "mvcPath", "/admin/view_dataset.jsp");

            dataSetNavigationItem.setHref(viewDatasetURL.toString());

            dataSetNavigationItem.setLabel(
                    LanguageUtil.get(_httpServletRequest, "data.cms.dataset"));

            navigationItems.add(dataSetNavigationItem);
        }

        return navigationItems;
    }

    private final HttpServletRequest _httpServletRequest;
    private final LiferayPortletResponse _liferayPortletResponse;
}
