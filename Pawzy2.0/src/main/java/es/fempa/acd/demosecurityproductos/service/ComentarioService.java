package es.fempa.acd.demosecurityproductos.service;

import es.fempa.acd.demosecurityproductos.model.Comentario;
import es.fempa.acd.demosecurityproductos.repository.ComentarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {
  private final ComentarioRepository comentarioRepository;

  public ComentarioService(ComentarioRepository comentarioRepository) {
    this.comentarioRepository = comentarioRepository;
  }

  public List<Comentario> obtenerComentariosPorFoto(Long fotoId) {
    return comentarioRepository.findByFotoId(fotoId);
  }

  public Comentario agregarComentario(Comentario comentario) {
    return comentarioRepository.save(comentario);
  }
}
