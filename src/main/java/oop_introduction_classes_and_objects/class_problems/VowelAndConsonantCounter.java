package oop_introduction_classes_and_objects.class_problems;

import java.util.*;

public class VowelAndConsonantCounter {
    public static void countVowelsAndConsonants(String text) {
        int v = 0, c = 0;
        for (int i = 0; i < text.length(); i++) {
            char x = Character.toLowerCase(text.charAt(i));
            if ("aeiou".indexOf(x) >= 0) v++;
            else if (Character.isLetter(x)) c++;
        }
        System.out.printf("Vowels: %d | Consonants: %d%n", v, c);
    }

    public static void main(String[] args) {
        countVowelsAndConsonants("Java Programming");
    }
}
