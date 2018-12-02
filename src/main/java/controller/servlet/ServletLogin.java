package controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.modelDAO.ClienteDAO;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		String path = "index.jsp";
		//comprobamos que ambos inputs envíen datos para validar
		if (user.isEmpty() || password.isEmpty()) {
			request.setAttribute("error", "Usuario y password no pueden ir vacíos");
            RequestDispatcher rs = request.getRequestDispatcher(path);
            rs.forward(request, response);
		} else {
			//consultamos la base de datos para comprobar user y password
			ClienteDAO consultaLogin = new ClienteDAO();
			try {
				List resultado = consultaLogin.authenticate(user, password);
				// si List está vacío o tiene datos sabremos si el usr y password están o no en la bbdd
				if (resultado.isEmpty()) {
					
					request.setAttribute("error", "Usuario y/o password invalido");
				} else {
					path = "/jsp/menu.jsp";
					request.setAttribute("error", "Usuario y password CORRECTO");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
            RequestDispatcher rs = request.getRequestDispatcher(path);
            rs.forward(request, response);
		}
	}

}
