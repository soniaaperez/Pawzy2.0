package es.fempa.acd.demosecurityproductos.service;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.com.mycompany.myapp.shared.collection.domain.Usuario;
import java.com.mycompany.myapp.shared.collection.repository.UsuarioRepository;
import java.util.Optional;
import java.util.List;

@Service
public class UsuarioService {
  private final UsuarioRepository usuarioRepository;
  private final BCryptPasswordEncoder passwordEncoder;

  public UsuarioService(UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {
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
}

