package ec.edu.ups.servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.FactoryDAO;
import ec.edu.ups.dao.TelefonoDAO;

/**
 * Servlet implementation class createTablePhoneController
 */
public class createTablePhoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TelefonoDAO telefonoDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createTablePhoneController() {
        telefonoDAO = FactoryDAO.getFactoryDAO().getTelefonoDAO();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Create Table Phone Servlet Inicialized....");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null; 
		try {
			telefonoDAO.createTable();
			url = "/View/AddUser.jsp";
		} catch (Exception e) {
			response.getWriter().append("Error: ").append(e.getMessage());
		}	
		request.getRequestDispatcher(url).forward(request, response);
	}

}
