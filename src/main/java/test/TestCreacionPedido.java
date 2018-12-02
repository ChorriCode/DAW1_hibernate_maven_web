package test;

import java.util.ArrayList;
import java.util.List;

import model.*;
import model.modelDAO.DatosDAO;

public class TestCreacionPedido {

	public static void main(String[] args) {
		
		DatosDAO<Pedido> accesoPedido = new DatosDAO<Pedido>(Pedido.class);
		DatosDAO<LineaPedido> accesoLineaPedido = new DatosDAO<LineaPedido>(LineaPedido.class);
		DatosDAO<Libro> accesoLibro = new DatosDAO<Libro>(Libro.class);
		
		//Creamos un Pedido nuevo
		Pedido unPedido = new Pedido(1);
		//Cargamos un Pedido que ya estaba en la BD
		//Pedido unPedido = accesoPedido.getDatoPorId(1);
		

		accesoPedido.guardarDatos(unPedido);
		

		/*
		//Mostramos los pedidos con la lista de lineas que le pertenecen
		ArrayList<Pedido> listadoPedidos = accesoPedido.getListadoDatos();
		ArrayList<LineaPedido> listadoLineaPedido = accesoLineaPedido.getListadoDatos();
		for (Pedido pedido : listadoPedidos) {
			System.out.println(pedido.toString());
			for (LineaPedido lineaPedido : listadoLineaPedido) {
				if (pedido.getId()==lineaPedido.getUnPedido().getId()) {
					System.out.println(lineaPedido.toString());
				}
			}
		}
		*/
		accesoPedido.cerrar();
		
		System.exit(0);
	}

}
