<%@ page import="com.liferay.asset.kernel.service.AssetTagLocalServiceUtil" %>
<%@ page import="com.liferay.petra.string.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringUtil" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/asset" prefix="liferay-asset" %>
<%@ taglib prefix="liferay-util" uri="http://liferay.com/tld/util" %>
<liferay-theme:defineObjects/>

<portlet:defineObjects/>

<%
    long companyId = themeDisplay.getCompanyId();

    long groupId = themeDisplay.getScopeGroupId();

    /*Property key tuong ung voi ten hien thi cua Tag*/
    String displayNamePropertyKey = "display-name";

    /*Property tuong ung voi id anh icon cua tag*/
    String iconImageIdPropertyKey = "icon-image-id";


    /*PropertyKey tuong ung voi custom url cua tag*/
    String customURLPropertyKey = "custom-url";

    /*Tieu de hien thi*/
    String navigationTitle = portletPreferences.getValue("navigationTitle", StringPool.BLANK);

    // Kieu hien thi mac dinh
    String defaultDisplayStyle = "default-style";

    String listTitleDisplayStyle = "list-title-style";

    String sliderDisplayStyle = "slider-style";

    // Kieu hien thi
    String displayStyle = portletPreferences.getValue("displayStyle", defaultDisplayStyle);

    long repository = themeDisplay.getLayout().getGroupId();

    // Kieu du lieu hien thi : AssetTag, Asset Category hoac Vocabulary
    String selectName = portletPreferences.getValue("selectedName", "assetTags");

    //Cac entry hien tai dang chon
    String currentSelectValues = StringUtil.merge(portletPreferences.getValues("selectedValues", new String[0]));

    if (selectName.equals("assetTags")) {
        currentSelectValues = ParamUtil.getString(request, "selectedTagNames", currentSelectValues);
    } else {
        currentSelectValues = ParamUtil.getString(request, "selectedCategoryIds", currentSelectValues);
    }

    String[] selectedValues = portletPreferences.getValues("selectedValues", new String[0]);

    long[] selectedTagIds = new long[selectedValues.length];

    long[] selectedCategoryIds = new long[selectedValues.length];
    if (selectName.equals("assetTags")) {
        selectedTagIds = AssetTagLocalServiceUtil.getTagIds(scopeGroupId, selectedValues);
    } else {
        for (int i = 0; i < selectedValues.length; i++) {
            selectedCategoryIds[i] = Long.parseLong(selectedValues[i]);
        }
    }

%>
