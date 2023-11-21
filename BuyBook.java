import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuyBook {

    private List<Book> catalog;
    private List<Book> shoppingCart;

    public BuyBook() {
        this.catalog = new ArrayList<>();
        this.shoppingCart = new ArrayList<>();
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
     * Allows the user to select a book to add to their shopping cart.
     * @param isbn The ISBN of the selected book.
     */
    public void selectBook(String isbn) {
        for (Book book : catalog) {
            if (book.getIsbn().equals(isbn)) {
                shoppingCart.add(book);
                System.out.println("Book added to shopping cart.");
                return;
            }
        }
        System.out.println("Book with ISBN " + isbn + " not found in catalog.");
    }

    /**
     * Displays the current contents of the shopping cart.
     */
    public void displayShoppingCart() {
        
        if (shoppingCart.isEmpty()) {
            System.out.println("Your shopping cart is empty.");
        } else {
            System.out.println("Shopping Cart:");
            for (Book book : shoppingCart) {
                System.out.println(book);
            }
        }
    }

    /**
     * Proceeds to checkout and completes the purchase transaction.
     */
    public void checkout() {
        if (shoppingCart.isEmpty()) {
            System.out.println("Your shopping cart is empty. Add books before proceeding to checkout.");
        } else {
            double totalAmount = 0;
            for (Book book : shoppingCart) {
                totalAmount += book.getPrice();
            }
            System.out.println("Total amount: $" + totalAmount);
            System.out.println("Checkout completed. Thank you for your purchase!");
            shoppingCart.clear(); // Clear the shopping cart after purchase
        }
    }

    /**
     * Main method for testing the BuyBook class.
     */
    public static void main(String[] args) {
        BuyBook buyBook = new BuyBook();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome, User!");

        // Adding books for testing
        buyBook.addBook("Book1", "Author1", "1234567890", 29.99);
        buyBook.addBook("Book2", "Author2", "0987654321", 19.99);

        // Displaying catalog (for testing)
        buyBook.displayCatalog();

        System.out.print("\nEnter ISBN of the book you want to buy: ");
        String isbn = scanner.nextLine();

        buyBook.selectBook(isbn);

        // Displaying updated shopping cart (for testing)
        buyBook.displayShoppingCart();

        // Proceed to checkout (for testing)
        buyBook.checkout();

        // Displaying empty shopping cart after checkout (for testing)
        buyBook.displayShoppingCart();

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

        public String getIsbn() {
            return isbn;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Price: $" + price;
        }
    }
}