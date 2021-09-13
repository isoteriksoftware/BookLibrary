package week6.assessment.encentral;

/**
 * An instance of this class represents a book in the library
 */
public class Book {
    // for assigning id to books
    private static int currentID = 1;

    // the remaining copies of the book
    private int copies = 1;

    // The book's name(title) and author
    private String name, author;

    // The book's id
    private final int id;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
        this.id = currentID;
        currentID++;
    }

    /**
     * Adds one or more copies of this book
     * @param copies the number of copies to add
     */
    public void addCopies(int copies) {
        this.copies += copies;
    }

    /**
     * Removes or more copies of this book
     * @param copies the number of copies to remove
     */
    public void reduceCopies(int copies) {
        this.copies -= copies;
    }

    /**
     * Borrows one or more copies of this book
     * @param copies the number of copies to borrow
     */
    public void borrow(int copies) {
        if (copies > this.copies)
            return;

        reduceCopies(copies);
    }

    public static int getCurrentID() {
        return currentID;
    }

    public static void setCurrentID(int currentID) {
        Book.currentID = currentID;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
















