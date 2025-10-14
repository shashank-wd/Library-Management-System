package com.library;

import java.util.List;
import java.util.Scanner;

public class Library {
    private Database db;
    private Scanner sc;

    public Library() {
        db = new Database();
        sc = new Scanner(System.in);
    }

    public void start() {
        int choice = -1;
        do {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addBook();
                case 2 -> viewBooks();
                case 3 -> issueBook();
                case 4 -> returnBook();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    private void addBook() {
        System.out.print("Enter book title: ");
        String title = sc.nextLine();
        System.out.print("Enter author: ");
        String author = sc.nextLine();
        db.addBook(title, author);
    }

    private void viewBooks() {
        List<Book> books = db.getAllBooks();
        books.forEach(System.out::println);
    }

    private void issueBook() {
        System.out.print("Enter book ID to issue: ");
        int id = sc.nextInt();
        db.issueBook(id);
    }

    private void returnBook() {
        System.out.print("Enter book ID to return: ");
        int id = sc.nextInt();
        db.returnBook(id);
    }
}
