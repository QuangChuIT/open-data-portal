<%@ include file="/admin/init.jsp" %>

<clay:management-toolbar
        actionDropdownItems="<%= dataCmsAdminManagementToolbarDisplayContext.getActionItemsDropdownItems() %>"
        clearResultsURL="<%= dataCmsAdminManagementToolbarDisplayContext.getClearResultsURL() %>"
        componentId="dataCmsManagementToolbar"
        creationMenu="<%= dataCmsAdminManagementToolbarDisplayContext.getCreationMenu() %>"
        disabled="<%= dataCmsAdminManagementToolbarDisplayContext.isDisabledManagementBar() %>"
        filterDropdownItems="<%= dataCmsAdminManagementToolbarDisplayContext.getFilterItemsDropdownItems() %>"
        itemsTotal="<%= dataCmsAdminManagementToolbarDisplayContext.getTotalItems() %>"
        namespace="<%= liferayPortletResponse.getNamespace() %>"
        searchActionURL="<%= dataCmsAdminManagementToolbarDisplayContext.getSearchActionURL() %>"
        searchContainerId="<%= dataCmsAdminManagementToolbarDisplayContext.getSearchContainerId() %>"
        searchFormName="fm1"
        sortingOrder="<%= dataCmsAdminManagementToolbarDisplayContext.getOrderByType() %>"
        sortingURL="<%= dataCmsAdminManagementToolbarDisplayContext.getSortingURL() %>"
/>

<aui:script>
    var deleteCatalogs = function () {
        if (
            confirm(
                '<%= UnicodeLanguageUtil.get(request, "are-you-sure-you-want-to-delete-this") %>'
            )
        ) {
            var searchContainer = document.getElementById(
                '<portlet:namespace/>DataCms'
            );

            if (searchContainer) {
                Liferay.Util.postForm(document.<portlet:namespace/>fm, {
                    data: {
                        deleteCatalogIds: Liferay.Util.listCheckedExcept(
                            searchContainer,
                            '<portlet:namespace/>allRowIds'
                        ),
                    },

                    <portlet:actionURL name="/admin/delete_catalog" var="deleteCatalog">
                    <portlet:param name="mvcPath" value="/view.jsp"/>
                    <portlet:param name="redirect" value="<%= currentURL %>"/>
                    </portlet:actionURL>

                    url: '<%= deleteCatalog %>',
                });
            }
        }
    };

    var ACTIONS = {
        deleteCatalogs: deleteCatalogs,
    };

    Liferay.componentReady('dataCmsManagementToolbar').then(function (
        managementToolbar
    ) {
        managementToolbar.on(['actionItemClicked'], function (event) {
            var itemData = event.data.item.data;

            if (itemData && itemData.action && ACTIONS[itemData.action]) {
                ACTIONS[itemData.action]();
            }
        });
    });
</aui:script>