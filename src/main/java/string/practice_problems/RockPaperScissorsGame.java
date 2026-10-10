package string.practice_problems;

import java.util.*;

public class RockPaperScissorsGame {
    public static String playRound(String player, String computer) {
        String p = player.trim().toLowerCase(Locale.ROOT),
                c = computer.trim().toLowerCase(Locale.ROOT);
        if (p.equals(c)) return "Draw";
        if ((p.equals("rock") && c.equals("scissors"))
                || (p.equals("paper") && c.equals("rock"))
                || (p.equals("scissors") && c.equals("paper"))) return "Player Wins";
        return "Computer Wins";
    }

    public static void main(String[] args) {
        System.out.println(playRound("Rock", "Scissors"));
    }
}
