package vn.vnpt.portlet.navigation.util;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetTag;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetTagLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.image.ImageBag;
import com.liferay.portal.kernel.image.ImageToolUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ImageLocalServiceUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.*;

import javax.portlet.ActionRequest;
import java.awt.image.RenderedImage;
import java.io.InputStream;

public class NavigationUtil {

    public static final String DISPLAY_NAME_PROPERTY_KEY = "display-name";

    public static final String ICON_IMAGE_ID_PROPERTY_KEY = "icon-image-id";

    public static final String CUSTOM_URL_PROPERTY_KEY = "custom-url";

    public static final String DEFAULT_TAG_ICON_IMAGE_FOLDER_NAME = "tag-icon-images";

    public static final String DEFAULT_CATEGORY_ICON_IMAGE_FOLDER_NAME = "category-icon-images";

    public static final String CLASS_NAME = "className";

    public static final String CLASS_ID = "classId";

    public static final String DISPLAY_NAME_PARAM = "displayName";

    public static final String ICON_IMAGE_FILE_PARAM = "iconImageFile";

    public static final String CUSTOM_URL_PARAM = "customURL";

    public static void updateDisplayName(ActionRequest actionRequest) {

        try {

            String assetTagClassName = AssetTag.class.getName();

            String className = ParamUtil.getString(actionRequest, CLASS_NAME, assetTagClassName);

            long classId = ParamUtil.getLong(actionRequest, CLASS_ID, 0L);

            long userId = PortalUtil.getUserId(actionRequest);

            if (classId > 0) {
                String displayName = ParamUtil.getString(actionRequest, DISPLAY_NAME_PARAM, StringPool.BLANK);
                CategoryPropertyUtil.updateCategoryProperty(userId, classId, DISPLAY_NAME_PROPERTY_KEY, displayName);
            }

        } catch (Exception e) {
            _log.error(e);
        }
    }

    public static void updateCustomURL(ActionRequest actionRequest) {

        try {

            long userId = PortalUtil.getUserId(actionRequest);

            String assetTagClassName = AssetTag.class.getName();

            String className = ParamUtil.getString(actionRequest, CLASS_NAME, assetTagClassName);

            long classId = ParamUtil.getLong(actionRequest, CLASS_ID, 0L);

            if (classId > 0) {

                String customURL = ParamUtil.getString(actionRequest, CUSTOM_URL_PARAM, StringPool.BLANK);

                CategoryPropertyUtil.updateCategoryProperty(userId, classId, CUSTOM_URL_PROPERTY_KEY, customURL);
            }

        } catch (Exception e) {
            _log.error(e);
        }
    }

    public static void updateIconImage(ActionRequest actionRequest) {

        try {

            UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);

            InputStream iconInputStream = uploadRequest.getFileAsStream(ICON_IMAGE_FILE_PARAM);

            if (iconInputStream != null) {

                byte[] iconImageBytes = FileUtil.getBytes(iconInputStream);

                long groupId = PortalUtil.getScopeGroupId(actionRequest);

                long userId = PortalUtil.getUserId(actionRequest);

                String assetTagClassName = AssetTag.class.getName();

                String assetCategoryClassName = AssetCategory.class.getName();

                String className = ParamUtil.getString(actionRequest, CLASS_NAME, assetTagClassName);

                long classId = ParamUtil.getLong(actionRequest, CLASS_ID, 0L);


                long categoryIconImageId = GetterUtil.getLong(CategoryPropertyUtil.getCategoryPropertyValue(classId,
                        ICON_IMAGE_ID_PROPERTY_KEY, String.valueOf(CounterLocalServiceUtil.increment())));

                uploadIconImage(groupId, categoryIconImageId, iconImageBytes);

                CategoryPropertyUtil.updateCategoryProperty(userId, classId, ICON_IMAGE_ID_PROPERTY_KEY, String.valueOf(categoryIconImageId));

            }

        } catch (Exception e) {
            _log.error(e);
        }
    }

    public static long[] validateSelectedEntryIds(long[] selectedEntryIds, String selectedName) {

        for (long selectedEntryId : selectedEntryIds) {

            if (selectedName.equals("assetTags")) {

                if (!validateTag(selectedEntryId)) {

                    selectedEntryIds = ArrayUtil.remove(selectedEntryIds, selectedEntryId);
                }
            } else {

                if (!validateCategory(selectedEntryId)) {
                    selectedEntryIds = ArrayUtil.remove(selectedEntryIds, selectedEntryId);
                }
            }
        }

        return selectedEntryIds;
    }

    private static boolean validateTag(long selectedTagId) {
        try {

            AssetTag assetTag = AssetTagLocalServiceUtil.getAssetTag(selectedTagId);

            return assetTag != null;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean validateCategory(long selectedCategoryId) {
        try {

            AssetCategory assetCategory = AssetCategoryLocalServiceUtil.getAssetCategory(selectedCategoryId);

            return assetCategory != null;
        } catch (Exception e) {
            return false;
        }
    }

    private static void uploadIconImage(long groupId, long iconImageId, byte[] bytes) throws Exception {

        long userImageMaxSize = PrefsPropsUtil.getLong(PropsKeys.DL_FILE_INDEXING_MAX_SIZE);

        if ((userImageMaxSize > 0) &&
                ((bytes == null) || (bytes.length > userImageMaxSize))) {

            throw new Exception();
        }

        ImageBag imageBag = ImageToolUtil.read(bytes);

        RenderedImage renderedImage = imageBag.getRenderedImage();

        if (renderedImage == null) {
            throw new Exception();
        }

        int USERS_IMAGE_MAX_HEIGHT = GetterUtil.getInteger(PropsUtil.get(PropsKeys.DL_FILE_ENTRY_THUMBNAIL_MAX_HEIGHT));

        int USERS_IMAGE_MAX_WIDTH = GetterUtil.getInteger(PropsUtil.get(PropsKeys.DL_FILE_ENTRY_THUMBNAIL_MAX_WIDTH));

        renderedImage = ImageToolUtil.scale(renderedImage, USERS_IMAGE_MAX_HEIGHT, USERS_IMAGE_MAX_WIDTH);

        String contentType = imageBag.getType();

        byte[] iconImageBytes = ImageToolUtil.getBytes(renderedImage, contentType);

        ImageLocalServiceUtil.updateImage(iconImageId, iconImageBytes);
    }

    private final static Log _log = LogFactoryUtil.getLog(NavigationUtil.class);
}
