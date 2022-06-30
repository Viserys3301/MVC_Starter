package org.example.DAO;

import org.example.entities.BonusDiscount;
import org.example.entities.BonusPatient;
import org.example.entities.psPatitem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class psPatitemDAO {

    SessionFactory factory = new Configuration().configure("database-connection.cfg.xml")
            .addAnnotatedClass(psPatitem.class)
            .buildSessionFactory();

    Session session = null;

    List<psPatitem> ps_Patitems;

    public List<psPatitem> getPsPatitems(Long id ){
        session = factory.getCurrentSession();
        session.getTransaction().begin();
        System.out.println(ps_Patitems + "============3============3=============3==============");
        ps_Patitems = session.createQuery("SELECT p FROM psPatitem p WHERE p.FK_TRXNO =:id").setParameter("id",id).getResultList();
        System.out.println(ps_Patitems + "============4============4=============4==============");
        session.getTransaction().commit();
        return ps_Patitems;
    }

    public void update(BigDecimal price, Integer id){
        session = factory.getCurrentSession();
        session.getTransaction().begin();
        session.createQuery("UPDATE psPatitem p set p.renprice =: id WHERE p.PK_psPatitem = : tranId")
                .setParameter("id",price)
                        .setParameter("tranId",id).executeUpdate();

        session.getTransaction().commit();
    }
}
