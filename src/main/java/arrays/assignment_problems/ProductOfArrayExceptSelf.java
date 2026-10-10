package arrays.assignment_problems;

import java.util.*;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] out = new int[nums.length];
        int p = 1;
        for (int i = 0; i < nums.length; i++) {
            out[i] = p;
            p *= nums[i];
        }
        p = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            out[i] *= p;
            p *= nums[i];
        }
        return out;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[] {
            1, 2, 3, 4
        })));
    }
}
