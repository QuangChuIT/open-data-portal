package vn.vnpt.data.cms.web.internal.asset;

import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import vn.vnpt.data.cms.contansts.DataCmsPortletKeys;
import vn.vnpt.data.cms.model.Catalog;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CatalogAssetRenderer extends BaseJSPAssetRenderer<Catalog> {

    public CatalogAssetRenderer(Catalog catalog, ModelResourcePermission<Catalog> modelResourcePermission) {

        _catalog = catalog;
        _catalogModelResourcePermission = modelResourcePermission;
    }

    @Override
    public boolean hasEditPermission(PermissionChecker permissionChecker) throws PortalException {
        try {
            return _catalogModelResourcePermission.contains(permissionChecker, _catalog, ActionKeys.UPDATE);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        return false;
    }


    @Override
    public boolean hasViewPermission(PermissionChecker permissionChecker) {
        try {
            return _catalogModelResourcePermission.contains(
                    permissionChecker, _catalog, ActionKeys.VIEW);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }

        return true;
    }

    @Override
    public boolean include(HttpServletRequest request, HttpServletResponse
            response, String template) throws Exception {
        request.setAttribute("CATALOG", _catalog);
        request.setAttribute("HtmlUtil", HtmlUtil.getHtml());
        request.setAttribute("StringUtil", new StringUtil());
        return super.include(request, response, template);
    }

    @Override
    public PortletURL getURLEdit(LiferayPortletRequest liferayPortletRequest,
                                 LiferayPortletResponse liferayPortletResponse) throws Exception {

        PortletURL portletURL = liferayPortletResponse.createLiferayPortletURL(
                getControlPanelPlid(liferayPortletRequest), DataCmsPortletKeys.CATALOG,
                PortletRequest.RENDER_PHASE);
        portletURL.setParameter("mvcRenderCommandName", "/catalogportlet/edit_catalog");
        portletURL.setParameter("catalogId", String.valueOf(_catalog.getCatalogId()));
        portletURL.setParameter("showback", Boolean.FALSE.toString());

        return portletURL;
    }

    @Override
    public String getURLViewInContext(LiferayPortletRequest liferayPortletRequest,
                                      LiferayPortletResponse liferayPortletResponse, String noSuchEntryRedirect) throws Exception {
        try {
            long plid = PortalUtil.getPlidFromPortletId(_catalog.getGroupId(),
                    DataCmsPortletKeys.CATALOG);

            PortletURL portletURL;
            if (plid == LayoutConstants.DEFAULT_PLID) {
                portletURL = liferayPortletResponse.createLiferayPortletURL(getControlPanelPlid(liferayPortletRequest),
                        DataCmsPortletKeys.CATALOG, PortletRequest.RENDER_PHASE);
            } else {
                portletURL = PortletURLFactoryUtil.create(liferayPortletRequest,
                        DataCmsPortletKeys.CATALOG, plid, PortletRequest.RENDER_PHASE);
            }

            portletURL.setParameter("mvcRenderCommandName", "/catalogportlet/view");
            portletURL.setParameter("catalogId", String.valueOf(_catalog.getCatalogId()));

            String currentUrl = PortalUtil.getCurrentURL(liferayPortletRequest);

            portletURL.setParameter("redirect", currentUrl);

            return portletURL.toString();

        } catch (PortalException | SystemException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }

        return noSuchEntryRedirect;
    }

    @Override
    public String getJspPath(HttpServletRequest httpServletRequest, String template) {
        if (template.equals(TEMPLATE_FULL_CONTENT)) {
            httpServletRequest.setAttribute("ct_catalog", _catalog);
            return "/asset/catalog/" + template + ".jsp";
        }
        return null;
    }

    @Override
    public Catalog getAssetObject() {
        return _catalog;
    }

    @Override
    public long getGroupId() {
        return _catalog.getGroupId();
    }

    @Override
    public long getUserId() {
        return _catalog.getUserId();
    }

    @Override
    public String getUserName() {
        return _catalog.getUserName();
    }

    @Override
    public String getUuid() {
        return _catalog.getUuid();
    }

    @Override
    public String getClassName() {
        return Catalog.class.getName();
    }

    @Override
    public long getClassPK() {
        return _catalog.getCatalogId();
    }

    @Override
    public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
        return "Name: " + _catalog.getDescription();
    }

    @Override
    public String getTitle(Locale locale) {
        return _catalog.getTitle();
    }

    @Override
    public String getURLView(LiferayPortletResponse liferayPortletResponse, WindowState windowState) throws Exception {
        return super.getURLView(liferayPortletResponse, windowState);
    }

    private Catalog _catalog;
    private final ModelResourcePermission<Catalog> _catalogModelResourcePermission;
    private final static Logger logger = Logger.getLogger(CatalogAssetRenderer.class.getName());
}
