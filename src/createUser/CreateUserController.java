package createUser;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * The controller for the CreateUser FXML file responsible for creating users to choose from in the system.
 */
public class CreateUserController {
	/**
	 * The anchor pane in the CreateUser FXML file.
	 */
	@FXML
	private AnchorPane rootPane;
	
	/**
	 * The text that links to the Exercise Logs page.
	 */
	@FXML
	private Text exercisesPage;
	
	/**
	 * The text that links to the Create Exercise Log page.
	 */
	@FXML
	private Text createExerciseLogPage;
	
	/**
	 * The text that links to the Create User page.
	 */
	@FXML
	private Text createUserPage;
	
	/**
	 * The prompt for entering the new user's name.
	 */
	@FXML
	private TextField userBox;
	
	CreateUserModel createUserModel = new CreateUserModel();
	
	/**
	 * Adjusts the text fill color when the mouse goes over the Exercise Logs text.
	 */
	@FXML
	private void onMouseEntered_Exercises() {
		exercisesPage.setStyle("-fx-fill: white;");
		exercisesPage.setCursor(Cursor.HAND);
	}
	
	/**
	 * Reverts the text fill color when the mouse goes away from the Exercise Logs text.
	 */
	@FXML
	private void onMouseExited_Exercises() {
		exercisesPage.setStyle("-fx-fill: #797979;");
	}
	
	/**
	 * Loads the Exercise Logs page when the Exercise Logs text is clicked on.
	 */
	@FXML
	private void LoadExercisesPage() {
		try {
			AnchorPane newPane = FXMLLoader.load(getClass().getResource("/exerciselogs/ExerciseLogs.fxml"));
			rootPane.getChildren().setAll(newPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Adjusts the text fill color when the mouse goes over the Create Exercise Log text.
	 */
	@FXML
	private void onMouseEntered_CreateExerciseLog() {
		createExerciseLogPage.setStyle("-fx-fill: white;");
		createExerciseLogPage.setCursor(Cursor.HAND);
	}
	
	/**
	 * Reverts the text fill color when the mouse goes away from the Create Exercise Log text.
	 */
	@FXML
	private void onMouseExited_CreateExerciseLog() {
		createExerciseLogPage.setStyle("-fx-fill: #797979;");
	}
	
	/**
	 * Loads the Exercise Logs page when the Create Exercise Log text is clicked on.
	 */
	@FXML
	private void LoadCreateExerciseLogPage() {
		try {
			AnchorPane newPane = FXMLLoader.load(getClass().getResource("/createexerciselog/CreateExerciseLog.fxml"));
			rootPane.getChildren().setAll(newPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Adjusts the text fill color when the mouse goes over the Create User text.
	 */
	@FXML
	private void onMouseEntered_CreateUser() {
		createUserPage.setStyle("-fx-fill: white;");
		createUserPage.setCursor(Cursor.HAND);
	}
	
	/**
	 * Reverts the text fill color when the mouse goes away from the Create User text.
	 */
	@FXML
	private void onMouseExited_CreateUser() {
		createUserPage.setStyle("-fx-fill: #797979;");
	}
	
	/**
	 * Loads the Exercise Logs page when the Create User text is clicked on.
	 */
	@FXML
	private void LoadCreateUserPage() {
		try {
			AnchorPane newPane = FXMLLoader.load(getClass().getResource("/createUser/CreateUser.fxml"));
			rootPane.getChildren().setAll(newPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * The method is run when the Create User button is clicked.
	 * It creates a new user in the system.
	 */
	@FXML
	private void createUser() {
		createUserModel.sqlCreateUser(userBox.getText());
	}
}
