package oop_introduction_abstraction_interface_class_vs_interface.assignment;

import java.util.*;

public class CanteenBillingCounter {
    private interface Bill {
        double amount();
    }

    private record StudentBill(double base) implements Bill {
        public double amount() {
            return base * .90;
        }
    }

    private record StaffBill(double base) implements Bill {
        public double amount() {
            return base * .95;
        }
    }

    private record GuestBill(double base) implements Bill {
        public double amount() {
            return base + 10;
        }
    }

    private static Bill create(String type, double amount) {
        return switch (type) {
            case "STUDENT" -> new StudentBill(amount);
            case "STAFF" -> new StaffBill(amount);
            case "GUEST" -> new GuestBill(amount);
            default -> throw new IllegalArgumentException("Unknown customer type");
        };
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] a = s.nextLine().trim().split("\\s+");
            Bill b = create(a[0], Double.parseDouble(a[1]));
            total += b.amount();
            System.out.printf("%s: %.2f%n", a[0], b.amount());
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
