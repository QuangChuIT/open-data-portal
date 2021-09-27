var dataSet = {
    setting: {
        host: "/dataset",
        mod: "release"
    },
    init: function () {
        console.log("data set init");
    },
    _renderDataTable(columns, datas) {
        console.log("Start rendering datatable with columns size: " + columns.length + " and data length: " + datas.length);
        $("#catalogDataTable").empty();
        // build datatable
        YUI().use(
            'aui-datatable',
            'aui-datatype',
            'datatable-sort',
            'datatable-paginator',
            function (Y) {
                const dataTable = new Y.DataTable(
                    {
                        columns: columns,
                        data: datas,
                        plugins: [
                            {
                                cfg: {
                                    highlightRange: false
                                },
                                fn: Y.Plugin.DataTableHighlight
                            }
                        ],
                        pageSizes: [ 4, 'Show All' ],
                        rowsPerPage: 4
                    }
                ).render('#catalogDataTable');

                dataTable.get('boundingBox').unselectable();
            }
        );
    },
    renderDataSetDataTable: function (catalogId, columnSearch) {
        let instance = this;
        const catalogGetDataUrl = config.host + "/o/catalog/get_data";
        const request = {};
        request.catalogId = catalogId;
        request.pageIndex = 1;
        request.status = 1;
        request.searchColumns = columnSearch;
        request.orderBy = "";
        request.transId = "abcxyz";
        request.channel = "cms";

        $.ajax({
            type: "POST",
            url: catalogGetDataUrl,
            contentType: "application/json",
            data: JSON.stringify(request),
            dataType: "json",   //expect html to be returned
            success: function (response) {
                // build search form
                instance.createFormSearch(response.data.items.headers);
                const headers = response.data.items.headers;
                const nestedCols = [];
                headers.forEach(function (item) {
                    const column = {};
                    column.sortable = true;
                    column.key = item.code;
                    column.label = item.name;
                    nestedCols.push(column);
                });
                const key = catalogId + "_columns";
                localStorage.setItem(key, JSON.stringify(nestedCols));
                instance._renderDataTable(nestedCols, response.data.items.data);
            }
        });
        localStorage.removeItem("catalogId");
        localStorage.setItem("catalogId", catalogId);
    },
    _filterColumnSearch(columns) {
        if (columns.length === 0) {
            return columns;
        }
        return columns.filter(column => column.isSearch === true);
    },
    createFormSearch: function (columns) {
        let instance = this;
        let columnSearch = instance._filterColumnSearch(columns);
        localStorage.removeItem("columnSearch");
        localStorage.setItem("columnSearch", JSON.stringify(columnSearch));
        const lengthColumn = columnSearch.length + 2;
        let numberRow = Math.ceil(lengthColumn / 4);
        const dataCfg = {};
        for (let i = 0; i < numberRow; i++) {
            const column = {};
            column.row = i;
            column.values = [];
        }
        dataCfg.columns = columnSearch;
        $("#catalogSearch").empty();
        $("#catalogSearchForm").tmpl(dataCfg).appendTo("#catalogSearch");
    },
    searchData: function () {
        let instance = this;
        const searchRequest = [];
        let columns = JSON.parse(localStorage.getItem("columnSearch"));
        columns.forEach(function (e) {
            const columnSearch = {};
            columnSearch.name = e.code;
            columnSearch.value = $("#" + e.code).val();
            columnSearch.dataType = e.dataType;
            columnSearch.catalogId = e.catalogId;
            if(columnSearch.value !== ""){
                searchRequest.push(columnSearch);
            }
        });
        let catalogId = localStorage.getItem("catalogId");
        instance.renderDataSetDataTable(catalogId, searchRequest);
    },
    clearSearch: function () {
        let instance = this;
        console.log("Clear search now");
        let columns = JSON.parse(localStorage.getItem("columnSearch"));
        let catalogId = localStorage.getItem("catalogId");
        columns.forEach(function (e) {
            $("#" + e.code).val("");
        });
        instance.renderDataSetDataTable(catalogId, []);
    }
}