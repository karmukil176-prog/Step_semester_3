package control_flow.assignment;

import java.util.*;

public class FestivalBonusCalculator {
    private interface Bonus {
        double amount();

        String name();
    }

    private record FullTimeEmployee(String name, double salary) implements Bonus {
        public double amount() {
            return salary * .10;
        }
    }

    private record PartTimeEmployee(String name, double salary) implements Bonus {
        public double amount() {
            return salary * .05;
        }
    }

    private record InternEmployee(String name, double salary) implements Bonus {
        public double amount() {
            return 2000;
        }
    }

    private static Bonus create(String type, String name, double salary) {
        return switch (type) {
            case "FULLTIME" -> new FullTimeEmployee(name, salary);
            case "PARTTIME" -> new PartTimeEmployee(name, salary);
            case "INTERN" -> new InternEmployee(name, salary);
            default -> throw new IllegalArgumentException("Unknown employee type");
        };
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] a = s.nextLine().trim().split("\\s+");
            Bonus b = create(a[0], a[1], Double.parseDouble(a[2]));
            total += b.amount();
            System.out.printf("%s: %.2f%n", b.name(), b.amount());
        }
        System.out.printf("Total Bonus: %.2f%n", total);
    }
}
