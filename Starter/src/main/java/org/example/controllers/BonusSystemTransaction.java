package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bonus_system/transaction")
public class BonusSystemTransaction {
    @GetMapping
    public String getAllTransactions(Model model){
        model.addAttribute("transactions");
        return "bonus-system-models/transactions";
    }
}
