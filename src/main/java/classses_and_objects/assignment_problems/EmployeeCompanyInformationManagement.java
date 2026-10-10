package classses_and_objects.assignment_problems;

public class EmployeeCompanyInformationManagement {
    public static class Employee {
        private final String empName;
        private final double salary;
        private static final String companyName = "Bright Horizon Technologies";
        private static int employeeCount;
        public Employee(String n, double s) {
            empName = n;
            salary = s;
            employeeCount++;
        }
        public static void printCompanyInfo() {
            System.out.println(companyName + "\nEmployees on record: " + employeeCount);
        }
    }
    public static void main(String[] args) {
        new Employee("Asha", 50000);
        new Employee("Ravi", 40000);
        new Employee("Neha", 30000);
        Employee.printCompanyInfo();
    }
}
