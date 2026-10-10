package string_operations_and_performance.practice_problems;

import java.util.*;

public class FileExtensionValidator {
    public static String validateFileExtension(String file) {
        int dot = file.lastIndexOf('.');
        if (dot < 0 || dot == file.length() - 1) return "Rejected — invalid file type";
        String e = file.substring(dot + 1);
        return e.equalsIgnoreCase("pdf") || e.equalsIgnoreCase("docx") || e.equalsIgnoreCase("zip")
                ? "Accepted"
                : "Rejected — invalid file type";
    }

    public static void main(String[] args) {
        System.out.println(validateFileExtension("Assignment1.PDF"));
    }
}
