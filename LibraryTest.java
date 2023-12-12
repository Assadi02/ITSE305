import org.junit.*;
import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void testAddBook() {
        AddBook addBook = new AddBook();
        addBook.addBook("TestBook", "TestAuthor", "123456789", 19.99);
        assertEquals(1, addBook.getCatalog().size());
    }

    @Test
    public void testBuyBook() {
        BuyBook buyBook = new BuyBook();
        buyBook.addBook("TestBook", "TestAuthor", "123456789", 19.99);
        buyBook.selectBook("123456789");
        assertEquals(1, buyBook.getShoppingCart().size());

        buyBook.checkout();
        assertEquals(0, buyBook.getShoppingCart().size());
    }

    @Test
    public void testRegistrationSystem() {
        RegistrationSystem registrationSystem = new RegistrationSystem();
        assertTrue(registrationSystem.registerUser("testUser", "testPassword"));
        assertTrue(registrationSystem.validateUser("testUser", "testPassword"));
        assertFalse(registrationSystem.registerUser("testUser", "newPassword"));
        assertFalse(registrationSystem.validateUser("testUser", "wrongPassword"));
    }

    @Test
    public void testRemoveBook() {
        RemoveBook removeBook = new RemoveBook();
        removeBook.addBook("TestBook", "TestAuthor", "123456789", 19.99);
        removeBook.removeBook("123456789");
        assertEquals(0, removeBook.getCatalog().size());
    }
}
