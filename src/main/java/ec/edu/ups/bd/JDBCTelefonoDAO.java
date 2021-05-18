package ec.edu.ups.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;

public class JDBCTelefonoDAO extends JDBCGenericDAO<Telefono, Integer> implements TelefonoDAO{

	public void createTable() {
		conection2.updateBD("DROP TABLE IF EXISTS Telefono");
		conection2.updateBD("CREATE TABLE public.Telefono ("
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
		conection2.updateBD("INSERT INTO public.telefono ("
				+ "	 numero, tipo, operadora, usuario)"
				+ "	VALUES ("
				+ "'" + entity.getNumero() + "', "
				+ "'" + entity.getTipo() + "', "
				+ "'" + entity.getOperadora() + "', "
				+ "'" + entity.getUsuario().getCedula() + "')"
		);
	}

	public Telefono read(Integer id) {
		JDBCUsuarioDAO usuarioDAO = new JDBCUsuarioDAO();
		Telefono telefono = null;
		ResultSet resultSet = conection2.queryBD("SELECT * FROM Telefono WHERE id=" + id);
		
		try {
			if (resultSet != null && resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario = usuarioDAO.read(resultSet.getString("usuario"));
				
				telefono = new Telefono(resultSet.getInt("id"), resultSet.getString("numero"), resultSet.getString("tipo"),
										resultSet.getString("operadora"), usuario);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCTelefonoDAO:read): " + e.getMessage());
		}
		return telefono;
	}

	public void update(Telefono entity) {
		conection2.updateBD("UPDATE public.telefono\n"
				+ "	SET numero='"+ entity.getNumero() +"', tipo='"+ entity.getTipo() +"', operadora='"+ entity.getOperadora() +"' " 
				+ "	WHERE id='"+ entity.getCodigo() +"'");
		
	}

	public void delete(Telefono entity) {
		conection2.queryBD("DELETE FROM public.telefono\n"
				+ "	WHERE id = " + entity.getCodigo());
		
	}

	public List<Telefono> find() {
		JDBCUsuarioDAO usuarioDAO = new JDBCUsuarioDAO();
		List<Telefono> telefonos = new ArrayList<Telefono>();
		ResultSet resultSet = conection2.queryBD("SELECT * FROM public.telefono");
		
		try {
			while (resultSet.next()) {
				Usuario usuario = new Usuario();
				
				int codigo = resultSet.getInt("id");
				String numero = resultSet.getString("numero");
				String tipo = resultSet.getString("tipo");
				String operadora = resultSet.getString("operadora");
				String cedula = resultSet.getString("usuario");
				
				usuario = usuarioDAO.read(cedula);
				Telefono telefono = new Telefono(codigo, numero, tipo, operadora, usuario);
				telefonos.add(telefono);

			}
			
		} catch (Exception e) {
			System.out.println(">>>WARNING (JDBCTelefonoDAO:find): " + e.getMessage());
		}
		return telefonos;
		
	}

}
