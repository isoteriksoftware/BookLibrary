package week6.assessment.encentral;

import static org.junit.Assert.*;
import org.junit.Test;

public class LibraryTest {
    Library library = Library.instance();

    @Test
    public void testAddBooks() {
        library.addBook("Test", "Tester");
        library.addBook("Test2", "Tester");

        assertEquals("Two books available", 2, library.getBooks().size());
    }

    @Test
    public void testAddSameBook() {
        library.addBook("Test", "Tester");

        assertEquals("Books available should still be two", 2, library.getBooks().size());
    }

    @Test
    public void testRemoveBook() {
        library.removeBook("Test2", "Tester", 1);
        assertEquals("Books available should be one now", 1, library.getBooks().size());

        library.removeBook("Test", "Tester", 1);
        assertEquals("Books available should still be one", 1, library.getBooks().size());

        library.removeBook("Test", "Tester", 1);
        assertEquals("Books available should be none", 0, library.getBooks().size());
    }
}


















