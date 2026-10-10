package string.practice_problems;

import java.util.*;

public class BMICalculatorForATeam {
    public static String getBmiStatus(double bmi) {
        return bmi < 18.5 ? "Underweight" : bmi < 25 ? "Normal" : bmi < 30 ? "Overweight" : "Obese";
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights.length != weights.length)
            throw new IllegalArgumentException("Parallel arrays must have equal lengths");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf(
                    "Person %d | Height: %.2f m | Weight: %.1f kg | BMI: %.2f | Status: %s%n",
                    i + 1, heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        printWellnessReport(new double[] {1.75, 1.60}, new double[] {70, 90});
    }
}
