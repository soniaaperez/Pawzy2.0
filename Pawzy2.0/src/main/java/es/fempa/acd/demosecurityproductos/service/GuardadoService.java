package es.fempa.acd.demosecurityproductos.service;

import es.fempa.acd.demosecurityproductos.model.Guardado;
import es.fempa.acd.demosecurityproductos.repository.GuardadoRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class GuardadoService {
  private final GuardadoRepository guardadoRepository;

  public GuardadoService(GuardadoRepository guardadoRepository) {
    this.guardadoRepository = guardadoRepository;
  }

  public List<Guardado> obtenerFotosGuardadasPorUsuario(Long usuarioId) {
    return guardadoRepository.findByUsuarioId(usuarioId);
  }

  public Optional<Guardado> verificarSiUsuarioGuardoFoto(Long usuarioId, Long fotoId) {
    return guardadoRepository.findByUsuarioIdAndFotoId(usuarioId, fotoId);
  }

  public Guardado guardarFoto(Guardado guardado) {
    return guardadoRepository.save(guardado);
  }
}
