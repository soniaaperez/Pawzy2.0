package es.fempa.acd.demosecurityproductos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.com.mycompany.myapp.shared.collection.domain.Foto;
import java.util.List;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Long> {
  List<Foto> findByTipoMascotaIgnoreCase(String tipoMascota);
  List<Foto> findByUsuarioId(Long usuarioId);
}
