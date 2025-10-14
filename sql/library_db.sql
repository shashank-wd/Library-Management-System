-- Create database
CREATE DATABASE IF NOT EXISTS library_db;

USE library_db;

-- Create table for books
CREATE TABLE IF NOT EXISTS books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    is_issued BOOLEAN DEFAULT FALSE
);
