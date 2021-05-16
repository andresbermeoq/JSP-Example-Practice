package ec.edu.ups.dao;

import ec.edu.ups.bd.JDBCTelefonoDAO;
import ec.edu.ups.bd.JDBCUsuarioDAO;

public class JDBCDAOFactory extends FactoryDAO {

	@Override
	public void createTables() {
		this.getUsuarioDAO().createTable();
		
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		return new JDBCUsuarioDAO();
	}

	@Override
	public TelefonoDAO getTelefonoDAO() {
		return new JDBCTelefonoDAO();
	}

}
