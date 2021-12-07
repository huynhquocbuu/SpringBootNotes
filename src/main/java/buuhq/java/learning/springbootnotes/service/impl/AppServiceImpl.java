package buuhq.java.learning.springbootnotes.service.impl;

import buuhq.java.learning.springbootnotes.model.entity.App;
import buuhq.java.learning.springbootnotes.repository.intf.AppRepository;
import buuhq.java.learning.springbootnotes.service.intf.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceImpl implements AppService {
    private AppRepository repository;
    @Autowired
    public AppServiceImpl(AppRepository repository){
        this.repository = repository;
    }

    @Override
    public List<App> getApps() {
        return repository.getApps();
    }

    @Override
    public App createApp(App app) {
        return repository.createApp(app);
    }
}
