<%@ page import="vn.vnpt.data.cms.model.Catalog" %>
<%@ page import="vn.vnpt.data.cms.service.CatalogLocalServiceUtil" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ include file="/init.jsp" %>

<%
    List<Catalog> catalogs = new ArrayList<>();
    catalogs = CatalogLocalServiceUtil.findByGroupId(scopeGroupId);
%>
<c:choose>
    <c:when test="<%=catalogs.size() > 0%>">
        <div class="catalogs">
            <%
                for (Catalog catalog : catalogs) {
                    long catalogId = catalog.getCatalogId();
                    String title = catalog.getTitle();
            %>
            <liferay-portlet:renderURL var="viewCatalogUrl">
                <liferay-portlet:param name="catalogId" value="<%=String.valueOf(catalogId)%>"/>
            </liferay-portlet:renderURL>
            <div class="catalog-item">
                <a href="<%=viewCatalogUrl%>"><%=title%>
                </a>
            </div>
            <%
                }
            %>
        </div>
    </c:when>
    <c:otherwise>
        <%
            renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
        %>
        <div class="portlet-configuration portlet-msg-info">
            <aui:a href="<%=portletDisplay.getURLConfiguration()%>" label="no-catalogs-were-found"
                   onClick="<%=portletDisplay.getURLConfigurationJS()%>"/>
        </div>
    </c:otherwise>
</c:choose>
<script>
    $(document).ready(function (){
       console.log("Hello QuangCV nhe :))))");
    });
</script>