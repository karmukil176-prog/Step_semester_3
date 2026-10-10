package java_string_concepts.class_problems;

import java.util.*;

public class FirstNonRepeatingCharacter {
    public static char findFirstNonRepeatingChar(String text) {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int n = 0;
            for (int j = 0; j < text.length(); j++) if (text.charAt(j) == c) n++;
            if (n == 1) return c;
        }
        return '\0';
    }

    public static void main(String[] args) {
        System.out.println(findFirstNonRepeatingChar("swiss"));
    }
}
