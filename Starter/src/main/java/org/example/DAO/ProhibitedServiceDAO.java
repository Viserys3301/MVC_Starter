package org.example.DAO;

import org.example.entities.BonusDiscount;
import org.example.entities.BonusPatient;
import org.example.entities.BonusTransaction;
import org.example.entities.ProhibitedService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;


@Repository
public class ProhibitedServiceDAO {


    SessionFactory factory = new Configuration().configure("database-connection.cfg.xml")
            .addAnnotatedClass(ProhibitedService.class)
            .buildSessionFactory();

    Session session = null;

    public Boolean getByServiceId(Long id){
        session = factory.getCurrentSession();
        session.getTransaction().begin();
        ProhibitedService service = session.get(ProhibitedService.class,id);
        session.getTransaction().commit();
        if (service==null){
            return true;
        }
        return false;
    }

}
