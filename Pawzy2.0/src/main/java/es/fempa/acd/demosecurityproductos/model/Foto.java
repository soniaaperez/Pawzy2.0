package es.fempa.acd.demosecurityproductos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fotos")
public class Foto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String url;
  private String descripcion;
  private String tipoMascota; // perro, gato, etc.

  @ManyToOne
  @JoinColumn(name = "usuario_id")
  private Usuario usuario;

  // Constructor vacío
  public Foto() {}

  // Constructor con parámetros
  public Foto(Long id, String url, String descripcion, String tipoMascota, Usuario usuario) {
    this.id = id;
    this.url = url;
    this.descripcion = descripcion;
    this.tipoMascota = tipoMascota;
    this.usuario = usuario;
  }

  // Getters y Setters
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getUrl() { return url; }
  public void setUrl(String url) { this.url = url; }
  public String getDescripcion() { return descripcion; }
  public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
  public String getTipoMascota() { return tipoMascota; }
  public void setTipoMascota(String tipoMascota) { this.tipoMascota = tipoMascota; }
  public Usuario getUsuario() { return usuario; }
  public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}

