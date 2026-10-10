package oop_introduction_classes_and_objects.assignment;

import java.util.*;

public class FantasyTeamScoreMultiplier {
    public static void applyMultipliers(double[] scores, int captain, int vice) {
        if (captain == vice) throw new IllegalArgumentException("Indices must differ");
        scores[captain] *= 2;
        scores[vice] *= 1.5;
    }

    public static void main(String[] args) {
        double[] a = {40, 55, 30, 62};
        applyMultipliers(a, 1, 3);
        System.out.println(Arrays.toString(a));
    }
}
