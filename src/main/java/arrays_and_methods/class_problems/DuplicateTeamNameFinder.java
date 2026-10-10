package arrays_and_methods.class_problems;

import java.util.*;

public class DuplicateTeamNameFinder {
    public static String findDuplicateName(String[] names) {
        for (int i = 0; i < names.length; i++) for (int j = i + 1; j < names.length; j++) if (names[i].equals(names[j])) return "Duplicate Found: " + names[i];
        return "No Duplicates Found";
    }
    public static void main(String[] args) {
        System.out.println(findDuplicateName(new String[] {
            "ByteForce", "CodeCrafters", "ByteForce"
        }));
    }
}
