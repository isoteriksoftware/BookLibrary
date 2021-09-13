package week6.assessment.encentral;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LibrarianTest {
    static Librarian librarian = new Librarian();
    static String bookName = "Test", author = "Tester";

    @BeforeClass
    public static void addBook() {
        librarian.addBook(bookName, author);
    }

    @Test
    public void testAddBorrowRequest() {
        Borrower jss1Student = new Student(Student.Level.JSS1);
        Borrower ss3Student = new Student(Student.Level.SS3);
        Borrower teacher = new Teacher();

        librarian.addBorrowRequest(jss1Student, bookName, author);
        librarian.addBorrowRequest(teacher, bookName, author);
        librarian.addBorrowRequest(ss3Student, bookName, author);

        assertEquals("Borrow Requests equals 3", 3, librarian.getBorrowRequestsCount());
    }

    @Test
    public void testProcessBorrowRequests() {
        librarian.processBorrowRequests();

        assertEquals("Borrow Requests equals 0", 0, librarian.getBorrowRequestsCount());

        BorrowRecord record1 = librarian.getBorrowRecords().get(0);
        BorrowRecord record2 = librarian.getBorrowRecords().get(1);
        BorrowRecord record3 = librarian.getBorrowRecords().get(2);

        assertTrue("Teacher was borrowed first", record1.getBorrower() instanceof Teacher);
        assertTrue("SS3 Student was borrowed next", record2.getBorrower() instanceof Student
                && ((Student)record2.getBorrower()).getLevel() == Student.Level.SS3);
        assertTrue("JSS1 Student was borrowed last", record3.getBorrower() instanceof Student
                && ((Student)record3.getBorrower()).getLevel() == Student.Level.JSS1);
    }
}















