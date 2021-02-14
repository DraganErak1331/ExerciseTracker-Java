package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Establishes a connection to the MySQL database on the schema "exercise_tracker_database" that will be used by using the appropriate credentials and URL of the database. 
 */
public class DatabaseConnection {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "NinGame567$!";
	private static final String CONN = "jdbc:mysql://localhost:3306/exercise_tracker_database";
	
	/**
	 * Uses the included JDBC drivers to connect to the MySQL database.
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(CONN,USERNAME,PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
