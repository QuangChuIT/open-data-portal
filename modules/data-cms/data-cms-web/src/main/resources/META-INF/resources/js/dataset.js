var dataSet = {
    appSetting: {
        host: "/o/catalog",
        mod: "release",
        debugAgent: "web",
        root: $("#main-content"),
        cookie: 1,
        pathPlugin: "/asset",
        requestTimeout: 5000, // Timeout request for ajax,
        dataTable: null,
        mode: "inbox"
    },
    init: function () {
        console.log("data set init");
    },
    _renderDataTable: function (columns, datas){
        let instance = this;
        $("#datasetTable").DataTable({
            serverSide: false,
            process: false,
            data: datas,
            responsive: true,
            pageLength: 24,
            autoWidth: false,
            ordering: true,
            bDestroy: true,
            lengthChange: true,
            paging: true,
            info: false,
            columns: columns
        });
    },
    _renderDataTable_YUI(columns, datas) {
        console.log("Start rendering datatable with columns size: " + columns.length + " and data length: " + datas.length);
        $("#catalogDataTable").empty();
        // build datatable
        YUI().use(
            'aui-datatable',
            'aui-datatype',
            'datatable-sort',
            'aui-pagination',
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
                        ]
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
                console.log("aaaaa");
                // build search form
                instance.createFormSearch(response.data.items.headers);
                const headers = response.data.items.headers;
                const nestedCols = [];
                const first = {};
                first.name = "id";
                first.title = "Id";
                nestedCols.push(first);
                headers.forEach(function (item) {
                    const column = {};
                    column.name = item.code;
                    column.title = item.name;
                    nestedCols.push(column);
                    column.data = null;
                    column.render = function (data){
                        return data[item.code];
                    }
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