package classses_and_objects.assignment;

public class LibraryInventoryManagement {
    public static class BookInventory {
        private final String title, author;
        private final int copiesAvailable;

        public BookInventory(String t, String a, int c) {
            title = t;
            author = a;
            copiesAvailable = c;
        }

        public void printEntry() {
            System.out.printf("%s by %s - %d copies available%n", title, author, copiesAvailable);
        }
    }

    public static void main(String[] args) {
        BookInventory[] books = {
            new BookInventory("Clean Code", "Robert C. Martin", 3),
            new BookInventory("Effective Java", "Joshua Bloch", 5),
            new BookInventory("Refactoring", "Martin Fowler", 0),
            new BookInventory("Design Patterns", "GoF", 2)
        };
        for (BookInventory b : books) b.printEntry();
    }
}
