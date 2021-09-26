package vn.vnpt.portlet.article.publisher.portlet;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import vn.vnpt.portlet.article.publisher.configuration.ArticlePublisherConfiguration;
import vn.vnpt.portlet.article.publisher.constants.ArticlePublisherPortletKeys;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author QuangChu
 */
@Component(
        configurationPid = ArticlePublisherPortletKeys.CONFIGURATION_ID,
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=ArticlePublisher",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + ArticlePublisherPortletKeys.ARTICLE_PUBLISHER,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class ArticlePublisherPortlet extends MVCPortlet {

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        renderRequest.setAttribute(ArticlePublisherConfiguration.class.getName(), _articlePublisherConfiguration);
        super.doView(renderRequest, renderResponse);
    }

    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
        _log.info("#####Calling activate() method######");
        _articlePublisherConfiguration = ConfigurableUtil.createConfigurable(
                ArticlePublisherConfiguration.class, properties);
    }

    private volatile ArticlePublisherConfiguration _articlePublisherConfiguration;
    private final static Log _log = LogFactoryUtil.getLog(ArticlePublisherPortlet.class);
}