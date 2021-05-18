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
		System.out.println("Create User inicialized....");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/View/AddUser.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		try {
			usuario.setNombre(request.getParameter("nombre"));
			usuario.setApellido(request.getParameter("apellido"));
			usuario.setCedula(request.getParameter("cedula"));
			usuario.setEmail(request.getParameter("email"));
			usuario.setPassword(request.getParameter("password"));
			
			usuarioDAO.create(usuario);
			url = "/index.jsp";
		} catch (Exception e) {
			url = "/View/Error/Error.html";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
