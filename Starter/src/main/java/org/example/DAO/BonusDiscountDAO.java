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

    public List<BonusDiscount> findAllTrue(){
        session = factory.getCurrentSession();
        session.getTransaction().begin();
        bonusDiscounts = session.createQuery("SELECT d FROM BonusDiscount d WHERE d.isActive=true ").getResultList();
        session.getTransaction().commit();
        return bonusDiscounts;
    }

    public BonusDiscount getById(Long id){
        session = factory.getCurrentSession();
        session.getTransaction().begin();
        BonusDiscount disc = session.get(BonusDiscount.class,id);
        session.getTransaction().commit();
        return disc;
    }

    public void decline(Long id) {
        session = factory.getCurrentSession();
        session.getTransaction().begin();
        BonusDiscount discount = session.get(BonusDiscount.class,id);
        discount.setIsActive(false);
        session.getTransaction().commit();
    }

    public void include(Long id) {
        session = factory.getCurrentSession();
        session.getTransaction().begin();
        BonusDiscount discount = session.get(BonusDiscount.class,id);
        discount.setIsActive(true);
        session.getTransaction().commit();
    }

    public void update(BonusDiscount discount) {
            session = factory.getCurrentSession();
            session.getTransaction().begin();
            BonusDiscount disc = session.get(BonusDiscount.class,discount.getId());
            disc.setDescription(discount.getDescription());
            disc.setBonusRate(discount.getBonusRate());
            disc.setBonusSum(discount.getBonusSum());
            disc.setIsActive(true);
            session.getTransaction().commit();

    }

    public void add(BonusDiscount discount) {
        session = factory.getCurrentSession();
        session.getTransaction().begin();
        discount.setIsActive(true);
        session.save(discount);
        session.getTransaction().commit();
    }
}
