package ec.edu.ups.bd;

import java.util.List;

import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.modelo.Telefono;

public class JDBCTelefonoDAO extends JDBCGenericDAO<Telefono, Integer> implements TelefonoDAO{

	public void createTable() {
		conection.updateBD("DROP TABLE IF EXISTS Telefono");
		conection.updateBD("CREATE TABLE public.Telefono ("
				+ " id Serial PRIMARY KEY,"
				+ " Numero text,"
				+ " Tipo text,"
				+ " Operadora text,"
				+ " Usuario text,"
				+ " CONSTRAINT fk_user_phone FOREIGN KEY (usuario)"
				+ " 	REFERENCES public.usuario (cedula) MATCH SIMPLE"
				+ " 	ON UPDATE CASCADE"
				+ " 	ON DELETE CASCADE"
				+ ")");
	}

	public void create(Telefono entity) {
		// TODO Auto-generated method stub
		
	}

	public Telefono read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Telefono entity) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Telefono entity) {
		// TODO Auto-generated method stub
		
	}

	public List<Telefono> find() {
		// TODO Auto-generated method stub
		return null;
	}

}
