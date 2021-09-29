package vn.vnpt.cms.api.internal.context;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        service = MyService.class
)
public class MyService {
    @Activate
    void activate() throws Exception {

        System.out.println("Activating " + this.getDescription());
    }

    public String getDescription() {

        return this.getClass().getSimpleName();
    }
}
