<%@ page import="vn.vnpt.data.cms.model.Catalog" %>
<%@ page import="vn.vnpt.data.cms.service.CatalogLocalServiceUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Catalog catalog = (Catalog) request.getAttribute("ct_catalog");

    catalog = catalog.toEscapedModel();
%>
<dl>
    <dt>Catalog</dt>
    <dd><%= CatalogLocalServiceUtil.getCatalog(catalog.getCatalogId()).getTitle() %>
    </dd>
    <dt>Name</dt>
    <dd><%= catalog.getTitle() %>
    </dd>
    <dt>Description</dt>
    <dd><%= catalog.getDescription() %>
    </dd>
</dl>
