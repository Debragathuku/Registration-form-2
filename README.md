markdown
Copy code
# Registration Form Application

This Java Swing application creates a registration form for users to input their personal details and submit them to a MySQL database. The form includes fields for name, mobile number, date of birth, gender, address, and additional information. Users must accept the terms and conditions before submitting.

## Features

- **User Information**: Allows input of name, mobile number, and address.
- **Date of Birth**: Selectable using dropdowns for day, month, and year.
- **Gender Selection**: Radio buttons to choose between 'Male' and 'Female'.
- **Additional Information**: A large text area for extra details.
- **Terms and Conditions**: Checkbox to accept terms before submission.
- **Database Integration**: Submits the form data to a MySQL database.

## Requirements

- Java Development Kit (JDK) 8 or higher
- MySQL Database
- XAMPP (for local server and database management)

## Installation

1. **Clone the Repository**: Download the project from GitHub.

   ```sh
   git clone https://github.com/yourusername/yourrepository.git
Set Up Database:

Ensure MySQL is running via XAMPP.

Create a database named registration_db.

Execute the following SQL script to create the required table:

sql
Copy code
CREATE TABLE registration (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    mobile VARCHAR(15),
    dob DATE,
    address TEXT,
    gender VARCHAR(10),
    additional_info TEXT
);
Configure Database Connection:

In the RegistrationForm class, update the DriverManager.getConnection URL if your database configuration is different.

java
Copy code
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/registration_db", "root", "");
Compile and Run:

Open the project in NetBeans or another Java IDE.
Build and run the project to start the registration form.
Usage
Open the application.
Fill out the fields for name, mobile number, and address.
Select the date of birth using the dropdown menus.
Choose your gender.
Enter any additional information.
Check the box to accept terms and conditions.
Click the "Submit" button to save the information to the database.
Code Overview
RegistrationForm.java: Contains the main class and Swing components for the registration form.
Database Connection: Handles form submission and inserts data into the MySQL database.
