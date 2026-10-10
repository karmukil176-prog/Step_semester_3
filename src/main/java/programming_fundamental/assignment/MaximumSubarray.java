package programming_fundamental.assignment;

import java.util.*;

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) throw new IllegalArgumentException("Array must not be empty");
        int best = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            best = Math.max(best, sum);
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
