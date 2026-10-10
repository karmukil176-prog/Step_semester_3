package oop_introduction_classes_and_objects.class_problems;

import java.util.*;

public class BankTransactionReferenceGeneratorAndValidator {
    public static String normalizeReference(String raw) {
        String s = raw.trim();
        return s.length() < 3
                ? s.toUpperCase(Locale.ROOT)
                : s.substring(0, 3).toUpperCase(Locale.ROOT) + s.substring(3);
    }

    public static String validateReference(String s) {
        if (s.length() != 14) return "Invalid: reference must be exactly 14 characters";
        for (int i = 0; i < 3; i++)
            if (!Character.isLetter(s.charAt(i))) return "Invalid: bank code must be 3 letters";
        for (int i = 3; i < 14; i++)
            if (!Character.isDigit(s.charAt(i)))
                return "Invalid: date and sequence must contain only digits";
        return "["
                + s.substring(0, 3)
                + "] DATE: "
                + s.substring(3, 9)
                + " | SEQUENCE: "
                + s.substring(9);
    }

    public static void main(String[] args) {
        System.out.println(validateReference(normalizeReference(" sbi12102412345 ")));
    }
}
