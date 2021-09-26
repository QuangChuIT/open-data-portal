<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ include file="/init.jsp" %>

<%
    long catalogId = ParamUtil.getLong(request,"catalogId", 0L);

%>
<h1>
    <%=catalogId%>
</h1>