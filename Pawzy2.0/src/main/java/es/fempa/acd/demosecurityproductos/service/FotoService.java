package es.fempa.acd.demosecurityproductos.service;


import es.fempa.acd.demosecurityproductos.model.Foto;
import es.fempa.acd.demosecurityproductos.repository.FotoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FotoService {
  private final FotoRepository fotoRepository;

  public FotoService(FotoRepository fotoRepository) {
    this.fotoRepository = fotoRepository;
  }

  public List<Foto> buscarFotosPorTipoMascota(String tipoMascota) {
    return fotoRepository.findByTipoMascotaIgnoreCase(tipoMascota);
  }

  public Foto subirFoto(Foto foto) {
    return fotoRepository.save(foto);
  }
}
