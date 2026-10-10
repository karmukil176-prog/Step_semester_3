package arrays.class_problems;

import java.util.*;

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int min = prices[0], best = 0;
        for (int i = 1; i < prices.length; i++) {
            best = Math.max(best, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return best;
    }
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {
            7, 1, 5, 3, 6, 4
        }));
    }
}
