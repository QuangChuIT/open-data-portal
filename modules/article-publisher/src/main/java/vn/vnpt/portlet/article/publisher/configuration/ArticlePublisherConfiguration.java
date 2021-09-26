package vn.vnpt.portlet.article.publisher.configuration;

import aQute.bnd.annotation.metatype.Meta;
import vn.vnpt.portlet.article.publisher.constants.ArticlePublisherPortletKeys;

@Meta.OCD(id = ArticlePublisherPortletKeys.CONFIGURATION_ID)
public interface ArticlePublisherConfiguration {
    @Meta.AD(deflt = "style-1",
            name = "displayStyle",
            optionLabels = {"%style-1", "%style-2", "%style-3", "%style-4", "%style-5"},
            optionValues = {"style-1", "style-2", "style-3","style-4","style-5"},
            required = false
    )
    public String displayStyle();

    @Meta.AD(required = false)
    public String styleTitle();

    @Meta.AD(required = false)
    public boolean showPublishDate();

    @Meta.AD(required = false)
    public boolean showRssIcon();

    @Meta.AD(required = false)
    public boolean showViewMoreAssetURL();

    @Meta.AD(required = false)
    public boolean queryContains();

    @Meta.AD(required = false)
    public boolean queryAndOperator();

    @Meta.AD(required = false)
    public String queryName();

    @Meta.AD(required = false)
    public String[] queryValues();

    @Meta.AD(required = false)
    public int numberOfEntriesDisplay();

    @Meta.AD(required = false)
    public String orderColumn();

    @Meta.AD(required = false)
    public String orderType();

}
