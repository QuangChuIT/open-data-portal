package vn.vnpt.portlet.navigation.configuration;

import aQute.bnd.annotation.metatype.Meta;
import vn.vnpt.portlet.navigation.constants.NavigationPortletKeys;

@Meta.OCD(id = NavigationPortletKeys.CONFIGURATION_ID)
public interface NavigationConfiguration {
    @Meta.AD(required = false)
    public String city();

    @Meta.AD(required = false)
    public String temperatureUnit();
}
