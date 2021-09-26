package vn.vnpt.cms.api.listener.filter;


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.servlet.*;
import java.io.IOException;

public class CustomizeFilter implements Filter {
    protected final Log logger = LogFactoryUtil.getLog(this.getClass());

    public CustomizeFilter() {
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        this.logger.info("Initializing filter, config: {}" + filterConfig);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        this.logger.info("===> New request: " + (request == null ? "" : request.toString()));
        if (chain != null) {
            chain.doFilter(request, response);
        } else {
            this.logger.warn("filterChain is null");
        }

    }

    public void destroy() {
    }
}
