<%@ page import="com.liferay.petra.string.StringPool" %>
<%@ page import="com.liferay.petra.string.StringUtil" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@ page import="vn.vnpt.portlet.article.publisher.configuration.ArticlePublisherConfiguration" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.liferay.asset.util.AssetHelper" %>
<%@ page import="com.liferay.asset.constants.AssetWebKeys" %>
<%@ page import="com.liferay.asset.publisher.constants.AssetPublisherWebKeys" %>
<%@ page import="com.liferay.asset.publisher.util.AssetPublisherHelper" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib prefix="liferay-util" uri="http://liferay.com/tld/util" %>
<%@ taglib uri="http://liferay.com/tld/clay" prefix="clay" %>
<%@ taglib uri="http://liferay.com/tld/asset" prefix="liferay-asset" %>
<liferay-theme:defineObjects/>

<portlet:defineObjects/>

<%
    String languageId = LanguageUtil.getLanguageId(request);

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

    ArticlePublisherConfiguration articlePublisherConfiguration = (ArticlePublisherConfiguration) renderRequest
            .getAttribute(ArticlePublisherConfiguration.class.getName());

    long groupId = themeDisplay.getScopeGroupId();

    String portletResource = ParamUtil.getString(request, "portletResource");

    String portletId = PortalUtil.getPortletId(request);

    String displayStyle = StringPool.BLANK;

    String[] numbersOfEntriesDisplayValues = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "15", "20", "30", "40", "50"};

    String styleTitle = StringPool.BLANK;

    boolean showPublishDate = false;

    boolean showRSSIcon = false;

    boolean showViewMoreAssetURL = false;

    boolean queryContains = true;

    boolean queryAndOperator = false;

    String queryName;

    String queryValues;

    String[] queryValuesArray;

    long[] allAssetCategoryIds;

    String[] allAssetCategoryTagNames = new String[0];

    displayStyle =
            portletPreferences.getValue(
                    "displayStyle", "");

    styleTitle = portletPreferences.getValue("styleTitle", LanguageUtil.get(locale, "title"));

    showPublishDate = GetterUtil.getBoolean(portletPreferences.getValue("showPublishDate", null), false);

    showRSSIcon = GetterUtil.getBoolean(portletPreferences.getValue("showRSSIcon", null), false);

    showViewMoreAssetURL = GetterUtil.getBoolean(portletPreferences.getValue("showViewMoreAssetURL", null), false);

    queryContains = GetterUtil.getBoolean(portletPreferences.getValue("queryContains", null), true);

    queryAndOperator = GetterUtil.getBoolean(portletPreferences.getValue("queryAndOperator", null), false);

    queryName = portletPreferences.getValue("queryName", "assetTags");

    queryValues = StringUtil.merge(portletPreferences.getValues("queryValues", new String[0]), ",");

    queryValuesArray = portletPreferences.getValues("queryValues", new String[0]);

    String[] allAssetTagNames = new String[0];

    if (queryName.equals("assetTags")) {

        queryValues = ParamUtil.getString(request, "selectedTagsNames", queryValues);

        allAssetTagNames = new String[queryValuesArray.length];

        allAssetTagNames = queryValuesArray;
    } else {

        queryValues = ParamUtil.getString(request, "selectedCategoryIds", queryValues);

        allAssetCategoryIds = new long[queryValuesArray.length];

        for (int i = 0; i < queryValuesArray.length; i++) {
            allAssetCategoryIds[i] = Long.parseLong(queryValuesArray[i]);
        }
    }

    int numbersOfEntriesDisplay = GetterUtil.getInteger(portletPreferences.getValue("numbersOfEntriesDisplay", "8"));

    String orderByColumn = portletPreferences.getValue("orderByColumn", "publishDate");

    String orderByType = portletPreferences.getValue("orderByType", "DESC");

%>