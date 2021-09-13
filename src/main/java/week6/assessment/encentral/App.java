package week6.assessment.encentral;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Driver class
 */
public class App {
    public static void main(String[] args) {

        // Create a librarian
        Librarian librarian = new Librarian();
        Library library = Library.instance();

        // Populate the library
        librarian.populateLibrary();

        // Create borrowers
        List<Borrower> borrowers = new ArrayList<>();
        borrowers.add(new Student(Student.Level.JSS2));
        borrowers.add(new Teacher());
        borrowers.add(new Student(Student.Level.SS1));

        // Borrow some books
        String genericBookNamePrefix = "The Ultimate Book ";
        String genericBookAuthorPrefix = "Author ";

        Random random = new Random();

        for (int i = 1; i <= 20; i++) {
            int r = random.nextInt(20) + 1;

            Borrower borrower = borrowers.get(random.nextInt(borrowers.size()));
            Book book = library.getBook(genericBookNamePrefix + r,
                    genericBookAuthorPrefix + r);

            librarian.addBorrowRequest(borrower, book.getName(), book.getAuthor());
        }

        // Process the borrow requests
        librarian.processBorrowRequests();
    }
}















