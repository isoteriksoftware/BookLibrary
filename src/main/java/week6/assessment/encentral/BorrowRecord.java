package week6.assessment.encentral;

import java.util.Comparator;

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

    public static class BorrowRecordComparator implements Comparator<BorrowRecord> {
        @Override
        public int compare(BorrowRecord record1, BorrowRecord record2) {
            return Float.compare(record1.getBorrower().getPriority(),
                    record2.getBorrower().getPriority());
        }
    }
}
