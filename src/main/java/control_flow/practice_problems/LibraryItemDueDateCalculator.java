package control_flow.practice_problems;

import java.time.LocalDate;
import java.util.*;

public class LibraryItemDueDateCalculator {
    private interface LibraryItem {
        String title();

        LocalDate dueDate();
    }

    private record Book(String title) implements LibraryItem {
        public LocalDate dueDate() {
            return LocalDate.of(2023, 10, 26).plusDays(14);
        }
    }

    private record Dvd(String title) implements LibraryItem {
        public LocalDate dueDate() {
            return LocalDate.of(2023, 10, 26).plusDays(7);
        }
    }

    private record Magazine(String title) implements LibraryItem {
        public LocalDate dueDate() {
            return LocalDate.of(2023, 10, 26).plusDays(3);
        }
    }

    private static String title(String line) {
        int first = line.indexOf('"'), last = line.lastIndexOf('"');
        return first >= 0 && last > first
                ? line.substring(first + 1, last)
                : line.substring(line.indexOf(' ') + 1).trim();
    }

    private static LibraryItem create(String type, String title) {
        return switch (type) {
            case "BOOK" -> new Book(title);
            case "DVD" -> new Dvd(title);
            case "MAGAZINE" -> new Magazine(title);
            default -> throw new IllegalArgumentException("Unknown item type");
        };
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine().trim());
        for (int i = 0; i < n; i++) {
            String line = s.nextLine().trim();
            String type = line.substring(0, line.indexOf(' '));
            LibraryItem item = create(type, title(line));
            System.out.println(item.title() + ": " + item.dueDate());
        }
    }
}
