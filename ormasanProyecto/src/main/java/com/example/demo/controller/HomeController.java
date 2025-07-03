package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("Home")
public class HomeController {

    @GetMapping
    public String home(HttpSession session) {   	
    		return "index";	    
    }
}
