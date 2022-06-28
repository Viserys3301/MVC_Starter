package org.example.controllers;

import org.example.DAO.BonusDiscountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bonus_system/discounts")
public class BonusSystemDiscount {

    BonusDiscountDAO bonusDiscountDAO;

    @Autowired
    public void setBonusDiscountDAO(BonusDiscountDAO bonusDiscountDAO) {
        this.bonusDiscountDAO = bonusDiscountDAO;
    }

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("discounts",bonusDiscountDAO.findAll());
        return "bonus-system-models/discounts";
    }

    @GetMapping("{id}")
    public String getById(Model model, @PathVariable(value = "id") Long id){
        model.addAttribute("discount",bonusDiscountDAO.getById(id));
        return "bonus-system-models/discounts";
    }
}
