package oop_introduction_classes_and_objects.class_problems;

import java.util.*;

public class Top3PodiumFinder {
    public static int[] findTopThreeScores(int[] scores) {
        if (scores.length < 3) throw new IllegalArgumentException("At least three scores required");
        int[] top = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int x : scores)
            for (int i = 0; i < 3; i++)
                if (x > top[i]) {
                    for (int j = 2; j > i; j--) top[j] = top[j - 1];
                    top[i] = x;
                    break;
                }
        return top;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(findTopThreeScores(new int[] {45, 82, 79, 90, 33, 90, 61})));
    }
}
