package buuhq.java.learning.springbootnotes.repository.impl;

import buuhq.java.learning.springbootnotes.model.entity.App;
import buuhq.java.learning.springbootnotes.repository.intf.AppRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AppRepositoryImpl implements AppRepository {
    private SessionFactory sessionFactory;
    public AppRepositoryImpl(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public List<App> getApps() {
        /*
        List<App> apps = new ArrayList<App>();
        apps.add(new App("app001","xù xí đám","xàm xí đú"));
        apps.add(new App("app002","xù xí đám 2","xàm xí đú 2"));
        apps.add(new App("app003","xù xí đám 3","xàm xí đú 3"));
         */
        Session session = sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        //CriteriaQuery<App> cq = cb.createQuery(App.class);
        CriteriaQuery<App> cq = cb.createQuery(App.class);
        Root<App> rootEntry = cq.from(App.class);
        CriteriaQuery<App> all = cq.select(rootEntry);

        TypedQuery<App> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public App createApp(App app) {
        Session session = sessionFactory.openSession();

        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();

            session.saveOrUpdate(app);
            transaction.commit();
        }catch (Exception ex){
            transaction.rollback();
        }finally {
            session.close();
        }
        return app;
    }
}
