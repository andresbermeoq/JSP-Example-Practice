package ec.edu.ups.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Usuario;

public class JDBCUsuarioDAO extends JDBCGenericDAO<Usuario, String> implements UsuarioDAO {

	public void createTable() {
		conection.updateBD("DROP TABLE IF EXISTS Usuario");
		conection.updateBD("CREATE TABLE public.Usuario ("
				+ " id Serial PRIMARY KEY,"
				+ " Nombre text,"
				+ " Apellido text,"
				+ " Cedula text,"
				+ " Email text,"
				+ " Pass text,"
				+ " UNIQUE(Cedula)"
				+ ")");
		
	}

	public void create(Usuario entity) {
		conection.updateBD("INSERT INTO public.Usuario ("
				+ "	 nombre, apellido, cedula, email, pass)"
				+ "	VALUES ("
				+ "'" + entity.getNombre() + "', "
				+ "'" + entity.getApellido() + "', "
				+ "'" + entity.getCedula() + "', "
				+ "'" + entity.getEmail() + "', "
				+ "'" + entity.getPassword() + "')"
		);
	}

	public Usuario read(String cedula) {
		Usuario usuario = null;
		ResultSet resultSet = conection.queryBD("SELECT * FROM Usuario WHERE cedula= '" + cedula + "'");
		
		try {
			if (resultSet != null && resultSet.next()) {
				usuario = new Usuario(resultSet.getInt("id"), resultSet.getString("nombre"), resultSet.getString("apellido"), 
									resultSet.getString("cedula"), resultSet.getString("email"), resultSet.getString("pass"));
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
		}
		return usuario;
	}
	

	public void update(Usuario entity) {
		conection.updateBD("UPDATE Usuario SET nombre = " + entity.getNombre() + ", apellido = " + entity.getApellido() 
					+ ", cedula = " + entity.getCedula() + ", email = " + entity.getEmail() + ", password = " + entity.getPassword()
					+ "WHERE id = " + entity.getId()
				);
		
	}

	public void delete(Usuario entity) {
		conection.updateBD("DELETE FROM Usuario WHERE id = " + entity.getId());
	}

	public List<Usuario> find() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		ResultSet resultSet = conection.queryBD("SELECT * FROM public.Usuario");
		
		
		try {
			while (resultSet.next()) {
				usuarios.add(new Usuario(resultSet.getInt("id"), resultSet.getString("nombre"), resultSet.getString("apellido"), 
						resultSet.getString("cedula"), resultSet.getString("email"), resultSet.getString("pass")));
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:find): " + e.getMessage());
		}
		return usuarios;
	}

}
