<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="init.jsp"%>

<%
    String categoryPropertiesPanelState = ParamUtil.getString(request, "categoryPropertiesPanelState","closed");
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" >
    <liferay-portlet:param  name="portletResource" value="<%=portletResource %>"/>
</liferay-portlet:actionURL>