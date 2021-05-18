package ec.edu.ups.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.FactoryDAO;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.modelo.Telefono;

/**
 * Servlet implementation class UpdatePhoneController
 */
public class UpdatePhoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TelefonoDAO telefonoDAO;
	private Telefono telefono;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePhoneController() {
    	telefonoDAO = FactoryDAO.getFactoryDAO().getTelefonoDAO();
    	telefono = new Telefono();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Update");
	}
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		telefono = telefonoDAO.read(codigo);
		request.setAttribute("telefono", telefono);
		System.out.println(telefono.toString());
		
		request.getRequestDispatcher("/View/UpdatePhone.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		String numero = String.valueOf(request.getParameter("numero"));
		String tipo = String.valueOf(request.getParameter("tipo"));
		String operadora = String.valueOf(request.getParameter("operadora"));
		
		try {
			telefono = new Telefono(codigo, numero, tipo, operadora, null);
			System.out.println("Telefono Actualizado: " + telefono.toString());
			
			telefonoDAO.update(telefono);
			
			url="/View/UserIndex.jsp";
			
			
		} catch (Exception e) {
			url = "/View/Error/Error.html";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
