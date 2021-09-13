package week6.assessment.encentral;

/**
 * A Student is a borrower with lower priority than a Teacher
 */
public class Student implements Borrower {
    /**
     * Every student has a level to further categorize them. Students of higher levels have higher priorities
     */
    public enum Level {
        JSS1(0.1f),
        JSS2(0.2f),
        JSS3(0.3f),
        SS1(0.4f),
        SS2(0.5f),
        SS3(0.6f);

        private final float priority;

        Level(float priority) {
            this.priority = priority;
        }

        public float getPriority() {
            return priority;
        }
    }

    private final Level level;

    public Student(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    @Override
    public float getPriority() {
        return level.getPriority();
    }

    @Override
    public String toString() {
        return "Student{" +
                "level=" + level +
                '}';
    }
}
