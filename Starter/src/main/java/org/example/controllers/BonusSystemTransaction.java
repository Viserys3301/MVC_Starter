package org.example.controllers;

import org.example.DAO.BonusTransactionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bonus_system/transaction")
public class BonusSystemTransaction {
    BonusTransactionDAO bonusTransactionDAO;

    @Autowired
    public void setBonusTransactionDAO(BonusTransactionDAO bonusTransactionDAO) {
        this.bonusTransactionDAO = bonusTransactionDAO;
    }

    @GetMapping
    public String getAllTransactions(Model model){
        model.addAttribute("transactions",bonusTransactionDAO.getBonusTransactionsTop30());
        return "bonus-system-models/transactions";
    }
}
