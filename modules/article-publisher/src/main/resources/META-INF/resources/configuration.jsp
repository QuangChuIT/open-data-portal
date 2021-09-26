<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="vn.vnpt.portlet.article.publisher.constants.ArticlePublisherPortletKeys" %>
<%@ include file="/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="<%=true%>"
                           var="configurationActionURL"/>

<liferay-portlet:renderURL portletConfiguration="<%=true%>"
                           var="configurationRenderURL"/>

<%
    String styleThumbnailImgPath = "/o/article-publisher-portlet/style/" + displayStyle.trim() + "/thumbnail.png";

%>
<aui:form action="<%=configurationActionURL%>" method="post" name="fm"
          cssClass="container-lg container-no-gutters-sm-down container-view">
    <div class="panel-group panel-group-flush">
        <aui:input name="<%=Constants.CMD%>" type="hidden" value="<%=Constants.UPDATE%>"/>
        <aui:input name="redirect" type="hidden" value="<%=configurationRenderURL%>"/>
        <div class="lfr-form-content">
            <div class="sheet sheet-lg">
                <div aria-multiselectable="true" role="tablist">
                    <h3><liferay-ui:message key="display-setting"/></h3>
                    <aui:fieldset>
                        <aui:select name="displayStyle" id="styleSelector">
                            <aui:option value="<%=ArticlePublisherPortletKeys.DISPLAY_STYLE_1%>"
                                        label="<%=ArticlePublisherPortletKeys.DISPLAY_STYLE_1%>"
                                        selected="<%=displayStyle.equals(ArticlePublisherPortletKeys.DISPLAY_STYLE_1)%>"
                            />
                            <aui:option value="<%=ArticlePublisherPortletKeys.DISPLAY_STYLE_2%>"
                                        label="<%=ArticlePublisherPortletKeys.DISPLAY_STYLE_2%>"
                                        selected="<%=displayStyle.equals(ArticlePublisherPortletKeys.DISPLAY_STYLE_2)%>"
                            />
                            <aui:option value="<%=ArticlePublisherPortletKeys.DISPLAY_STYLE_3%>"
                                        label="<%=ArticlePublisherPortletKeys.DISPLAY_STYLE_3%>"
                                        selected="<%=displayStyle.equals(ArticlePublisherPortletKeys.DISPLAY_STYLE_3)%>"
                            />
                            <aui:option value="<%=ArticlePublisherPortletKeys.DISPLAY_STYLE_4%>"
                                        label="<%=ArticlePublisherPortletKeys.DISPLAY_STYLE_4%>"
                                        selected="<%=displayStyle.equals(ArticlePublisherPortletKeys.DISPLAY_STYLE_4)%>"
                            />
                            <aui:option value="<%=ArticlePublisherPortletKeys.DISPLAY_STYLE_5%>"
                                        label="<%=ArticlePublisherPortletKeys.DISPLAY_STYLE_5%>"
                                        selected="<%=displayStyle.equals(ArticlePublisherPortletKeys.DISPLAY_STYLE_5)%>"
                            />
                        </aui:select>
                    </aui:fieldset>
                    <aui:fieldset>
                        <div class="ltr-form-row">
                            <img id="<portlet:namespace/>styleThumbnailImage" style="width: 100%"
                                 src="<%=styleThumbnailImgPath%>" alt="Asset Image"
                                 onerror="this.src='/o/article-publisher-portlet/images/default.png'">
                        </div>
                    </aui:fieldset>

                    <h3 class="config-title"><liferay-ui:message key="asset-query-rules"/></h3>

                    <div class="lfr-form-row">
                        <div class="row-fields">
                            <div class="aui-field-row query-row">

                                <aui:input label="style-title" cssClass="tab-name-input" name="styleTitle"
                                           value="<%=styleTitle%>"/>
                                <label class="control-label"><span
                                        class="aui-field-label"><liferay-ui:message
                                        key="select-asset-categories"/></span></label>
                                <aui:select cssClass="tab-asset-query-name" name="queryName" label="">
                                    <aui:option label="tags" value="assetTags"
                                                selected='<%= queryName.equals("assetTags") %>'/>
                                    <aui:option label="categories" value="assetCategories"
                                                selected='<%= queryName.equals( "assetCategories")  %>'/>
                                </aui:select>
                                <div class="aui-field tags-selector <%= queryName.equals("assetTags") ? StringPool.BLANK : "aui-helper-hidden" %>">
                                    <liferay-asset:asset-tags-selector hiddenInput="selectedTagsNames"
                                                                       tagNames='<%=queryName.equals("assetTags") ? queryValues : null %>'
                                                                       autoFocus="<%=false%>"/>
                                </div>
                                <div class="aui-field categories-selector <%= queryName.equals("assetCategories") ? StringPool.BLANK : "aui-helper-hidden" %>">
                                    <liferay-asset:asset-categories-selector hiddenInput="selectedCategoryIds"
                                                                             categoryIds='<%=queryName.equals("assetCategories") ? queryValues : null %>'
                                                                             showRequiredLabel="<%=true%>"
                                    />
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="lfr-form-row">
                        <div class="row-fields">

                            <aui:select name="numbersOfEntriesDisplay" label="total-assets-display">
                                <%
                                    for (String s : numbersOfEntriesDisplayValues) {
                                        int numbersOfEntriesDisplayValue = GetterUtil.getInteger(s);
                                %>
                                <aui:option label="<%= String.valueOf(numbersOfEntriesDisplayValue)%>"
                                            value="<%= String.valueOf(numbersOfEntriesDisplayValue)%>"
                                            selected='<%= numbersOfEntriesDisplay == numbersOfEntriesDisplayValue %>'/>
                                <%
                                    }
                                %>
                            </aui:select>

                            <div style="clear: both;"></div>

                            <aui:select name="orderByColumn" label="asset-order-by-column">
                                <aui:option label="by-title" value="title"
                                            selected='<%= orderByColumn.equals("title") %>'/>
                                <aui:option label="by-publish-date" value="publishDate"
                                            selected='<%= orderByColumn.equals("publishDate") %>'/>
                                <aui:option label="by-view-count" value="viewCount"
                                            selected='<%= orderByColumn.equals("viewCount") %>'/>
                            </aui:select>

                            <aui:select inlineField="<%= true %>" label="" name="orderByType">
                                <aui:option label="ASC" value="ASC"
                                            selected='<%= orderByType.equals("ASC") %>'/>
                                <aui:option label="DESC" value="DESC"
                                            selected='<%= orderByType.equals("DESC") %>'/>
                            </aui:select>

                        </div>
                    </div>

                    <div class="lfr-form-row">
                        <div class="row-fields">
                            <aui:input type="checkbox" name="showPublishDate" value="<%=showPublishDate %>"
                                       label="show-publish-date"/>

                            <aui:input type="checkbox" label="show-rss-icon" name="showRSSIcon"
                                       value="<%=showRSSIcon %>"/>

                            <aui:input type="checkbox" label="show-view-more-asset-url"
                                       name="showViewMoreAssetURL" value="<%=showViewMoreAssetURL %>"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="sheet-footer dialog-footer">
            <aui:button-row>
                <aui:button type="submit" value="save"/>
                <aui:button name="cancelBtn" value="cancel"/>
            </aui:button-row>
        </div>
    </div>

</aui:form>

<script type="text/javascript">
    AUI().use("aui-loading-mask", 'aui-io-request', 'liferay-portlet-url', function (A) {
            let displayStyleSelector = A.one('#<portlet:namespace/>styleSelector');

            if (displayStyleSelector) {

                displayStyleSelector.on('change', function () {

                    let selectedStyle = this.val().trim();

                    let styleThumbnailImg = A.one('#<portlet:namespace/>styleThumbnailImage');

                    if (styleThumbnailImg) {
                        let selectedStyleThumbnailPath = '/o/article-publisher-portlet/style/' + selectedStyle + '/thumbnail.png';

                        styleThumbnailImg.setAttribute('src', selectedStyleThumbnailPath);
                    }
                });
            }

            let closeConfigPageBtn = A.one('#<portlet:namespace/>cancelBtn');

            if (closeConfigPageBtn) {

                closeConfigPageBtn.on('click', function () {
                    Liferay.Util.getWindow().close();
                });
            }

            let queryNameSelectors = A.one('#_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_queryName');

            if (queryNameSelectors) {

                let row = queryNameSelectors.ancestor('.query-row');

                if (row) {
                    queryNameSelectors.on(
                        'change',
                        function (event) {
                            let tagsSelector = row.one('.tags-selector');
                            let categoriesSelector = row.one('.categories-selector');

                            if (queryNameSelectors.val() === 'assetTags') {
                                if (tagsSelector) {
                                    tagsSelector.removeClass("aui-helper-hidden");
                                    tagsSelector.show();
                                }

                                if (categoriesSelector) {
                                    categoriesSelector.hide();
                                }
                            } else {
                                if (tagsSelector) {
                                    tagsSelector.hide();
                                }

                                if (categoriesSelector) {
                                    categoriesSelector.removeClass("aui-helper-hidden");
                                    categoriesSelector.show();
                                }
                            }
                        }
                    );
                }
            }
        }
    );
</script>