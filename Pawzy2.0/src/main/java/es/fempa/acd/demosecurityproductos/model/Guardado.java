package es.fempa.acd.demosecurityproductos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "guardados")
public class Guardado {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "usuario_id")
  private Usuario usuario;

  @ManyToOne
  @JoinColumn(name = "foto_id")
  private Foto foto;

  // Constructor vacío
  public Guardado() {}

  // Constructor con parámetros
  public Guardado(Long id, Usuario usuario, Foto foto) {
    this.id = id;
    this.usuario = usuario;
    this.foto = foto;
  }

  // Getters y Setters
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public Usuario getUsuario() { return usuario; }
  public void setUsuario(Usuario usuario) { this.usuario = usuario; }
  public Foto getFoto() { return foto; }
  public void setFoto(Foto foto) { this.foto = foto; }
}
