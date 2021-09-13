package week6.assessment.encentral;

import java.util.Comparator;

/**
 * Stores the record of a single borrow event.
 */
public class BorrowRecord {
    private Book book;
    private Borrower borrower;

    public BorrowRecord(Book book, Borrower borrower) {
        this.book = book;
        this.borrower = borrower;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    /**
     * Compares records based on the priority of the borrower
     */
    public static class BorrowRecordComparator implements Comparator<BorrowRecord> {
        @Override
        public int compare(BorrowRecord record1, BorrowRecord record2) {
            float p1 = record1.getBorrower().getPriority();
            float p2 = record2.getBorrower().getPriority();

            return Float.compare(p2, p1);
        }
    }
}
