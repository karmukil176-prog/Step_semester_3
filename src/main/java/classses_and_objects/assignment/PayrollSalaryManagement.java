package classses_and_objects.assignment;

public class PayrollSalaryManagement {
    public static class PayrollAccount {
        private double basicSalary, bonus;

        public PayrollAccount(double s) {
            if (s < 0) {
                System.out.println("Warning: negative salary set to 0");
                s = 0;
            }
            basicSalary = s;
        }

        public void creditBonus(double a) {
            if (a <= 0) System.out.println("Bonus rejected: amount must be positive");
            else {
                bonus += a;
                System.out.println("Bonus credited: Rs " + a);
            }
        }

        public void deductTax(double p) {
            if (p < 0 || p > 100)
                System.out.println("Tax rejected: percent must be between 0 and 100");
            else {
                basicSalary *= 1 - p / 100;
                System.out.println("Tax deducted: " + p + "%");
            }
        }

        public double getNetSalary() {
            return basicSalary + bonus;
        }
    }

    public static void main(String[] args) {
        PayrollAccount p = new PayrollAccount(50000);
        p.creditBonus(5000);
        p.deductTax(10);
        System.out.println("Net salary: Rs " + p.getNetSalary());
    }
}
