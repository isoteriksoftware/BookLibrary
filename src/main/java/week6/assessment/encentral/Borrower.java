package week6.assessment.encentral;

/**
 * A borrower defines its own priority. The librarian will use this when lending out books from the library
 */
public interface Borrower {
    /**
     * Returns a number between 0 and 1 for the priority. The higher the value the higher the priority
     * @return the priority
     */
    float getPriority();
}
