package programming_fundamental.practice_problems;

import java.util.*;

public class RotateArray {
    public static int[] rotateArray(int[] nums, int k) {
        if (nums.length == 0) return nums;
        k = ((k % nums.length) + nums.length) % nums.length;
        int[] out = new int[nums.length];
        for (int i = 0; i < nums.length; i++) out[(i + k) % nums.length] = nums[i];
        return out;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotateArray(new int[] {1, 2, 3, 4, 5, 6, 7}, 3)));
    }
}
