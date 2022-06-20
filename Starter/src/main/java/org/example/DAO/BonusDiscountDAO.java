package org.example.DAO;

import org.example.entities.BonusDiscount;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BonusDiscountDAO {

    List<BonusDiscount> bonusDiscounts;

    public List<BonusDiscount> findAll(){
        return bonusDiscounts;
    }

    public BonusDiscount getById(Long id){
        return new BonusDiscount();
    }
}
