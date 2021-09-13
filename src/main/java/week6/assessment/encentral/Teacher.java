package week6.assessment.encentral;

public class Teacher implements Borrower {
    @Override
    public float getPriority() {
        // A Teacher has the highest priority
        return 1;
    }

    @Override
    public String toString() {
        return "Teacher";
    }
}
