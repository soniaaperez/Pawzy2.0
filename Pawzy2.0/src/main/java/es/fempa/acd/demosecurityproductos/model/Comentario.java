package es.fempa.acd.demosecurityproductos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "comentarios")
public class Comentario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String contenido;

  @ManyToOne
  @JoinColumn(name = "usuario_id")
  private Usuario usuario;

  @ManyToOne
  @JoinColumn(name = "foto_id")
  private Foto foto;

  // Constructor vacío
  public Comentario() {}

  // Constructor con parámetros
  public Comentario(Long id, String contenido, Usuario usuario, Foto foto) {
    this.id = id;
    this.contenido = contenido;
    this.usuario = usuario;
    this.foto = foto;
  }

  // Getters y Setters
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getContenido() { return contenido; }
  public void setContenido(String contenido) { this.contenido = contenido; }
  public Usuario getUsuario() { return usuario; }
  public void setUsuario(Usuario usuario) { this.usuario = usuario; }
  public Foto getFoto() { return foto; }
  public void setFoto(Foto foto) { this.foto = foto; }
}
