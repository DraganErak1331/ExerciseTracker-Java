package editexerciselog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dbutil.DatabaseConnection;

/**
 * The Model class of the EditExerciseLog FXML file which handles the database related functionality and logic.
 */
public class EditExerciseLogModel {

	/**
	 * This method takes in the text values of the entries from the Edit Exercise Log page and updates the respective entry
	 * in the exercises table of the exercise_tracker_database database with the provided entries.
	 * @param id
	 * @param user
	 * @param description
	 * @param duration
	 * @param date
	 */
	public void sqlEditExercise(Integer id, String user, String description, String duration, String date) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DatabaseConnection.getConnection();
			String sqlEdit = "UPDATE exercises SET user = ?, description = ?, duration = ?, date = ? WHERE exercise_id = ?";
			stmt = conn.prepareStatement(sqlEdit);
			stmt.setString(1, user);
			stmt.setString(2, description);
			stmt.setString(3, duration);
			stmt.setString(4, date);
			stmt.setString(5, id.toString());
			stmt.execute();
			stmt.close();
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null) 
					stmt.close();
				} catch(SQLException e){
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
