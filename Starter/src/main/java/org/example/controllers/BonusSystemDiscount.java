package org.example.controllers;

import org.example.DAO.BonusDiscountDAO;
import org.example.entities.BonusDiscount;
import org.example.entities.BonusPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
        return "bonus-system-models/discount";
    }

    @GetMapping("/decline/{id}")
    public String decline( @PathVariable(value = "id") Long id){
        bonusDiscountDAO.decline(id);
        return "redirect:/bonus_system/discounts";
    }

    @GetMapping("/include/{id}")
    public String include( @PathVariable(value = "id") Long id){
        bonusDiscountDAO.include(id);
        return "redirect:/bonus_system/discounts";
    }

    @GetMapping("/new")
    public String addNewDiscount(Model model){
        model.addAttribute("discount",new BonusDiscount());
        return "bonus-system-models/add-new-discount";
    }

    @PostMapping("/update_discount")
    public String update(BonusDiscount discount){
        bonusDiscountDAO.update(discount);
        return "redirect:/bonus_system/discounts";
    }

    @PostMapping("/new_discount")
    public String saveNewPatient(BonusDiscount discount){
        bonusDiscountDAO.add(discount);
        return "redirect:/bonus_system/discounts";
    }
}
