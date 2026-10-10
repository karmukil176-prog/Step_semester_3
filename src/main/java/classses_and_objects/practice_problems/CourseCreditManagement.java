package classses_and_objects.practice_problems;

public class CourseCreditManagement {
    public static class Course {
        private final String code, title;
        private final int credits, labCredits;

        public Course(String c, String t, int cr, int lab) {
            code = c;
            title = t;
            credits = cr;
            labCredits = lab;
        }

        public Course(String c, String t, int cr) {
            this(c, t, cr, 0);
        }

        public int totalCredits() {
            return credits + labCredits;
        }
    }

    public static void main(String[] x) {
        System.out.println(new Course("21CSC201J", "Data Structures", 4, 1).totalCredits());
        System.out.println(new Course("21MAT101", "Math", 4).totalCredits());
    }
}
