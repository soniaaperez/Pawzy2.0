package es.fempa.acd.demosecurityproductos.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public String listarProductos(Model model) {
        List<Producto> productos = productoService.listarProductos();
        model.addAttribute("productos", productos);
        return "productos/lista"; // Apunta a una plantilla Thymeleaf
    }

    
    @GetMapping("/nuevo")
    @PreAuthorize("hasRole('ADMIN')") // Solo los administradores pueden acceder a la página de edición de productos
    public String mostrarFormularioNuevoProducto() {
        return "productos/nuevo"; // Devuelve la plantilla "editar.html"
    }
    
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')") // Solo los administradores pueden crear productos
    public String crearProducto(@RequestParam String nombre,
                                @RequestParam String descripcion,
                                @RequestParam double precio,
                                @RequestParam String imagen) {
        productoService.crearProducto(nombre, descripcion, precio, imagen);
        return "redirect:/productos";
    }

    @PostMapping("/{id}/editar")
    @PreAuthorize("hasRole('ADMIN')") // Solo los administradores pueden editar productos
    public String editarProducto(@PathVariable Long id,
                                  @RequestParam String nombre,
                                  @RequestParam String descripcion,
                                  @RequestParam double precio,
                                  @RequestParam String imagen) {
        Producto producto = productoService.buscarPorId(id);
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setImagen(imagen);

        // Llama al servicio para guardar el producto actualizado
        productoService.actualizarProducto(producto);

        return "redirect:/productos";
    }

    
    @GetMapping("/{id}/editar")
    @PreAuthorize("hasRole('ADMIN')") // Solo los administradores pueden acceder a la página de edición de productos
    public String mostrarFormularioEditarProducto(@PathVariable Long id, Model model) {
        Producto producto = productoService.buscarPorId(id); // Obtén el producto existente por su ID
        model.addAttribute("producto", producto); // Agrega el producto al modelo
        return "productos/editar"; // Devuelve la plantilla "editar.html"
    }


    @PostMapping("/{id}/eliminar")
    @PreAuthorize("hasRole('ADMIN')") // Solo los administradores pueden eliminar productos
    public String eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return "redirect:/productos";
    }
}
