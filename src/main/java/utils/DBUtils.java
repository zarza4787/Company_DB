package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		final String USER = "root";
		final String PASS = "";
		final String CONN_URL = "jdbc:mysql://localhost:3306/company_db";
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(CONN_URL, USER, PASS);
			return conn;
		} catch (SQLException e) {
			System.out.println("Error al conectar a la base de datos: " + e.getMessage());
			throw e;
		}
	}
}
