package es.fempa.acd.demosecurityproductos.repository;

import es.fempa.acd.demosecurityproductos.model.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Long> {
  List<Foto> findByTipoMascotaIgnoreCase(String tipoMascota);
  List<Foto> findByUsuarioId(Long usuarioId);
}
