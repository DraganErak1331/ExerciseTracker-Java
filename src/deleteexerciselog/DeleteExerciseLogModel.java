package deleteexerciselog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import createexerciselog.ExerciseLogData;
import dbutil.DatabaseConnection;

public class DeleteExerciseLogModel {
	
	public void sqlDeleteExercise(ExerciseLogData exercise) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ExerciseLogData selectedRowData = exercise;
		
		try {
			conn = DatabaseConnection.getConnection();
			String sqlDelete = "DELETE FROM exercises WHERE exercise_id = ?";
			stmt = conn.prepareStatement(sqlDelete);
			stmt.setString(1, selectedRowData.getID().toString());
			stmt.execute();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally  {
			try {
				if(stmt!=null)
					stmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null) {
					conn.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
