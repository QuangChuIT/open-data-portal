package vn.vnpt.cms.api.listener.service;

import com.google.gson.Gson;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;
import vn.vnpt.cms.api.controller.channels.CmsCatalogGetDataCmd;
import vn.vnpt.cms.api.controller.channels.CmsCatalogInsertCmd;
import vn.vnpt.cms.api.controller.channels.CmsCatalogSearchDataCmd;
import vn.vnpt.cms.api.internal.context.ServiceContextContentProvider;
import vn.vnpt.cms.api.listener.request.CmsCategoryCreateReq;
import vn.vnpt.data.cms.service.CatalogLocalService;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.util.HashSet;
import java.util.List;
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


    @GET
    @Path("/get_all_user")
    @Produces(ContentTypes.APPLICATION_JSON)
    public String getAllUserPortal() {
        List<User> users = UserLocalServiceUtil.getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
        Gson gson = new Gson();
        return gson.toJson(users);
    }

    @GET
    @Path("/get_data")
    @Produces(ContentTypes.APPLICATION_JSON)
    public Response getData(@QueryParam("channel") String channel, @QueryParam("transId") String transId,
                            @QueryParam("catalogId") long catalogId) {
        CmsCatalogGetDataCmd cmd = new CmsCatalogGetDataCmd(this.httpServletRequest, channel, transId,
                catalogId, "", 1, "", 1);
        cmd.execute();
        return cmd.getResponse();
    }

    @POST
    @Path("/search")
    @Produces(ContentTypes.APPLICATION_JSON)
    @Consumes(ContentTypes.APPLICATION_JSON)
    public Response searchData(@QueryParam("channel") String channel, @QueryParam("transId") String transId,
                               @QueryParam("catalogId") long catalogId, String jsonRequest) {
        _log.info(jsonRequest);
        CmsCatalogSearchDataCmd cmd = new CmsCatalogSearchDataCmd();
        cmd.execute();
        return cmd.getResponse();
    }

    @POST
    @Path("/hello")
    @Produces(ContentTypes.APPLICATION_JSON)
    @Consumes(ContentTypes.APPLICATION_JSON)
    public String postHello(String jsonRequest) {
        _log.info("Vao day baby");
        List<User> users = UserLocalServiceUtil.getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
        Gson gson = new Gson();
        return gson.toJson(users);
    }

    @Reference
    private CatalogLocalService _CatalogLocalService;
    @Reference
    private ServiceContextContentProvider _serviceContextContentProvider;
    private final static Log _log = LogFactoryUtil.getLog(CatalogService.class);
}
