# To-Do List App

A simple and intuitive To-Do List application built using **HTML**, **CSS**, and **JavaScript** for the front-end, with **Spring Boot** for the back-end and **MySQL** for data storage. This app allows users to add, delete, and mark tasks as complete.

## Features
- **Task Creation**: Users can add new tasks to the list.
- **Task Deletion**: Tasks can be deleted once completed or if no longer needed.
- **Mark as Complete**: Users can mark tasks as completed, with a visual change indicating their status.
- **Minimalistic Design**: The app uses plain HTML and CSS to deliver a clean, simple, and user-friendly experience.

## Tech Stack
- **Frontend**: HTML, CSS, JavaScript
- **Backend**: Spring Boot (Java)
- **Database**: MySQL

## Getting Started

### Prerequisites
- **Java**: Ensure you have Java installed to run the Spring Boot application.
- **MySQL**: Set up MySQL for task data storage.

### Installation

1. Clone this repository to your local machine:
   ```bash
   git clone https://github.com/your-username/todo-app.git
   
2. Set Up MySQL Database:
Install MySQL on your system if you haven't already.
Create a new database for the application (e.g., todo_app_db).
Update the application.properties file in the src/main/resources folder with your database connection details:
properties

spring.datasource.url=jdbc:mysql://localhost:3306/todo_app_db 

spring.datasource.username=your_mysql_username 

spring.datasource.password=your_mysql_password 

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver 

spring.jpa.hibernate.ddl-auto=update 

spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect 

Replace your_mysql_username and your_mysql_password with your MySQL credentials. 

3. Navigate to the backend folder and run the Spring Boot application:
   ```bash
   ./mvnw spring-boot:run

4. For the front-end:
   Navigate to the frontend folder.
   Open the index.html file in your browser to view the app.
