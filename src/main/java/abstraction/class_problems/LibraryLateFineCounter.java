package abstraction.class_problems;

import java.util.*;

public class LibraryLateFineCounter {
    private interface Fine {
        String title();
        double fine();
    }
    private record Book(String title, int days) implements Fine {
        public double fine() {
            return 2.0 * days;
        }
    }
    private record Dvd(String title, int days) implements Fine {
        public double fine() {
            return Math.min(50, 5.0 * days);
        }
    }
    private record Magazine(String title, int days) implements Fine {
        public double fine() {
            return days;
        }
    }
    private static Scanner in() {
        return new Scanner(System.in);
    }
    public static void fines() {
        Scanner s = in();
        int n = s.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = s.next(), title = s.next();
            int days = s.nextInt();
            Fine f = switch (type) {
                case "BOOK" -> new Book(title, days);
                case "DVD" -> new Dvd(title, days);
                case "MAGAZINE" -> new Magazine(title, days);
                default -> throw new IllegalArgumentException("Unknown item");
            };
            total += f.fine();
            System.out.printf("%s: %.2f%n", f.title(), f.fine());
        }
        System.out.printf("Total Fines: %.2f%n", total);
    }
    public static void main(String[] args) {
        fines();
    }
}
