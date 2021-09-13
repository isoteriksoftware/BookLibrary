package week6.assessment.encentral;

import static org.junit.Assert.*;
import org.junit.Test;

public class BookTest {
    Book book1 = new Book("TestBook", "Tester");
    Book book2 = new Book("TestBook2", "Tester");

    @Test
    public void testBooksEquality() {
        assertNotEquals("Book1 != Book2", book1, book2);
    }

    @Test
    public void testBooksIDIncrement() {
        assertTrue("Book2 ID > Book1 ID", book1.getId() > book2.getId());
    }

    @Test
    public void testBookBorrowing() {
        assertEquals("Copies should be 1", 1, book1.getCopies());

        book1.addCopies(1);

        assertEquals("Copies should be 2", 2, book1.getCopies());

        book1.borrow(2);

        assertEquals("Copies should be 0", 0, book1.getCopies());
    }
}















