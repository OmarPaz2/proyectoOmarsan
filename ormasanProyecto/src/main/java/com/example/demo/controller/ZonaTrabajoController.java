package com.example.demo.controller;

import com.example.demo.models.*;
import com.example.demo.repository.IZonaTrabajo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/zonas")
public class ZonaTrabajoController {

    @Autowired
    private IZonaTrabajo zonaTrabajoRepository; 

    @GetMapping
    public String listarZonas(Model model) {
        List<ZonaTrabajo> zonas = zonaTrabajoRepository.findAll();
        model.addAttribute("zonas", zonas);
        return "zonas/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("zona", new ZonaTrabajo());
        return "zonas/form";
    }

    @PostMapping("/save")
    public String saveZona(@ModelAttribute ZonaTrabajo zona) {
        zonaTrabajoRepository.save(zona);
        return "redirect:/zonas";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<ZonaTrabajo> zona = zonaTrabajoRepository.findById(id);
        if (zona.isPresent()) {
            model.addAttribute("zona", zona.get());
            return "zonas/form";
        }
        return "redirect:/zonas";
    }

    @GetMapping("/delete/{id}")
    public String deleteZona(@PathVariable Long id) {
        zonaTrabajoRepository.deleteById(id);
        return "redirect:/zonas";
    }
}