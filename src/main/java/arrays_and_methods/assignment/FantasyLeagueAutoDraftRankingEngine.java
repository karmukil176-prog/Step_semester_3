package arrays_and_methods.assignment;

import java.util.*;

public class FantasyLeagueAutoDraftRankingEngine {
    public static final class Player implements Comparable<Player> {
        private final String name;
        private final int matchesPlayed;
        private final double battingAverage;
        private final boolean injured;

        public Player(String n, int m, double a, boolean i) {
            name = n;
            matchesPlayed = m;
            battingAverage = a;
            injured = i;
        }

        static boolean isDraftable(int m) {
            return m >= 10;
        }

        static boolean isDraftable(int m, boolean injured) {
            return m >= 5 && !injured;
        }

        public int compareTo(Player p) {
            int c = Double.compare(p.battingAverage, battingAverage);
            return c != 0 ? c : name.compareTo(p.name);
        }
    }

    public static String draftAndRank(Player[] players) {
        List<Player> list = new ArrayList<>();
        for (Player p : players)
            if (Player.isDraftable(p.matchesPlayed)
                    || Player.isDraftable(p.matchesPlayed, p.injured)) list.add(p);
        Collections.sort(list);
        StringJoiner out = new StringJoiner(" | ");
        int i = 1;
        for (Player p : list) out.add((i++) + ". " + p.name);
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(
                draftAndRank(
                        new Player[] {
                            new Player("Virat", 15, 48, false),
                            new Player("Rahul", 7, 55, false),
                            new Player("Sameer", 3, 60, false),
                            new Player("Dev", 12, 20, true)
                        }));
    }
}
