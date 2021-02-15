package createexerciselog;

import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Defines the structure of each exercise log in the exercises table of the exercise_tracker_database database.
 */
public class ExerciseLogData {
	
	private IntegerProperty id;
	private StringProperty user;
	private StringProperty description;
	private IntegerProperty duration;
	private StringProperty date;
	
	/**
	 * Each exercise log of type ExerciseLogData will the id of each exercise log, a user, the description of the exercise,
	 * the duration of the exercise, and the date the exercise was done.
	 * The id is used for referencing a specific exercise when deleting an exercise log, and the other variables are used in the cell values 
	 * that they correspond to in the database table view using the ExerciseLogsController class and ExerciseLogs FXML file. 
	 * @param id
	 * @param user
	 * @param description
	 * @param duration
	 * @param date
	 */
	public ExerciseLogData(Integer id, String user, String description, Integer duration, String date) {
		
		this.id = new SimpleIntegerProperty(id);
		this.user = new SimpleStringProperty(user);
		this.description = new SimpleStringProperty(description);
		this.duration = new SimpleIntegerProperty(duration);
		this.date = new SimpleStringProperty(date);
	}
	
	/**
	 * The getter class for the IntegerProperty id variable.
	 * @return
	 */
	public Integer getID() {
		return id.get();
	}
	
	/**
	 * The IntegerProperty class for the IntegerProperty id variable.
	 * @return
	 */
	public IntegerProperty idProperty() {
		return id;
	}
	
	/**
	 * The setter class for the IntegerProperty id variable.
	 * @param user
	 */
	public void setID(Integer id) {
		this.id.set(id);
	}
	
	/**
	 * The getter class for the StringProperty user variable.
	 * @return
	 */
	public String getUser() {
		return user.get();
	}
	
	/**
	 * The StringProperty class for the StringProperty user variable.
	 * @return
	 */
	public StringProperty userProperty() {
		return user;
	}
	
	/**
	 * The setter class for the StringProperty user variable.
	 * @param user
	 */
	public void setUsername(String user) {
		this.user.set(user);
	}
	
	/**
	 * The getter class for the StringProperty description variable.
	 * @return
	 */
	public String getDescription() {
		return description.get();
	}
	
	/**
	 * The StringProperty class for the StringProperty description variable.
	 * @return
	 */
	public StringProperty descriptionProperty() {
		return description;
	}
	
	/**
	 * The setter class for the StringProperty description variable.
	 * @param user
	 */
	public void setDescription(String description) {
		this.description.set(description);
	}
	
	/**
	 * The getter class for the IntegerProperty duration variable.
	 * @return
	 */
	public Integer getDuration() {
		return duration.get();
	}
	
	/**
	 * The IntegerProperty class for the IntegerProperty duration variable.
	 * @return
	 */
	public IntegerProperty durationProperty() {
		return duration;
	}
	
	/**
	 * The setter class for the IntegerProperty duration variable.
	 * @param user
	 */
	public void setDuration(Integer duration) {
		this.duration.set(duration);
	}
	
	/**
	 * The getter class for the StringProperty date variable.
	 * @return
	 */
	public String getDate() {
		return date.get();
	}
	
	/**
	 * The StringProperty class for the StringProperty date variable.
	 * @return
	 */
	public StringProperty dateProperty() {
		return date;
	}
	
	/**
	 * The setter class for the StringProperty date variable.
	 * @param user
	 */
	public void setDate(String date) {
		this.date.set(date);
	}

	
}
