import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;


public class RemoveBook {

    private List<Book> catalog;

    public RemoveBook() {
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
     * Removes a book from the catalog.
     * @param isbn The ISBN of the book to be removed.
     */
    public void removeBook(String isbn) {
        for (Book book : catalog) {
            if (book.getIsbn().equals(isbn)) {
                catalog.remove(book);
                System.out.println("Book removed successfully.");
                return;
            }
        }
        System.out.println("Book with ISBN " + isbn + " not found in catalog.");
    }

    public void removeBookByTitle(String title) {
        Iterator<Book> iterator = catalog.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getTitle().equals(title)) {
                iterator.remove();
                System.out.println("Book with title '" + title + "' removed successfully.");
                return;
            }
        }
        System.out.println("Book with title '" + title + "' not found in catalog.");
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
     * Main method for testing the RemoveBook class.
     */
    public static void main(String[] args) {

        
        
        RemoveBook removeBook = new RemoveBook();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome, Administrator!");

        // Adding books (for testing)
        removeBook.addBook("Book1", "Author1", "1234567890", 29.99);
        removeBook.addBook("Book2", "Author2", "0987654321", 19.99);

        // Displaying catalog (for testing)
        removeBook.displayCatalog();

        System.out.print("\nEnter ISBN of the book to be removed: ");
        String isbn = scanner.nextLine();

       


        removeBook.removeBook(isbn);
         System.out.print("\nEnter title of the book to be removed: ");
        String title = scanner.nextLine();
        removeBook.removeBookByTitle(title);
        // Displaying updated catalog (for testing)
        removeBook.displayCatalog();

        // Accessing catalog using the getter method
        List<Book> catalog = removeBook.getCatalog();
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
        public String getTitle() {
            return title;
        }

        public String getIsbn() {
            return isbn;
        }

        @Override
        public String toString() {
            return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Price: $" + price;
        }
    }
}
