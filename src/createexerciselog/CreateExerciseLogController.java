package createexerciselog;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * The controller for the CreateExerciseLog FXML file responsible for creating users to choose from in the system.
 */
public class CreateExerciseLogController implements Initializable{
	/**
	 * The anchor pane in the CreateExerciseLog FXML file.
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
	 * The dropdown menu of users to choose from.
	 */
	@FXML
	private ComboBox<String> userList;
	
	/**
	 * The prompt for entering the description of the exercise.
	 */
	@FXML
	private TextField descriptionBox;
	
	/**
	 * The prompt for entering the duration of the exercise.
	 */
	@FXML
	private TextField durationBox;
	
	/**
	 * The prompt for choosing the date the exercise was done.
	 */
	@FXML
	private DatePicker dateBox;
	
	CreateExerciseLogModel createExerciseLogModel = new CreateExerciseLogModel();
	//the ObservableList that will hold the extracted list of users from the users table
	private ObservableList<String> userData;
	
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
	 * Adds the extracted users from the users table into the userData ObservableList to be used in the userList ComboBox.
	 */
	private void initializeUserList() {
		userData = createExerciseLogModel.sqlLoadUserData(userData);
		userList.setItems(userData);
	}
	
	/**
	 * This method is used when the Create Exercise Log button is clicked.
	 * It creates an exercise log in the system.
	 */
	@FXML
	private void createExerciseLog() {
		createExerciseLogModel.sqlCreateExerciseLog(userList.getValue(),descriptionBox.getText(),durationBox.getText(),dateBox.getEditor().getText());
	}
	
	/**
	 * Loads the user dropdown menu values on initialization of the page.
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initializeUserList();
	}
}
