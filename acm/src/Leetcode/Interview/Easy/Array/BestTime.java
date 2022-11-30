package Leetcode.Interview.Easy.Array;

public class BestTime {
    public static void main(String[] args) {
        System.out.println(7 == maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(4 == maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(0 == maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    /*public static int maxProfit(int[] prices) {

        if (prices.length <= 1) {
            return 0;
        }

        int min = prices[0], max = prices[0], profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= max && i + 1 < prices.length) {
                max = prices[i];
                continue;
            }
            max = Math.max(max, prices[i]);
            profit += (max - min);
            min = max = prices[i];
        }

        return profit;
    }*/

    // Brute force
    public static int maxProfit(int[] prices) {
        int maxProfit = findMaxProfit(prices, 0, prices.length - 1);
        System.out.println(maxProfit);
        return maxProfit;
    }

    private static int findMaxProfit(int[] prices, int i, int j) {

        if (i >= j) {
            return 0;
        }

        if (i + 1 == j) {
            int p = prices[j] - prices[i];
            return Math.max(p, 0);
        }

        int max = -1;
        for (int k = i + 1; k < j; k++) {
            int p = findMaxProfit(prices, i, k) + findMaxProfit(prices, k + 1, j);
            max = Math.max(max, p);
        }

        return max;
    }
}
