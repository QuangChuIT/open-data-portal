package vn.vnpt.data.cms.util.comparator;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import vn.vnpt.data.cms.model.Catalog;

public class CatalogCreateDateComparator extends OrderByComparator<Catalog> {
    public static final String ORDER_BY_ASC = "Catalog.createDate ASC";
    public static final String ORDER_BY_DESC = "Catalog.createDate DESC";
    public static final String[] ORDER_BY_FIELDS = {"createDate"};

    public CatalogCreateDateComparator(boolean ascending) {
        _ascending = ascending;
    }

    @Override
    public int compare(Catalog o1, Catalog o2) {
        int value = DateUtil.compareTo(o1.getCreateDate(), o2.getCreateDate());
        if (_ascending) {
            return value;
        }
        return -value;
    }

    @Override
    public String getOrderBy() {
        if (_ascending) {
            return ORDER_BY_ASC;
        }

        return ORDER_BY_DESC;
    }

    @Override
    public String[] getOrderByFields() {
        return ORDER_BY_FIELDS;
    }

    @Override
    public boolean isAscending() {
        return _ascending;
    }

    private final boolean _ascending;
}
