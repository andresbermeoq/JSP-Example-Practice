package ec.edu.ups.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import ec.edu.ups.dao.FactoryDAO;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TelefonoDAO telefonoDAO;
	private UsuarioDAO usuarioDAO;
	private List<Usuario> usuarios;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        usuarioDAO = FactoryDAO.getFactoryDAO().getUsuarioDAO();
        telefonoDAO = FactoryDAO.getFactoryDAO().getTelefonoDAO();
   
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/View/Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = String.valueOf(request.getParameter("email"));
		String password = String.valueOf(request.getParameter("password"));
		String url = null;
		HttpSession session = request.getSession(true);
		
		int numVeces = 0;
		
		usuarios = usuarioDAO.find();
		
		for(Usuario usuario: usuarios) {
			
			if (usuario.getPassword().equals(password) && usuario.getEmail().equals(email)) {
				System.out.println("Usuario Encontrado: " + usuario.toString());
				session.setAttribute("usuario", usuario);
				
				if (session.isNew()) {
					session.setAttribute("accesos", numVeces);
				} else {
					session.setAttribute("accesos", numVeces + 1);
				}
				
				List<Telefono> telefonos = new ArrayList<Telefono>();
				for (Telefono telefono: telefonoDAO.find()) {
					
					if(telefono.getUsuario().getCedula().equals(usuario.getCedula())) {
						telefonos.add(telefono);
					}
				}
				
				
				request.setAttribute("telefonos", telefonos);
				usuario.setTelefonos(telefonos);
				request.setAttribute("usuario", usuario);
				url = "/View/UserIndex.jsp";
				
				break;
			} else {
				session.invalidate();
				url = "/View/Error/Error.html";
			}
			
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
