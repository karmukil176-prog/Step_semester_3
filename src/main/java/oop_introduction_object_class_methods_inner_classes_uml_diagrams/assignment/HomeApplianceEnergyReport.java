package oop_introduction_object_class_methods_inner_classes_uml_diagrams.assignment;

import java.util.*;

public class HomeApplianceEnergyReport {
    private abstract static class Appliance {
        final double hours;

        Appliance(double h) {
            hours = h;
        }

        abstract double watts();

        boolean saverCapable() {
            return false;
        }

        double units(boolean saver) {
            return watts() * hours / 1000 * (saver ? .75 : 1);
        }

        double cost(boolean saver) {
            return units(saver) * 8;
        }
    }

    private static final class Fridge extends Appliance {
        Fridge(double h) {
            super(h);
        }

        double watts() {
            return 150;
        }
    }

    private static final class Ac extends Appliance {
        Ac(double h) {
            super(h);
        }

        double watts() {
            return 1500;
        }

        boolean saverCapable() {
            return true;
        }
    }

    private static final class Tv extends Appliance {
        Tv(double h) {
            super(h);
        }

        double watts() {
            return 100;
        }
    }

    private static final class Washer extends Appliance {
        Washer(double h) {
            super(h);
        }

        double watts() {
            return 500;
        }

        boolean saverCapable() {
            return true;
        }
    }

    private static Scanner in() {
        return new Scanner(System.in);
    }

    public static void appliances() {
        Scanner s = in();
        int n = s.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String t = s.next();
            double hours = s.nextDouble();
            boolean saver = s.hasNext("SAVER") && s.next().equals("SAVER");
            Appliance a =
                    switch (t) {
                        case "FRIDGE" -> new Fridge(hours);
                        case "AC" -> new Ac(hours);
                        case "TV" -> new Tv(hours);
                        case "WASHER" -> new Washer(hours);
                        default -> throw new IllegalArgumentException("Unknown appliance");
                    };
            if (saver && !a.saverCapable()) System.out.println(t + ": saver mode not supported");
            else {
                double u = a.units(saver), c = a.cost(saver);
                total += c;
                System.out.printf("%s: Units=%.2f Cost=%.2f%n", t, u, c);
            }
        }
        System.out.printf("Total Cost: %.2f%n", total);
    }

    public static void main(String[] args) {
        appliances();
    }
}
