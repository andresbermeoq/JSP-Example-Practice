package ec.edu.ups.servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.FactoryDAO;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.modelo.Telefono;

/**
 * Servlet implementation class CreatePhoneController
 */
public class CreatePhoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TelefonoDAO telefonoDAO;
	private Telefono telefono;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePhoneController() {
        telefonoDAO = FactoryDAO.getFactoryDAO().getTelefonoDAO();
        telefono = new Telefono();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Create Phone inicialized....");
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
		try {
			telefono.setNumero(request.getParameter("numero"));
			telefono.setTipo(request.getParameter("tipo"));
			telefono.setOperadora(request.getParameter("operadora"));
			telefono.setUsuario(request.getParameter("usuario"));
			
			telefonoDAO.create(telefono);
		} catch (Exception e) {
			response.getWriter().append("Error: ").append(e.getMessage());
		}
	}

}
