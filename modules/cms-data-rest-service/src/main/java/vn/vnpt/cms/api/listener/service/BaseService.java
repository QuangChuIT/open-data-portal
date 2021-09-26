package vn.vnpt.cms.api.listener.service;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Consumes({"application/json"})
@Produces({"application/json"})
public class BaseService extends Application {
    @Context
    protected HttpServletRequest httpServletRequest;

    public BaseService() {
    }

    @GET
    @Path("example")
    public Response example(){
        return null;
    }
}
