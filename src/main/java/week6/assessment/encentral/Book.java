package week6.assessment.encentral;

public class Book {
    private static int currentID = 1;

    private int copies = 1;
    private String name, author;
    private int id;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
        this.id = currentID;
        currentID++;
    }

    public void addCopies(int copies) {
        this.copies += copies;
    }

    public void reduceCopies(int copies) {
        this.copies -= copies;
    }

    public void borrow(int copies) {
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
















