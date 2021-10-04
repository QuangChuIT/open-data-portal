<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/META-INF/resources/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL">
    <liferay-portlet:param name="portletResource" value="<%=portletResource %>"/>
</liferay-portlet:actionURL>


<liferay-portlet:renderURL portletConfiguration="<%=true%>"
                           var="configurationRenderURL"/>

<h1>Hello</h1>