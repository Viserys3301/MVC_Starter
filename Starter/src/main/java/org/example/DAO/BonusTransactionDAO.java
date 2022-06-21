package org.example.DAO;

import org.example.entities.BonusTransaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BonusTransactionDAO {

    List<BonusTransaction> bonusTransactions;

    public List<BonusTransaction> getBonusTransactions(){
        return bonusTransactions;
    }
}
