package week6.assessment.encentral;

import java.util.Comparator;

public interface Borrower {
    /**
     * Returns a number between 0 and 1 for the priority. The higher the value the higher the priority
     * @return the priority
     */
    float getPriority();
}
