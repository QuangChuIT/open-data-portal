package vn.vnpt.data.cms.web.internal.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenuBuilder;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.util.*;
import vn.vnpt.data.cms.contansts.DataCmsActionKeys;
import vn.vnpt.data.cms.model.Catalog;
import vn.vnpt.data.cms.service.CatalogLocalService;
import vn.vnpt.data.cms.util.comparator.CatalogCreateDateComparator;
import vn.vnpt.data.cms.util.comparator.CatalogFullNameComparator;
import vn.vnpt.data.cms.web.internal.portlet.search.CatalogSearch;
import vn.vnpt.data.cms.web.internal.portlet.util.DataCmsAdminRequestHelper;
import vn.vnpt.data.cms.web.internal.security.permission.resource.DataCmsAdminPermission;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataCmsAdminManagementToolbarDisplayContext {
    private static final Log _log = LogFactoryUtil.getLog(
            DataCmsAdminManagementToolbarDisplayContext.class);
    private final CatalogLocalService _catalogLocalService;
    private final DataCmsAdminRequestHelper _dataCmsAdminRequestHelper;
    private final RenderRequest _renderRequest;
    private final RenderResponse _renderResponse;
    private CatalogSearch _catalogSearch;

    public DataCmsAdminManagementToolbarDisplayContext(
            RenderRequest renderRequest, RenderResponse renderResponse,
            CatalogLocalService catalogLocalService) {

        _renderRequest = renderRequest;
        _renderResponse = renderResponse;
        _catalogLocalService = catalogLocalService;

        _dataCmsAdminRequestHelper = new DataCmsAdminRequestHelper(renderRequest);
    }

    public List<DropdownItem> getActionItemsDropdownItems() {
        return DropdownItemListBuilder.add(
                dropdownItem -> {
                    dropdownItem.putData("action", "deleteQuestions");
                    dropdownItem.setIcon("times-circle");
                    dropdownItem.setLabel(
                            LanguageUtil.get(
                                    _dataCmsAdminRequestHelper.getRequest(), "delete"));
                    dropdownItem.setQuickAction(true);
                }
        ).build();
    }

    public String getClearResultsURL() throws PortletException {
        PortletURL clearResultsURL = PortletURLUtil.clone(
                getPortletURL(), _renderResponse);

        clearResultsURL.setParameter("keywords", StringPool.BLANK);

        return clearResultsURL.toString();
    }

    public CreationMenu getCreationMenu() throws PortalException {
/*
        if (!isShowAddCatalogButton()) {
            return null;
        }
*/

        return CreationMenuBuilder.addPrimaryDropdownItem(
                dropdownItem -> {
                    HttpServletRequest httpServletRequest =
                            _dataCmsAdminRequestHelper.getRequest();

                    dropdownItem.setHref(
                            _renderResponse.createRenderURL(), "mvcPath",
                            "/admin/edit_catalog.jsp", "redirect",
                            PortalUtil.getCurrentURL(httpServletRequest));
                    dropdownItem.setLabel(
                            LanguageUtil.get(httpServletRequest, "add-catalog"));
                }
        ).build();
    }

    public String getSearchActionURL() {
        PortletURL portletURL = _renderResponse.createRenderURL();

        portletURL.setParameter("mvcPath", "/admin/view.jsp");

        return portletURL.toString();
    }

    public String getSearchContainerId() {
        return "DataCms";
    }

    public boolean isDisabledManagementBar() {
        if (hasResults()) {
            return false;
        }

        if (isSearch()) {
            return false;
        }

        return true;
    }

    protected boolean hasResults() {
        if (getTotalItems() > 0) {
            return true;
        }

        return false;
    }

    public int getTotalItems() {
        SearchContainer<?> searchContainer = getSearch();

        return searchContainer.getTotal();
    }

    protected boolean isSearch() {
        if (Validator.isNotNull(getKeywords())) {
            return true;
        }

        return false;
    }

    public String getDisplayStyle() {
        return "list";
    }

    public List<DropdownItem> getFilterItemsDropdownItems() {
        HttpServletRequest httpServletRequest =
                _dataCmsAdminRequestHelper.getRequest();

        return DropdownItemListBuilder.addGroup(
                dropdownGroupItem -> {
                    dropdownGroupItem.setDropdownItems(
                            getFilterNavigationDropdownItems());
                    dropdownGroupItem.setLabel(
                            LanguageUtil.get(
                                    httpServletRequest, "filter-by-navigation"));
                }
        ).addGroup(
                dropdownGroupItem -> {
                    dropdownGroupItem.setDropdownItems(getOrderByDropdownItems());
                    dropdownGroupItem.setLabel(
                            LanguageUtil.get(httpServletRequest, "order-by"));
                }
        ).build();
    }

    public SearchContainer<?> getSearch() {
        if (_catalogSearch != null) {
            return _catalogSearch;
        }

        PortletURL portletURL = getPortletURL();

        portletURL.setParameter("displayStyle", getDisplayStyle());

        _catalogSearch = new CatalogSearch(
                _renderRequest, portletURL);

        String orderByCol = getOrderByCol();
        String orderByType = getOrderByType();

        OrderByComparator<Catalog> orderByComparator =
                getCatalogOrderByComparator(orderByCol, orderByType);

        _catalogSearch.setOrderByCol(orderByCol);
        _catalogSearch.setOrderByComparator(orderByComparator);
        _catalogSearch.setOrderByType(orderByType);

        if (_catalogSearch.isSearch()) {
            _catalogSearch.setEmptyResultsMessage("no-catalogs-were-found");

            _populateWithSearchIndex(_catalogSearch);
        } else {
            _catalogSearch.setEmptyResultsMessage("there-are-no-catalogs");

            _populateWithDatabase(_catalogSearch);
        }

        return _catalogSearch;
    }

    private void _populateWithDatabase(
            CatalogSearch catalogSearch) {

        catalogSearch.setResults(
                _catalogLocalService.search(
                        _dataCmsAdminRequestHelper.getScopeGroupId(),
                        catalogSearch.getStart(), catalogSearch.getEnd(),
                        catalogSearch.getOrderByComparator()));
        catalogSearch.setTotal(
                _catalogLocalService.searchCount(
                        _dataCmsAdminRequestHelper.getScopeGroupId()));
    }

    private void _populateWithSearchIndex(
            CatalogSearch catalogSearch) {

        try {
            Indexer<Catalog> indexer = IndexerRegistryUtil.getIndexer(
                    Catalog.class);

            Hits hits = indexer.search(
                    _buildSearchContext(catalogSearch));

            List<SearchResult> searchResults =
                    SearchResultUtil.getSearchResults(
                            hits, LocaleUtil.getDefault());

            Stream<SearchResult> stream = searchResults.stream();

            catalogSearch.setResults(
                    stream.map(
                            SearchResult::getClassPK
                    ).map(
                            _catalogLocalService::fetchCatalog
                    ).collect(
                            Collectors.toList()
                    ));

            catalogSearch.setTotal(hits.getLength());
        } catch (SearchException searchException) {
            if (_log.isDebugEnabled()) {
                _log.debug(searchException, searchException);
            }

            catalogSearch.setResults(Collections.emptyList());

            catalogSearch.setTotal(0);
        }
    }

    private SearchContext _buildSearchContext(
            CatalogSearch catalogSearch) {

        SearchContext searchContext = SearchContextFactory.getInstance(
                _dataCmsAdminRequestHelper.getRequest());

        searchContext.setAttribute("paginationType", "none");
        searchContext.setCompanyId(_dataCmsAdminRequestHelper.getCompanyId());
        searchContext.setEnd(catalogSearch.getEnd());
        searchContext.setGroupIds(
                new long[]{_dataCmsAdminRequestHelper.getScopeGroupId()});
        searchContext.setKeywords(getKeywords());

        OrderByComparator<Catalog> orderByComparator =
                catalogSearch.getOrderByComparator();

        if (orderByComparator != null) {
            searchContext.setSorts(_getSortFromComparator(orderByComparator));
        }

        searchContext.setStart(catalogSearch.getStart());

        return searchContext;
    }

    private Sort _getSortFromComparator(
            OrderByComparator<Catalog> orderByComparator) {

        boolean reverse = !orderByComparator.isAscending();

        String[] orderByFields = orderByComparator.getOrderByFields();

        String orderByField = orderByFields[0];

        if (orderByField.equals(Field.CREATE_DATE)) {
            return new Sort(orderByField, Sort.LONG_TYPE, reverse);
        }

        return new Sort(orderByField, reverse);
    }

    public OrderByComparator<Catalog> getCatalogOrderByComparator(
            String orderByCol, String orderByType) {

        boolean orderByAsc = false;

        if (orderByType.equals("asc")) {
            orderByAsc = true;
        }

        OrderByComparator<Catalog> orderByComparator = null;

        if (orderByCol.equals("create-date")) {
            orderByComparator = new CatalogCreateDateComparator(
                    orderByAsc);
        } else if (orderByCol.equals("cat-full-name")) {
            orderByComparator = new CatalogFullNameComparator(orderByAsc);
        }

        return orderByComparator;
    }

    protected List<DropdownItem> getOrderByDropdownItems() {
        return DropdownItemListBuilder.add(
                getOrderByDropdownItem("create-date")
        ).add(
                getOrderByDropdownItem("title")
        ).build();
    }

    protected UnsafeConsumer<DropdownItem, Exception> getOrderByDropdownItem(
            String orderByCol) {

        return dropdownItem -> {
            dropdownItem.setActive(orderByCol.equals(getOrderByCol()));
            dropdownItem.setHref(getPortletURL(), "orderByCol", orderByCol);
            dropdownItem.setLabel(
                    LanguageUtil.get(_dataCmsAdminRequestHelper.getRequest(), orderByCol));
        };
    }

    protected List<DropdownItem> getFilterNavigationDropdownItems() {
        return DropdownItemListBuilder.add(
                dropdownItem -> {
                    dropdownItem.setActive(true);

                    dropdownItem.setHref(getPortletURL(), "navigation", "all");

                    dropdownItem.setLabel(
                            LanguageUtil.get(_dataCmsAdminRequestHelper.getRequest(), "all"));
                }
        ).build();
    }

    public boolean isShowAddCatalogButton() throws PortalException {
        return DataCmsAdminPermission.contains(
                _dataCmsAdminRequestHelper.getPermissionChecker(),
                _dataCmsAdminRequestHelper.getScopeGroupId(), DataCmsActionKeys.ADD_CATALOG);
    }

    protected String getKeywords() {
        return ParamUtil.getString(_renderRequest, "keywords");
    }

    public String getOrderByCol() {
        return ParamUtil.getString(_renderRequest, "orderByCol", "create-date");
    }

    public String getOrderByType() {
        return ParamUtil.getString(_renderRequest, "orderByType", "desc");
    }

    public String getSortingURL() throws Exception {
        PortletURL sortingURL = PortletURLUtil.clone(
                getPortletURL(), _renderResponse);

        String orderByType = ParamUtil.getString(_renderRequest, "orderByType");

        sortingURL.setParameter(
                "orderByType", orderByType.equals("asc") ? "desc" : "asc");

        return sortingURL.toString();
    }

    public PortletURL getPortletURL() {
        PortletURL portletURL = _renderResponse.createRenderURL();

        portletURL.setParameter("mvcPath", "/admin/view.jsp");

        String delta = ParamUtil.getString(_renderRequest, "delta");

        if (Validator.isNotNull(delta)) {
            portletURL.setParameter("delta", delta);
        }

        String displayStyle = getDisplayStyle();

        if (Validator.isNotNull(displayStyle)) {
            portletURL.setParameter("displayStyle", displayStyle);
        }

        String keywords = getKeywords();

        if (Validator.isNotNull(keywords)) {
            portletURL.setParameter("keywords", keywords);
        }

        String orderByCol = getOrderByCol();

        if (Validator.isNotNull(orderByCol)) {
            portletURL.setParameter("orderByCol", orderByCol);
        }

        String orderByType = getOrderByType();

        if (Validator.isNotNull(orderByType)) {
            portletURL.setParameter("orderByType", orderByType);
        }

        return portletURL;
    }
}
