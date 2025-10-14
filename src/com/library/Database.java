package com.library;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/library_db";
    private static final String USER = "root"; // replace with your username
    private static final String PASSWORD = ""; // replace with your password

    private Connection conn;

    public Database() {
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addBook(String title, String author) {
        String sql = "INSERT INTO books(title, author) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.executeUpdate();
            System.out.println("Book added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                books.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getBoolean("is_issued")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public void issueBook(int id) {
        String sqlCheck = "SELECT is_issued FROM books WHERE id = ?";
        String sqlUpdate = "UPDATE books SET is_issued = TRUE WHERE id = ?";
        try (PreparedStatement checkStmt = conn.prepareStatement(sqlCheck);
             PreparedStatement updateStmt = conn.prepareStatement(sqlUpdate)) {

            checkStmt.setInt(1, id);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && !rs.getBoolean("is_issued")) {
                updateStmt.setInt(1, id);
                updateStmt.executeUpdate();
                System.out.println("Book issued successfully!");
            } else {
                System.out.println("Book is already issued or doesn't exist!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void returnBook(int id) {
        String sqlUpdate = "UPDATE books SET is_issued = FALSE WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sqlUpdate)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Book returned successfully!");
            else System.out.println("Book not found!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
