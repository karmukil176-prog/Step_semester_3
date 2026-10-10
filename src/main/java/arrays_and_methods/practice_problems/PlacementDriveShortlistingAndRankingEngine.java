package arrays_and_methods.practice_problems;

import java.util.*;

public class PlacementDriveShortlistingAndRankingEngine {
    public static final class Candidate implements Comparable<Candidate> {
        final String name;
        final double cgpa;
        final int codingScore;

        public Candidate(String n, double c, int s) {
            name = n;
            cgpa = c;
            codingScore = s;
        }

        double score() {
            return cgpa * 10 + codingScore * .5;
        }

        static boolean isEligible(double c) {
            return c >= 7.5;
        }

        static boolean isEligible(double c, int s) {
            return c >= 6.5 && s >= 60;
        }

        public int compareTo(Candidate o) {
            int c = Double.compare(o.score(), score());
            return c != 0 ? c : name.compareTo(o.name);
        }
    }

    public static String shortlistAndRank(Candidate[] a) {
        List<Candidate> chosen = new ArrayList<>();
        for (Candidate c : a)
            if (Candidate.isEligible(c.cgpa) || Candidate.isEligible(c.cgpa, c.codingScore))
                chosen.add(c);
        Collections.sort(chosen);
        StringJoiner out = new StringJoiner(" | ");
        int i = 1;
        for (Candidate c : chosen)
            out.add(
                    (i++)
                            + ". "
                            + c.name
                            + " ("
                            + String.format(Locale.ROOT, "%.1f", c.score())
                            + ")");
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(
                shortlistAndRank(
                        new Candidate[] {
                            new Candidate("Aisha", 8.2, 40),
                            new Candidate("Rohit", 6.8, 65),
                            new Candidate("Meena", 6.0, 90),
                            new Candidate("Karan", 7.5, 20)
                        }));
    }
}
