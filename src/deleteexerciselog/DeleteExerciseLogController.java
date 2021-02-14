package deleteexerciselog;

import java.io.IOException;
import java.time.LocalDate;

import createexerciselog.ExerciseLogData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * The controller for the EditExerciseLog FXML file responsible for deleting the selected exercise logs in the system.
 */
public class DeleteExerciseLogController {
	/**
	 * The Yes button of the Delete Exercise Log page.
	 */
	@FXML
	private Button yesButton;
	
	/**
	 * The No button of the Delete Exercise Log Page
	 */
	@FXML
	private Button noButton;
	
	DeleteExerciseLogModel deleteExerciseModel = new DeleteExerciseLogModel();
	//This variable will contain the row data selected when the user chose which entry to edit.
	private ExerciseLogData selectedRowData = null;
	Stage editStage = null;
	
	/**
	 * Occurs when the Yes button is clicked.
	 * It will delete the selected entry in the system, close the current window, and reopen the Exericse Logs page.
	 */
	@FXML
	private void yesResponse() {
		deleteExerciseModel.sqlDeleteExercise(selectedRowData);
		
		Stage deleteStage = (Stage)yesButton.getScene().getWindow();
		deleteStage.close();
		editStage.close();
		
		try {
			Pane root = FXMLLoader.load(getClass().getResource("/exerciselogs/ExerciseLogs.fxml"));
			Scene scene = new Scene(root);
			Stage editStage = new Stage();
			editStage.setScene(scene);
			editStage.setTitle("Exercise Tracker");
			editStage.setResizable(false);
			editStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Occurs when the No button is clicked.
	 * It will close the Delete Exercise Log page.
	 */
	@FXML
	private void noResponse() {
		Stage stage = (Stage)noButton.getScene().getWindow();
		stage.close();
	}
	
	/**
	 * This method extracts the ExerciseLogData and Stage data from a different window to be used in the Delete Exercise Log window.
	 * @param exercise
	 * @param stage
	 */
	public void getSelectedRow(ExerciseLogData exercise, Stage stage) {
		selectedRowData = exercise;
		this.editStage = stage;
		
	}
	
	
}
