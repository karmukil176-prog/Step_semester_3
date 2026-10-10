package oop_introduction_object_class_methods_inner_classes_uml_diagrams.assigment_problems;

import java.util.*;

public class CollegeFeeCounter {
    private abstract static class Student {
        final String name;

        Student(String n) {
            name = n;
        }

        abstract double tuition();

        boolean usesBus() {
            return false;
        }

        double total() {
            return tuition() + (usesBus() ? 12000 : 0);
        }
    }

    private static final class DayScholar extends Student {
        DayScholar(String n) {
            super(n);
        }

        double tuition() {
            return 40000;
        }

        boolean usesBus() {
            return true;
        }
    }

    private static final class Hosteller extends Student {
        Hosteller(String n) {
            super(n);
        }

        double tuition() {
            return 100000;
        }
    }

    private static final class Scholar extends Student {
        Scholar(String n) {
            super(n);
        }

        double tuition() {
            return 20000;
        }

        boolean usesBus() {
            return true;
        }
    }

    private static Scanner in() {
        return new Scanner(System.in);
    }

    public static void fees() {
        Scanner s = in();
        int n = s.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String t = s.next(), name = s.next();
            Student x =
                    switch (t) {
                        case "DAY_SCHOLAR" -> new DayScholar(name);
                        case "HOSTELLER" -> new Hosteller(name);
                        case "SCHOLAR" -> new Scholar(name);
                        default -> throw new IllegalArgumentException("Unknown student");
                    };
            total += x.total();
            System.out.printf("%s: %.2f%n", name, x.total());
        }
        System.out.printf("Total Collected: %.2f%n", total);
    }

    public static void main(String[] args) {
        fees();
    }
}
