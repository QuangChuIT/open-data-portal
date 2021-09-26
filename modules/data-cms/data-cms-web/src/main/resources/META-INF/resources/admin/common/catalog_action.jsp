<%@ page import="com.liferay.petra.string.StringPool" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.security.permission.ActionKeys" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="vn.vnpt.data.cms.contansts.DataCmsActionKeys" %>
<%@ page import="vn.vnpt.data.cms.model.Catalog" %>
<%@ page import="vn.vnpt.data.cms.web.internal.security.permission.resource.DataCmsCatalogPermission" %>
<%@ include file="/admin/common/init.jsp" %>

<%
    ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

    Catalog catalogSelected = (Catalog) row.getObject();
%>

<liferay-ui:icon-menu
        direction="left-side"
        icon="<%= StringPool.BLANK %>"
        markupView="lexicon"
        message="<%= StringPool.BLANK %>"
        showWhenSingleIcon="<%= true %>"
>
    <c:if test="<%= DataCmsCatalogPermission.contains(permissionChecker, catalogSelected, ActionKeys.UPDATE) %>">
        <portlet:renderURL var="editURL">
            <portlet:param name="mvcRenderCommandName" value="/admin/edit_catalog"/>
            <portlet:param name="redirect" value="<%= currentURL %>"/>
            <portlet:param name="catalogId" value="<%= String.valueOf(catalogSelected.getCatalogId()) %>"/>
        </portlet:renderURL>

        <liferay-ui:icon
                message="edit"
                url="<%= editURL %>"
        />
    </c:if>

    <c:if test="<%= DataCmsCatalogPermission.contains(permissionChecker, catalogSelected, ActionKeys.PERMISSIONS) %>">
        <liferay-security:permissionsURL
                modelResource="<%= Catalog.class.getName() %>"
                modelResourceDescription="<%= catalogSelected.getTitle(locale) %>"
                resourcePrimKey="<%= String.valueOf(catalogSelected.getCatalogId()) %>"
                var="permissionsURL"
                windowState="<%= LiferayWindowState.POP_UP.toString() %>"
        />

        <liferay-ui:icon
                message="permissions"
                method="get"
                url="<%= permissionsURL %>"
                useDialog="<%= true %>"
        />
    </c:if>
    <c:if test="<%= DataCmsCatalogPermission.contains(permissionChecker, catalogSelected, DataCmsActionKeys.IMPORT_DATA_CATALOG) %>">
        <portlet:renderURL var="uploadDataPopupUrl" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
            <portlet:param name="mvcPath" value="/admin/common/upload_data.jsp"/>
            <portlet:param name="catalogId" value="<%= String.valueOf(catalogSelected.getCatalogId()) %>"/>
        </portlet:renderURL>
        <input type="hidden" id="uploadDataPopupURL" value="<%=uploadDataPopupUrl%>">
        <liferay-ui:icon
                message="upload-data"
                url="javascript:void(0)"
                onClick='<%= "event.preventDefault(); " + liferayPortletResponse.getNamespace() + "openPopup();" %>'
        />
    </c:if>

    <c:if test="<%= DataCmsCatalogPermission.contains(permissionChecker, catalogSelected, ActionKeys.DELETE) %>">
        <portlet:actionURL name="/admin/edit_catalog" var="deleteURL">
            <portlet:param name="mvcActionCommand" value="/admin/edit_catalog"/>
            <portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>"/>
            <portlet:param name="redirect" value="<%= currentURL %>"/>
            <portlet:param name="catalogId" value="<%= String.valueOf(catalogSelected.getCatalogId()) %>"/>
        </portlet:actionURL>

        <liferay-ui:icon-delete
                url="<%= deleteURL %>"
        />
    </c:if>

</liferay-ui:icon-menu>

<script>
    function <portlet:namespace/>openPopup(url) {
        const URL = $("#uploadDataPopupURL").val();
        Liferay.Util.openWindow({
            dialog: {
                centered: true,
                height: 300,
                modal: true,
                width: 800
            },
            id: '<portlet:namespace/>uploadDataModal',
            title: '<%=LanguageUtil.get(request, "upload-data-catalog-dialog-title")%>',
            uri: URL
        });
    }
</script>