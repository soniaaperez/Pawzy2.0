package es.fempa.acd.demosecurityproductos.controller;

import es.fempa.acd.demosecurityproductos.model.Like;
import es.fempa.acd.demosecurityproductos.service.LikeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/likes")
public class LikeController {
  private final LikeService likeService;

  public LikeController(LikeService likeService) {
    this.likeService = likeService;
  }

  @GetMapping("/foto/{fotoId}")
  public List<Like> obtenerPorFoto(@PathVariable Long fotoId) {
    return likeService.obtenerLikesPorFoto(fotoId);
  }

  @PostMapping
  public Like darLike(@RequestBody Like like) {
    return likeService.darLike(like);
  }

  @GetMapping("/verificar")
  public ResponseEntity<Boolean> verificarLike(@RequestParam Long usuarioId, @RequestParam Long fotoId) {
    Optional<Like> like = likeService.verificarSiUsuarioDioLike(usuarioId, fotoId);
    return ResponseEntity.ok(like.isPresent());
  }
}

