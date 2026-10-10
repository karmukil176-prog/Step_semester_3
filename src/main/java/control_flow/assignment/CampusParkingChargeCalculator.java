package control_flow.assignment;

import java.util.*;

public class CampusParkingChargeCalculator {
    private interface ParkingCharge {
        double amount();
    }

    private record Bike(int hours) implements ParkingCharge {
        public double amount() {
            return 10.0 * hours;
        }
    }

    private record Car(int hours) implements ParkingCharge {
        public double amount() {
            return 30.0 + 20.0 * (hours - 1);
        }
    }

    private record Truck(int hours) implements ParkingCharge {
        public double amount() {
            return Math.max(100.0, 50.0 * hours);
        }
    }

    private static ParkingCharge create(String type, int hours) {
        return switch (type) {
            case "BIKE" -> new Bike(hours);
            case "CAR" -> new Car(hours);
            case "TRUCK" -> new Truck(hours);
            default -> throw new IllegalArgumentException("Unknown vehicle type");
        };
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] a = s.nextLine().trim().split("\\s+");
            ParkingCharge p = create(a[0], Integer.parseInt(a[1]));
            total += p.amount();
            System.out.printf("%s: %.2f%n", a[0], p.amount());
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
