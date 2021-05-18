package ec.edu.ups.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
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
 * Servlet implementation class CreatePhoneController
 */
public class CreatePhoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDAO;
	private Usuario usuario;
	private TelefonoDAO telefonoDAO;
	private Telefono telefono;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePhoneController() {
        telefonoDAO = FactoryDAO.getFactoryDAO().getTelefonoDAO();
        usuarioDAO = FactoryDAO.getFactoryDAO().getUsuarioDAO();
        telefono = new Telefono();
        usuario = new Usuario();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/View/AddPhone.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cedula = request.getParameter("cedula");
		String numero = request.getParameter("numero");
		String tipo = request.getParameter("tipo");
		String operadora = request.getParameter("operadora");
		String url = null;
			
		
		try {
			usuario = usuarioDAO.read(cedula);
			if (usuario != null) {
				telefono.setNumero(numero);
				telefono.setTipo(tipo);
				telefono.setOperadora(operadora);
				telefono.setUsuario(usuario);
								
				telefonoDAO.create(telefono);
				
				url = "/View/UserIndex.jsp";
			} else {
				url = "/View/Error/Error.html";
			}
		} catch (Exception e) {
			url = "/View/Error/Error.html";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
			
	}

}
