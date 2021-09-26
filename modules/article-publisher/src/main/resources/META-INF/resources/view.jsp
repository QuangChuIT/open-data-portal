<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="vn.vnpt.portlet.article.publisher.util.ArticlePublisherUtil" %>
<%@ include file="/init.jsp" %>

<%
    String styleViewPath = "/style/" + displayStyle.trim() + "/view.jsp";

%>
<aui:row>
    <c:choose>
        <c:when test='<%=Validator.isNotNull(displayStyle) %>'>

            <liferay-util:include page="<%=styleViewPath%>" servletContext="<%= application %>"/>

            <c:if test="<%=showRSSIcon || showViewMoreAssetURL %>">
                <div class="bottom-links col-md-12 col-xs-12 col-sm-12">
                    <c:if test="<%=showRSSIcon %>">

                        <portlet:resourceURL var="rssResourceURL"/>

                        <div class="subscribe pull-left">
                            <liferay-ui:icon image="rss" label="<%= true %>" method="get"
                                             target="_blank" url="<%= rssResourceURL %>"/>
                        </div>
                    </c:if>

                    <c:if test="<%=showViewMoreAssetURL %>">
                        <%
                            String olderAssetURL = ArticlePublisherUtil.getOlderAssetsURL(request);
                        %>
                        <div class="read-more-articles pull-right">
                            <a href="<%=olderAssetURL%>"><liferay-ui:message
                                    key="more-articles"/></a>
                        </div>
                    </c:if>
                </div>
            </c:if>
        </c:when>

        <c:otherwise>
            <%
                renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.FALSE);
            %>

            <div class="portlet-configuration portlet-msg-info">
                <aui:a href="<%= portletDisplay.getURLConfiguration() %>"
                       label="please-config-this-portlet-to-display-assets"
                       onClick="<%= portletDisplay.getURLConfigurationJS() %>"/>
            </div>
        </c:otherwise>
    </c:choose>
</aui:row>
