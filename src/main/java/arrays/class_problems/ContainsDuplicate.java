package arrays.class_problems;

import java.util.*;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] a) {
        for (int i = 0; i < a.length; i++) for (int j = i + 1; j < a.length; j++) if (a[i] == a[j]) return true;
        return false;
    }
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[] {
            1, 2, 3, 1
        }));
    }
}
