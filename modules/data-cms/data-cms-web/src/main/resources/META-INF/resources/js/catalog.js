var config = {
    host: "http://localhost:8080"
};

var catalog = {
    init: function () {
        const instance = this;
        console.log("init function");
    },
    _renderTemplateMetaDataTable: function () {
    },
    createCatalog: function (descriptionData) {
        const instance = this;
        const request = {};
        request.title = $(instance._buildKey("catalogTitle")).val();
        request.description = descriptionData;
        request.version = $(instance._buildKey("version")).val();
        request.visibility = $(instance._buildKey("visibility")).val() === "1";
        let lstColumns = $('#mtConfigBody tr').map(function () {
            return {
                name: $(this).find('[name="cname"]').val(),
                length: $(this).find('[name="length"]').val(),
                dataType: $(this).find('[name="selectDataType"]').val(),
                defaultValue: $(this).find('[name="defaultValue"]').val(),
                notNull: $(this).find('[name="notNull"]').is(':checked'),
                isSearch: $(this).find('[name="isSearch"]').is(':checked'),
                hiddenStatus: false
            };
        }).get();
        if (lstColumns.length === 0) {
            alert("Vui lòng cấu hình các trường dữ liệu cho danh mục");
            return;
        }
        request.lstColumns = lstColumns;
        const redirectUrl = config.host + $(instance._buildKey("redirectUrl")).val();
        $.ajax({
            type: "post",
            url: config.host + '/o/catalog/create',
            contentType: "application/json",
            data: JSON.stringify(request),
            success: function (resp) {
                console.log(JSON.stringify(resp));
                if (resp.error.code !== 200) {
                    $.notify("Thực hiện thêm danh mục dữ liệu thất bại, kiểm tra lại các thông số", "error");
                } else {
                    $.notify("Thực hiện thêm danh mục dữ liệu thành công.", "success")
                    location.href = redirectUrl;
                }
            },
            error: function (xhr, status, error) {
                const errorMessage = xhr.status + ': ' + xhr.statusText
                $.notify(errorMessage, "error");
            }
        });
    },
    addColumnTmpl: function () {
        const instance = this;
        const defaultConfig = {
            idRow: instance._createUUID(),
            dataType: [
                {
                    key: "Số",
                    value: "BIGINT"
                },
                {
                    key: "Chữ",
                    value: "VARCHAR"
                },
                {
                    key: "Ngày tháng",
                    value: "DATETIME"
                },
            ]
        };
        $("#trRowTbConfigTmpl").tmpl(defaultConfig).appendTo("#mtConfigBody");
    },
    downloadTmp: function () {
        let catalogId = $("#catalogId").val();
        let urlDownload = config.host + "/o/source_data/export/template?catalogId=" + catalogId;
        window.open(urlDownload);
    },
    _createUUID: function () {
        let dt = new Date().getTime();
        return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
            let r = (dt + Math.random() * 16) % 16 | 0;
            dt = Math.floor(dt / 16);
            return (c === 'x' ? r : (r & 0x3 | 0x8)).toString(16);
        });
    },
    deleteRowTemplate: function (identifier) {
        const rowId = $(identifier).attr("data-id");
        $("#tr-" + rowId).remove();
    },
    _buildKey(key) {
        const portletNamespace = $("#portletNamespace").val();
        return "#" + portletNamespace + key;
    },
    downloadFile: function (type, catalogId) {
        console.log("Download !!!!!!");
        const url = config.host + "/o/source_data/export?type=" + type + "&catalogId=" + catalogId;
        let link = document.createElement('a');
        link.href = url;
        link.download = url.substr(url.lastIndexOf('/') + 1);
        link.click();
    }
};
/*
 * This function gets loaded when all the HTML, not including the portlets, is
 * loaded.
 */
AUI().ready(function () {

});

/*
 * This function gets loaded after each and every portlet on the page.
 *
 * portletId: the current portlet's id
 * node: the Alloy Node object of the current portlet
 */
Liferay.Portlet.ready(function (_portletId, _node) {
});

/*
 * This function gets loaded when everything, including the portlets, is on
 * the page.
 */
Liferay.on('allPortletsReady', function () {
});
$(document).ready(function () {
    catalog.init();
});
