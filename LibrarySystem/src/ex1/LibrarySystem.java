package ex1;

import java.util.Scanner;

class Book {
    private int bookID;
    private String title;
    private String author;
    private boolean isAvailable;

    // Constructor
    public Book(int bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isAvailable = true; // By default, the book is available
    }

    // Getters and Setters
    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    // toString method to display book details
    @Override
    public String toString() {
        return "Book ID: " + bookID + ", Title: " + title + ", Author: " + author + ", Available: " + (isAvailable ? "Yes" : "No");
    }
}

class Library {
    private Book[] books;
    private int count;

    // Constructor to initialize the library with a certain capacity
    public Library(int capacity) {
        books = new Book[capacity];
        count = 0;
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        if (count < books.length) {
            books[count] = book;
            count++;
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    // Method to remove a book by its ID
    public void removeBook(int bookID) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (books[i].getBookID() == bookID) {
                found = true;
                books[i] = books[count - 1]; // Replace with last book
                books[count - 1] = null; // Remove last book
                count--;
                System.out.println("Book removed successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found.");
        }
    }

    // Method to search for a book by its ID
    public Book searchBook(int bookID) {
        for (int i = 0; i < count; i++) {
            if (books[i].getBookID() == bookID) {
                return books[i];
            }
        }
        return null;
    }

    // Method to display all books in the library
    public void displayBooks() {
        if (count == 0) {
            System.out.println("No books in the library.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(books[i]);
            }
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library(5); // Create a library with a capacity of 5 books

        boolean running = true;

        while (running) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book by ID");
            System.out.println("4. Display All Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = scanner.nextLine();
                    Book book = new Book(id, title, author);
                    library.addBook(book);
                    break;

                case 2:
                    System.out.print("Enter Book ID to remove: ");
                    int removeID = scanner.nextInt();
                    library.removeBook(removeID);
                    break;

                case 3:
                    System.out.print("Enter Book ID to search: ");
                    int searchID = scanner.nextInt();
                    Book foundBook = library.searchBook(searchID);
                    if (foundBook != null) {
                        System.out.println("Book found: " + foundBook);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    System.out.println("Displaying all books:");
                    library.displayBooks();
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting the system.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
