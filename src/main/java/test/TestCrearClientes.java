package test;

import java.util.ArrayList;

import model.*;

public class TestCrearClientes {
	public static void main(String[] args) {
		
		DatosDAO<Cliente> accesoCliente = new DatosDAO<Cliente>(Cliente.class);
		Cliente cliente1 = new Cliente("Javier","Hernández","javier","0007");
		Cliente cliente2 = new Cliente("Janniel","Diez","janniel","1234");
		accesoCliente.guardarDatos(cliente1);
		accesoCliente.guardarDatos(cliente2);
		
		ArrayList<Cliente> listadoClientes = accesoCliente.getListadoDatos();
		
		for (Cliente cliente : listadoClientes) {
			System.out.println(cliente.toString());
		}
		accesoCliente.cerrar();
		
		System.exit(0);
	}
}
