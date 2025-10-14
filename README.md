# Library Management System

A **console-based Library Management System** built in **Java** with **MySQL** using **JDBC**.  
This system allows users to **add books, view books, issue books, and return books** in a simple console interface.

---

## Features

- Add new books to the library  
- View all available books  
- Issue a book to a user  
- Return a previously issued book  
- Tracks the issued status of each book  

---

## Project Structure

Library-Management-System/
│
├── src/
│ └── com/library/
│ ├── Main.java
│ ├── Book.java
│ ├── Database.java
│ └── Library.java
│
├── sql/
│ └── library_db.sql
├── README.md
└── .gitignore

yaml
Copy code

---

## Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/Library-Management-System.git
cd Library-Management-System
2. Setup MySQL Database
Open MySQL Workbench or command line.

Run the SQL script:

sql
Copy code
-- Create database
CREATE DATABASE IF NOT EXISTS library_db;

USE library_db;

-- Create books table
CREATE TABLE IF NOT EXISTS books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    is_issued BOOLEAN DEFAULT FALSE
);
3. Configure Database Connection
Open src/com/library/Database.java and update the database credentials:

java
Copy code
private static final String USER = "root";       // Your MySQL username
private static final String PASSWORD = "";       // Your MySQL password
4. Compile and Run
Open terminal in the project root.

Compile all Java files:

bash
Copy code
javac -d bin src/com/library/*.java
Run the program:

bash
Copy code
java -cp bin com.library.Main
Usage
The program will show a console menu:

markdown
Copy code
=== Library Menu ===
1. Add Book
2. View All Books
3. Issue Book
4. Return Book
0. Exit
Enter your choice to perform actions:

Add book → Enter title and author

Issue book → Enter book ID

Return book → Enter book ID

Requirements
Java JDK 8 or higher

MySQL server installed

JDBC connector for MySQL (mysql-connector-java.jar)

