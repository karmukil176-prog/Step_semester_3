package oop_introduction_abstraction_interface_class_vs_interface.assigment_problems;

import java.util.*;

public class HostelElectricityBill {
    private interface RoomBill {
        double amount();
    }

    private record SingleRoom(int units) implements RoomBill {
        public double amount() {
            return 8.0 * units;
        }
    }

    private record SharedRoom(int units, int occupants) implements RoomBill {
        public double amount() {
            return 6.0 * units / occupants;
        }
    }

    private record AcRoom(int units) implements RoomBill {
        public double amount() {
            return 10.0 * units + 200;
        }
    }

    private static RoomBill create(String type, int units, int occupants) {
        return switch (type) {
            case "SINGLE" -> new SingleRoom(units);
            case "SHARED" -> new SharedRoom(units, occupants);
            case "AC" -> new AcRoom(units);
            default -> throw new IllegalArgumentException("Unknown room type");
        };
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] a = s.nextLine().trim().split("\\s+");
            RoomBill r =
                    create(a[0], Integer.parseInt(a[1]), a.length > 2 ? Integer.parseInt(a[2]) : 1);
            total += r.amount();
            System.out.printf("%s: %.2f%n", a[0], r.amount());
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
