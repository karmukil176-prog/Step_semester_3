package oop_introduction_classes_and_objects.assignment;

import java.util.*;

public class LibraryISBNNormalizerAndValidator {
    public static String normalizeCode(String raw) {
        String s = raw.trim();
        return s.length() < 3
                ? s.toUpperCase(Locale.ROOT)
                : s.substring(0, 3).toUpperCase(Locale.ROOT) + s.substring(3);
    }

    public static String validateAndFormat(String code) {
        if (code.length() != 13) return "Invalid: code must be exactly 13 characters";
        for (int i = 0; i < 3; i++)
            if (!Character.isLetter(code.charAt(i)))
                return "Invalid: publisher code must be 3 letters";
        for (int i = 3; i < 13; i++)
            if (!Character.isDigit(code.charAt(i)))
                return "Invalid: year and catalog must contain only digits";
        return new StringBuilder()
                .append('[')
                .append(code, 0, 3)
                .append("] YEAR: ")
                .append(code, 3, 7)
                .append(" | CATALOG: ")
                .append(code, 7, 13)
                .toString();
    }

    public static void main(String[] args) {
        System.out.println(validateAndFormat(normalizeCode(" pen2026004251 ")));
    }
}
