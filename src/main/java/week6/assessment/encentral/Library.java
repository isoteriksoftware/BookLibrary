package week6.assessment.encentral;

import java.util.HashMap;
import java.util.Map;

/**
 * The Library class manages available books
 */
public final class Library {
    // Books are mapped to their name + author
    private final Map<String, Book> books;

    private static Library instance;

    private Library() {
        books = new HashMap<>();
    }

    public static Library instance() {
        if (instance == null)
            instance = new Library();

        return instance;
    }

    public Book getBook(String name, String author) {
        // We use a combination of the book name and the author for the key because
        // two different books can have the same name but different authors
        String key = name + "|" + author;
        return books.get(key);
    }

    public void addBook(String name, String author) {
        // We use a combination of the book name and the author for the key because
        // two different books can have the same name but different authors
        String key = name + "|" + author;
        Book book = books.get(key);

        if (book == null) {
            book = new Book(name, author);
            books.put(key, book);
        }
        else
            book.addCopies(1);
    }

    public void removeBook(String name, String author, int copies) {
        // We use a combination of the book name and the author for the key because
        // two different books can have the same name but different authors
        String key = name + "|" + author;
        Book book = books.get(key);

        if (book != null) {
            book.reduceCopies(copies);
            if (book.getCopies() <= 0)
                books.remove(key);
        }
    }

    /**
     * Checks if a book is available. This also makes sure enough copies are available
     * @param name the book's name
     * @param author the author's name
     * @return true if the book exists and has enough copies. false otherwise
     */
    public boolean isBookAvailable(String name, String author) {
        // We use a combination of the book name and the author for the key because
        // two different books can have the same name but different authors
        String key = name + "|" + author;
        Book book = books.get(key);

        return book != null && book.getCopies() >= 1;
    }

    public int getTotalBookCopiesAvailable() {
        int totalCopies = 0;

        for (Book book : books.values())
            totalCopies += book.getCopies();

        System.out.println(books.size());
        return totalCopies;
    }

    public Map<String, Book> getBooks() {
        return books;
    }
}






















