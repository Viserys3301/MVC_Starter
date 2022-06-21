package org.example.controllers;

import org.example.DAO.psPatLedgersDAO;
import org.example.services.BonusSystemAddNewPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/payments")
public class psPatLedgersController {

    BonusSystemAddNewPatient bonusSystemAddNewPatient;

    @Autowired
    public void setBonusSystemAddNewPatient(BonusSystemAddNewPatient bonusSystemAddNewPatient) {
        this.bonusSystemAddNewPatient = bonusSystemAddNewPatient;
    }

    @GetMapping
    public String gtPayments(Model model){
        model.addAttribute("payments",bonusSystemAddNewPatient.findNewPatient());
        return "payments-list";
    }
}
