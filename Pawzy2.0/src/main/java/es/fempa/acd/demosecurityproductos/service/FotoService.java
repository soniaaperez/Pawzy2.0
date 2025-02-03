package es.fempa.acd.demosecurityproductos.service;


import org.springframework.stereotype.Service;

import java.com.mycompany.myapp.shared.collection.domain.Foto;
import java.com.mycompany.myapp.shared.collection.repository.FotoRepository;
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
