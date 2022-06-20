package org.example.controllers;

import org.example.DAO.BonusPatientDAO;
import org.example.DAO.BonusPatientRepo;
import org.example.entities.BPatient;
import org.example.entities.BonusPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bonus_system/patient")
public class BonusSystemController {

    BonusPatientDAO bonusPatientDAO;

    @Autowired
    public void setBonusPatientDAO(BonusPatientDAO bonusPatientDAO) {
        this.bonusPatientDAO = bonusPatientDAO;
    }

    @GetMapping
    public String getAllPatients(Model model){
        model.addAttribute("bonusPatients", bonusPatientDAO.bPatientsGetAll());
        return "bonus-system-models/index";
    }
    @GetMapping("/{id}")
    public String StringgetById(Model model, @PathVariable(value = "id") Long id){
        model.addAttribute("patient", bonusPatientDAO.getBuid(id));
        return "bonus-system-models/patient";
    }

    @PostMapping("/update_patient")
    public String update(BonusPatient bPatient){
        bonusPatientDAO.update(bPatient);
        return "redirect:/bonus_system/patient";
    }

    @GetMapping("/delete/{id}")
    public String deleted(@PathVariable(value = "id") Long id){
        bonusPatientDAO.delete(id);
        return "redirect:/bonus_system/patient";
    }
    @GetMapping("/decline/{id}")
    public String decline(@PathVariable(value = "id") Long id){
        bonusPatientDAO.decline(id);
        return "redirect:/bonus_system/patient";
    }
    @GetMapping("/include/{id}")
    public String include(@PathVariable(value = "id") Long id){
        bonusPatientDAO.include(id);
        return "redirect:/bonus_system/patient";
    }

    @GetMapping("/new")
    public String addNewPatient(Model model){
        model.addAttribute("patient",new BonusPatient());
        return "bonus-system-models/newPatient";
    }

    @PostMapping("/new_patient")
    public String saveNewPatient(BonusPatient bPatient){
        bonusPatientDAO.add(bPatient);
        return "redirect:/bonus_system/patient";
    }
}
