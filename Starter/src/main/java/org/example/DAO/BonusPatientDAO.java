package org.example.DAO;

import org.example.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class BonusPatientDAO {
//
//    SessionFactory factory = new Configuration().configure("database-connection.cfg.xml")
//            .addAnnotatedClass(BPatient.class)
//            .buildSessionFactory();
//
//    Session session = null;
//
//    List<BPatient> bPatients;
//
//
//    public List<BPatient> bPatientsGetAll(){
//        session = factory.getCurrentSession();
//        session.getTransaction().begin();
//        bPatients = session.createQuery("SELECT b FROM BPatient b").getResultList();
//        session.getTransaction().commit();
//        return bPatients;
//    }
//    public BPatient getBuid(Long id){
//        session = factory.getCurrentSession();
//        session.getTransaction().begin();
//        BPatient bPatient = session.get(BPatient.class,id);
//        session.getTransaction().commit();
//        return bPatient;
//    }
//
//    public void update(BPatient bPatient){
//        session = factory.getCurrentSession();
//        session.getTransaction().begin();
//        BPatient bPatientik = session.get(BPatient.class,bPatient.getId());
//        bPatientik.setName(bPatient.getName());
//        session.getTransaction().commit();
//    }
//
//    public void delete(Long id){
//        session = factory.getCurrentSession();
//        session.getTransaction().begin();
//        BPatient bPatient = session.get(BPatient.class,id);
//        session.delete(bPatient);
//        session.getTransaction().commit();
//    }
//
//    public void add(BPatient patient){
//        session = factory.getCurrentSession();
//        session.getTransaction().begin();
//        session.save(patient);
//        session.getTransaction().commit();
//    }

    SessionFactory factory = new Configuration().configure("database-connection.cfg.xml")
            .addAnnotatedClass(BonusDiscount.class)
            .addAnnotatedClass(BonusPatient.class)
            .addAnnotatedClass(BonusTransaction.class)
            .buildSessionFactory();

    Session session = null;

    List<BonusPatient> bPatients;


    public List<BonusPatient> bPatientsGetAll(){
        session = factory.getCurrentSession();
        session.getTransaction().begin();
        bPatients = session.createQuery("SELECT b FROM BonusPatient b").getResultList();
        session.getTransaction().commit();
        return bPatients;
    }
    public BonusPatient getBuid(Long id){
        session = factory.getCurrentSession();
        session.getTransaction().begin();
        BonusPatient bPatient = session.get(BonusPatient.class,id);
        session.getTransaction().commit();
        return bPatient;
    }
    public boolean getBollById(Long id){
        session = factory.getCurrentSession();
        session.getTransaction().begin();
        List<BonusPatient> bPatient = session.createQuery("SELECT p FROM BonusPatient p where p.bizboxId =:bbId").setParameter("bbId",id).getResultList();
        session.getTransaction().commit();
        if (bPatient.isEmpty()){
            System.out.println("Тру");
            return true;
        }
        else {
            System.out.println("Фолс");
            return false;
        }

    }

    public void update(BonusPatient bPatient){
        session = factory.getCurrentSession();
        session.getTransaction().begin();
        BonusPatient bPatientik = session.get(BonusPatient.class,bPatient.getId());
        bPatientik.setName(bPatient.getName());
        bPatientik.setSum(bPatient.getSum());
        session.getTransaction().commit();
    }

    public void delete(Long id){
        session = factory.getCurrentSession();
        session.getTransaction().begin();
        BonusPatient bPatient = session.get(BonusPatient.class,id);
        session.delete(bPatient);
        session.getTransaction().commit();
    }

    public void add(BonusPatient patient){
        session = factory.getCurrentSession();
        session.getTransaction().begin();
        patient.setIsActive(true);
        session.save(patient);
        session.getTransaction().commit();
    }

    public void add(BonusPatient patient,BonusDiscount bonusDiscount){
        session = factory.getCurrentSession();
        session.getTransaction().begin();
        patient.setIsActive(true);
        patient.setBonusDiscount(bonusDiscount);
        session.save(patient);
        session.getTransaction().commit();
    }

    public void decline(Long id) {
        session = factory.getCurrentSession();
        session.getTransaction().begin();
        BonusPatient patient = session.get(BonusPatient.class,id);
        patient.setIsActive(false);
        session.getTransaction().commit();
    }

    public void include(Long id) {
        session = factory.getCurrentSession();
        session.getTransaction().begin();
        BonusPatient patient = session.get(BonusPatient.class,id);
        patient.setIsActive(true);
        session.getTransaction().commit();
    }


    public Long getByBBid(Long id) {
        session = factory.getCurrentSession();
        session.getTransaction().begin();
        BonusPatient patient = (BonusPatient) session.createQuery("SELECT p FROM BonusPatient p where p.bizboxId=:id").setParameter("id",id).getSingleResult();
        session.getTransaction().commit();
        return patient.getId();
    }

    public void updateSum(BigDecimal newSum,Long id){
        session = factory.getCurrentSession();
        session.getTransaction().begin();
        BonusPatient patientSum = session.get(BonusPatient.class,id);
        patientSum.setSum(patientSum.getSum().add(newSum));
        session.getTransaction().commit();
    }
}
