package model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Esta clase usa una base de datos.
 * Los métodos que la llamen de manera que si cambiamos el nombre
 * de la base de datos no tenemos que ir a todas las clases DAO a
 * cambiarlo ese parámetro. Tener en cuenta que el parámentro dentro de
 * createEntityManagerFactory("libreria") puede o no coincidir con el nombre 
 * de la base de datos, ya que se refiere al nombre de la unidad de persistencia
 * configurado dentro del archivo persisntence.xml
 * 
 * @author Javier
 *
 */
public class DataManager {
	
	private static EntityManagerFactory emf;


	public static EntityManagerFactory getEmf() {
		DataManager.emf = Persistence.createEntityManagerFactory("libreria");
		return emf;
	}

}
