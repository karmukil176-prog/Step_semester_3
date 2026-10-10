package classses_and_objects.practice_problems;

public class LibraryIdCardManagement {
    public static class IdCard {
        String name;
        int booksIssued;

        public IdCard(String n, int c) {
            name = n;
            booksIssued = c;
        }
    }

    public static void main(String[] x) {
        IdCard ravi = new IdCard("Ravi", 0), duplicate = ravi;
        duplicate.booksIssued = 3;
        IdCard separate = new IdCard("Ravi", 3);
        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}
