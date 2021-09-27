<%@ page import="com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="vn.vnpt.data.cms.exception.NoSuchCatalogException" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ include file="/admin/init.jsp" %>

<liferay-util:include page="/admin/common/top_tabs.jsp" servletContext="<%= application %>"/>
<liferay-util:include page="/admin/management_bar.jsp" servletContext="<%= application %>"/>
<clay:container-fluid
        cssClass="main-content-body"
>
    <aui:form method="post" name="fm">
        <aui:input name="deleteCatalogIds" type="hidden"/>
        <liferay-ui:error exception="<%= NoSuchCatalogException.class %>" message="please-select-an-option"/>

        <liferay-ui:search-container
                cssClass="table-nowrap"
                id="<%=dataCmsAdminManagementToolbarDisplayContext.getSearchContainerId()%>"
                rowChecker="<%= new EmptyOnClickRowChecker(renderResponse)%>"
                searchContainer="<%= dataCmsAdminManagementToolbarDisplayContext.getSearch() %>"
        >
            <liferay-ui:search-container-row className="vn.vnpt.data.cms.model.Catalog"
                                             cssClass="entry-display-style"
                                             keyProperty="catalogId"
                                             modelVar="catalog">
                <%
                    PortletURL rowURL = renderResponse.createRenderURL();

                    rowURL.setParameter("mvcRenderCommandName", "/datacms/view_dataset");
                    rowURL.setParameter("redirect", currentURL);
                    rowURL.setParameter("catalogId", String.valueOf(catalog.getCatalogId()));
                %>
                <liferay-ui:search-container-column-text
                        cssClass="table-cell-expand table-cell-minw-200 table-title"
                        href="<%= rowURL %>"
                        name="cat-full-name"
                        value="<%= HtmlUtil.escape(catalog.getTitle()) %>"
                />
                <liferay-ui:search-container-column-text
                        cssClass="table-cell-expand-smaller"
                        href="<%= rowURL %>"
                        name="cat-table-name"
                        value="<%= catalog.getTableName() %>"
                />
                <%--<liferay-ui:search-container-column-text
                        cssClass="table-cell-expand table-cell-minw-200 table-title"
                        href="<%= rowURL %>"
                        name="cat-description"
                        value="<%= HtmlUtil.escape(catalog.getDescription()) %>"
                />--%>
                <liferay-ui:search-container-column-text
                        cssClass="table-cell-expand table-cell-minw-200 table-title"
                        href="<%= rowURL %>"
                        name="cat-version"
                        value="<%= HtmlUtil.escape(catalog.getVersion()) %>"
                />
                <liferay-ui:search-container-column-text
                        cssClass="table-cell-expand table-cell-minw-200 table-title"
                        href="<%= rowURL %>"
                        name="cat-visibility"
                        value='<%= catalog.getVisibility() == true ? LanguageUtil.get(request, "public") : LanguageUtil.get(request, "private")%>'
                />
                 <liferay-ui:search-container-column-jsp
                         path="/admin/common/catalog_action.jsp"
                 />
            </liferay-ui:search-container-row>
            <liferay-ui:search-iterator
                    displayStyle="list"
                    markupView="lexicon"
                    searchContainer="<%= searchContainer %>"
            />
        </liferay-ui:search-container>
    </aui:form>
</clay:container-fluid>

