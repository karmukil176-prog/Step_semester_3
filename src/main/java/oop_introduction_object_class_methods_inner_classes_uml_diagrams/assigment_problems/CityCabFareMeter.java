package oop_introduction_object_class_methods_inner_classes_uml_diagrams.assigment_problems;

import java.util.*;

public class CityCabFareMeter {
    private abstract static class Cab {
        final double km;

        Cab(double km) {
            this.km = km;
        }

        abstract double rate();

        boolean nightCapable() {
            return false;
        }

        double fare(boolean night) {
            double base = Math.max(100, km * rate());
            return night ? base * 1.2 : base;
        }
    }

    private static final class Mini extends Cab {
        Mini(double k) {
            super(k);
        }

        double rate() {
            return 10;
        }
    }

    private static final class Sedan extends Cab {
        Sedan(double k) {
            super(k);
        }

        double rate() {
            return 14;
        }

        boolean nightCapable() {
            return true;
        }
    }

    private static final class Suv extends Cab {
        Suv(double k) {
            super(k);
        }

        double rate() {
            return 18;
        }

        boolean nightCapable() {
            return true;
        }
    }

    private static Scanner in() {
        return new Scanner(System.in);
    }

    public static void cabs() {
        Scanner s = in();
        int n = s.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String t = s.next();
            double km = s.nextDouble();
            boolean night = s.next().equals("NIGHT");
            Cab c =
                    switch (t) {
                        case "MINI" -> new Mini(km);
                        case "SEDAN" -> new Sedan(km);
                        case "SUV" -> new Suv(km);
                        default -> throw new IllegalArgumentException("Unknown cab");
                    };
            if (night && !c.nightCapable()) System.out.println(t + ": night service not available");
            else {
                double fare = c.fare(night);
                total += fare;
                System.out.printf("%s: %.2f%n", t, fare);
            }
        }
        System.out.printf("Total: %.2f%n", total);
    }

    public static void main(String[] args) {
        cabs();
    }
}
