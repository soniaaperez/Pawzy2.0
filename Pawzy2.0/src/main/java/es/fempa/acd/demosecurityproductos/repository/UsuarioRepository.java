package es.fempa.acd.demosecurityproductos.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.com.mycompany.myapp.shared.collection.domain.Usuario;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
  Optional<Usuario> findByEmail(String email);
  Optional<Usuario> findByNombre(String nombre);
}
