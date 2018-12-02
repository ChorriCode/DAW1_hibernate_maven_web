package controller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Libro;
import model.modelDAO.LibroDAO;

/**
 * Servlet implementation class ServletController
 */
@WebServlet(description = "Controlador Gestion Libros", urlPatterns = { "/ServletLibro" })
public class ServletLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpServletRequest request;
	HttpServletResponse response;
	LibroDAO myBookDAO = new LibroDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLibro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.request = request;
		this.response = response;
		String option = request.getParameter("option");
		String path = "";

		
		switch (option) {
			case "findId":
				int bookId = Integer.parseInt(request.getParameter("libroId"));
				Libro oneBook = findBookById(bookId);
				request.setAttribute("book", oneBook);
				path = "jsp/bookDetails.jsp";
				break;
	
			default:
				break;
		}
		RequestDispatcher rs = request.getRequestDispatcher(path);
		rs.forward(request, response);
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	// este método del controlador lláma al método DAO encargado de buscar la información de un Libro en concreto
	//en la BBDD cuando lo encuentra lo devuelve
	private Libro findBookById(int bookId) {
		return myBookDAO.getLibroPorId(bookId);
		
	}
	

	
}
