package login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dbutil.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * The controller for the Login FXML responsible for displaying the login window.
 */
public class LoginController implements Initializable{

	//object for accessing the DatabaseConnection class
	DatabaseConnection databaseConnection = new DatabaseConnection();
	//object for accessing the LoginModel class
	LoginModel loginModel = new LoginModel();
	
	/**
	 * Displays a message indicating whether or not the application is connected to the database.
	 */
	@FXML
	private Label databaseStatus;
	
	/**
	 * The username prompt field.
	 */
	@FXML
	private TextField usernameBox;
	
	/**
	 * The password prompt field.
	 */
	@FXML
	private PasswordField passwordBox;
	
	/**
	 * This label appears beside the login button and informs the user if they have entered incorrect credentials.
	 */
	@FXML
	private Label loginStatus;
	
	/**
	 * The button for attempting to login to the system using correct credentials.
	 */
	@FXML
	private Button loginButton;
	
	/**
	 * Initializes the window to state whether there is an active database connection as defined in the DatabaseConnection class.
	 * If there is a connection, "Connected to Database" will appear in the databaseStatus label.
	 * If a connection cannot be made, "Not Connected to Database" will appear in the databaseStatus label.
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if (loginModel.isConnected()) {
			databaseStatus.setText("Connected to Database");
		}
		else {
			databaseStatus.setText("Not connected to database");
		}
	
	}
	
	/**
	 * Executed when the Login button is pressed.
	 * The method will check if the username and password that have been entered are valid by
	 * checking if they correspond to entries in the login table.
	 * If they do, the current window will close and the adminLogin method will be run.
	 * Otherwise, a loginStatus label will output the text "Wrong credentials!".
	 * @param event
	 * @throws Exception
	 */
	@FXML
	private void login(ActionEvent event) throws Exception {
		if (loginModel.credentialCheck(usernameBox.getText(), passwordBox.getText())) {
			Stage stage = (Stage)loginButton.getScene().getWindow();
			stage.close();
			authenticatedUserLogin();
		}
		else {
			loginStatus.setText("Wrong" + "\n" + "credentials!");
		}
	}
	
	/**
	 * Creates a new window that will load the Exercise Tracker, which is the main page of the system, using the ExerciseLogs FXML file.
	 */
	private void authenticatedUserLogin() {
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