package ec.edu.ups.servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.FactoryDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Usuario;

/**
 * Servlet implementation class createController
 */
public class createController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createController() {
        usuarioDAO = FactoryDAO.getFactoryDAO().getUsuarioDAO();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Create Table Servlet Inicialized....");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			usuarioDAO.createTable();
			response.getWriter().append("Creado Table: ").append(request.getContextPath());
		} catch (Exception e) {
			response.getWriter().append("Error: ").append(e.getMessage());
		}
		
	}

}
