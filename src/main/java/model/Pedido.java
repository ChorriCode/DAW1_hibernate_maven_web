package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name="PEDIDO")
public class Pedido implements Serializable{

	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID_PEDIDO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="ID_CLIENTE")
	private int idCliente;
	@OneToMany(mappedBy = "unPedido")
	@OrderBy("name ASC")
    private List<LineaPedido> lineasPedido;

	

	public Pedido() {
		lineasPedido = new ArrayList<LineaPedido>();
	}

	public Pedido(int idCliente) {
		super();
		this.idCliente = idCliente;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}



	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}




	public List<LineaPedido> getLineasPedido() {
		return lineasPedido;
	}


	public void setLineasPedido(List<LineaPedido> lineasPedido) {
		this.lineasPedido = lineasPedido;
	}


	@Override
	public String toString() {
		return "Pedido [id=" + id + ", idCliente=" + idCliente + "]";
	}


	




	
		
}	

