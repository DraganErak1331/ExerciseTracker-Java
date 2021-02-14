package editexerciselog;

import java.io.IOException;
import java.time.LocalDate;

import createexerciselog.ExerciseLogData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * The controller for the EditExerciseLog FXML file responsible for editing the selected exercise logs in the system.
 */
public class EditExerciseLogController{
	/**
	 * Contains the entry for the User field for the respective exercise log.
	 */
	@FXML
	private TextField userBox;
	
	/**
	 * Contains the entry for the Description field for the respective exercise log.
	 */
	@FXML
	private TextField descriptionBox;
	
	/**
	 * Contains the entry for the Duration field for the respective exercise log.
	 */
	@FXML
	private TextField durationBox;
	
	/**
	 * Contains the entry for the Date field for the respective exercise log.
	 */
	@FXML
	private DatePicker dateBox;
	
	/**
	 * The button that edits the exercise log entry.
	 */
	@FXML
	private Button editExerciseLogButton;
	
	//This variable will contain the row data selected when the user chose which entry to edit.
	private ExerciseLogData selectedRowData = null;
	
	EditExerciseLogModel editExerciseModel = new EditExerciseLogModel();
	Stage listStage = null;
	
	/**
	 * This method extracts the ExerciseLogData and Stage data from a different window to be used in the Edit Exercise Log window.
	 * @param exercise
	 * @param stage
	 */
	public void getSelectedRow(ExerciseLogData exercise, Stage stage) {
		selectedRowData = exercise;
		userBox.setText(selectedRowData.getUser());
		descriptionBox.setText(selectedRowData.getDescription());
		durationBox.setText(selectedRowData.getDuration().toString());
		dateBox.setValue(LocalDate.parse(selectedRowData.getDate()));
		this.listStage = stage;
	}
	
	/**
	 * This method will be used when the Edit Exercise Log button is clicked in the Edit Exercise Log window.
	 * It replaces the selected entry in the system with the edited information given, closes the open windows,
	 * and reopens the Exercise Logs window and provides updated information.
	 * @param event
	 * @throws Exception
	 */
	@FXML
	private void editExerciseLog(ActionEvent event) throws Exception{
		editExerciseModel.sqlEditExercise(selectedRowData.getID(), userBox.getText(), descriptionBox.getText(), durationBox.getText(), dateBox.getEditor().getText());
		
		Stage editStage = (Stage)editExerciseLogButton.getScene().getWindow();
		editStage.close();
		listStage.close();
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/exerciselogs/ExerciseLogs.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage listStage = new Stage();
			listStage.setScene(scene);
			listStage.setTitle("Exercise Tracker");
			listStage.setResizable(false);
			listStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
