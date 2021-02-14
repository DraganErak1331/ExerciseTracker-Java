package exerciselogs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import createexerciselog.ExerciseLogData;
import dbutil.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * The Model class of the ExerciseLogs FXML file which handles the database related functionality and logic.
 */
public class ExerciseLogsModel {
	
	/**
	 * Takes an empty ObservableList of type ExerciseLogData that will be used to store all of the ExerciseLogData entries to display. 
	 * An sql statement is executed to retrieve each row from the exercises table of the exercise_tracker_database schema.
	 * Each row of the resulting result set is then added to the ObservableList that was passed in to this method.
	 * @param data
	 * @return
	 */
	public ObservableList<ExerciseLogData> sqlLoadTable(ObservableList<ExerciseLogData> data) {
		Connection conn = null;
		Statement stmt = null;
		
		data = FXCollections.observableArrayList();
		
		try {
			conn = DatabaseConnection.getConnection();
			stmt = conn.createStatement();
			
			String sqlRetrieve = "SELECT * FROM exercises";
			//the output from the executed sql query is stored in the result set
			ResultSet rs = stmt.executeQuery(sqlRetrieve);
			
			//for each from in the result set, store the row a s a new ExerciseLogData object in the ObservableList data
			while (rs.next()) {
				data.add(new ExerciseLogData(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
			}
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
}
