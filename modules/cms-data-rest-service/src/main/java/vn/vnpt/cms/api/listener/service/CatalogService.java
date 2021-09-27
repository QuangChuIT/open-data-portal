package vn.vnpt.cms.api.listener.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;
import vn.vnpt.cms.api.controller.channels.CmsCatalogGetDataCmd;
import vn.vnpt.cms.api.controller.channels.CmsCatalogInsertCmd;
import vn.vnpt.cms.api.internal.context.ServiceContextContentProvider;
import vn.vnpt.cms.api.listener.request.CmsCatalogGetDataReq;
import vn.vnpt.cms.api.listener.request.CmsCategoryCreateReq;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.util.HashSet;
import java.util.Set;

/**
 * @author QuangChu
 */
@Component(
        property = {
                JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/catalog",
                JaxrsWhiteboardConstants.JAX_RS_NAME + "=Catalog.RestService",
                "auth.verifier.guest.allowed=true",
                "liferay.access.control.disable=true"
        },
        service = Application.class
)
public class CatalogService extends BaseService {

    public Set<Object> getSingletons() {
        Set<Object> singletons = new HashSet<>();

        singletons.add(_serviceContextContentProvider);

        singletons.add(this);

        return singletons;
    }

    @POST
    @Path("create")
    public Response insertCategory(String jsonRequest, @Context ServiceContext serviceContext) {
        CmsCatalogInsertCmd cmd = new CmsCatalogInsertCmd(this.httpServletRequest, jsonRequest, CmsCategoryCreateReq.class);
        cmd.execute();
        return cmd.getResponse();
    }


    @POST
    @Path("/get_data")
    @Produces(ContentTypes.APPLICATION_JSON)
    public Response getData(String jsonRequest) {
        CmsCatalogGetDataCmd cmd = new CmsCatalogGetDataCmd(this.httpServletRequest, jsonRequest, CmsCatalogGetDataReq.class);
        cmd.execute();
        return cmd.getResponse();
    }


    @Reference
    private ServiceContextContentProvider _serviceContextContentProvider;
    private final static Log _log = LogFactoryUtil.getLog(CatalogService.class);
}
