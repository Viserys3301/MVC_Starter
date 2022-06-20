package org.example.controllers;

import org.example.DAO.BonusDiscountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bonus_system/discount")
public class BonusSystemDiscount {

    BonusDiscountDAO bonusDiscountDAO;

    @Autowired
    public BonusDiscountDAO getBonusDiscountDAO() {
        return bonusDiscountDAO;
    }

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("discount",bonusDiscountDAO.findAll());
        return "bonus-system-models/discount/index";
    }

    @GetMapping("{id}")
    public String getById(Model model, @PathVariable(value = "id") Long id){
        model.addAttribute("discount",bonusDiscountDAO.getById(id));
        return "bonus-system-models/discount/index";
    }
}
