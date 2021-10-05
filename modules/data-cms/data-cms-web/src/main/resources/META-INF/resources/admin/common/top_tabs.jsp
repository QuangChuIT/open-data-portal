<%@ page import="vn.vnpt.data.cms.web.internal.display.context.DataCmsAdminNavigationDisplayContext" %>
<%@ include file="/admin/common/init.jsp" %>

<%
    DataCmsAdminNavigationDisplayContext dataCmsAdminNavigationDisplayContext = new DataCmsAdminNavigationDisplayContext(request, liferayPortletResponse);
%>

<clay:navigation-bar
        inverted="<%= true %>"
        navigationItems="<%= dataCmsAdminNavigationDisplayContext.getNavigationItems() %>"
/>