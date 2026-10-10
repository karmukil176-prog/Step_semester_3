package string.assignment_problems;

import java.util.Arrays;

public class TrafficSignalStreakAnalyzer {
    public static void findLongestStreak(String s) {
        if (s.isEmpty()) {
            System.out.println("No readings");
            return;
        }
        char best = s.charAt(0), current = best;
        int bestN = 1, n = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == current) n++;
            else {
                current = s.charAt(i);
                n = 1;
            }
            if (n > bestN) {
                bestN = n;
                best = current;
            }
        }
        System.out.printf("Longest Streak: '%c' repeated %d times%n", best, bestN);
    }
    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
    }
}
