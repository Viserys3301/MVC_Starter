package org.example.entities;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("database-connection.cfg.xml")
                .addAnnotatedClass(ProhibitedService.class)
                .buildSessionFactory();

        Session session = null;


        session = factory.getCurrentSession();
        session.getTransaction().begin();


        ProhibitedService service = new ProhibitedService();
        service.setServiceId(30101L);
        session.save(service);

        ProhibitedService service2 = new ProhibitedService();
        service.setServiceId(30102L);
        session.save(service2);

        ProhibitedService service3 = new ProhibitedService();
        service.setServiceId(30103L);
        session.save(service3);

        ProhibitedService service4 = new ProhibitedService();
        service.setServiceId(72734L);
        session.save(service4);




        session.getTransaction().commit();

    }
}
