package org.example.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import org.hibernate.boot.jaxb.hbm.internal.CacheAccessTypeConverter;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("database-connection.cfg.xml")
                .addAnnotatedClass(BonusPatient.class)
                .addAnnotatedClass(BonusDiscount.class)
                .buildSessionFactory();

        Session session = null;
        try {




            session = factory.getCurrentSession();
            session.getTransaction().begin();


            BonusDiscount bonusDiscount = session.get(BonusDiscount.class,1L);
            BonusPatient bonusPatient = new BonusPatient();
            bonusPatient.setSum(new BigDecimal(600000));
            bonusPatient.setIsActive(true);
            bonusPatient.setName("Андрей");
            bonusPatient.setBizboxId(228L);
            bonusPatient.setBonusDiscount(bonusDiscount);


            session.save(bonusPatient);
            session.getTransaction().commit();





        }finally {
            session.close();
            factory.close();
        }
    }
}
