 <h1 align="center">Exercise Tracker</h1>

 <br>

## About The Project

<img src = "screenshots/main_page.PNG">

This is an application that functions as a student database. It was created using Java, JavaFX, the SceneBuilder editor tool, and MySQL.

For the backend, it uses a schema called "exercise_tracker_database", along with a "users" table, an "exercises" table and a "login" table using MySQL Server and Workbench.
* The users table is a table that holds entries that contain the columns <i>user_id</i>, and <i>user</i>. The user_id column is the primary key and it automatically increments. The user column contains the name of a user that can be selected when creating an exercise log. These columns are referencing "User Data" entries.
* The exercises table is a table that holds entries that contain the columns <i>exercise_id</i>, <i>user</i>, <i>description</i>, <i>duration</i>, and <i>date</i>. The ID column is the primary key and it automatically increments, the user column contains the name of a selectable user, the description column contains the description of the exercise, the duration column is how long the exercise was done for (in minutes), and the date column is the date in which the exercise occurs. These columns are referencing "Exercise Log Data" entries.
* The login table is a table that holds entries containing the columns <i>username</i> and <i>password</i>. These columns are referencing username and password login information to enter the system.

For the frond end, it is using the ExerciseTracker-Java project folder. In it's src folder, it contains a dbutil package, a login package, an exerciselogs package, an editexerciselog package, a deleteexerciselog package, a createexerciselog package, and a createuser package. The admin and login package use a model-view-controller pattern to develop each window of the application.
* The dbutil package contains the java class file DatabaseConnection.java, which is used to establish a connection to the MySQL database on the schema "school" by using the appropriate credentials and URL of the database.
* The login package contains LoginModel.java, LoginController.java, Login.java, and Login.fxml. They are the model, controller, view and fxml files respectively for the initial window that appears when the program is launched.
* The admin package contains StudentData.java, AdminModel.java, AdminController.java, and Admin.fxml. The StudentData.java file defines the structure of each student in the database, and the rest of the fles are the model, controller, and fxml files respectively for the window that launches upon successful login into the application via the first window.

## Getting Started

### Prerequisites
The following needed to be installed via commands in the terminal:
* In the main project folder:
```sh 
npx create-react-app folder_name
```

```sh
npm init -y
```

```sh
npm install express cors mongoose dotenv
```

* In the backend folder:

```sh
npm install -g nodemon
```

* In the src folder:
```sh
npm install bootstrap
```

```sh
npm install react-router-dom
```


## Usage
The basic functionality of the website is as follows:

* Run the server file by going to the backend directory and using the following command
```sh
nodemon server
```

* In the main project directory use the following command
```sh
npm start
```

<hr>

* The main page displays all of the logged exercises. From here, a user can either edit or delete an exercise log. Clicking the edit button brings the user to a page where they can edit the exercise log. Clicking delete will delete the exercise log from the list.

<img src = "screenshots/main_page.PNG">

<hr>

* Clicking the Create Exercise Log tab of the navbar on the top of a page will bring the user to the page where they can create a new exercise log.

<img src = "screenshots/create_exercise.PNG">
<img src = "screenshots/main_page_after_create.PNG">

<hr>

* In the edit exercise page, the user can edit any of the aspects of any exercise log. Clicking the Edit Exercise Log button will update the respective exercise log in the Logged Exercises list on the main page of the website.

<img src = "screenshots/edit_exercise.PNG">
<img src = "screenshots/main_page_after_edit.PNG">

<hr>

* Clicking the Exercises tab of the navbar on the top of a page will bring the user to the main page of the website.

<img src = "screenshots/main_page.PNG">

<hr>

* Clicking the Create User tab of the navbar on the top of a page will bring the user to the page where they can create a new user to be entered in the Username section of an exercise log.

<img src = "screenshots/create_user.PNG">

## Resources Used

This project was based off of the following YouTube tutorial: https://www.youtube.com/watch?v=7CqJlxBYj-M
