 <h1 align="center">Exercise Tracker</h1>

 <br>

## About The Project

<img src = "screenshots/main_page.PNG">

This is a website that functions as an exercise log. It was created using the MERN stack, which combines MongoDB, Express, React, and Node JS. 

For the backend, a database called Exercise_Tracker_Database is used, along side a collection called exercises and a collection called users. The exercises collection stores logged exercises and the users collection stores crated users. There is a schema for each user and a schema for each student. The database portion of the project was done in MongoDB.

Each user in the users schema has a String type entry to refer to their names. Each exercise in the exercise schema has a username, description, duration and date field.
Along with the database, Express was used as the Node JS framework, Node was used as the JavaScript Web Server, and MongoDB was used as the document database. The respective files for the backend are in the backend folder and are as follows:
* The .env file contains the connection string used to connect to the MongoDB database.
* The server.js file is used for connecting to the Exercise_Tracker_Database by opening the connection, importing the respective routes, and starting the server.
* The user.model.js file located in the models folder contains the model for each user entry.
* The exercise.model.js file located in the model folder contains the model for each exercise entry.
* The users.js file located in the routes folder contains all of the respective routes for the user collection in the Exercise_Tracker_Database.
* The exercises.js file located in the routes folder contains all of the respective routes for the exercise collection in the Exercise_Tracker_Database.

For the frontend, React was used for the client-side JavaScript framework. It's made up of the following files in the src folder:
* Index.js is the main page of the program, it renders the contents of the App.js file
* App.js combines all of the component files from the component folder.
* navbar.component.js located in the components folder contains the navbar that is shown at the top of each page. It provides links to the other pages of the website
* exercise-list.component.js located in the components folder displays all of the exercises. 
* create-user.component.js located in the components folder contains the page where a user can create a new user
* create-exercise.component.js located in the components folder contains the page where a user can create a new exercise log in the list of logged exercises
* edit-exercise.component.js located in the components folder contains the page that is displayed when a user selects the option to edit an exercise log

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
