/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

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

function postRequest(options) {
    $.ajax({
        type: options['type'] || "POST",
        contentType: "application/json",
        url: options['url'],
        data: JSON.stringify(options['data']),
        /*dataType: 'json',*/
        success: options['success'],
        error: function (e) {
            console.log(e);
        }
    });
}

function postFormRequest(options, formData) {
    $.ajax({
        type: "POST",
        url: options['url'],
        data: formData,
        dataType: 'json',
        processData: false,
        contentType: false,
        success: options['success'],
        error: function (e) {
            options['error'](e.responseJSON);
        }
    });
}

function getRequest(options) {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: options['url'],
        success: options['success'],
        error: function (e) {
            options['error'](e.responseText);
        }
    });
}

function deleteRequest(options) {
    $.ajax({
        type: "DELETE",
        contentType: "application/json",
        url: options['url'],
        success: options['success'],
        error: function (e) {
            options['error'](e.responseJSON);
        }
    });
}