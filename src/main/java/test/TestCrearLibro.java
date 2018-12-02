package test;

import java.util.ArrayList;

import model.*;
import model.modelDAO.DatosDAO;

public class TestCrearLibro {
	public static void main(String[] args) {
		
		DatosDAO<Libro> accesoLibro = new DatosDAO<Libro>(Libro.class);

		Libro nuevoLibro1 = new Libro("Nuevo Libro", "Nuevo Autor", 10.99f, 1);
		accesoLibro.guardarDatos(nuevoLibro1);
		/*Libro nuevoLibro2 = new Libro("Libro2", "Autor2", 22.22f, 1);
		accesoLibro.guardarDatos(nuevoLibro2);
		Libro nuevoLibro3 = new Libro("Libro3", "Autor3", 22.22f, 1);
		accesoLibro.guardarDatos(nuevoLibro3);*/
		
			
		ArrayList<Libro> listadoLibros = accesoLibro.getListadoDatos();
		
		for (Libro libro : listadoLibros) {
			System.out.println(libro.toString());
		}
		
		accesoLibro.cerrar();
			
		System.exit(0);
	}
	
}
