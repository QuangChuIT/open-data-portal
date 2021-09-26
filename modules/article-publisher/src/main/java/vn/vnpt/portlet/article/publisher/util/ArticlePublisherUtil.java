package vn.vnpt.portlet.article.publisher.util;

import com.liferay.asset.category.property.model.AssetCategoryProperty;
import com.liferay.asset.category.property.service.AssetCategoryPropertyLocalServiceUtil;
import com.liferay.asset.kernel.AssetRendererFactoryRegistryUtil;
import com.liferay.asset.kernel.exception.NoSuchCategoryPropertyException;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetTagLocalServiceUtil;
import com.liferay.asset.kernel.service.persistence.AssetEntryQuery;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalArticleDisplay;
import com.liferay.journal.model.JournalArticleResource;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.journal.service.JournalArticleResourceLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Image;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.service.ImageLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import vn.vnpt.portlet.article.publisher.cache.AssetEntryCache;
import vn.vnpt.portlet.article.publisher.cache.MemcachedUtil;

import javax.portlet.*;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ArticlePublisherUtil {

    public static String getCategoryPropertyValue(long categoryId, String propertyKey, String defaultValue) {
        try {
            List<AssetCategoryProperty> propertyList = AssetCategoryPropertyLocalServiceUtil.getCategoryProperties(categoryId);

            if (propertyList.isEmpty()) {
                return defaultValue;
            } else {
                return AssetCategoryPropertyLocalServiceUtil.getCategoryProperty(categoryId, propertyKey).getValue();
            }
        } catch (Exception e) {
            if (e instanceof NoSuchCategoryPropertyException) {
                LOG.error("No such category property exist with propertyKey =" + propertyKey);
            } else {
                LOG.error(e);
            }
        }
        return defaultValue;
    }

    public static String getOlderAssetsURL(HttpServletRequest request) {

        String oldAssetURL = "";

        try {

            ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

            PortletPreferences preferences = PortalUtil.getPreferences(request);

            String portletResource = ParamUtil.getString(request, "portletResource");

            if (Validator.isNotNull(portletResource)) {
                preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
            }

            String queryName = preferences.getValue("queryName", "assetTags");

            String[] queryValues = preferences.getValues("queryValues", new String[0]);

            if (queryName.equals("assetTags")) {

                String tagName = queryValues[0];

                PortletURL portletURL =
                        PortletURLFactoryUtil.create(request, "101", themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);

                portletURL.setParameter("tag", tagName);

                oldAssetURL = portletURL.toString();

            } else {

                long categoryId = GetterUtil.getLong(queryValues[0]);

                long pageLayoutId =
                        GetterUtil.getLong(getCategoryPropertyValue(
                                categoryId, _PAGE_LAYOUT_ID_CATEGORY_PROPERTY_KEY, String.valueOf(themeDisplay.getPlid())));

                PortletURL portletURL =
                        PortletURLFactoryUtil.create(request, "101", pageLayoutId, PortletRequest.RENDER_PHASE);

                portletURL.setParameter("categoryId", String.valueOf(categoryId));

                oldAssetURL = portletURL.toString();
            }

        } catch (Exception e) {
            LOG.error(e);
        }
        return oldAssetURL;
    }

    /**
     * Tao url xem chi tiet noi dung bai viet
     */
    public static String getViewContentURL(HttpServletRequest request, AssetEntryCache assetEntry) {

        String viewContentURL = "";

        if (assetEntry != null) {
            try {

                long entryId = assetEntry.getEntryId();

                long classPK = assetEntry.getClassPK();

                ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

                // layout id cua page hien thi chi tiet tin bai
                long pageLayoutId = themeDisplay.getLayout().getPlid();

                String className = PortalUtil.getClassName(assetEntry.getClassNameId());

                AssetRendererFactory<?> assetRendererFactory =
                        AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(className);

                AssetRenderer<?> assetRenderer = assetRendererFactory.getAssetRenderer(classPK);

                List<AssetCategory> assetCategoryList = AssetCategoryLocalServiceUtil.getEntryCategories(entryId);

                if (!assetCategoryList.isEmpty()) {

                    AssetCategory assetCategory = assetCategoryList.get(0);

                    List<AssetCategoryProperty> categoryPropertyList =
                            AssetCategoryPropertyLocalServiceUtil.getCategoryProperties(assetCategory.getCategoryId());

                    if (categoryPropertyList.size() > 0) {

                        // layoutId la layoutId cua Page duoc chon de hien thi
                        // tin bai theo tung Category
                        // layoutId duoc luu duoi dang property cua Category voi
                        // propertyKey = "link-to-page"
                        // Cac thuoc tinh (property) cua Category duoc luu trong
                        // bang assetcategoryproperty
                        pageLayoutId =
                                Long.parseLong(getCategoryPropertyValue(
                                        assetCategory.getCategoryId(), _PAGE_LAYOUT_ID_CATEGORY_PROPERTY_KEY,
                                        String.valueOf(pageLayoutId)));
                    }
                }
                PortletURL viewFullContentURL =
                        PortletURLFactoryUtil.create(request,
                                "com_liferay_asset_publisher_web_portlet_AssetPublisherPortlet", pageLayoutId,
                                PortletRequest.RENDER_PHASE);
                viewFullContentURL.setWindowState(WindowState.NORMAL);
                viewFullContentURL.setPortletMode(PortletMode.VIEW);
                viewFullContentURL.setParameter("mvcPath", "/asset_publisher/view_content.jsp");
                viewFullContentURL.setParameter("assetEntryId", String.valueOf(entryId));
                viewFullContentURL.setParameter("type", assetRendererFactory.getType());

                if (Validator.isNotNull(assetRenderer.getUrlTitle())) {
                    viewFullContentURL.setParameter("urlTitle", assetRenderer.getUrlTitle());
                }

                viewContentURL = viewFullContentURL.toString();

            } catch (Exception e) {
                LOG.error(e);
            }
        }
        return viewContentURL;
    }

    public static String getSmallImagePath(HttpServletRequest request, long classPK) {
        String smallImagePath = "";
        try {
            String languageId = LanguageUtil.getLanguageId(request);

            ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

            JournalArticleResource articleResource = JournalArticleResourceLocalServiceUtil.getArticleResource(classPK);

            JournalArticleDisplay articleDisplay = JournalArticleLocalServiceUtil.getArticleDisplay(articleResource.getGroupId(),
                    articleResource.getArticleId(), null, null, languageId, themeDisplay);

            if (articleDisplay.isSmallImage()) {
                if (!articleDisplay.getSmallImageURL().equals("")) {
                    smallImagePath = articleDisplay.getSmallImageURL();
                } else {
                    long smallImageId = articleDisplay.getSmallImageId();

                    if (smallImageId <= 0) {
                        String smallImageURL = articleDisplay.getSmallImageURL();
                        if (Validator.isNotNull(smallImageURL)) {
                            smallImagePath = smallImageURL;
                        }
                    } else {
                        Image smallImage = ImageLocalServiceUtil.fetchImage(smallImageId);

                        if (smallImage != null) {
                            String smallImageIdStr = String.valueOf(smallImageId);

                            String stringBuilder = _THUMBNAIL_FILTER_PATH +
                                    "?img_id=" + smallImageIdStr;
                            smallImagePath = stringBuilder;
                        }
                    }
                }
            }
        } catch (Exception e) {
            LOG.error(e);
        }
        return smallImagePath;
    }

    public static List<AssetEntryCache> getListAssetEntryCaches(HttpServletRequest request, int numbersOfDetailEntry) {
        List<AssetEntryCache> assetEntryCaches = new ArrayList<>();
        try {
            long groupId = PortalUtil.getScopeGroupId(request);

            String portletId = PortalUtil.getPortletId(request);

            PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletId);

            String queryName = preferences.getValue("queryName", "assetTags");

            String[] queryValues = preferences.getValues("queryValues", new String[0]);

            String orderByColumn = preferences.getValue("orderByColumn", "publishDate");

            String orderByType = preferences.getValue("orderByType", "DESC");

            int numberOfEntriesDisplay = GetterUtil.getInteger(preferences.getValue("numberOfEntriesDisplay", "4"));

            String queryKey = buildQueryKey(groupId, queryName, queryValues, orderByColumn, orderByType, numberOfEntriesDisplay);

            assetEntryCaches = getCacheData(queryKey);

            if (assetEntryCaches.isEmpty()) {
                Locale locale = PortalUtil.getLocale(request);

                AssetEntryQuery assetEntryQuery = new AssetEntryQuery();

                long[] selectedTagIds = new long[0];

                long[] selectedCategoryIds = new long[0];

                if (queryName.equals(_ASSET_TAG_QUERY_NAME)) {
                    selectedTagIds = AssetTagLocalServiceUtil.getTagIds(groupId, queryValues);
                } else {
                    selectedCategoryIds = new long[queryValues.length];

                    for (int i = 0; i < queryValues.length; i++) {
                        selectedCategoryIds[i] = Long.parseLong(queryValues[i]);
                    }
                }

                assetEntryQuery.setGroupIds(new long[]{groupId});

                assetEntryQuery.setClassName(JournalArticle.class.getName());
                assetEntryQuery.setAnyTagIds(selectedTagIds);
                assetEntryQuery.setAnyCategoryIds(selectedCategoryIds);

                assetEntryQuery.setOrderByCol1(orderByColumn);
                assetEntryQuery.setOrderByType1(orderByType);

                assetEntryQuery.setStart(0);
                assetEntryQuery.setEnd(numberOfEntriesDisplay);

                List<AssetEntry> queryList = AssetEntryLocalServiceUtil.getEntries(assetEntryQuery);

                for (int i = 0; i < queryList.size(); i++) {

                    AssetEntry assetEntry = queryList.get(i);

                    AssetEntryCache entryCache = new AssetEntryCache();

                    entryCache.setEntryId(assetEntry.getEntryId());
                    entryCache.setClassNameId(assetEntry.getClassNameId());
                    entryCache.setClassPK(assetEntry.getClassPK());
                    entryCache.setTitle(assetEntry.getTitle(locale));
                    entryCache.setViewContentURL(getViewContentURL(request, entryCache));
                    entryCache.setPublishDate(assetEntry.getPublishDate());

                    if (i < numbersOfDetailEntry) {
                        entryCache.setSummary(getContentSummary(
                                request, assetEntry.getClassPK(), _DEFAULT_ASSET_SUMMARY_LENGTH));
                        entryCache.setSmallImagePath(getSmallImagePath(request,
                                assetEntry.getClassPK()));
                    }

                    assetEntryCaches.add(entryCache);
                }
                if (!assetEntryCaches.isEmpty()) {

                    if (updateCacheData(queryKey, assetEntryCaches)) {
                        updateSystemQueryKeys(queryKey);
                    }
                }
            }

        } catch (Exception e) {
            LOG.error(e);
        }
        return assetEntryCaches;
    }

    private static void updateSystemQueryKeys(String queryKey) {

        String systemQueryKeys = SystemProperties.get(_SYSTEM_QUERY_KEY);

        if (Validator.isNull(systemQueryKeys)) {
            systemQueryKeys = queryKey;
        } else {
            systemQueryKeys += StringPool.COMMA;
            systemQueryKeys += queryKey;
        }

        SystemProperties.set(_SYSTEM_QUERY_KEY, systemQueryKeys);
    }


    private static boolean updateCacheData(String queryKey, List<AssetEntryCache> assetList) {
        return MemcachedUtil.getInstance().create(queryKey, 60400, assetList);
    }

    private static ArrayList<AssetEntryCache> getCacheData(String queryKey) {

        Object cacheData = MemcachedUtil.getInstance().read(queryKey);

        if (cacheData != null) {
            return (ArrayList<AssetEntryCache>) cacheData;
        } else {
            return new ArrayList<>();
        }
    }

    private static boolean existQueryKey(String queryKey) {

        if (Validator.isNull(SystemProperties.get(_SYSTEM_QUERY_KEY))) {
            return false;
        } else {
            return SystemProperties.get(_SYSTEM_QUERY_KEY).contains(queryKey);
        }
    }

    public static String getContentSummary(HttpServletRequest request, long classPK, int abstractLength) {

        String contentSummary = "";

        try {

            String languageId = LanguageUtil.getLanguageId(request);

            ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

            JournalArticleResource articleResource = JournalArticleResourceLocalServiceUtil.getArticleResource(classPK);

            JournalArticleDisplay articleDisplay =
                    JournalArticleLocalServiceUtil.getArticleDisplay(
                            articleResource.getGroupId(), articleResource.getArticleId(), null, null, languageId, themeDisplay);

            contentSummary = articleDisplay.getDescription();

            if (contentSummary.equals(StringPool.BLANK) || (contentSummary.length() <= 10)) {

                // Doi voi tin bai khong co mo ta ngan (Abstract) thi se cat 100
                // ky tu dau tien cua noi dung tin bai lam noi dung mo ta ngan
                contentSummary = StringUtil.shorten(articleDisplay.getContent(), 100);
            }

            if ((abstractLength > 0) && (abstractLength < contentSummary.length())) {

                contentSummary = StringUtil.shorten(contentSummary, abstractLength);
            }

        } catch (Exception e) {
            LOG.error(e);
        }

        return contentSummary;
    }


    private static String buildQueryKey(
            long groupId, String queryName, String[] queryValues, String orderByColumn, String orderByType,
            int numbersOfEntriesDisplay)
            throws PortalException, SystemException {

        long[] queryIds = new long[queryValues.length];

        // Get asset entry list by Asset Tags
        if (queryName.equals(_ASSET_TAG_QUERY_NAME)) {

            queryIds = AssetTagLocalServiceUtil.getTagIds(groupId, queryValues);

        } else {
            for (int i = 0; i < queryValues.length; i++) {
                queryIds[i] = Long.parseLong(queryValues[i]);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < queryIds.length; i++) {

            stringBuilder.append(queryIds[i]);

            if (i < (queryIds.length - 1)) {
                stringBuilder.append(StringPool.DASH);
            }
        }

        stringBuilder.append(StringPool.UNDERLINE);

        stringBuilder.append(orderByColumn.toLowerCase());
        stringBuilder.append(StringPool.DASH);

        stringBuilder.append(orderByType.toLowerCase());
        stringBuilder.append(StringPool.DASH);

        stringBuilder.append(numbersOfEntriesDisplay);

        return stringBuilder.toString();
    }

    private static final Log LOG = LogFactoryUtil.getLog(ArticlePublisherUtil.class);

    private static final int _DEFAULT_ASSET_SUMMARY_LENGTH = 300;

    private static final String _THUMBNAIL_FILTER_PATH = "/image/journal/article";

    private static final String _THUMBNAIL_DEFAULT_SIZE = "400x300";

    private static final String _SYSTEM_QUERY_KEY = "vn.vnpt.portal.memcached.key";

    public static final String _PAGE_LAYOUT_ID_CATEGORY_PROPERTY_KEY = "link-to-page";

    private static final String _ASSET_TAG_QUERY_NAME = "assetTags";
}
