# Registration Form Project

## Description

This project is a Java Swing application for user registration. It includes a form where users can enter their details such as name, mobile number, date of birth, gender, address, and additional information. The data is then stored in a MySQL database. The form also features an area on the right side that displays the filled-in information in a vertical format.

## Features

- **User Registration Form**: Collects user details including name, mobile number, date of birth, gender, address, and additional information.
- **Database Integration**: Stores user information in a MySQL database.
- **Real-Time Data Display**: Shows entered data on the right side of the form.

## Requirements

- **Java Development Kit (JDK)**: Version 8 or above.
- **NetBeans IDE**: For running and editing the Java code.
- **XAMPP**: For managing the MySQL database.

## Setup Instructions

1. **Set Up the Database**

   - Open XAMPP and start the MySQL server.
   - Access phpMyAdmin from [http://localhost/phpmyadmin](http://localhost/phpmyadmin).
   - Create a new database named `registration_db`.
   - Execute the following SQL script to create the table:

     ```sql
     CREATE TABLE `registration` (
         id INT AUTO_INCREMENT PRIMARY KEY,
         name VARCHAR(255),
         mobile VARCHAR(255),
         dob DATE,
         address TEXT,
         gender VARCHAR(50),
         additional_info TEXT
     );
     ```

2. **Configure Database Connection**

   - Open `RegistrationForm.java` in NetBeans.
   - Update the database connection settings in the code if needed:

     ```java
     Connection con = DriverManager.getConnection(
             "jdbc:mysql://localhost:3306/registration_db", "root", "");
     ```

3. **Run the Application**

   - Compile and run `RegistrationForm.java` in NetBeans.
   - The application will display a registration form where users can enter their information.
