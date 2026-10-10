package oop_introduction_abstraction_interface_class_vs_interface.assignment;

import java.time.LocalDate;
import java.util.*;

public class StreamingPlanRenewalReminder {
    private interface Plan {
        String name();

        LocalDate renewal();
    }

    private record BasicPlan(String name, LocalDate start) implements Plan {
        public LocalDate renewal() {
            return start.plusDays(30);
        }
    }

    private record StandardPlan(String name, LocalDate start) implements Plan {
        public LocalDate renewal() {
            return start.plusDays(90);
        }
    }

    private record PremiumPlan(String name, LocalDate start) implements Plan {
        public LocalDate renewal() {
            return start.plusDays(365);
        }
    }

    private static Plan create(String type, String name, LocalDate start) {
        return switch (type) {
            case "BASIC" -> new BasicPlan(name, start);
            case "STANDARD" -> new StandardPlan(name, start);
            case "PREMIUM" -> new PremiumPlan(name, start);
            default -> throw new IllegalArgumentException("Unknown plan");
        };
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine().trim());
        for (int i = 0; i < n; i++) {
            String[] a = s.nextLine().trim().split("\\s+");
            Plan p = create(a[0], a[1], LocalDate.parse(a[2]));
            System.out.println(p.name() + ": " + p.renewal());
        }
    }
}
