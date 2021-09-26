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
        // build datatable
        YUI().use(
            'aui-datatable',
            'aui-datatype',
            'datatable-sort',
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
                        rowsPerPage: 10,
                        pageSizes: [2, 'Show All']
                    }
                ).render('#catalogDataTable');

                dataTable.get('boundingBox').unselectable();
            }
        );
    },
    renderDataSetDataTable: function (catalogId) {
        let instance = this;
        const catalogGetDataUrl = config.host + "/o/catalog/get_data?catalogId=" + catalogId + '&channel=CMS&transId=ktgb8x1l';
        $.ajax({
            type: "GET",
            url: catalogGetDataUrl,
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
        $("#catalogSearchForm").tmpl(dataCfg).appendTo("#catalogSearch");
    },
    searchData: function () {
        let instance = this;
        const searchRequest = [];
        let columns = JSON.parse(localStorage.getItem("columnSearch"));
        columns.forEach(function (e) {
            const columnSearch = {};
            columnSearch.key = e.code;
            columnSearch.value = $("#" + e.code).val("");
            searchRequest.push(columnSearch);
        });
        const catalogId = localStorage.getItem("catalogId");
        const catalogSearchDataUrl = config.host + "/o/catalog/search?catalogId=" + catalogId + '&channel=CMS&transId=ktgb8x1l';
        $.ajax({
            type: "POST",
            url: catalogSearchDataUrl,
            data: JSON.stringify(searchRequest),
            dataType: "json",   //expect html to be returned
            success: function (response) {
                // build search form
                const key = catalogId + "_columns";
                const nestedCols = JSON.parse(localStorage.getItem(key));
                instance._renderDataTable(nestedCols, response.data.items.data);
            },
            error: function () {

            }
        });

    },
    clearSearch: function () {
        let columns = JSON.parse(localStorage.getItem("columnSearch"));
        columns.forEach(function (e) {
            $("#" + e.code).val("");
        });
        console.log("Clear search now");
    }
}