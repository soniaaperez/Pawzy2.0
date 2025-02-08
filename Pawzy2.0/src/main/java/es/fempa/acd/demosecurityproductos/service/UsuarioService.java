package es.fempa.acd.demosecurityproductos.service;

import es.fempa.acd.demosecurityproductos.model.Usuario;
import es.fempa.acd.demosecurityproductos.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder; // <--- Asegúrate de importar esto

@Service
public class UsuarioService implements UserDetailsService {
  private final UsuarioRepository usuarioRepository;
  private final PasswordEncoder passwordEncoder; // Cambiar de BCryptPasswordEncoder a PasswordEncoder

  public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
    this.usuarioRepository = usuarioRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public Usuario registrarUsuario(Usuario usuario) {
    usuario.setContraseña(passwordEncoder.encode(usuario.getContraseña())); // Encriptar contraseña
    return usuarioRepository.save(usuario);
  }

  public Optional<Usuario> obtenerUsuarioPorEmail(String email) {
    return usuarioRepository.findByEmail(email);
  }

  public List<Usuario> obtenerTodosLosUsuarios() {
    return usuarioRepository.findAll();
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Usuario usuario = usuarioRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con email: " + email));

    return User.builder()
            .username(usuario.getEmail()) // Usa el email como username
            .password(usuario.getContraseña()) // Usa la contraseña almacenada
            .roles("USER") // Puedes cambiar esto si tienes roles en tu entidad
            .build();
  }
}
