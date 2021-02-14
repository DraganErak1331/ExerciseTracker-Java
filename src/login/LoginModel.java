package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbutil.DatabaseConnection;

/**
 * The Model Class of the login window which handles the database related functionality and logic.
 */
public class LoginModel {
	
	Connection conn = null;
	
	/**
	 * Initializes the constructor to establish the connection to the database using the DatabaseConnection class.
	 */
	public LoginModel() {
		try {
			conn = DatabaseConnection.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		//Terminates the JVM if there is no connection.
		if (conn == null) {
			System.exit(1);
			}
		}

	/**
	 * Checks if there is an active connection to the SQL database.
	 * @return
	 */
	public boolean isConnected() {
		return conn != null;
	}
	
	/**
	 * Executes an SQL query to check if the entered credentials match any of the username and password combinations in the login table of the exercise_tracker_database schema.
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public boolean credentialCheck(String username, String password) throws Exception {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			/*
			 * Selects all the rows that contain the username placeholder and password place holder,
			 * which are inputed using the prepareStatement variable from the method inputs.
			 * The Method inputs are the username and password that the user types in on the login screen.
			 */
			String sqlQuery = "SELECT * FROM login where username = ? AND password = ?";
			stmt = conn.prepareStatement(sqlQuery);
			stmt.setString(1, username);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			return false;
		} finally {
			try {
				if(rs!=null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(stmt!=null)
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
