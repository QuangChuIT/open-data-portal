package vn.vnpt.portlet.navigation.util;

import com.liferay.asset.category.property.model.AssetCategoryProperty;
import com.liferay.asset.category.property.service.AssetCategoryPropertyLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

public class CategoryPropertyUtil {
    public static String getCategoryPropertyValue(long categoryId, String propertyKey, String defaultPropertyValue) {

        try {

            List<AssetCategoryProperty> categoryPropertyList = AssetCategoryPropertyLocalServiceUtil.getCategoryProperties(categoryId);

            if (categoryPropertyList.isEmpty()) {

                return defaultPropertyValue;

            } else {

                AssetCategoryProperty categoryProperty = AssetCategoryPropertyLocalServiceUtil.getCategoryProperty(categoryId, propertyKey);

                if (categoryProperty != null) {

                    return categoryProperty.getValue();
                } else {
                    return defaultPropertyValue;
                }
            }
        } catch (Exception e) {
            _log.error(e);
            return defaultPropertyValue;
        }
    }

    public static void updateCategoryProperty(long userId, long categoryId, String propertyKey, String propertyValue) {

        if (userId > 0 && categoryId > 0 && Validator.isNotNull(propertyKey) && Validator.isNotNull(propertyValue)) {

            try {

                String oldPropertyValue = getCategoryPropertyValue(categoryId, propertyKey, StringPool.BLANK);

                // Kiem tra xem da ton tai thuoc tinh tuong ung voi propertyKey hay chua?
                if (oldPropertyValue.equals(StringPool.BLANK)) {

                    // Them moi thuoc tinh
                    AssetCategoryPropertyLocalServiceUtil.addCategoryProperty(userId, categoryId, propertyKey, propertyValue);
                } else {

                    // Update gia tri thuoc tinh
                    AssetCategoryProperty categoryProperty = AssetCategoryPropertyLocalServiceUtil.getCategoryProperty(categoryId, propertyKey);

                    categoryProperty.setValue(propertyValue);

                    AssetCategoryPropertyLocalServiceUtil.updateAssetCategoryProperty(categoryProperty);
                }

            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    private static final Log _log = LogFactoryUtil.getLog(CategoryPropertyUtil.class);
}
