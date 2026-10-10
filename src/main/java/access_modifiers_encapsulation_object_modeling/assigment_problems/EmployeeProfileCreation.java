package access_modifiers_encapsulation_object_modeling.assigment_problems;

public class EmployeeProfileCreation {
    public static class EmployeeProfile {
        private final String empId, empName;
        private final double salary;
        private boolean isIntern;

        public EmployeeProfile(String i, String n, double s) {
            empId = i;
            empName = n;
            salary = s;
            isIntern = false;
        }

        public EmployeeProfile(String i, String n) {
            this(i, n, 0);
            isIntern = true;
        }

        public void printProfile() {
            System.out.printf("%s | %s | Rs %.1f | Intern: %s%n", empId, empName, salary, isIntern);
        }
    }

    public static void main(String[] args) {
        new EmployeeProfile("E-101", "Divya", 65000).printProfile();
        new EmployeeProfile("E-102", "Arjun").printProfile();
    }
}
