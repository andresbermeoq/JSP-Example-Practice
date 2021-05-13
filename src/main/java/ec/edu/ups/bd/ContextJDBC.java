package ec.edu.ups.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ContextJDBC {
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/JEE";
	private static final String USER = "user_andres";
	private static final String PASSWORD = "andres";
	
	private Statement statement = null;
	private static ContextJDBC jdbc = null;
	
	
	public ContextJDBC() {
		this.connectBD();
	}
	
	public void connectBD() {
		try {
			Class.forName(DRIVER);
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connection Succesful....");
			this.statement = connection.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println("----WARNING (JDBC:Connect).......problems with the driver\n" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("----WARNING (JDBC:Connect).......problems with the BD\n" + e.getMessage());
		}
	}
	
	public ResultSet queryBD(String sql) {
		try {
			return this.statement.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("----WARNING (JDBC:Query)....\n" + sql + ": " + e);
		}
		return null;
	}
	
	public boolean updateBD(String sql) {
		try {
			this.statement.execute(sql);
			return true;
		} catch (Exception e) {
			System.out.println("----WARNING (JDBC:Update)....\n" + sql + ": " + e);
			return false;
		}
	}
	
	protected static ContextJDBC getContextJDBC() {
		if(jdbc == null) {
			jdbc = new ContextJDBC();
		}
		
		return jdbc;
	}
	
	
	
	
	

}
