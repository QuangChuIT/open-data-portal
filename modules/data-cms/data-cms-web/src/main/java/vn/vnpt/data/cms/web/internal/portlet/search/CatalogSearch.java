package vn.vnpt.data.cms.web.internal.portlet.search;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.util.OrderByComparator;
import vn.vnpt.data.cms.model.Catalog;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import java.util.ArrayList;
import java.util.List;

public class CatalogSearch extends SearchContainer<Catalog> {
    public static final String EMPTY_RESULTS_MESSAGE = "no-entries-were-found";

    public static List<String> headerNames = new ArrayList<String>() {
        {
            add("title");
            add("table-name");
            add("status");
            add("modified-date");
        }
    };

    public CatalogSearch(
            PortletRequest portletRequest, PortletURL iteratorURL) {

        super(
                portletRequest, new CatalogDisplayTerms(portletRequest),
                new CatalogDisplayTerms(portletRequest), DEFAULT_CUR_PARAM,
                DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
    }

    public void setOrderByComparator(OrderByComparator<Catalog> orderByComparator) {
    }
}
