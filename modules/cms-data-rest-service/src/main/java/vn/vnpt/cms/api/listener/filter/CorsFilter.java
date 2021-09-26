package vn.vnpt.cms.api.listener.filter;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;

public class CorsFilter implements ContainerRequestFilter, ContainerResponseFilter {
    protected final Log logger = LogFactoryUtil.getLog(this.getClass());
    protected String origin;

    public CorsFilter() {
    }

    private static boolean isPreflightRequest(ContainerRequestContext request) {
        return request.getHeaderString("Origin") != null && request.getMethod().equalsIgnoreCase("OPTIONS");
    }

    public void filter(ContainerRequestContext request) throws IOException {
        this.origin = request.getHeaderString("Origin");
        this.logger.info(String.format("---------> New request: %s, Method: %s, \"Origin\": %s",
                request.getUriInfo().getRequestUri(), request.getMethod(), this.origin));
        if (isPreflightRequest(request)) {
            request.abortWith(Response.ok().build());
        }
    }

    public void filter(ContainerRequestContext request, ContainerResponseContext response) throws IOException {
        if (request != null && request.getHeaderString("Origin") != null) {
            if (isPreflightRequest(request) && response != null) {
                response.getHeaders().add("Access-Control-Allow-Credentials", "true");
                response.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
                response.getHeaders().add("Access-Control-Allow-Headers", "*");
                response.getHeaders().add("Content-Type", "application/json; charset=utf-8");
                response.setStatus(Status.ACCEPTED.getStatusCode());
            }

            if (response != null) {
                HashSet<String> allowedOrigins = new HashSet<>(Collections.singletonList(this.origin));
                response.getHeaders().add("Access-Control-Allow-Origin", allowedOrigins.contains(this.origin) ? this.origin : "");
                response.getHeaders().add("Vary", "Origin");
            }

        }
    }
}
