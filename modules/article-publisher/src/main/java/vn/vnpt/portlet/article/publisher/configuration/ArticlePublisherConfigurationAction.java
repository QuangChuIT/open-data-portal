package vn.vnpt.portlet.article.publisher.configuration;

import aQute.bnd.annotation.metatype.Configurable;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;
import vn.vnpt.portlet.article.publisher.constants.ArticlePublisherPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component(
        configurationPid = ArticlePublisherPortletKeys.CONFIGURATION_ID,
        configurationPolicy = ConfigurationPolicy.OPTIONAL,
        immediate = true,
        property = {
                "javax.portlet.name=" + ArticlePublisherPortletKeys.ARTICLE_PUBLISHER
        },
        service = ConfigurationAction.class
)
public class ArticlePublisherConfigurationAction extends DefaultConfigurationAction {
    @Override
    public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
                        HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setAttribute(ArticlePublisherConfigurationAction.class.getName(),
                _articlePublisherConfiguration);

        super.include(portletConfig, httpServletRequest, httpServletResponse);
    }

    @Override
    public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        String displayStyle = ParamUtil.getString(actionRequest, "displayStyle");

        String styleTitle = ParamUtil.getString(actionRequest, "styleTitle");

        boolean showPublishDate = ParamUtil.getBoolean(actionRequest, "showPublishDate", false);

        boolean showRSSIcon = ParamUtil.getBoolean(actionRequest, "showRSSIcon", false);

        boolean showViewMoreAssetURL = ParamUtil.getBoolean(actionRequest, "showViewMoreAssetURL", false);

        boolean queryContains = ParamUtil.getBoolean(actionRequest, "queryContains", true);

        boolean queryAndOperator = ParamUtil.getBoolean(actionRequest, "queryAndOperator", false);

        String queryName = ParamUtil.getString(actionRequest, "queryName", "assetTags");

        String[] queryValues = ParamUtil.getStringValues(actionRequest, "selectedCategoryIds_40103");

        if (queryName.equals("assetTags")) { //Truong hop loc tin theo Tag
            queryValues = ParamUtil.getStringValues(actionRequest, "selectedTagsNames");
        }

        int numbersOfEntriesDisplay = ParamUtil.getInteger(actionRequest, "numbersOfEntriesDisplay", 6);

        String orderByColumn = ParamUtil.getString(actionRequest, "orderByColumn", "publishDate");
        String orderByType = ParamUtil.getString(actionRequest, "orderByType", "DESC");
        setPreference(actionRequest, "displayStyle", displayStyle);
        setPreference(actionRequest, "styleTitle", styleTitle);
        setPreference(actionRequest, "showPublishDate", String.valueOf(showPublishDate));
        setPreference(actionRequest, "showRSSIcon", String.valueOf(showRSSIcon));
        setPreference(actionRequest, "showViewMoreAssetURL", String.valueOf(showViewMoreAssetURL));
        setPreference(actionRequest, "queryContains", String.valueOf(queryContains));
        setPreference(actionRequest, "queryAndOperator", String.valueOf(queryAndOperator));
        setPreference(actionRequest, "queryName", queryName);
        setPreference(actionRequest, "queryValues", queryValues);
        setPreference(actionRequest, "numbersOfEntriesDisplay", String.valueOf(numbersOfEntriesDisplay));
        setPreference(actionRequest, "orderByColumn", orderByColumn);
        setPreference(actionRequest, "orderByType", orderByType);
        _log.info("Save config for article publisher configuration !!!!!");
        super.processAction(portletConfig, actionRequest, actionResponse);
    }

    /**
     * (1)If a method is annoted with @Activate then the method will be called at the time of activation of the component
     * so that we can perform initialization task
     * <p>
     * (2) This class is annoted with @Component where we have used configurationPid with id com.proliferay.configuration.DemoConfiguration
     * So if we modify any configuration then this method will be called.
     */
    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
        _articlePublisherConfiguration = Configurable.createConfigurable(ArticlePublisherConfiguration.class, properties);
    }

    private volatile ArticlePublisherConfiguration _articlePublisherConfiguration;
    private final static Log _log = LogFactoryUtil.getLog(ArticlePublisherConfigurationAction.class);

}
