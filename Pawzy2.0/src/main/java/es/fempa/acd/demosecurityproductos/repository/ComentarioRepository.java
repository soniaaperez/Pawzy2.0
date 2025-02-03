package es.fempa.acd.demosecurityproductos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.com.mycompany.myapp.shared.collection.domain.Comentario;
import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
  List<Comentario> findByFotoId(Long fotoId);
  List<Comentario> findByUsuarioId(Long usuarioId);
}
