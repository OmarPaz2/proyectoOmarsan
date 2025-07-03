package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.*;
import com.example.demo.repository.*;
import org.springframework.web.bind.annotation.PostMapping;





@Controller
@RequestMapping("/Materiales")
public class MaterialesController {
    
    @Autowired
    private IMaterialRepository materialesRepository;
    @Autowired
    private ITipoMaterialRepository tipo;

    @GetMapping("/Listar")
    public String list(Model model) {
        List<Material> list = materialesRepository.findAll();
        model.addAttribute("materiales", list);
        return "Materiales";
    }

    @GetMapping("/Formulario_crear")
    public String showRegister(Model model) {
        model.addAttribute("materiales", new Material());
        List<TipoMaterial> tmaterial = tipo.findAll();
        model.addAttribute("tipo",tmaterial);
        return "Formulario_crear";
    }
    @PostMapping("/registrar")
    public String register(Model model, Material materiales) {
        materialesRepository.save(materiales);
        return "redirect:/Materiales/Listar";
    }

    @GetMapping("/editar/{idMaterial}")
    public String mostraEditar(@PathVariable Long idMaterial, Model model) {
        Material material = materialesRepository.findById(idMaterial).orElseThrow();
        model.addAttribute("materiales", material);
        List<TipoMaterial> tmaterial = tipo.findAll();
        model.addAttribute("tipo",tmaterial);
        return "Formulario_crear";
    }
    
    @GetMapping("/eliminar/{idMaterial}")
    public String eliminarMaterial(@PathVariable Long idMaterial) {
        materialesRepository.deleteById(idMaterial);
        return "redirect:/Materiales/Listar";
    }
    
    
}
