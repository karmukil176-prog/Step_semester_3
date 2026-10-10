package arrays_and_methods.assignment;

import java.util.*;

public class TopPerformerTracker {
    public static String findMinMaxSpread(int[] scores) {
        if (scores.length == 0) throw new IllegalArgumentException("No scores");
        int min = scores[0], max = scores[0];
        for (int x : scores) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        return "Min: " + min + " | Max: " + max + " | Spread: " + (max - min);
    }

    public static void main(String[] args) {
        System.out.println(findMinMaxSpread(new int[] {45, 82, 79, 90, 33, 90, 61}));
    }
}
