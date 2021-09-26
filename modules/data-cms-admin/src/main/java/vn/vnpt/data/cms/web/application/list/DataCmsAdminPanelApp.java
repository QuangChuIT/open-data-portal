package vn.vnpt.data.cms.web.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import vn.vnpt.data.cms.web.constants.DataCmsAdminPortletKeys;

@Component(
        immediate = true,
        property = {
                "panel.app.order:Integer=0",
                "panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT
        },

        service = PanelApp.class)
public class DataCmsAdminPanelApp extends BasePanelApp {
    @Override
    public String getPortletId() {
        return DataCmsAdminPortletKeys.PORTLET_ID;
    }

    @Override
    @Reference(target = "(javax.portlet.name=" + DataCmsAdminPortletKeys.PORTLET_ID + ")", unbind = "-")
    public void setPortlet(Portlet portlet) {
        super.setPortlet(portlet);
    }
}
