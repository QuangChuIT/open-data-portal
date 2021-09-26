<%@ include file="/init.jsp" %>
<%
    PortalPreferences portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(liferayPortletRequest);

    DataCmsAdminManagementToolbarDisplayContext dataCmsAdminManagementToolbarDisplayContext =
            (DataCmsAdminManagementToolbarDisplayContext) request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);
%>