package es.fempa.acd.demosecurityproductos.service;

import org.springframework.stereotype.Service;

import java.com.mycompany.myapp.shared.collection.domain.Like;
import java.com.mycompany.myapp.shared.collection.repository.LikeRepository;
import java.util.List;
import java.util.Optional;

@Service
public class LikeService {
  private final LikeRepository likeRepository;

  public LikeService(LikeRepository likeRepository) {
    this.likeRepository = likeRepository;
  }

  public List<Like> obtenerLikesPorFoto(Long fotoId) {
    return likeRepository.findByFotoId(fotoId);
  }

  public Optional<Like> verificarSiUsuarioDioLike(Long usuarioId, Long fotoId) {
    return likeRepository.findByUsuarioIdAndFotoId(usuarioId, fotoId);
  }

  public Like darLike(Like like) {
    return likeRepository.save(like);
  }
}
