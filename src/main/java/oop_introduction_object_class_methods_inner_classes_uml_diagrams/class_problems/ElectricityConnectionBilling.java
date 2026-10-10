package oop_introduction_object_class_methods_inner_classes_uml_diagrams.class_problems;

import java.util.*;

public class ElectricityConnectionBilling {
    private abstract static class Connection {
        final int units;

        Connection(int u) {
            units = u;
        }

        abstract double bill();
    }

    private static final class Home extends Connection {
        Home(int u) {
            super(u);
        }

        double bill() {
            return Math.min(units, 100) * 5 + Math.max(0, units - 100) * 7;
        }
    }

    private static final class Shop extends Connection {
        Shop(int u) {
            super(u);
        }

        double bill() {
            return 8.0 * units + 100;
        }
    }

    private static final class Factory extends Connection {
        Factory(int u) {
            super(u);
        }

        double bill() {
            return Math.max(1000, 6.0 * units);
        }
    }

    private static Scanner in() {
        return new Scanner(System.in);
    }

    public static void electricity() {
        Scanner s = in();
        int n = s.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = s.next();
            int units = s.nextInt();
            Connection c =
                    switch (type) {
                        case "HOME" -> new Home(units);
                        case "SHOP" -> new Shop(units);
                        case "FACTORY" -> new Factory(units);
                        default -> throw new IllegalArgumentException("Unknown connection");
                    };
            total += c.bill();
            System.out.printf("%s: %.2f%n", type, c.bill());
        }
        System.out.printf("Total: %.2f%n", total);
    }

    public static void main(String[] args) {
        electricity();
    }
}
