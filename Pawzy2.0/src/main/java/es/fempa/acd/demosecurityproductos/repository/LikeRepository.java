package es.fempa.acd.demosecurityproductos.repository;

import es.fempa.acd.demosecurityproductos.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
  List<Like> findByFotoId(Long fotoId);
  List<Like> findByUsuarioId(Long usuarioId);
  Optional<Like> findByUsuarioIdAndFotoId(Long usuarioId, Long fotoId);
}
