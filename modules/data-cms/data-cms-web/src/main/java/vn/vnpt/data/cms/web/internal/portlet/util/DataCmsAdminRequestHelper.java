package vn.vnpt.data.cms.web.internal.portlet.util;

import com.liferay.portal.kernel.display.context.util.BaseRequestHelper;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.RenderRequest;

public class DataCmsAdminRequestHelper extends BaseRequestHelper {
    public DataCmsAdminRequestHelper(RenderRequest renderRequest) {
        super(PortalUtil.getHttpServletRequest(renderRequest));
    }
}
