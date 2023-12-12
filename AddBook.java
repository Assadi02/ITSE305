import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddBook {

    private List<Book> catalog;

    public AddBook() {
        this.catalog = new ArrayList<>();
    }

    /**
     * Adds a new book to the catalog.
     * @param title The title of the book.
     * @param author The author of the book.
     * @param isbn The ISBN of the book.
     * @param price The price of the book.
     */
    public void addBook(String title, String author, String isbn, double price) {
        Book newBook = new Book(title, author, isbn, price);
        catalog.add(newBook);
        System.out.println("Book added successfully.");
    }

    /**
     * Displays the current catalog of books.
     */
    public void displayCatalog() {
        if (catalog.isEmpty()) {
            System.out.println("The catalog is empty.");
        } else {
            System.out.println("Catalog:");
            for (Book book : catalog) {
                System.out.println(book);
            }
        }
    }

    /**
     * Gets the current catalog of books.
     * @return The catalog of books.
     */
    public List<Book> getCatalog() {
        return catalog;
    }

    /**
     * Main method for testing the AddBook class.
     */
    public static void main(String[] args) {
        AddBook addBook = new AddBook();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome, Administrator!");

        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = Double.parseDouble(scanner.nextLine());

        addBook.addBook(title, author, isbn, price);

        // Displaying catalog
        addBook.displayCatalog();

        // Accessing catalog using the getter method
        List<Book> catalog = addBook.getCatalog();
        System.out.println("Catalog size: " + catalog.size());

        scanner.close();
    }

    /**
     * Inner class representing a book.
     */
    private static class Book {
        private String title;
        private String author;
        private String isbn;
        private double price;

        public Book(String title, String author, String isbn, double price) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Price: $" + price;
        }
    }
}
