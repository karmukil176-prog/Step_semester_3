package programming_fundamental.class_problems;

import java.util.*;

public class TwoSum {
    public static int[] twoSum(int[] a, int target) {
        for (int i = 0; i < a.length; i++)
            for (int j = i + 1; j < a.length; j++)
                if ((long) a[i] + a[j] == target) return new int[] {i, j};
        throw new IllegalArgumentException("No solution");
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {2, 7, 11, 15}, 9)));
    }
}
