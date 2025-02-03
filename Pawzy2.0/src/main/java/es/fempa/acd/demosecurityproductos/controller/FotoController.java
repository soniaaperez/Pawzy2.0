package es.fempa.acd.demosecurityproductos.controller;

import es.fempa.acd.demosecurityproductos.model.Foto;
import es.fempa.acd.demosecurityproductos.service.FotoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fotos")
public class FotoController {
  private final FotoService fotoService;

  public FotoController(FotoService fotoService) {
    this.fotoService = fotoService;
  }

  @GetMapping("/buscar")
  public List<Foto> buscarPorTipoMascota(@RequestParam String tipoMascota) {
    return fotoService.buscarFotosPorTipoMascota(tipoMascota);
  }

  @PostMapping
  public Foto subir(@RequestBody Foto foto) {
    return fotoService.subirFoto(foto);
  }
}
