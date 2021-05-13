package ec.edu.ups.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.FactoryDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Usuario;

/**
 * Servlet implementation class ListUserController
 */
public class ListUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDAO;
	private List<Usuario> usuarios;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListUserController() {
        usuarioDAO = FactoryDAO.getFactoryDAO().getUsuarioDAO();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("List of The User");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		try {
			usuarios = usuarioDAO.find();
			System.out.println("List Size: " + usuarios.size());
			request.setAttribute("usuarios", usuarios);
			url = "/View/ListUser.jsp";
		} catch (Exception e) {
			response.getWriter().append("Error: ").append(e.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
