package org.example.DAO;

import org.example.entities.BonusDiscount;
import org.example.entities.BonusPatient;
import org.example.entities.BonusTransaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BonusDiscountDAO {

    SessionFactory factory = new Configuration().configure("database-connection.cfg.xml")
            .addAnnotatedClass(BonusDiscount.class)
            .addAnnotatedClass(BonusPatient.class)
            .addAnnotatedClass(BonusTransaction.class)
            .buildSessionFactory();

    Session session = null;

    List<BonusDiscount> bonusDiscounts;

    public List<BonusDiscount> findAll(){
        session = factory.getCurrentSession();
        session.getTransaction().begin();
        bonusDiscounts = session.createQuery("SELECT d FROM BonusDiscount d").getResultList();
        session.getTransaction().commit();
        return bonusDiscounts;
    }

    public BonusDiscount getById(Long id){
        return new BonusDiscount();
    }
}
