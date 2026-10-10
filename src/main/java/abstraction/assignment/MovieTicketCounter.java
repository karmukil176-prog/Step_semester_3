package abstraction.assignment;

import java.util.Scanner;

public class MovieTicketCounter {
    private abstract static class Ticket {
        private static final double CONVENIENCE_FEE = 20.0;

        abstract double seatPrice();

        final double totalPrice() {
            return seatPrice() + CONVENIENCE_FEE;
        }
    }

    private static final class Regular extends Ticket {
        double seatPrice() {
            return 150.0;
        }
    }

    private static final class Premium extends Ticket {
        double seatPrice() {
            return 250.0;
        }
    }

    private static final class Recliner extends Ticket {
        double seatPrice() {
            return 400.0;
        }
    }

    private static Ticket create(String seat) {
        return switch (seat) {
            case "REGULAR" -> new Regular();
            case "PREMIUM" -> new Premium();
            case "RECLINER" -> new Recliner();
            default -> throw new IllegalArgumentException("Unknown seat type: " + seat);
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bookings = scanner.nextInt();
        double total = 0;
        for (int i = 0; i < bookings; i++) {
            String type = scanner.next();
            int count = scanner.nextInt();
            double amount = create(type).totalPrice() * count;
            total += amount;
            System.out.printf("%s: %.2f%n", type, amount);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
