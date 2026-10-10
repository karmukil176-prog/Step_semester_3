package arrays_and_methods.class_problems;

import java.util.*;

public class HackathonScoreCurveBooster {
    public static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) scores[i] += bonus;
        System.out.println(Arrays.toString(scores));
    }
    public static void main(String[] args) {
        int[] a = {
            70, 85, 60
        };
        curveScores(a, 10);
    }
}
