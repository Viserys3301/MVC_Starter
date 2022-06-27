package org.example.DAO;

import org.example.entities.psPatLedgers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@Repository
public class psPatLedgersDAO {

    SessionFactory factory = new Configuration().configure("database-connection.cfg.xml")
            .addAnnotatedClass(psPatLedgers.class)
            .buildSessionFactory();

    Session session = null;

    List<psPatLedgers> payments;

    public List<psPatLedgers> findPayments(Timestamp timestampStart, Timestamp timestampEnd, SimpleDateFormat simpleDateFormat){
        session = factory.getCurrentSession();
        session.getTransaction().begin();

        System.out.println("SELECT p FROM psPatLedgers p where p.docdate between '"
                + simpleDateFormat.format(timestampStart) + "' and '"
                + simpleDateFormat.format(timestampEnd)  + "' and  p.billtrancode =PAYMENT");

        payments = session.createQuery("SELECT p FROM psPatLedgers p where p.docdate between '"
                        + simpleDateFormat.format(timestampStart) + "' and '"
                        + simpleDateFormat.format(timestampEnd)  + "' and  p.billtrancode =:pay")
                .setParameter("pay","PAYMENT").getResultList();




        session.getTransaction().commit();
        return payments;
    }

    public List<psPatLedgers> findPaymentsHC(Timestamp timestampStart, Timestamp timestampEnd, SimpleDateFormat simpleDateFormat){
        session = factory.getCurrentSession();
        session.getTransaction().begin();

        System.out.println("SELECT p FROM psPatLedgers p where p.docdate between '"
                + simpleDateFormat.format(timestampStart) + "' and '"
                + simpleDateFormat.format(timestampEnd)  + "' and  p.billtrancode =HC");

        payments = session.createQuery("SELECT p FROM psPatLedgers p where p.docdate between '"
                        + simpleDateFormat.format(timestampStart) + "' and '"
                        + simpleDateFormat.format(timestampEnd)  + "' and  p.billtrancode =:pay")
                .setParameter("pay","HC").getResultList();




        session.getTransaction().commit();
        return payments;
    }


    public void update(BigDecimal price,Long id){
        session = factory.getCurrentSession();
        session.getTransaction().begin();
        session.createQuery("UPDATE psPatLedgers p SET p.debit=:price WHERE p.PK_psPatledgers=:id")
                .setParameter("price",price).setParameter("id",id).executeUpdate();
        session.getTransaction().commit();
    }
}
