package oop_introduction_classes_and_objects.assignment;

import java.util.*;

public class MatchDayGridAnalyzer {
    private static double rowAverage(int[] row) {
        if (row.length == 0) return 0;
        long sum = 0;
        for (int x : row) sum += x;
        return (double) sum / row.length;
    }

    public static String classifyMatches(int[][] runs, int threshold) {
        StringJoiner result = new StringJoiner(" | ");
        for (int i = 0; i < runs.length; i++)
            result.add(
                    "Match "
                            + i
                            + ": "
                            + (rowAverage(runs[i]) >= threshold ? "Power Surge" : "Normal"));
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(classifyMatches(new int[][] {{4, 6, 8}, {10, 12, 14}, {2, 3, 1}}, 8));
    }
}
