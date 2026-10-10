package control_flow.class_problems;

import java.util.*;

public class PublicTransportFareCalculator {
    private interface Journey {
        double fare();
    }
    private record Bus(double distance) implements Journey {
        public double fare() {
            return Math.min(10, 2 + .1 * distance);
        }
    }
    private record Train(double distance) implements Journey {
        public double fare() {
            return 3 + .15 * distance;
        }
    }
    private record Metro(double distance, double peakFactor) implements Journey {
        public double fare() {
            return(1.5 + .2 * distance) * peakFactor;
        }
    }
    private static Journey create(String type, double d, double factor) {
        return switch (type) {
            case "BUS" -> new Bus(d);
            case "TRAIN" -> new Train(d);
            case "METRO" -> new Metro(d, factor);
            default -> throw new IllegalArgumentException("Unknown transport type");
        };
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] a = s.nextLine().trim().split("\\s+");
            Journey j = create(a[0], Double.parseDouble(a[1]), a.length > 2 ? Double.parseDouble(a[2]) : 1);
            total += j.fare();
            System.out.printf("%s: %.2f%n", a[0], j.fare());
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
