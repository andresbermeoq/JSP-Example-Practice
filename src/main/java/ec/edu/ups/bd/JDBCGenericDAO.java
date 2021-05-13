package ec.edu.ups.bd;

import ec.edu.ups.dao.GenericDAO;

public abstract class JDBCGenericDAO<T, ID> implements GenericDAO<T, ID> {
	protected ContextJDBC conection = ContextJDBC.getContextJDBC(); 
}
