package test;

import java.util.ArrayList;
import java.util.List;

import model.*;


public class TestConsultaPorId {

	public static void main(String[] args) {
		System.gc();

		
		DatosDAO<Pedido> accesoPedido = new DatosDAO<Pedido>(Pedido.class);
		DatosDAO<LineaPedido> accesoLineaPedido = new DatosDAO<LineaPedido>(LineaPedido.class);
		DatosDAO<Libro> accesoLibro = new DatosDAO<Libro>(Libro.class);
		
		// Consulta de un Pedido y sus lineas
		Pedido unPedido = accesoPedido.getDatoPorId(1);
		System.out.println("Pedido: " + unPedido.toString());
		System.out.println("IdCLiente: " + unPedido.getIdCliente());
		ArrayList<LineaPedido> listadoLineaPedido = accesoLineaPedido.getListadoDatos();
		for (LineaPedido lineaPedido : listadoLineaPedido) {
			if (unPedido.getId()==lineaPedido.getUnPedido().getId()) {
				System.out.println(lineaPedido.toString());
			}
		}

		/*
		DatosDAO2<Student> sd1 = new DatosDAO2<Student>(Student.class);
		DatosDAO2<Department> dd1 = new DatosDAO2<Department>(Department.class);

	    
		  //EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreria");
		  //EntityManager em = emf.createEntityManager(); 
		  //em.getTransaction().begin();
	    Student student = new Student();
	    student.setName("Manolo");
	    //em.persist(student);
	    sd1.guardarDatos(student);
	    
	    Department dept = new Department();
	    dept.addStudent(student);
	    dept.setName("Administraci");
	    //em.persist(dept);
	    System.out.println(dept.toString());
	    dd1.guardarDatos(dept);
	    
	    
	    ArrayList<Student> listadoEstudiantes = sd1.getListadoDatos();
		for (Student estudiante : listadoEstudiantes) {
			System.out.println(estudiante.toString());
		}
		
		//System.out.println(sd1.getDatoPorId(15).toString());
		sd1.cerrar();
		dd1.cerrar();
	    
	    
	   // em.flush();
/*
		  Query query = em.createQuery("SELECT e FROM Student e");
		    List<Student> list = (List<Student>) query.getResultList();
		    System.out.println(list);
		    
		    query = em.createQuery("SELECT d FROM Department d");
		    List<Department> dList = (List<Department>) query.getResultList();
		    System.out.println(dList);
		    em.getTransaction().commit();
		    em.close();
		    emf.close();
		*/
		
		System.exit(0);
	}

}
