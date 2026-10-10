package oop_introduction_object_class_methods_inner_classes_uml_diagrams.assigment_problems;

import java.util.*;

public class ParcelShippingDesk {
    private abstract static class Parcel {
        final double weight, value;

        Parcel(double w, double v) {
            weight = w;
            value = v;
        }

        abstract double charge();

        double insurance() {
            return 0;
        }

        double total() {
            return charge() + insurance();
        }
    }

    private static final class Standard extends Parcel {
        Standard(double w, double v) {
            super(w, v);
        }

        double charge() {
            return 40 + 10 * weight;
        }
    }

    private static final class Express extends Parcel {
        Express(double w, double v) {
            super(w, v);
        }

        double charge() {
            return 80 + 15 * weight;
        }

        double insurance() {
            return .02 * value;
        }
    }

    private static final class Fragile extends Parcel {
        Fragile(double w, double v) {
            super(w, v);
        }

        double charge() {
            return 40 + 10 * weight + 50;
        }

        double insurance() {
            return .02 * value;
        }
    }

    private static Scanner in() {
        return new Scanner(System.in);
    }

    public static void parcels() {
        Scanner s = in();
        int n = s.nextInt();
        double grand = 0;
        for (int i = 0; i < n; i++) {
            String t = s.next();
            double w = s.nextDouble(), v = s.nextDouble();
            Parcel p =
                    switch (t) {
                        case "STANDARD" -> new Standard(w, v);
                        case "EXPRESS" -> new Express(w, v);
                        case "FRAGILE" -> new Fragile(w, v);
                        default -> throw new IllegalArgumentException("Unknown parcel");
                    };
            grand += p.total();
            System.out.printf(
                    "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    t, p.charge(), p.insurance(), p.total());
        }
        System.out.printf("Grand Total: %.2f%n", grand);
    }

    public static void main(String[] args) {
        parcels();
    }
}
