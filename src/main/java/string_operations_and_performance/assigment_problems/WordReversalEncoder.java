package string_operations_and_performance.assigment_problems;

import java.util.*;

public class WordReversalEncoder {
    public static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ", -1);
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i > 0) out.append(' ');
            out.append(new StringBuilder(words[i]).reverse());
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseEachWord("hello club"));
    }
}
