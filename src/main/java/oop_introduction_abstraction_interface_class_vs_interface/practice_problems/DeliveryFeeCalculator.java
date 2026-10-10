package oop_introduction_abstraction_interface_class_vs_interface.practice_problems;

import java.util.*;

public class DeliveryFeeCalculator {
    private interface Delivery {
        double fee();
    }

    private record Standard(double weight, double distance) implements Delivery {
        public double fee() {
            return 5 + .5 * weight + .1 * distance;
        }
    }

    private record Express(double weight, double distance) implements Delivery {
        public double fee() {
            return 15 + weight + .2 * distance;
        }
    }

    private record International(double weight, double distance, double customs)
            implements Delivery {
        public double fee() {
            return 25 + 2 * weight + .5 * distance + customs;
        }
    }

    private static Delivery create(String type, double w, double d, double customs) {
        return switch (type) {
            case "STANDARD" -> new Standard(w, d);
            case "EXPRESS" -> new Express(w, d);
            case "INTERNATIONAL" -> new International(w, d, customs);
            default -> throw new IllegalArgumentException("Unknown delivery type");
        };
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] a = s.nextLine().trim().split("\\s+");
            Delivery d =
                    create(
                            a[0],
                            Double.parseDouble(a[1]),
                            Double.parseDouble(a[2]),
                            a.length > 3 ? Double.parseDouble(a[3]) : 0);
            total += d.fee();
            System.out.printf("%s: %.2f%n", a[0], d.fee());
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
