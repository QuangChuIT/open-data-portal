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

    <button id="showModal" class="btn btn-primary">Show Modal</button>

    <div class="yui3-skin-sam">
        <div id="modal">
            <h1>hellow</h1>
        </div>
    </div>
</clay:container-fluid>
<script>
    dataSet.renderDataSetDataTable('<%=catalog.getCatalogId()%>');
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
<script>
    YUI().use(
        'aui-modal',
        function(Y) {
            var modal = new Y.Modal(
                {
                    bodyContent: 'How many pages do you want to print?',
                    centered: true,
                    destroyOnHide: false,
                    headerContent: '<h3>Print</h3>',
                    modal: true,
                    render: '#modal',
                    resizable: {
                        handles: 'b, r'
                    },
                    toolbars: {
                        body: [
                            {
                                icon: 'glyphicon glyphicon-file',
                                label: 'Single Page'
                            },
                            {
                                icon: 'glyphicon glyphicon-book',
                                label: 'All Pages'
                            }
                        ]
                    },
                    visible: true,
                    width: 450
                }
            ).render();

            modal.addToolbar(
                [
                    {
                        label: 'Cancel',
                        on: {
                            click: function() {
                                modal.hide();
                            }
                        }
                    },
                    {
                        label: 'Okay',
                        on: {
                            click: function() {
                                alert('Just an example, there will be no printing here.');
                            }
                        }
                    }
                ]
            );

            Y.one('#showModal').on(
                'click',
                function() {
                    modal.show();
                }
            );
        }
    );
</script>