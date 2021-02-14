package createUser;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Defines the structure of each user in the users table of the exercise_tracker_database database.
 */
public class UserData {
	private StringProperty user;

	/**
	 * Each user of type UserData will include a user's name.
	 * These will be used in the list of users in the dropdown menu for selecting a user in the Create Exercise Log page.
	 * @param user
	 */
	public UserData(String user) {
		this.user = new SimpleStringProperty(user);
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
	public void setUser(String user) {
		this.user.set(user);
	}
}
