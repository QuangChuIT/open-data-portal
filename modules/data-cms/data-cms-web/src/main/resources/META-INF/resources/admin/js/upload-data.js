$(function () {
    $(document).ajaxStart(function () {
        $('#upload-data-process').show();
    });
    // Drag over event
    $('#drop-area').on('dragover', function (e) {
        e.stopPropagation();
        e.preventDefault();
        $(this).addClass("drag-active");
    });

    // Drag leave event
    $('#drop-area').on('dragleave', function (e) {
        e.stopPropagation();
        e.preventDefault();
        $(this).removeClass("drag-active");
    });

    // Drop event
    $('.drag-area').on('drop', function (e) {
        e.stopPropagation();
        e.preventDefault();

        $(this).addClass("drag-active");

        var file = e.originalEvent.dataTransfer.files;
        var fd = new FormData();

        fd.append('file', file[0]);

        uploadData(fd, e);
    });

    // Open file selector on div click
    $("#uploadDataCat").click(function () {
        $("#uploadInput").click();
    });

    // file selected
    $("#uploadInput").change(function (e) {
        e.preventDefault();
        var fd = new FormData();

        var files = $('#uploadInput')[0].files[0];

        fd.append('file', files);

        uploadData(fd, e);
    });
});

// Sending AJAX request and upload file
function uploadData(formData, event) {
    console.log("Upload data !!!!");
    event.preventDefault();
    // Get form
    let catalogId = $("#catalogId").val();
    $.ajax({
        url: config.host + '/o/source_data/import?catalogId=' + catalogId,
        type: 'POST',
        data: formData,
        cache: false,
        xhr: function () {
            var xhr = new window.XMLHttpRequest();
            //Upload Progress
            xhr.upload.addEventListener("progress", function (evt) {
                if (evt.lengthComputable) {
                    var percentComplete = (evt.loaded / evt.total) * 100;
                    $('div.progress > div.progress-bar').css({"width": percentComplete + "%"});
                }
            }, false);

            //Download progress
            xhr.addEventListener("progress", function (evt) {
                    if (evt.lengthComputable) {
                        var percentComplete = (evt.loaded / evt.total) * 100;
                        $("div.progress > div.progress-bar").css({"width": percentComplete + "%"});
                    }
                },
                false);
            return xhr;
        },
        contentType: false,
        processData: false,
        success: function (data, textStatus, jqXHR) {
            $('#upload-data-process').hide();
            if (data.error.code !== 0) {
                $.notify(data.error.message, "error");
                $("#uploadDatasetModal").modal('hide');
            } else {
                $.notify(data.error.message, "T???i l??n d??? li???u th??nh c??ng")
                $("#uploadDatasetModal").modal('hide');
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            $('#upload-data-process').hide();
            $.notify(textStatus, "error");
            $("#uploadDatasetModal").modal('hide');
        }
    });
}
