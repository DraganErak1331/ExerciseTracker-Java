package createexerciselog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbutil.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * The Model class of the CreateExerciseLog FXML file which handles the database related functionality and logic.
 */
public class CreateExerciseLogModel {

	/**
	 * This method takes in an empty ObservableList, executes and SQL query to retrieve each user entry in the users table,
	 * and adds each one to the ObservableList.
	 * @param data
	 * @return
	 */
	public ObservableList<String> sqlLoadUserData(ObservableList<String> data) {
		Connection conn = null;
		Statement stmt = null;
		
		data = FXCollections.observableArrayList();
		
		try {
			conn = DatabaseConnection.getConnection();
			stmt = conn.createStatement();
			
			String sqlRetrieve = "SELECT user FROM users";
			ResultSet rs = stmt.executeQuery(sqlRetrieve);
			
			while(rs.next()) {
				data.add(rs.getString(1));
			}
			
			rs.close();
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
				if (conn!=null)
					conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	
	/**
	 * This method takes in the text values of the TextFields for the user, description, and duration, as well as the text values
	 * for the date DatePicker. It then uses those values in an SQL query to insert those values into the exercises table.
	 * @param user
	 * @param description
	 * @param duration
	 * @param date
	 */
	public void sqlCreateExerciseLog(String user, String description, String duration, String date) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DatabaseConnection.getConnection();
			String sqlInsert = "INSERT INTO exercises (user,description, duration, date) VALUES (?,?,?,?)";
			stmt = conn.prepareStatement(sqlInsert);
			stmt.setString(1, user);
			stmt.setString(2, description);
			stmt.setInt(3, Integer.parseInt(duration));
			stmt.setString(4, date);
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
