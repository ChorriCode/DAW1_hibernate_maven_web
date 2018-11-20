package model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table (name="LINEAS_PEDIDO")
public class LineaPedido implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_LINEA_PEDIDO")
	private int id;
	@OneToOne
	private Libro unLibro;
	@Column(name="CANTIDAD")
	private int cantidad;
	@ManyToOne
    private Pedido unPedido;
	
	public LineaPedido() {
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Libro getUnLibro() {
		return unLibro;
	}


	public void setUnLibro(Libro unLibro) {
		this.unLibro = unLibro;
	}


	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public Pedido getUnPedido() {
		return unPedido;
	}


	public void setUnPedido(Pedido unPedido) {
		this.unPedido = unPedido;
	}


	@Override
	public String toString() {
		return "LineaPedido [id=" + getId() + ", unLibro=" + getUnLibro() + ", cantidad=" + getCantidad()
				+ "]";
	}






	
	

}
