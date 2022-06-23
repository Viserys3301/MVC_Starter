package org.example.DAO;

import org.example.entities.psPatinv;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class psPatinvDAO {


    SessionFactory factory = new Configuration().configure("database-connection.cfg.xml")
            .addAnnotatedClass(psPatinv.class)
            .buildSessionFactory();

    Session session = null;

    List<psPatinvDAO> ps_Patitems;


    public void update(BigDecimal price1,BigDecimal price2,Long id){
        session = factory.getCurrentSession();
        session.getTransaction().begin();
        session.createQuery("UPDATE psPatinv p SET p.renamount=:price1 , p.amount=:price2 WHERE p.FK_psPatRegisters =: id")
                .setParameter("price1",price1).setParameter("price2",price2).setParameter("id",id).executeUpdate();
        session.getTransaction().commit();
    }
}
