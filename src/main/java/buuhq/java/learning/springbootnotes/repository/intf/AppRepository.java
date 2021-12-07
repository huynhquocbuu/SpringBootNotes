package buuhq.java.learning.springbootnotes.repository.intf;

import buuhq.java.learning.springbootnotes.model.entity.App;

import java.util.List;

public interface AppRepository {
    List<App> getApps();
    App createApp(App app);
}
