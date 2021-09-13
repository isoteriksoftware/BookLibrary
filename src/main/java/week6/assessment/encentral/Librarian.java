package week6.assessment.encentral;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Librarian {
    private PriorityQueue<BorrowRecord> borrowRequests;
    private List<BorrowRecord> borrowRecords;

    private final Library library;
    private final Logger logger;

    public Librarian() {
        borrowRequests = new PriorityQueue<>(new BorrowRecord.BorrowRecordComparator());
        borrowRecords = new ArrayList<>();
        library = Library.instance();

        BasicConfigurator.configure();
        logger = LogManager.getLogger(Librarian.class);
    }

    public void addBorrowRequest(Borrower borrower, String bookName, String author) {
        if (!library.isBookAvailable(bookName, author))
            return;

        Book book = library.getBook(bookName, author);
        borrowRequests.add(new BorrowRecord(book, borrower));
    }

    public void addBook(String name, String author) {
        library.addBook(name, author);
    }

    public int getBorrowRequestsCount() {
        return borrowRequests.size();
    }

    public void processBorrowRequests() {
        while (!borrowRequests.isEmpty()) {
            BorrowRecord record = borrowRequests.poll();

            // get the book to be borrowed
            Book book = record.getBook();
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
}


















