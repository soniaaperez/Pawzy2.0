package es.fempa.acd.demosecurityproductos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.com.mycompany.myapp.shared.collection.domain.Guardado;
import java.util.List;
import java.util.Optional;

@Repository
public interface GuardadoRepository extends JpaRepository<Guardado, Long> {
  List<Guardado> findByUsuarioId(Long usuarioId);
  Optional<Guardado> findByUsuarioIdAndFotoId(Long usuarioId, Long fotoId);
}
