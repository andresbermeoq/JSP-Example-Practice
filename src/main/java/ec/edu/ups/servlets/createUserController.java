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
 * Servlet implementation class createUserController
 */
public class createUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDAO;
	private Usuario usuario;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createUserController() {
        usuarioDAO = FactoryDAO.getFactoryDAO().getUsuarioDAO();
        usuario = new Usuario();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			usuario.setId(Integer.valueOf(request.getParameter("id")));
			usuario.getNombre(request.getParameter("nombre"));
			response.getWriter().append("Creado User: ").append(request.getContextPath());
		} catch (Exception e) {
			response.getWriter().append("Error: ").append(e.getMessage());
		}
	}

}
