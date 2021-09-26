package vn.vnpt.data.cms.web.internal.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import org.osgi.service.component.annotations.Component;
import vn.vnpt.data.cms.contansts.DataCmsPortletKeys;
import vn.vnpt.data.cms.exception.NoSuchCatalogException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
        property = {
                "javax.portlet.name=" + DataCmsPortletKeys.DATA_CMS_ADMIN,
                "javax.portlet.name=" + DataCmsPortletKeys.DATA_CMS_DISPLAY,
                "mvc.command.name=/datacms/view_dataset"
        },
        service = MVCRenderCommand.class
)
public class ViewCatalogMVCRenderActionCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        try {
            ActionUtil.getCatalog(renderRequest);
        } catch (Exception e){
            if(e instanceof NoSuchCatalogException || e instanceof PrincipalException) {
                SessionErrors.add(renderRequest, e.getClass());
                return "/datacms/error.jsp";
            }

            throw  new PortletException(e);
        }
        return "/admin/view_dataset.jsp";
    }
}
