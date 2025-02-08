package es.fempa.acd.demosecurityproductos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/feed")
public class PrincipalController {

    @GetMapping("")
    public String mostrarFeed() {
        return "feed"; // Apunta a templates/feed/feed.html
    }
}