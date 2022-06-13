package org.example.controllers;

import org.example.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomePageController {


    Patient patient;
    @Autowired
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @GetMapping
    public String getHomePage(Model model){
        model.addAttribute("patients",patient.load());
        return "index";
    }

    @GetMapping("/{id}")
    public String getHomePageWithParam(Model model, @PathVariable(value = "id") int id ){
        model.addAttribute("patients",patient.load());
        System.out.println(id);
        return "redirect:/home";
    }
}
