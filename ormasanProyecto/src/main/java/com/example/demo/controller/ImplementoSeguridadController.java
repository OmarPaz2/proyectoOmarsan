package com.example.demo.controller;

import com.example.demo.models.*;
import com.example.demo.repository.IImplentosRepository;
import com.example.demo.repository.TipoImpSeguridadRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/implementos")
public class ImplementoSeguridadController {

    @Autowired 
    private IImplentosRepository implementoSeguridadRepository;

    @Autowired 
    private TipoImpSeguridadRepository tipoImpSeguridadRepository;

    @GetMapping
    public String listarImplementos(Model model) {
        List<Implemento_Seguridad> implementos = implementoSeguridadRepository.findAll();
        model.addAttribute("implementos", implementos);
        return "implementos/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("implemento", new Implemento_Seguridad());
        model.addAttribute("tipos", tipoImpSeguridadRepository.findAll());
        return "implementos/form";
    }

    @PostMapping("/save")
    public String saveImplemento(@ModelAttribute Implemento_Seguridad implemento) {
    	System.out.println("costo unitario : " + implemento.getCostoUnit());
        if (implemento.getTipo() != null && implemento.getTipo().getIdTipo() != null) {
            Optional<TipoImpSeguridad> tipo = tipoImpSeguridadRepository.findById(implemento.getTipo().getIdTipo());
            tipo.ifPresent(implemento::setTipo);
        }
        System.out.println("costo unitario 2: " + implemento.getCostoUnit());
        implementoSeguridadRepository.save(implemento);
        return "redirect:/implementos";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Optional<Implemento_Seguridad> implemento = implementoSeguridadRepository.findById(id);
        if (implemento.isPresent()) {
            model.addAttribute("implemento", implemento.get());
            model.addAttribute("tipos", tipoImpSeguridadRepository.findAll());
            return "implementos/form";
        }
        return "redirect:/implementos";
    }

    @GetMapping("/delete/{id}")
    public String deleteImplemento(@PathVariable Integer id) {
        implementoSeguridadRepository.deleteById(id);
        return "redirect:/implementos";
    }
}