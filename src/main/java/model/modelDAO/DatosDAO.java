package model.modelDAO;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.DataManager;

/**
 * 
 * @author Javier
 *
 * @param <T>
 * es la clase que tenemos que utilizar para usar los metodos que represetan el CRUD
 * como es una class generics <T> nos valdrá para todas las clases
 */
public class DatosDAO<T> {

	static EntityManagerFactory emf;
	static EntityManager em;
	private Class<T> entityClass;
	
	public DatosDAO(Class <T> entityClass) {
		System.out.println(entityClass.getClass());
		DatosDAO.emf = DataManager.getEmf();
		DatosDAO.em = emf.createEntityManager();
		this.entityClass = entityClass;
	}
	
	public T getDatoPorId(int id) {
		
		//this.em = emf.createEntityManager();
		T t = (T) em.find(entityClass, id);
		System.out.println("-----------------");
		System.out.println(t.getClass());

		//em.close();
		return t;
	}

	public ArrayList<T> getListadoDatos() {
		ArrayList<T> listadoDatos;
		//this.em = emf.createEntityManager();
		Query query = em.createQuery("SELECT l FROM " + entityClass.getSimpleName() + " l");
		listadoDatos = (ArrayList<T>) query.getResultList();
		//em.close();
		return listadoDatos;
	}
	

	public boolean guardarDatos(T dato) {
		
		EntityTransaction transaccion = em.getTransaction();
		transaccion.begin();

		try {
			em.persist(dato);
			//em.flush();
			transaccion.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(transaccion.isActive()){
				transaccion.rollback();
	        }
			return false;
		} finally {
			//cerrar();
		}		
		return true;		
	}
	
	public void cerrar() {
		DatosDAO.em.close();
		DatosDAO.emf.close();
	}

	public static EntityManagerFactory getEmf() {
		return emf;
	}


	public static EntityManager getEm() {
		return em;
	}

	// en vez de usar generics uso Object
	public boolean guardarDatos2(Object dato) {
		
		EntityTransaction transaccion = em.getTransaction();
		transaccion.begin();

		try {
			em.persist(dato);
			em.flush();
			transaccion.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(transaccion.isActive()){
				transaccion.rollback();
	        }
			return false;
		} finally {
			//cerrar();
		}		
		return true;		
	}
	
}
