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
        const columnsToConfig = JSON.parse(columns);
        instance.appSetting.dataTable = $("#datasetTable").DataTable({
            serverSide: true,
            processing: true,
            ajax: {
                url: url,
                type: "GET",
                dataType: 'json',
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
            columns: columnsToConfig,
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
        const key = catalogId + "_columns";
        const nestedCols = StorageService.getItem(key);
        if (nestedCols === null) {
            const catalogGetColumnUrl = config.host + "/o/catalog/get_detail_column?transId=kyzica&channel=cms&catalogId=" + catalogId;
            $.ajax({
                type: "GET",
                url: catalogGetColumnUrl,
                contentType: "application/json",
                dataType: "json",
                success: function (response) {
                    // build search form
                    instance._storeColumnSearch(response.data.lsColumn);
                    const headers = response.data.lsColumn;
                    const nestedColsNew = [];
                    headers.forEach(function (item) {
                        const column = {};
                        column.name = item.code;
                        column.title = item.name;
                        column.data = item.code;
                        column.searchable = item.isSearch;
                        nestedColsNew.push(column);
                    });
                    instance._renderDataTable(catalogId, JSON.stringify(nestedColsNew), columnSearch);
                    StorageService.deleteItems("_columns");
                    StorageService.setItem(key, JSON.stringify(nestedColsNew));
                }
            });
        } else {
            instance._renderDataTable(catalogId, nestedCols, columnSearch);
        }

        StorageService.deleteItem("catalogId");
        StorageService.setItem("catalogId", catalogId);
    },
    _filterColumnSearch(columns) {
        if (columns.length === 0) {
            return columns;
        }
        return columns.filter(column => column.isSearch === true);
    },
    createFormSearch: function () {
        let instance = this;
        let columnSearch = JSON.parse(StorageService.getItem("columnSearch"));
        const dataCfg = {};
        dataCfg.columns = columnSearch;
        $("#advSearchContainer").empty();
        $("#catalogSearchForm").tmpl(dataCfg).appendTo("#advSearchContainer");
    },
    _storeColumnSearch: function (columns) {
        let instance = this;
        let columnSearch = instance._filterColumnSearch(columns);
        StorageService.deleteItem("columnSearch");
        StorageService.setItem("columnSearch", JSON.stringify(columnSearch));
    },
    searchData: function () {
        let instance = this;
        const searchRequest = [];
        let columns = JSON.parse(StorageService.getItem("columnSearch"));
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
        const dtColumnKey = catalogId + "_columns";
        const columnsDatatable = StorageService.getItem(dtColumnKey);
        $('#datasetAdvSearch').modal('hide');
        instance._renderDataTable(catalogId, columnsDatatable, searchRequest);
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
        $('#datasetAdvSearch').modal('hide');
    },
    openAdvanceSearch: function () {
        let instance = this;
        instance.createFormSearch();
        $('#datasetAdvSearch').modal('toggle');
    },
    openUploadData: function () {
    }
}
