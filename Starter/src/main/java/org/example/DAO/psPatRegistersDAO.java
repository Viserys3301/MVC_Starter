package org.example.DAO;

import org.example.entities.psPatRegisters;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;


@Repository
public class psPatRegistersDAO {

    SessionFactory factory = new Configuration().configure("database-connection.cfg.xml")
            .addAnnotatedClass(psPatRegisters.class)
            .buildSessionFactory();

    Session session = null;

    public Boolean getById(Integer id){
        session = factory.getCurrentSession();
        session.getTransaction().begin();
        psPatRegisters ps = session.get(psPatRegisters.class,id);
        session.getTransaction().commit();

        if(ps==null){
            return true;
        }
        return false;
    }
}
