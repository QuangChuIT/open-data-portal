<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="vn.vnpt.portlet.article.publisher.cache.AssetEntryCache" %>
<%@ page import="vn.vnpt.portlet.article.publisher.util.ArticlePublisherUtil" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/init.jsp" %>

<%
    List<AssetEntryCache> assetCacheList = ArticlePublisherUtil.getListAssetEntryCaches(request, 1);
%>
<c:choose>
    <c:when test='<%=assetCacheList.size() > 0 %>'>
        <div class="article-publisher-style1">
        <%
            String topAssetSummary = "";
            String topAssetImgPath = "";

            for (int index = 0; index < assetCacheList.size(); index++) {

                AssetEntryCache assetCache = assetCacheList.get(index);

                String assetTitle = com.liferay.portal.kernel.util.StringUtil.shorten(assetCache.getTitle(), 120);

                String assetLink = ArticlePublisherUtil.getViewContentURL(request, assetCache); //assetCache.getViewContentURL();

                String publishDate = dateFormat.format(assetCache.getPublishDate());

                if (index == 0) {
                    topAssetSummary = assetCache.getSummary();
                    topAssetImgPath = assetCache.getSmallImagePath();
                }
        %>
        <c:choose>
            <c:when test='<%=(index == 0)%>'>
                <div class="row mb-2">
                    <div class="col-md-12">
                        <div class="asset-title">
                            <a href="<%=assetLink%>" title="<%=assetCache.getTitle()%>">
                                <%=assetTitle %>
                            </a>
                            <c:if test="<%=showPublishDate %>">
                                <span class="publish-date"><%=publishDate %></span>
                            </c:if>
                        </div>
                    </div>
                </div>
                <div class="row asset-summary">
                    <div class="col-md-3 asset-image">
                        <c:if test='<%=Validator.isNotNull(topAssetImgPath) %>'>
                            <a href="<%=assetLink%>">
                                <img class="small-img" align="left"
                                     src="<%= topAssetImgPath %>"
                                     title="<%=assetCache.getTitle()%>"
                                     onerror="this.src='/thumbnail/default-image.jpg'"
                                 alt="<%=assetTitle%>"/>
                            </a>
                        </c:if>
                    </div>
                    <div class="col-md-9">
                        <span class="summary-content"><%=topAssetSummary %></span>
                    </div>
                </div>
                <div style="clear: both;"></div>
            </c:when>
            <c:otherwise>
                <div class="older-asset">
						<span class="asset-title">
							<a href="<%=assetLink%>" title="<%=assetCache.getTitle()%>"><%=assetTitle %></a>
						</span>
                    <c:if test='<%=showPublishDate %>'>
                        <span class="publish-date">(<%=publishDate %>)</span>
                    </c:if>
                </div>
            </c:otherwise>
        </c:choose>
        <%
            }
        %>
        </div>
    </c:when>

    <c:otherwise>
        <%
            renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.FALSE);
        %>

        <div class="portlet-configuration portlet-msg-info">
            <aui:a href="<%= portletDisplay.getURLConfiguration() %>"
                   label="no-asset-found" onClick="<%= portletDisplay.getURLConfigurationJS() %>"/>
        </div>
    </c:otherwise>
</c:choose>
