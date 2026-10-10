package control_flow.practice_problems;

import java.util.*;

public class PaymentSystemFeeCalculation {
    private interface Payment {
        double adjusted();
    }

    private record Card(double amount) implements Payment {
        public double adjusted() {
            return amount * 1.02;
        }
    }

    private record Wallet(double amount) implements Payment {
        public double adjusted() {
            return amount * 1.01;
        }
    }

    private record BankTransfer(double amount) implements Payment {
        public double adjusted() {
            return amount;
        }
    }

    private static Payment create(String t, double a) {
        return switch (t) {
            case "CARD" -> new Card(a);
            case "WALLET" -> new Wallet(a);
            case "BANKTRANSFER" -> new BankTransfer(a);
            default -> throw new IllegalArgumentException("Unknown payment type");
        };
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] a = s.nextLine().trim().split("\\s+");
            Payment p = create(a[0], Double.parseDouble(a[1]));
            total += p.adjusted();
            System.out.printf("%s: %.2f%n", a[0], p.adjusted());
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
