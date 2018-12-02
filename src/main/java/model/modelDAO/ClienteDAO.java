package model.modelDAO;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Cliente;
import model.DataManager;

public class ClienteDAO {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public ClienteDAO() {
		new DataManager();
		this.emf = DataManager.getEmf();
	}
	
	public Cliente getClientePorId(int id) {
		this.em = emf.createEntityManager();
		Cliente cliente = em.find(Cliente.class, id);
		em.close();
		return cliente;
	}
	
	public ArrayList<Cliente> getListadoClientes() {
		ArrayList<Cliente> listadoClientes;
		this.em = emf.createEntityManager();
		Query query = em.createQuery("SELECT l FROM Cliente l");
		listadoClientes = (ArrayList<Cliente>) query.getResultList();
		em.close();
		return listadoClientes;
	}
	
	public boolean guardarCliente(Cliente unCliente) {
		this.em = emf.createEntityManager();
		EntityTransaction transaccion = em.getTransaction();
		transaccion.begin();
		em.persist(unCliente);
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
	
	public boolean actualizarCliente(Cliente unCliente) {
		this.em = emf.createEntityManager();
		EntityTransaction transaccion = em.getTransaction();
		transaccion.begin();
		em.merge(unCliente);
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
	
	public boolean borrarCliente(Cliente unCliente) {
		this.em = emf.createEntityManager();
		EntityTransaction transaccion = em.getTransaction();
		transaccion.begin();
		em.remove(unCliente);
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
	
	 public boolean crudCliente(Cliente unCliente, String accion) {
			this.em = emf.createEntityManager();
			EntityTransaction transaccion = em.getTransaction();
			transaccion.begin();
			switch (accion) {
				case "insertar":
					em.persist(unCliente);
					break;
				case "actualizar":
					em.merge(unCliente);
					break;
				case "borrar":
					em.remove(unCliente);
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
