<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="vn.vnpt.data.cms.model.Catalog" %>
<%@ page import="vn.vnpt.data.cms.service.CatalogLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@ include file="/init.jsp" %>
<%
    long catalogId = ParamUtil.getLong(request, "catalogId", 0L);
    Catalog catalog = null;
    if (catalogId != 0L) {
        try {
            catalog = CatalogLocalServiceUtil.getCatalog(catalogId);
        } catch (PortalException e) {
            e.printStackTrace();
        }
    }
%>

<div class="catalog-wrapper">
    <c:if test="<%=catalog != null%>">
        <div class="panel-title mb-2">
            <h2><%=catalog.getTitle()%>
            </h2>
        </div>
        <div class="catalog-tags mb-2">
            <ul class="tags">
                <li>
                    <a href="#">
                        <i class="icon-tags" aria-hidden="true"></i>
                        Test 1
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="icon-tags" aria-hidden="true"></i>
                        Test 1
                    </a>
                </li>
            </ul>
        </div>
        <div class="catalog-desc">
            <%=catalog.getDescription()%>
        </div>
        <aui:fieldset collapsed="<%= true %>" collapsible="<%= true %>" label="assets-resources">
            <div class="management-bar-light mb-2" id="catalogSearch">
            </div>
            <div id="catalogDataTable" class="mb-2"></div>
            <table id="datasetTable" class="table table-striped table-bordered" style="width:100%">
            </table>
            <div class="download-resource">
                <button class="btn btn-primary download-data" onclick="catalog.downloadFile(1,<%=catalogId%>)">
                    PDF
                </button>
                <button class="btn btn-primary download-data" onclick="catalog.downloadFile(2,<%=catalogId%>)">
                    CSV
                </button>
            </div>
        </aui:fieldset>
    </c:if>
</div>
<script>
    if ('<%=catalog != null%>') {
        dataSet.renderDataSetDataTable('<%=catalogId%>', []);
    }
</script>
<script id="catalogSearchForm" type="text/x-jQuery-tmpl">
    <div class="row mb-2">
        {{each columns}}
            <div class="col-md-3">
            {{if dataType == "VARCHAR"}}
               <input class="form-control" id="${code}" type="text" name="${code}" placeholder="${name}">
            {{else dataType == "BIGINT" }}
               <input class="form-control" id="${code}" type="number" name="${code}" placeholder="${name}" min="0">
            {{else}}
               ${dataType}
            {{/if}}
            </div>
        {{/each}}
    </div>
    <div class="row">
        <div class="col-md-6">
            <button type="button" class="btn btn-primary" onclick="dataSet.searchData()">
                <i class="icon-search"></i> <%=LanguageUtil.get(request, "search")%>
            </button>

            <button type="button" class="btn btn-light" onclick="dataSet.clearSearch()">
                <i class="icon-eraser"></i> <%=LanguageUtil.get(request, "cancel")%>
            </button>
        </div>
    </div>

</script>