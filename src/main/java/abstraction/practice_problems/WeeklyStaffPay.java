package abstraction.practice_problems;

import java.util.*;

public class WeeklyStaffPay {
    private abstract static class Staff {
        final String name;

        Staff(String n) {
            name = n;
        }

        abstract double pay();
    }

    private static final class FullTime extends Staff {
        final double salary;

        FullTime(String n, double s) {
            super(n);
            salary = s;
        }

        double pay() {
            return salary;
        }
    }

    private static final class Hourly extends Staff {
        final double hours, rate;

        Hourly(String n, double h, double r) {
            super(n);
            hours = h;
            rate = r;
        }

        double pay() {
            return Math.min(hours, 40) * rate + Math.max(0, hours - 40) * rate * 1.5;
        }
    }

    private static final class Intern extends Staff {
        final double stipend;

        Intern(String n, double s) {
            super(n);
            stipend = s;
        }

        double pay() {
            return stipend;
        }
    }

    private static Scanner in() {
        return new Scanner(System.in);
    }

    public static void payroll() {
        Scanner s = in();
        int n = s.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = s.next(), name = s.next();
            Staff x =
                    switch (type) {
                        case "FULLTIME" -> new FullTime(name, s.nextDouble());
                        case "HOURLY" -> new Hourly(name, s.nextDouble(), s.nextDouble());
                        case "INTERN" -> new Intern(name, s.nextDouble());
                        default -> throw new IllegalArgumentException("Unknown staff");
                    };
            total += x.pay();
            System.out.printf("%s: %.2f%n", name, x.pay());
        }
        System.out.printf("Total Payroll: %.2f%n", total);
    }

    public static void main(String[] args) {
        payroll();
    }
}
