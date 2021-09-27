<%@ page import="com.liferay.portal.kernel.bean.BeanParamUtil" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter" %>
<%@ page import="vn.vnpt.data.cms.contansts.DataCmsPortletKeys" %>
<%@ page import="vn.vnpt.data.cms.model.Catalog" %>
<%@ include file="/admin/common/init.jsp" %>
<%
    String redirect = ParamUtil.getString(request, "redirect");

    String referringPortletResource = ParamUtil.getString(request, "referringPortletResource");

    Catalog catalog = (Catalog) request.getAttribute(DataCmsPortletKeys.CATALOG);

    long catalogId = BeanParamUtil.getLong(catalog, request, "catalogId");

    boolean showHeader = ParamUtil.getBoolean(request, "showHeader", true);

    if (showHeader) {
        renderResponse.setTitle((catalog == null) ? LanguageUtil.get(request, "add-catalog") : catalog.getTitle(locale));
    }
    portletDisplay.setShowBackIcon(true);
    portletDisplay.setURLBack(redirect);

    long userId = themeDisplay.getUserId();

    long groupId = themeDisplay.getScopeGroupId();

    String queryName = "assetTags";

    String queryValues = "";

%>
<liferay-portlet:actionURL name="/admin/edit_catalog" refererPlid="<%= themeDisplay.getRefererPlid() %>"
                           var="editCatalogURL">
    <portlet:param name="mvcPath" value="/admin/edit_catalog.jsp"/>
</liferay-portlet:actionURL>


<aui:form cssClass="container-fluid-1280" method="post" name="fmEditCatalog">
    <aui:input name="<%= Constants.CMD %>" type="hidden" value=""/>
    <aui:input name="redirect" type="hidden" id="redirectUrl" value="<%= redirect %>"/>
    <aui:input name="referringPortletResource" type="hidden" value="<%= referringPortletResource %>"/>
    <aui:input name="catalogId" type="hidden" value="<%= catalogId %>"/>
    <input type="hidden" value="<portlet:namespace/>" id="portletNamespace"/>
    <aui:model-context bean="<%= catalog %>" model="<%= Catalog.class %>"/>

    <aui:fieldset-group markupView="lexicon">
        <aui:fieldset>
            <aui:input name="catalogTitle" label="cat-full-name" type="text" required="true"/>

            <liferay-ui:input-editor
                    name="catDescription"
                    onInitMethod="OnDescriptionEditorInit"
                    placeholder="description"
                    showSource="true"
            />
            <input name="<portlet:namespace />htmlCodeFromEditorPlacedHere" type="hidden" value=""/>
            <aui:input name="version" label="version" value="1.0.0"/>

            <aui:select name="visibility">
                <aui:option label="public" value="1" selected="true"/>
                <aui:option label="private" value="0"/>
            </aui:select>
            <aui:field-wrapper cssClass="form-group input-catalog-field" label="cat-field-name">
                <aui:row cssClass="mb-2">
                    <table class="table table-striped table-hover" id="metaTableConfig">
                        <thead>
                        <tr>
                            <th scope="col"><%=LanguageUtil.get(request, "cat-field-name-name")%>
                            </th>
                            <th scope="col"><%=LanguageUtil.get(request, "cat-field-name-type")%>
                            </th>
                            <th scope="col"><%=LanguageUtil.get(request, "cat-field-length")%>
                            </th>
                            <th scope="col"><%=LanguageUtil.get(request, "cat-field-default-value")%>
                            </th>
                            <th scope="col"><%=LanguageUtil.get(request, "cat-field-not-null")%>
                            </th>
                            <th scope="col"><%=LanguageUtil.get(request, "cat-field-is-search")%>
                            </th>
                        </tr>
                        </thead>
                        <tbody id="mtConfigBody">
                        </tbody>
                    </table>
                </aui:row>
                <div>
                    <button class="btn btn-primary" type="button" id="btnAddRowTemplate"
                            onclick="catalog.addColumnTmpl()">
                        <i class="icon-plus" aria-hidden="true"></i>
                        <%=LanguageUtil.get(request, "add-new-row-template")%>
                    </button>
                </div>
            </aui:field-wrapper>
        </aui:fieldset>
        <aui:fieldset collapsed="<%= true %>" collapsible="<%= true %>" label="category-tag">
            <div class="aui-field tags-selector">
                <liferay-asset:asset-tags-selector hiddenInput="selectedTagsNames"

                                                   autoFocus="<%=false%>"/>
            </div>
            <div class="aui-field categories-selector">
                <liferay-asset:asset-categories-selector hiddenInput="selectedCategoryIds"
                                                         showRequiredLabel="<%=true%>"
                />
            </div>
        </aui:fieldset>
        <c:if test="<%= catalog == null %>">
            <aui:fieldset collapsed="<%= true %>" collapsible="<%= true %>" label="permissions">
                <liferay-ui:input-permissions
                        modelName="<%= Catalog.class.getName() %>"
                />
            </aui:fieldset>
        </c:if>
    </aui:fieldset-group>
    <aui:button-row>
        <button class="btn btn-primary" type="button" id="btnCreateCatalog" onclick="saveData()">
            <i class="icon-plus" aria-hidden="true"></i>
            <%=LanguageUtil.get(request, "add-new-catalog")%>
        </button>
        <aui:button href="<%= redirect %>" type="cancel"/>
    </aui:button-row>

</aui:form>
<script>
    function <portlet:namespace/>OnDescriptionEditorInit() {
        return '<%=UnicodeFormatter.toString("")%>';
    }

    function saveData() {
        const descriptionData = window.<portlet:namespace />catDescription.getHTML();
        catalog.createCatalog(descriptionData);
    }
</script>
<script id="trRowTbConfigTmpl" type="text/x-jQuery-tmpl">
    <tr id="tr-${idRow}">
        <td>
            <input class="form-control" name="cname" id="cname" type="text"/>
        </td>
        <td>
            <select class="form-control" id="selectDataType" name="selectDataType">
                {{each dataType}}
                    <<option value="${value}">${key}</option>
	            {{/each}}
            </select>
        </td>
        <td>
            <input class="form-control" name="length" type="text"/>
        </td>
        <td>
            <input class="form-control" name="defaultValue" type="text"/>
        </td>
        <td class="text-center">
            <input class="form-check-input" type="checkbox" name="notNull" id="notNull">
        </td>
        <td class="text-center">
            <input class="form-check-input" type="checkbox" name="isSearch" id="isSearch">
        </td>
        <td class="text-center">
            <button type="button" data-id="${idRow}" class="btn btn-sm text-danger .delete-tmp-field"  title="One fine body"
             onclick="catalog.deleteRowTemplate(this)">
                 <i class="icon-trash" aria-hidden="true"></i>
            </button>
        </td>
    </tr>

</script>
