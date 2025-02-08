package es.fempa.acd.demosecurityproductos.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;


  private String nombre;


  @Column(unique = true)
  private String email;


  private String contraseña;

  private String fotoPerfil;

  // Relación 1:N con Fotos
  @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Foto> fotos;

  // Relación N:M con Likes
  @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Like> likes;

  // Relación N:M con Comentarios
  @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Comentario> comentarios;

  // Relación N:M con Guardados
  @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Guardado> guardados;

  // Constructor vacío
  public Usuario() {}

  // Constructor con todos los parámetros
  public Usuario(Long id, String nombre, String email, String contraseña, String fotoPerfil, List<Foto> fotos, List<Like> likes, List<Comentario> comentarios, List<Guardado> guardados) {
    this.id = id;
    this.nombre = nombre;
    this.email = email;
    this.contraseña = contraseña;
    this.fotoPerfil = fotoPerfil;
    this.fotos = fotos;
    this.likes = likes;
    this.comentarios = comentarios;
    this.guardados = guardados;
  }

  // Getters y Setters
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getNombre() { return nombre; }
  public void setNombre(String nombre) { this.nombre = nombre; }
  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }
  public String getContraseña() { return contraseña; }
  public void setContraseña(String contraseña) { this.contraseña = contraseña; }
  public String getFotoPerfil() { return fotoPerfil; }
  public void setFotoPerfil(String fotoPerfil) { this.fotoPerfil = fotoPerfil; }
  public List<Foto> getFotos() { return fotos; }
  public void setFotos(List<Foto> fotos) { this.fotos = fotos; }
  public List<Like> getLikes() { return likes; }
  public void setLikes(List<Like> likes) { this.likes = likes; }
  public List<Comentario> getComentarios() { return comentarios; }
  public void setComentarios(List<Comentario> comentarios) { this.comentarios = comentarios; }
  public List<Guardado> getGuardados() { return guardados; }
  public void setGuardados(List<Guardado> guardados) { this.guardados = guardados; }

}
