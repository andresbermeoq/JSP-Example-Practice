package ec.edu.ups.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.dao.FactoryDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Usuario;

/**
 * Servlet Filter implementation class FilterController
 */
public class FilterController implements Filter {
	
	private UsuarioDAO usuarioDAO;
	private Usuario usuario;

    /**
     * Default constructor. 
     */
    public FilterController() {
    	usuarioDAO = FactoryDAO.getFactoryDAO().getUsuarioDAO();
		usuario = new Usuario();
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest)request).getSession();
		
		System.out.println("Session: "+session.getAttribute("usuario"));
		if (session.getAttribute("usuario")!=null) {
			try {
				Usuario utemp = new Usuario();
				utemp = (Usuario)session.getAttribute("usuario");
				usuario = usuarioDAO.read(utemp.getCedula());
				chain.doFilter(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Erro en filtro validando login: "+e.getMessage());
				session.invalidate();
				((HttpServletResponse)response).sendRedirect("/Practice-JSP/View/Login.jsp");
			}
			
		}else {
			((HttpServletResponse)response).sendRedirect("/Practice-JSP/View/Login.jsp");
			session.invalidate();
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
