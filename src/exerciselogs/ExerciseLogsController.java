package exerciselogs;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import createexerciselog.ExerciseLogData;
import deleteexerciselog.DeleteExerciseLogController;
import editexerciselog.EditExerciseLogController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * The controller for the ExerciseLogs FXML file responsible for listing the exercise logs in the system.
 */
public class ExerciseLogsController implements Initializable{
	/**
	 * The anchor pane in the ExerciseList FXML file.
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
	 * The table view that will display all of the exercise logs in the system.
	 */
	@FXML
	private TableView<ExerciseLogData> exerciseTable;
	
	/**
	 * The first column in the table view that displays the user for each respective exercise log.
	 */
	@FXML
	private TableColumn<ExerciseLogData, String> userColumn;
	
	/**
	 * The second column in the table view that displays the description of each exercise in the respective exercise log.
	 */
	@FXML
	private TableColumn<ExerciseLogData, String> descriptionColumn;
	
	/**
	 * The third column in the table view that displays the duration of each exercise in the respective exercise log.
	 */
	@FXML
	private TableColumn<ExerciseLogData, Integer> durationColumn;
	
	/**
	 * The fourth column in the table view that displays the date of when each exercise in the respective exercise log was done.
	 */
	@FXML
	private TableColumn<ExerciseLogData, String> dateColumn;
	
	/* 
	 * The data variable will be used to store the ExerciseData entries that are in the database 
	 * to be used in the exerciseTable tableview.
	 */
	private ObservableList<ExerciseLogData> data;
	/*
	 * The selectedRowData will be used to store the data in the row that the respective button is clicked on
	 */
	private TableRow<ExerciseLogData> selectedRowData;
	ExerciseLogsModel adminModel = new ExerciseLogsModel();
	
	/**
	 * This method creates the column in each row that will contain the button to edit exercise logs.
	 */
	private void addEditButtonToTable() {
		TableColumn<ExerciseLogData, Void> editColumn = new TableColumn<ExerciseLogData, Void>("Edit");
		
		Callback<TableColumn<ExerciseLogData, Void>, TableCell<ExerciseLogData, Void>> cellFactory = new Callback<TableColumn<ExerciseLogData, Void>, TableCell<ExerciseLogData, Void>>() {

			@Override
			public TableCell<ExerciseLogData, Void> call(TableColumn<ExerciseLogData, Void> arg0) {
				final TableCell<ExerciseLogData, Void> cell = new TableCell<ExerciseLogData, Void>() {
					private final Button editButton = new Button("Edit");
					{
						editButton.setOnAction((ActionEvent event) -> {
							selectedRowData = getTableRow();
							/*
							 * The listStage variable is used to pass on the current scene information over for use in the scene for the Edit Exercise Log window.
							 */
							Stage listStage = (Stage)editButton.getScene().getWindow();
							
							try {
								//opens the Edit Exercise Log page
								FXMLLoader loader = new FXMLLoader(getClass().getResource("/editexerciselog/EditExerciseLog.fxml"));
								Parent root = loader.load();
								EditExerciseLogController controller = loader.getController();
								/*
								 * The getSelectedRow method passes the current row data and the current stage data over 
								 * for use in the scene for the Edit Exercise Log window.
								 */
								controller.getSelectedRow(selectedRowData.getItem(), listStage);
								Stage editStage = new Stage();
								editStage.setScene(new Scene (root));
								editStage.setTitle("Edit Exercise Log");
								editStage.show();
							} catch (IOException ex) {
								ex.printStackTrace();
							}
						});
					}
					
					@Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(editButton);
                        }
                    }
                };
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        };

        editColumn.setCellFactory(cellFactory);
        exerciseTable.getColumns().add(editColumn);

	}
	
	/**
	 * This method creates the column in each row that will contain the button to delete exercise logs.
	 */
	private void addDeleteButtonToTable() {
		TableColumn<ExerciseLogData, Void> deleteColumn = new TableColumn<ExerciseLogData, Void>("Delete");
		
		Callback<TableColumn<ExerciseLogData, Void>, TableCell<ExerciseLogData, Void>> cellFactory = new Callback<TableColumn<ExerciseLogData, Void>, TableCell<ExerciseLogData, Void>>() {

			@Override
			public TableCell<ExerciseLogData, Void> call(TableColumn<ExerciseLogData, Void> arg0) {
				final TableCell<ExerciseLogData, Void> cell = new TableCell<ExerciseLogData, Void>() {
					private final Button deleteButton = new Button("Delete");
					{
						deleteButton.setOnAction((ActionEvent event) -> {
							selectedRowData = getTableRow();
							/*
							 * The listStage variable is used to pass on the current scene information over for use in the scene for the Edit Exercise Log window.
							 */
							Stage listStage = (Stage)deleteButton.getScene().getWindow();
							
							try {
								//opens the Delete Exercise Log page
								FXMLLoader loader = new FXMLLoader(getClass().getResource("/deleteexerciselog/DeleteExerciseLog.fxml"));
								Parent root = loader.load();
								DeleteExerciseLogController controller = loader.getController();
								/*
								 * The getSelectedRow method passes the current row data and the current stage data over 
								 * for use in the scene for the Edit Exercise Log window.
								 */
								controller.getSelectedRow(selectedRowData.getItem(), listStage);
								Stage deleteStage = new Stage();
								deleteStage.setScene(new Scene (root));
								deleteStage.setTitle("Delete Exercise Log");
								deleteStage.show();
							} catch (IOException ex) {
								ex.printStackTrace();
							}
						});
					}
					
					@Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(deleteButton);
                        }
                    }
                };
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        };

        deleteColumn.setCellFactory(cellFactory);
        exerciseTable.getColumns().add(deleteColumn);
	}
	
	/**
	 * This method loads the current exercise log data from the database into the exerciseTable tableview.
	 * It will go through each exerciseLogData element in the ObservableList in the data ObservbleList 
	 * and assign each property of the element to it's respective column in the TableView.
	 */
	private void loadExerciseData() {
		data = adminModel.sqlLoadTable(data);
		
		userColumn.setCellValueFactory(new PropertyValueFactory<ExerciseLogData,String>("user"));
		descriptionColumn.setCellValueFactory(new PropertyValueFactory<ExerciseLogData,String>("description"));
		durationColumn.setCellValueFactory(new PropertyValueFactory<ExerciseLogData,Integer>("duration"));
		dateColumn.setCellValueFactory(new PropertyValueFactory<ExerciseLogData,String>("date"));
		
		addEditButtonToTable();
		addDeleteButtonToTable();
	
		exerciseTable.setItems(data);
	}
	
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
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadExerciseData();
	}
	
}
