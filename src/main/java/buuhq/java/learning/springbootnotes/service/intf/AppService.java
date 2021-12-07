package buuhq.java.learning.springbootnotes.service.intf;

import buuhq.java.learning.springbootnotes.model.entity.App;

import java.util.List;

public interface AppService {
    List<App> getApps();
    App createApp(App app);
}
