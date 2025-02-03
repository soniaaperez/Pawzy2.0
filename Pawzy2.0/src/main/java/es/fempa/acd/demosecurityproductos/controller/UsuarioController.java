package es.fempa.acd.demosecurityproductos.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PreAuthorize("hasRole('ADMIN')") // Solo los administradores pueden listar usuarios
    @GetMapping
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "usuarios/lista"; // Apunta a una plantilla Thymeleaf
    }

    @PreAuthorize("hasRole('ADMIN')") // Solo los administradores pueden crear nuevos usuarios
    @GetMapping("/nuevo")
    public String formularioNuevoUsuario(Model model) {
        model.addAttribute("roles", Rol.values());
        return "usuarios/nuevo"; // Apunta a una plantilla Thymeleaf
    }

    @PreAuthorize("hasRole('ADMIN')") // Solo los administradores pueden guardar nuevos usuarios
    @PostMapping
    public String crearUsuario(@RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String email,
                               @RequestParam Rol rol) {
        usuarioService.crearUsuario(username, password, email, rol);
        return "redirect:/usuarios";
    }

    @PreAuthorize("hasRole('ADMIN')") // Solo los administradores pueden eliminar usuarios
    @PostMapping("/{id}/eliminar")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return "redirect:/usuarios";
    }
}
