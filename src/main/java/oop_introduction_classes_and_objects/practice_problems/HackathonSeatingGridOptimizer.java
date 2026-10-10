package oop_introduction_classes_and_objects.practice_problems;

import java.util.*;

public class HackathonSeatingGridOptimizer {
    private static double rowAverage(int[] row) {
        if (row.length == 0) return 0;
        long sum = 0;
        for (int x : row) sum += x;
        return (double) sum / row.length;
    }

    public static String classifyRows(int[][] grid, int threshold) {
        StringJoiner out = new StringJoiner(" | ");
        for (int i = 0; i < grid.length; i++)
            out.add(
                    "Row "
                            + i
                            + ": "
                            + (rowAverage(grid[i]) >= threshold ? "Buzzing Zone" : "Quiet Zone"));
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(
                classifyRows(new int[][] {{40, 50, 45}, {85, 90, 95}, {30, 20, 25}}, 60));
    }
}
