package es.fempa.acd.demosecurityproductos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/")  // ✅ Ahora la página principal será el landing page
    public String landingPage() {
        return "principal/landingpage"; // ✅ Asegúrate de que esté en templates/principal/
    }

    @GetMapping("/auth/login")
    public String login() {
        return "accesoCuentas/login"; // Asegúrate de que esta ruta apunte al archivo correcto en templates
    }
}
