package oop_introduction_classes_and_objects.assignment;

import java.util.*;

public class StopWordFilteredWordFrequencyReport {
    public static void printFilteredWordFrequency(String feedback) {
        Set<String> stop = Set.of("the", "was", "and", "a", "is", "of", "in");
        Map<String, Integer> count = new HashMap<>();
        String cleaned = feedback.toLowerCase(Locale.ROOT).replaceAll("[.,!?;:]", " ").trim();
        if (!cleaned.isEmpty())
            for (String w : cleaned.split("\\s+"))
                if (!stop.contains(w)) count.merge(w, 1, Integer::sum);
        count.entrySet().stream()
                .sorted((x, y) -> Integer.compare(y.getValue(), x.getValue()))
                .forEach(e -> System.out.print(e.getKey() + ": " + e.getValue() + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}
