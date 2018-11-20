package model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table (name="LIBRO")
public class Libro implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID_LIBRO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="TITULO") // si la columna tiene el mismo nombre se puede dejar solo @Column
	private String titulo;
	@Column(name="AUTOR")
	private String autor;
	@Column(name="PRECIO")
	private float precio;	
	@Column(name="ID_CATEGORIA")
	private int idCategoria;
	
	public Libro() {		
	}
	
	public Libro(String titulo, String autor, float precio, int idCategoria) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
		this.idCategoria = idCategoria;
	}	
	
	public Libro(int id, String titulo, String autor, float precio, int idCategoria) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
		this.idCategoria = idCategoria;
	}
	
	
	public float getPrecio() {
		return precio;
	}
	public int getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getAutor() {
		return autor;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", precio=" + precio + ", idCategoria="
				+ idCategoria + "]";
	}
	
}
