package oop_introduction_classes_and_objects.assigment_problems;

import java.util.*;

public class DuplicatePlayerPickChecker {
    public static String findDuplicatePick(String[] names) {
        for (int i = 0; i < names.length; i++)
            for (int j = i + 1; j < names.length; j++)
                if (names[i].equals(names[j])) return "Duplicate Found: " + names[i];
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        System.out.println(findDuplicatePick(new String[] {"Kohli", "Bumrah", "Kohli"}));
    }
}
