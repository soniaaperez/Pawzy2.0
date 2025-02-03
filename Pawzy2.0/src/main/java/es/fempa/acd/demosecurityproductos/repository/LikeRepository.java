package es.fempa.acd.demosecurityproductos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.com.mycompany.myapp.shared.collection.domain.Like;
import java.util.List;
import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
  List<Like> findByFotoId(Long fotoId);
  List<Like> findByUsuarioId(Long usuarioId);
  Optional<Like> findByUsuarioIdAndFotoId(Long usuarioId, Long fotoId);
}
