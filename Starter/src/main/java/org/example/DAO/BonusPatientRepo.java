package org.example.DAO;



import org.example.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;


public class BonusPatientRepo {

    SessionFactory factory = new Configuration().configure("database-connection.cfg.xml")
            .addAnnotatedClass(BonusPatient.class)
            .buildSessionFactory();

    Session session = null;

    List<BonusPatient> bonusPatients;

    public List<BonusPatient> findAll(){
        session = factory.getCurrentSession();
        session.getTransaction().begin();
        bonusPatients = session.createQuery("SELECT p FROM BonusPatient p").getResultList();
        session.getTransaction().commit();
        return bonusPatients;
    }

}
