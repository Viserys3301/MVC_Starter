package org.example.DAO;

import org.example.entities.psPatinv;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class psPatinvDAO {


    SessionFactory factory = new Configuration().configure("database-connection.cfg.xml")
            .addAnnotatedClass(psPatinv.class)
            .buildSessionFactory();

    Session session = null;

    List<psPatinv> psPatinvList;

    public  List<psPatinv> get(Long id){
        session = factory.getCurrentSession();
        session.getTransaction().begin();
        psPatinvList = session.createQuery("SELECT p FROM psPatinv p WHERE p.PK_TRXNO=:id").setParameter("id",id).getResultList();
        session.getTransaction().commit();
        session.close();

        return psPatinvList;
    }

    public void update(BigDecimal price1,BigDecimal price2,BigDecimal price3,Long id){
        session = factory.getCurrentSession();
        session.getTransaction().begin();
        session.createQuery("UPDATE psPatinv p SET p.renamount=:price1 , p.amount=:price2,p.netamount=:price3 WHERE p.PK_TRXNO =: id")
                .setParameter("price1",price1)
                .setParameter("price2",price2)
                .setParameter("price3",price3)
                .setParameter("id",id).executeUpdate();

        session.getTransaction().commit();
        session.close();

    }

    @Transactional
    public String getNameById(Integer id,Integer psPatReg){
        session = factory.getCurrentSession();
        session.getTransaction().begin();
        System.out.println(id);
        psPatinv patient = (psPatinv) session.createQuery("SELECT p FROM psPatinv p WHERE p.FK_emdPatients=:id AND p.FK_psPatRegisters=:psPatReg")
                                                        .setParameter("id",id)
                                                        .setParameter("psPatReg",psPatReg)
                                                        .getSingleResult();
        session.getTransaction().commit();
        session.close();
        return patient.getPayername();
    }
}
