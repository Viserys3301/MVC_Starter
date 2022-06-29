//package org.example.DAO;
//
//import org.example.entities.BonusDiscount;
//import org.example.entities.BonusPatient;
//import org.example.entities.BonusTransaction;
//import org.example.entities.psPatRegisters;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class psPatRegistersDAO {
//
//    SessionFactory factory = new Configuration().configure("database-connection.cfg.xml")
//            .addAnnotatedClass(psPatRegistersDAO.class)
//            .buildSessionFactory();
//
//    Session session = null;
//
//
//
//    public String getNameById(Long id){
//        session = factory.getCurrentSession();
//        session.getTransaction().begin();
//        psPatRegisters patient = session.get(psPatRegisters.class,id);
//        session.getTransaction().commit();
//        return patient.getF
//    }
//}
