<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="init.jsp" %>
<liferay-portlet:actionURL portletConfiguration="<%=true%>" var="configurationActionURL"/>

<liferay-portlet:renderURL portletConfiguration="<%=true%>"
                           var="configurationRenderURL"/>

<aui:form action="<%=configurationActionURL%>" method="post" name="fm"
          cssClass="container-lg container-no-gutters-sm-down container-view">
    <div class="panel-group panel-group-flush">
        <aui:input name="<%=Constants.CMD%>" type="hidden" value="<%=Constants.UPDATE%>"/>
        <aui:input name="redirect" type="hidden" value="<%=configurationRenderURL%>"/>

        <div class="ltr-form-content">
            <div class="sheet-lg sheet">
                <div role="tablist" aria-multiselectable="true">
                    <h3><liferay-ui:message key="choose-display-setting"/></h3>
                    <aui:fieldset>
                        <aui:select name="displayStyle" id="styleSelector">
                            <aui:option label="<%=defaultDisplayStyle%>"
                                        selected="<%=displayStyle.equals(defaultDisplayStyle)%>"
                            />
                            <aui:option label="<%=sliderDisplayStyle%>"
                                        selected="<%=displayStyle.equals(sliderDisplayStyle)%>"
                            />
                            <aui:option label="<%=listTitleDisplayStyle%>"
                                        selected="<%=displayStyle.equals(listTitleDisplayStyle)%>"
                            />
                        </aui:select>
                    </aui:fieldset>
                    <div class="lfr-form-row">
                        <div class="row-fields">
                            <div class="aui-field-row query-row">
                                <label class="control-label"><span
                                        class="aui-field-label"><liferay-ui:message
                                        key="select-asset-categories"/></span></label>
                                <aui:select cssClass="tab-asset-query-name" name="queryName" label=""
                                            id="entrySelector">
                                    <aui:option label="tags" value="assetTags"
                                                selected='<%= selectName.equals("assetTags") %>'/>
                                    <aui:option label="categories" value="assetCategories"
                                                selected='<%= selectName.equals( "assetCategories")  %>'/>
                                </aui:select>
                                <div class="aui-field tags-selector <%= selectName.equals("assetTags") ? StringPool.BLANK : "aui-helper-hidden" %>">
                                    <liferay-asset:asset-tags-selector hiddenInput="selectedTagsNames"
                                                                       tagNames='<%=selectName.equals("assetTags") ? currentSelectValues : null %>'
                                                                       autoFocus="<%=false%>"/>
                                </div>
                                <div class="aui-field categories-selector <%= selectName.equals("assetCategories") ? StringPool.BLANK : "aui-helper-hidden" %>">
                                    <liferay-asset:asset-categories-selector hiddenInput="selectedCategoryIds"
                                                                             categoryIds='<%=selectName.equals("assetCategories") ? currentSelectValues : null %>'
                                                                             showRequiredLabel="<%=true%>"
                                    />
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="show-advance-settings-action-trigger">
                        <a id="show-advance-settings-action-trigger" href="javascript:;">
                            <liferay-ui:message key="show-advance-settings"/>
                        </a>
                    </div>
                    <aui:input type="hidden" name="configCommand" value="updateEntriesSelection"/>
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

<div id="advanced-settings-container" class="advanced-settings-container">
    <c:if test='<%=selectName.equals("assetTags")%>'>
        <liferay-util:include page="/tag_properties.jsp"/>
    </c:if>
    <c:if test='<%=selectName.equals("assetCategories")%>'>
        <liferay-util:include page="/category_properties.jsp"/>
    </c:if>
</div>

<script>
    AUI().ready('aui-base', function (A) {
        let select = A.one('#<portlet:namespace/>entrySelector');
        if (select) {
            var row = select.ancestor('.query-row');
            if (row) {
                select.on('change', function (event) {
                    const tagsSelector = row.one('.tags-selector');
                    const categoriesSelector = row.one('.categories-selector');

                    if (select.val() === 'assetTags') {
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
                });
            }
        }
    });
</script>