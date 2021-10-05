package vn.vnpt.data.cms.web.internal.asset;


import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import vn.vnpt.data.cms.contansts.DataCmsPortletKeys;
import vn.vnpt.data.cms.model.Catalog;
import vn.vnpt.data.cms.service.CatalogLocalService;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.ServletContext;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component(immediate = true,
        property = {"javax.portlet.name=" + DataCmsPortletKeys.CATALOG},
        service = AssetRendererFactory.class
)
public class CatalogAssetRenderFactory extends BaseAssetRendererFactory<Catalog> {

    public CatalogAssetRenderFactory() {
        setClassName(CLASS_NAME);
        setLinkable(_LINKABLE);
        setPortletId(DataCmsPortletKeys.CATALOG);
        setSearchable(true);
        setSelectable(true);
    }

    @Override
    public AssetRenderer<Catalog> getAssetRenderer(long classPK, int type) throws PortalException {
        Catalog catalog = _catalogLocalService.getCatalog(classPK);

        CatalogAssetRenderer catalogAssetRenderer = new CatalogAssetRenderer(catalog, _catalogModelResourcePermission);

        catalogAssetRenderer.setAssetRendererType(type);
        catalogAssetRenderer.setServletContext(_servletContext);

        return catalogAssetRenderer;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public String getClassName() {
        return CLASS_NAME;
    }

    @Override
    public PortletURL getURLAdd(LiferayPortletRequest liferayPortletRequest,
                                LiferayPortletResponse liferayPortletResponse, long classTypeId) {
        PortletURL portletURL = null;

        try {
            ThemeDisplay themeDisplay = (ThemeDisplay)
                    liferayPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);

            portletURL = liferayPortletResponse.createLiferayPortletURL(getControlPanelPlid(themeDisplay),
                    DataCmsPortletKeys.CATALOG, PortletRequest.RENDER_PHASE);
            portletURL.setParameter("mvcRenderCommandName", "/catalogportlet/edit_catalog");
            portletURL.setParameter("showback", Boolean.FALSE.toString());

        } catch (PortalException e) {

            logger.log(Level.SEVERE, e.getMessage());

        }

        return portletURL;
    }

    @Override
    public boolean isLinkable() {
        return _LINKABLE;
    }

    @Override
    public String getIconCssClass() {
        return "bookmarks";
    }

    @Reference(target ="(osgi.web.symbolicname=vn.vnpt.data.cms.web.internal.portlet)",
              unbind ="-")

    public void setServletContext(ServletContext servletContext) {
        _servletContext = servletContext;
    }

    @Reference(unbind = "-")
    protected void setGuestbookLocalService(CatalogLocalService catalogLocalService) {
        _catalogLocalService = catalogLocalService;
    }

    private ServletContext _servletContext;
    private CatalogLocalService _catalogLocalService;
    private static final boolean _LINKABLE = true;
    public static final String CLASS_NAME = Catalog.class.getName();
    public static final String TYPE = "catalog";
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private ModelResourcePermission<Catalog> _catalogModelResourcePermission;
}
