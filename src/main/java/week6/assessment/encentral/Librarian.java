package week6.assessment.encentral;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * A librarian is responsible for adding books to the library and also lending out books.
 * Borrow requests are queued as they are received. The requests are later processed by the librarian when there are
 * no longer any new request being added
 */
public class Librarian {
    // A queue of borrow requests
    private final PriorityQueue<BorrowRecord> borrowRequests;

    // A list of borrow records
    private final List<BorrowRecord> borrowRecords;

    private final Library library;
    private final Logger logger;

    public Librarian() {
        borrowRequests = new PriorityQueue<>(new BorrowRecord.BorrowRecordComparator());
        borrowRecords = new ArrayList<>();
        library = Library.instance();

        BasicConfigurator.configure();
        logger = LogManager.getLogger("Librarian");
    }

    /**
     * Adds a new borrow request
     * @param borrower the borrower
     * @param bookName the name of the book to borrow
     * @param author the author of the book to borrow
     */
    public void addBorrowRequest(Borrower borrower, String bookName, String author) {
        if (!library.isBookAvailable(bookName, author))
            return;

        Book book = library.getBook(bookName, author);
        borrowRequests.add(new BorrowRecord(book, borrower));
        logger.info(String.format("%s wants to borrow %s", borrower, book));
    }

    /**
     * Adds a new book to the library
     * @param name the name of the book to add
     * @param author the author of the book to add
     */
    public void addBook(String name, String author) {
        library.addBook(name, author);
    }

    public int getBorrowRequestsCount() {
        return borrowRequests.size();
    }

    /**
     * Processes all the queued borrow requests
     */
    public void processBorrowRequests() {
        while (!borrowRequests.isEmpty()) {
            BorrowRecord record = borrowRequests.poll();

            // get the book to be borrowed
            Book book = record.getBook();
            logger.info(String.format("Attempting to borrow %s to %s...", book, record.getBorrower()));

            if (!library.isBookAvailable(book.getName(), book.getAuthor()))
                logger.info("book taken");
            else {
                book.borrow(1);
                logger.info(String.format("Book %s borrowed to %s", book, record.getBorrower()));
                borrowRecords.add(record);
            }
        }
    }

    public List<BorrowRecord> getBorrowRecords() {
        return borrowRecords;
    }

    /**
     * Automatically populates the library with default books
     */
    public void populateLibrary() {
        Random random = new Random();

        // Add new books
        for (int i = 1; i <= 20; i++) {
            addBook("The Ultimate Book " + i, "Author " + i);
        }

        // Add more copies of some books (with possibly different authors)
        for (int i = 1; i <= 10; i++) {
            int r = random.nextInt(20) + 1;
            Book book = library.getBook("The Ultimate Book " + r,
                      "Author " + r);

            addBook(book.getName(), "Author " + i);
        }
    }
}


















