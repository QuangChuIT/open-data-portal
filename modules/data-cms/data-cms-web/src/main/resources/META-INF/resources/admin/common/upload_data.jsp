<%@ page import="com.liferay.portal.kernel.bean.BeanParamUtil" %>
<%@ page import="vn.vnpt.data.cms.contansts.DataCmsPortletKeys" %>
<%@ page import="vn.vnpt.data.cms.model.Catalog" %>
<%@ include file="/admin/common/init.jsp" %>
<%
    Catalog catalog = (Catalog) request.getAttribute(DataCmsPortletKeys.CATALOG);

    long catalogId = BeanParamUtil.getLong(catalog, request, "catalogId");
%>
