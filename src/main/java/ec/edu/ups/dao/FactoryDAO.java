package ec.edu.ups.dao;

public abstract class FactoryDAO {
	
	protected static FactoryDAO factory = new JDBCDAOFactory();
	
	public static FactoryDAO getFactoryDAO() {
		return factory;
	}
	
	public abstract void createTables();
	public abstract UsuarioDAO getUsuarioDAO();
	public abstract TelefonoDAO getTelefonoDAO();

}
