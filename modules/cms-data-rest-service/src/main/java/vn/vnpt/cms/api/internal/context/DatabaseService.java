package vn.vnpt.cms.api.internal.context;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        service = DatabaseService.class
)
public class DatabaseService {

    @Activate
    void activate() throws Exception {
        _log.info(getDescription());
    }

    public String getDescription() {

        return this.getClass().getSimpleName();
    }

    private final static Log _log = LogFactoryUtil.getLog(DatabaseService.class);
}
