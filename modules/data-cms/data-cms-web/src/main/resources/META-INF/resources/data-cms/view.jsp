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
        <div class="catalog-desc mb-3">
            <%=catalog.getDescription()%>
        </div>
        <aui:fieldset collapsed="<%= true %>" collapsible="<%= true %>" label="assets-resources">
            <table id="datasetTable" class="table table-bordered table-hover" style="width:100%">
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
        <%-- Advance Search --%>
        <div aria-labelledby="datasetAdvSearch" class="fade modal" id="datasetAdvSearch" role="dialog" tabindex="-1">
            <div class="modal-dialog modal-full-screen-sm-down modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header">
                        <div class="modal-title" id="clayDefaultModalLabel">
                            <%=LanguageUtil.get(request,"advanced-search")%>
                        </div>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body" id="advSearchContainer">
                    </div>
                </div>
            </div>
        </div>
    </c:if>
</div>
<script>
    if ('<%=catalog != null%>') {
        dataSet.renderDataSetDataTable('<%=catalogId%>', []);
    }
</script>
<script id="catalogSearchForm" type="text/x-jQuery-tmpl">
    <form id="formSearchData">
        {{each columns}}
            <div class="form-group">
            <label for="${code}">${name}</label>
            {{if dataType == "VARCHAR"}}
               <input class="form-control" id="${code}" type="text" name="${code}" placeholder="${name}">
            {{else dataType == "BIGINT" }}
               <input class="form-control" id="${code}" type="number" name="${code}" placeholder="${name}" min="0">
            {{else}}
               ${dataType}
            {{/if}}
            </div>
        {{/each}}
         <div class="form-group">
            <button type="button" class="btn btn-primary" onclick="dataSet.searchData()">
                <i class="icon-search"></i> <%=LanguageUtil.get(request, "search")%>
            </button>

            <button type="button" class="btn btn-light" onclick="dataSet.clearSearch()">
                <i class="icon-eraser"></i> <%=LanguageUtil.get(request, "cancel")%>
            </button>
         </div>
    </form>

</script>