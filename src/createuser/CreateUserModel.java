package createuser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dbutil.DatabaseConnection;

/**
 * The Model class of the CreateUser FXML file which handles the database related functionality and logic.
 */
public class CreateUserModel {
	/**
	 * This method takes in a text value of what was entered in the user prompt box on the Create User page and
	 * execute an sql statement that will insert the string variable into the users table of the exercise_tracker_database database.
	 * @param user
	 */
	public void sqlCreateUser(String user) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DatabaseConnection.getConnection();
			String sqlAddUser = "INSERT INTO users (user) VALUES (?)";
			stmt = conn.prepareStatement(sqlAddUser);
			stmt.setString(1, user);
			stmt.execute();
			stmt.close();
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null)
					stmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null)
					conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
}
