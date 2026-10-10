package string.assignment;


public class ExamHallSeatDuplicationChecker {
    public static void checkDuplicateSeats(int[] a) {
        boolean found = false;
        for (int i = 0; i < a.length; i++) {
            boolean appearedEarlier = false;
            for (int k = 0; k < i; k++)
                if (a[k] == a[i]) {
                    appearedEarlier = true;
                    break;
                }
            if (appearedEarlier) continue;
            for (int j = i + 1; j < a.length; j++)
                if (a[i] == a[j]) {
                    System.out.println("Duplicate Seat Number Found: " + a[i]);
                    found = true;
                    break;
                }
        }
        if (!found) System.out.println("No Duplicate Seats Found");
    }

    public static void main(String[] args) {
        checkDuplicateSeats(new int[] {101, 102, 103, 102, 105});
    }
}
