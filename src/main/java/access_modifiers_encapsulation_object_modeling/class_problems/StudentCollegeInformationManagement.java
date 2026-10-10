package access_modifiers_encapsulation_object_modeling.class_problems;

public class StudentCollegeInformationManagement {
    public static class Student {
        private final String name;
        private final int attendance;
        private static final String collegeName = "SRM Institute of Science and Technology";
        private static int studentCount;

        public Student(String n, int a) {
            name = n;
            attendance = a;
            studentCount++;
        }

        public static void printCollegeInfo() {
            System.out.println(collegeName + "\nStudents created: " + studentCount);
        }
    }

    public static void main(String[] x) {
        new Student("Asha", 90);
        new Student("Ravi", 85);
        Student.printCollegeInfo();
    }
}
