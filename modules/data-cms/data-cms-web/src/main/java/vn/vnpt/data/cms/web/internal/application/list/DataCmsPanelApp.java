package vn.vnpt.data.cms.web.internal.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import vn.vnpt.data.cms.contansts.DataCmsPortletKeys;

@Component(
        immediate = true,
        property = {
                "panel.app.order:Integer=300",
                "panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT
        },
        service = PanelApp.class
)
public class DataCmsPanelApp extends BasePanelApp {
    @Override
    public String getPortletId() {
        return DataCmsPortletKeys.DATA_CMS_ADMIN;
    }

    @Override
    @Reference(
            target = "(javax.portlet.name=" + DataCmsPortletKeys.DATA_CMS_ADMIN + ")",
            unbind = "-"
    )
    public void setPortlet(Portlet portlet) {
        super.setPortlet(portlet);
    }
}
