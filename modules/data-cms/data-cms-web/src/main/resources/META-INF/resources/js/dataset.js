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
    _renderDataTable: function (catalogId, columns, columnsSearch) {
        let instance = this;
        const url = config.host + "/o/catalog/get_data_detail?channel=cms&transId=123&catalogId=" + catalogId;
        instance.appSetting.dataTable = $("#datasetTable").DataTable({
            serverSide: true,
            process: true,
            ajax: {
                url: url,
                type: "GET",
                data: {
                    "searchAdv": JSON.stringify(columnsSearch)
                }
            },
            responsive: true,
            lengthMenu: [[10, 25, 50, -1], [10, 25, 50, 100]],
            autoWidth: false,
            ordering: false,
            lengthChange: true,
            searching: true,
            bDestroy: true,
            language: app_message.language,
            paging: true,
            info: false,
            //dom: "lrtip",
            columns: columns,
            "columnDefs": [
                {
                    "searchable": false,
                    "orderable": false,
                    "targets": 0
                }
            ],
            "order": [
                [1, 'asc']
            ],
            initComplete: function () {
                $("div.dataTables_filter")
                    .append('<button class="btn btn-primary btn-sm btn-search-adv" ' +
                        'onclick="dataSet.openAdvanceSearch()" type="button" id="btnSearchAdv">Tìm kiếm nâng cao</button>');
            }
        });

        // Here we create the index column in jquery datatable
        /* instance.appSetting.dataTable.on('order.dt search.dt', function() {
             instance.appSetting.dataTable.column(0, {
                 search: 'applied',
                 order: 'applied'
             }).nodes().each(function(cell, i) {
                 cell.innerHTML = i + 1;
             });
         }).draw();*/
    },
    renderDataSetDataTable: function (catalogId, columnSearch) {
        console.log("Get Data catalog " + catalogId + " column size: " + columnSearch.length);
        let instance = this;
        const catalogGetColumnUrl = config.host + "/o/catalog/get_detail_column?transId=kyzica&channel=cms&catalogId=" + catalogId;
        $.ajax({
            type: "GET",
            url: catalogGetColumnUrl,
            contentType: "application/json",
            dataType: "json",
            success: function (response) {
                // build search form
                instance.createFormSearch(response.data.lsColumn);
                const headers = response.data.lsColumn;
                const nestedCols = [];
                headers.forEach(function (item) {
                    const column = {};
                    column.name = item.code;
                    column.title = item.name;
                    column.data = item.code;
                    column.searchable = item.isSearch;
                    nestedCols.push(column);
                });
                StorageService.deleteItems("_columns");
                const key = catalogId + "_columns";
                StorageService.setItem(key, JSON.stringify(nestedCols));
                instance._renderDataTable(catalogId, nestedCols, columnSearch);
            }
        });
        StorageService.deleteItem("catalogId");
        StorageService.setItem("catalogId", catalogId);
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
        StorageService.deleteItem("columnSearch");
        StorageService.setItem("columnSearch", JSON.stringify(columnSearch));
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
        $("#catalogSearchForm").tmpl(dataCfg).appendTo("#advSearchContainer");
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
            if (columnSearch.value !== "") {
                searchRequest.push(columnSearch);
            }
        });
        let catalogId = StorageService.getItem("catalogId");
        instance.renderDataSetDataTable(catalogId, searchRequest);
    },
    clearSearch: function () {
        let instance = this;
        console.log("Clear search now");
        let columns = JSON.parse(StorageService.getItem("columnSearch"));
        let catalogId = StorageService.getItem("catalogId");
        columns.forEach(function (e) {
            $("#" + e.code).val("");
        });
        instance.renderDataSetDataTable(catalogId, []);
    },
    openAdvanceSearch: function () {
        $('#datasetAdvSearch').modal('toggle');
    },
    openUploadData: function () {
    }
}
