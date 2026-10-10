package arrays.assignment_problems;

import java.util.*;

public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        if (nums.length == 0) throw new IllegalArgumentException("Array must not be empty");
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]) l = m + 1;
            else r = m;
        }
        return nums[l];
    }
    public static void main(String[] args) {
        System.out.println(findMin(new int[] {
            3, 4, 5, 1, 2
        }));
    }
}
