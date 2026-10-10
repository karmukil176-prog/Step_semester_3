package programming_fundamental.assigment_problems;

import java.util.*;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        Map<Long, Integer> seen = new HashMap<>();
        seen.put(0L, 1);
        long sum = 0;
        int answer = 0;
        for (int n : nums) {
            sum += n;
            answer += seen.getOrDefault(sum - k, 0);
            seen.merge(sum, 1, Integer::sum);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[] {1, 1, 1}, 2));
    }
}
