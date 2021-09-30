<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="vn.vnpt.data.cms.contansts.DataCmsPortletKeys" %>
<%@ page import="vn.vnpt.data.cms.model.Catalog" %>
<%@ include file="/admin/init.jsp" %>

<%
    String redirect = ParamUtil.getString(request, "redirect");

    Catalog catalog = (Catalog) request.getAttribute(DataCmsPortletKeys.CATALOG);

    catalog = catalog.toEscapedModel();
%>
<clay:container-fluid
        cssClass="main-content-body"
>
    <div class="row mb-2">
        <div class="col-md-12 col-xs-12 col-sm-12">
            <h3 class="text-success"><%=catalog.getTitle()%>
        </div>
    </div>
    <div class="management-bar-light mb-2" id="catalogSearch">
    </div>
    <div id="catalogDataTable" class="mb-2"></div>
    <!-- Button trigger modal -->
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
        Launch demo modal
    </button>
    <!-- Modal -->
    <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    ...
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>
</clay:container-fluid>
<script>
    dataSet.renderDataSetDataTable('<%=catalog.getCatalogId()%>', []);
</script>
<script id="catalogSearchForm" type="text/x-jQuery-tmpl">
    <div class="row mb-2">
        {{each(i, column) columns}}
            <div class="col-md-3">
                <input class="form-control" id="${column.code}" type="text" name="${column.code}" value="" placeholder="${column.name}">
            </div>
        {{/each}}
    </div>
    <div class="row ">
        <div class="col-md-3">
            <button type="button" class="btn btn-primary">
                <i class="icon-search"></i> <%=LanguageUtil.get(request, "search")%>
            </button>

            <button type="button" class="btn btn-dark">
                <i class="icon-eraser"></i> <%=LanguageUtil.get(request, "cancel")%>
            </button>
        </div>
    </div>
</script>