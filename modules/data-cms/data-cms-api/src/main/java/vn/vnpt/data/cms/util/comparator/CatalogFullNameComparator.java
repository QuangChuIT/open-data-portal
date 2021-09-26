package vn.vnpt.data.cms.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;
import vn.vnpt.data.cms.model.Catalog;

public class CatalogFullNameComparator extends OrderByComparator<Catalog> {
    public static final String ORDER_BY_ASC = "Catalog.catFullName ASC";
    public static final String ORDER_BY_DESC = "Catalog.catFullName DESC";
    public static final String[] ORDER_BY_FIELDS = {"catFullName"};

    public CatalogFullNameComparator(boolean _ascending) {
        this._ascending = _ascending;
    }

    @Override
    public String[] getOrderByFields() {
        return ORDER_BY_FIELDS;
    }

    @Override
    public boolean isAscending() {
        return _ascending;
    }

    @Override
    public int compare(Catalog o1, Catalog o2) {
        String title1 = StringUtil.toLowerCase(o1.getTitle());
        String title2 = StringUtil.toLowerCase(o2.getTitle());

        int value = title1.compareTo(title2);

        if (_ascending) {
            return value;
        }

        return -value;
    }

    private final boolean _ascending;
}
