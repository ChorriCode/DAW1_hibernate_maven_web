package test;

import model.*;
import model.modelDAO.DatosDAO;

public class TestCrearLineaPedido {

	public static void main(String[] args) {
		DatosDAO<Pedido> accesoPedido = new DatosDAO<Pedido>(Pedido.class);
		DatosDAO<LineaPedido> accesoLineaPedido = new DatosDAO<LineaPedido>(LineaPedido.class);
		DatosDAO<Libro> accesoLibro = new DatosDAO<Libro>(Libro.class);
		
		//Creamos una linea de pedido
		LineaPedido unaLineaPedido = new LineaPedido();
		//Cargamos un Libro desde la BD
		unaLineaPedido.setUnLibro(accesoLibro.getDatoPorId(2));
		unaLineaPedido.setCantidad(2);
		unaLineaPedido.setUnPedido(accesoPedido.getDatoPorId(1));
		accesoLineaPedido.guardarDatos(unaLineaPedido);
		
		accesoLineaPedido.cerrar();
	}

}
