package string.assignment_problems;

import java.util.Arrays;

public class TypingSpeedTestAccuracyChecker {
    public static void checkTypingAccuracy(String original, String typed) {
        int n = Math.min(original.length(), typed.length()), matches = 0, first = -1;
        for (int i = 0; i < n; i++) if (original.charAt(i) == typed.charAt(i)) matches++;
        else if (first < 0) first = i;
        int total = Math.max(original.length(), typed.length());
        double accuracy = total == 0 ? 100.0 : 100.0 * matches / total;
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | ", matches, total, accuracy);
        if (first < 0 && original.length() == typed.length()) System.out.println("No Mismatches");
        else if (first < 0) System.out.println("First Mismatch at position " + (n + 1) + " (length differs)");
        else System.out.printf("First Mismatch at position %d ('%s' vs '%s')%n", first + 1, first < original.length() ? original.charAt(first) : "<end>", first < typed.length() ? typed.charAt(first) : "<end>");
    }
    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
    }
}
