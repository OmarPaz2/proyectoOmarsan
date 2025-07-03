package com.example.demo.controller;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.models.*;
import com.example.demo.repository.*;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;




@Controller
@RequestMapping("/inicioSesion")
public class UsuarioController {
    
    @Autowired
    private UsuariosRepository usuariosRepository;


    @GetMapping
    public String showLogin(Model model) {
    	System.out.println("se INGRESO AL LOGIN DAAA");
         model.addAttribute("usuarios", new Usuario());

         return "Login";
    }

    @PostMapping("/Login")
    public String ValidarDatos(@ModelAttribute Usuario usuarios, RedirectAttributes redirAtb, HttpSession session) {
        String correo = usuarios.getCorreo();
        String clave = usuarios.getContraseña();

        Optional<Usuario> usuarioEncontrado = usuariosRepository.findByCorreoAndContraseña(correo, clave);
       
        if (usuarioEncontrado.isPresent()) {
        	
        	session.setAttribute("usuarioIniciado",usuarioEncontrado.get());
            return "redirect:/Home";
        } else {
        	redirAtb.addFlashAttribute("mensaje", "Datos incorrectos");
            return "redirect:/inicioSesion";
        }
    }
    

}
