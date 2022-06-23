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
public class BonusTransactionDAO {

    SessionFactory factory = new Configuration().configure("database-connection.cfg.xml")
            .addAnnotatedClass(BonusDiscount.class)
            .addAnnotatedClass(BonusPatient.class)
            .addAnnotatedClass(BonusTransaction.class)
            .buildSessionFactory();

    Session session = null;


    List<BonusTransaction> bonusTransactions;

    public List<BonusTransaction> getBonusTransactions(){
        session = factory.getCurrentSession();
        session.getTransaction().begin();
        bonusTransactions = session.createQuery("SELECT t FROM BonusTransaction t").getResultList();
        session.getTransaction().commit();
        return bonusTransactions;
    }

    public void add(BonusTransaction transaction){
        session = factory.getCurrentSession();
        session.getTransaction().begin();
        session.save(transaction);
        session.getTransaction().commit();
    }
}
