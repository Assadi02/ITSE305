import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestRemoveBook {

    private RemoveBook removeBook;

    @Before
    public void setUp() {
        removeBook = new RemoveBook();
        removeBook.addBook("Book1", "Author1", "1234567890", 29.99);
        removeBook.addBook("Book2", "Author2", "0987654321", 19.99);
    }

    @Test
    public void testRemoveBook() {
        assertEquals(2, removeBook.getCatalog().size());

        removeBook.removeBook("1234567890");

        assertEquals(1, removeBook.getCatalog().size());
    }

    @Test
    public void testRemoveNonExistingBook() {
        assertEquals(2, removeBook.getCatalog().size());

        removeBook.removeBook("1111111111");

        assertEquals(2, removeBook.getCatalog().size());
    }

    @Test
    public void testCatalogSizeAfterRemoval() {
        assertEquals(2, removeBook.getCatalog().size());

        removeBook.removeBook("1234567890");

        assertEquals(1, removeBook.getCatalog().size());

        removeBook.removeBook("0987654321");

        assertEquals(0, removeBook.getCatalog().size());
    }
}
