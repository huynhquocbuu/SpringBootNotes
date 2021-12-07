package buuhq.java.learning.springbootnotes.controller;

import buuhq.java.learning.springbootnotes.model.entity.App;
import buuhq.java.learning.springbootnotes.service.intf.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("apps")
public class AppController {
    private AppService service;
    @Autowired
    public AppController(AppService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<App>> getApps(){
        System.out.println("---get apps---");
        List<App> apps = service.getApps();

        return new ResponseEntity<>(apps, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<App> createApp(@RequestBody App app) {
        System.out.println("---post app---");
        App newApp = service.createApp(app);
        return new ResponseEntity<>(newApp, HttpStatus.CREATED);
    }
}
