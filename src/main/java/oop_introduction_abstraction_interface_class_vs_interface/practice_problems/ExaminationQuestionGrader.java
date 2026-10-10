package oop_introduction_abstraction_interface_class_vs_interface.practice_problems;

import java.util.*;

public class ExaminationQuestionGrader {
    private interface Question {
        double score();

        String type();
    }

    private record Exact(String type, String correct, String answer, double points)
            implements Question {
        public double score() {
            return correct.equals(answer) ? points : 0;
        }
    }

    private record Essay(String correct, String answer, double points) implements Question {
        public String type() {
            return "ESSAY";
        }

        public double score() {
            int matches = 0;
            String a = answer.toLowerCase(Locale.ROOT);
            for (String word : correct.split(","))
                if (a.contains(word.trim().toLowerCase(Locale.ROOT))) matches++;
            return points * (matches >= 2 ? .75 : matches == 1 ? .5 : 0);
        }
    }

    private static Question create(String type, String correct, String answer, double points) {
        return type.equals("ESSAY")
                ? new Essay(correct, answer, points)
                : new Exact(type, correct, answer, points);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] a = s.nextLine().split("\"", -1);
            String type = a[0].trim().split("\\s+")[0], correct = a[3].trim(), answer = a[5].trim();
            double points = Double.parseDouble(a[6].trim());
            Question q = create(type, correct, answer, points);
            total += q.score();
            System.out.printf("%s: %.2f%n", q.type(), q.score());
        }
        System.out.printf("Total Score: %.2f%n", total);
    }
}
