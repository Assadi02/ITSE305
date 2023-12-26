import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestAddBook 
{
    

    private AddBook addBook;

    @Before
    public void setUp() {
        addBook = new AddBook();
    }

    @Test
    public void testAddBook() {
        assertEquals(0, addBook.getCatalog().size());

        addBook.addBook("Book1", "Author1", "1234567890", 29.99);

        assertEquals(1, addBook.getCatalog().size());
    }

    @Test
    public void testAddDuplicateBook() {
        assertEquals(0, addBook.getCatalog().size());

        addBook.addBook("Book1", "Author1", "1234567890", 29.99);

        assertEquals(1, addBook.getCatalog().size());

        // Attempt to add the same book again
        addBook.addBook("Book1", "Author1", "1234567890", 29.99);

        assertEquals(2, addBook.getCatalog().size());
    }

    @Test
    public void testCatalogSizeAfterMultipleAdditions() {
        assertEquals(0, addBook.getCatalog().size());

        addBook.addBook("Book1", "Author1", "1234567890", 29.99);
        addBook.addBook("Book2", "Author2", "0987654321", 19.99);
        addBook.addBook("Book3", "Author3", "9876543210", 39.99);

        assertEquals(3, addBook.getCatalog().size());
    }
}
