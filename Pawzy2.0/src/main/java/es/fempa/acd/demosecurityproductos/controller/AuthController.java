package es.fempa.acd.demosecurityproductos.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "login"; // Apunta a una plantilla Thymeleaf llamada login.html
    }
    
    
    @GetMapping("/")
    public String home() {
        return "login"; // Apunta a una plantilla Thymeleaf llamada login.html
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "admin/dashboard";
    }
    
    
}
