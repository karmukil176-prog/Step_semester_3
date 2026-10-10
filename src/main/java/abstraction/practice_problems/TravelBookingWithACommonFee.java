package abstraction.practice_problems;

import java.util.*;

public class TravelBookingWithACommonFee {
    private abstract static class Booking {
        final double distance;
        static final double BOOKING_FEE = 50;

        Booking(double d) {
            distance = d;
        }

        abstract double baseFare();

        double total() {
            return baseFare() + BOOKING_FEE;
        }
    }

    private static final class Bus extends Booking {
        Bus(double d) {
            super(d);
        }

        double baseFare() {
            return 2 * distance;
        }
    }

    private static final class Train extends Booking {
        Train(double d) {
            super(d);
        }

        double baseFare() {
            return 1.5 * distance;
        }
    }

    private static final class Flight extends Booking {
        Flight(double d) {
            super(d);
        }

        double baseFare() {
            return 2500 + 4 * distance;
        }
    }

    private static Scanner in() {
        return new Scanner(System.in);
    }

    public static void bookings() {
        Scanner s = in();
        int n = s.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String mode = s.next();
            double distance = s.nextDouble();
            Booking b =
                    switch (mode) {
                        case "BUS" -> new Bus(distance);
                        case "TRAIN" -> new Train(distance);
                        case "FLIGHT" -> new Flight(distance);
                        default -> throw new IllegalArgumentException("Unknown mode");
                    };
            total += b.total();
            System.out.printf("%s: %.2f%n", mode, b.total());
        }
        System.out.printf("Total: %.2f%n", total);
    }

    public static void main(String[] args) {
        bookings();
    }
}
