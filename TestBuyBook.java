import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestBuyBook {

    private BuyBook buyBook;

    @Before
    public void setUp() {
        buyBook = new BuyBook();
        buyBook.addBook("Book1", "Author1", "1234567890", 29.99);
        buyBook.addBook("Book2", "Author2", "0987654321", 19.99);
    }

    @Test
    public void testSelectBook() {
        assertEquals(0, buyBook.getShoppingCart().size());

        buyBook.selectBook("1234567890");

        assertEquals(1, buyBook.getShoppingCart().size());
    }

    @Test
    public void testSelectNonExistingBook() {
        assertEquals(0, buyBook.getShoppingCart().size());

        buyBook.selectBook("1111111111");

        assertEquals(0, buyBook.getShoppingCart().size());
    }

    @Test
    public void testCheckout() {
        assertEquals(0, buyBook.getShoppingCart().size());

        buyBook.selectBook("1234567890");
        buyBook.selectBook("0987654321");

        assertEquals(2, buyBook.getShoppingCart().size());

        buyBook.checkout();

        assertEquals(0, buyBook.getShoppingCart().size());
    }

    @Test
    public void testCheckoutEmptyCart() {
        assertEquals(0, buyBook.getShoppingCart().size());

        buyBook.checkout(); // Try to checkout with an empty cart

        assertEquals(0, buyBook.getShoppingCart().size());
    }
}
