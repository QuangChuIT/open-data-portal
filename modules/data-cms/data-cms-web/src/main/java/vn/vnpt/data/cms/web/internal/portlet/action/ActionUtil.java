package vn.vnpt.data.cms.web.internal.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import vn.vnpt.data.cms.contansts.DataCmsPortletKeys;
import vn.vnpt.data.cms.model.Catalog;
import vn.vnpt.data.cms.service.CatalogLocalServiceUtil;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

public class ActionUtil {
    public static void getCatalog(HttpServletRequest httpServletRequest) throws PortalException {
        long catalogId = ParamUtil.getLong(httpServletRequest, "catalogId");

        Catalog catalog = null;
        if (catalogId > 0) {
            catalog = CatalogLocalServiceUtil.getCatalog(catalogId);
        }

        httpServletRequest.setAttribute(DataCmsPortletKeys.CATALOG, catalog);
    }

    public static void getCatalog(PortletRequest portletRequest) throws PortalException {
        getCatalog(PortalUtil.getHttpServletRequest(portletRequest));
    }
}
