package model.modelDAO;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.DataManager;
import model.Libro;

public class LibroDAO {

	EntityManagerFactory emf;
	EntityManager em;
	
	public LibroDAO() {
		new DataManager();
		this.emf = DataManager.getEmf();
	}
	
	public Libro getLibroPorId(int id) {
		this.em = emf.createEntityManager();
		Libro libro = em.find(Libro.class, id);
		em.close();
		return libro;
	}
	
	public ArrayList<Libro> getListadoLibros() {
		ArrayList<Libro> listadoLibros;
		this.em = emf.createEntityManager();
		Query query = em.createQuery("SELECT l FROM Libro l");
		listadoLibros = (ArrayList<Libro>) query.getResultList();
		em.close();
		return listadoLibros;
	}
	
	public boolean guardarLibro(Libro unLibro) {
		this.em = emf.createEntityManager();
		EntityTransaction transaccion = em.getTransaction();
		transaccion.begin();
		em.persist(unLibro);
		try {
			transaccion.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}		
		return true;		
	}
	
	public boolean actualizarLibro(Libro unLibro) {
		this.em = emf.createEntityManager();
		EntityTransaction transaccion = em.getTransaction();
		transaccion.begin();
		em.merge(unLibro);
		try {
			transaccion.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}		
		return true;
	}
	
	public boolean borrarLibro(Libro unLibro) {
		this.em = emf.createEntityManager();
		EntityTransaction transaccion = em.getTransaction();
		transaccion.begin();
		em.remove(unLibro);
		try {
			transaccion.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}		
		return true;		
	}
	
	 public boolean crudLibro(Libro unLibro, String accion) {
			this.em = emf.createEntityManager();
			EntityTransaction transaccion = em.getTransaction();
			transaccion.begin();
			switch (accion) {
				case "insertar":
					em.persist(unLibro);
					break;
				case "actualizar":
					em.merge(unLibro);
					break;
				case "borrar":
					em.remove(unLibro);
					break;				
				default:
					break;
			}		
			try {
				transaccion.commit();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			} finally {
				em.close();
			}		
			return true;
		 
	 }
	
	public void cerrar() {
		this.emf.close();
	}
	
}
