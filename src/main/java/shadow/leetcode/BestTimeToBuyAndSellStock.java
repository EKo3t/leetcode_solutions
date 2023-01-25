package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">Task description</a>
 * Difficulty: easy
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int[] maximums = new int[prices.length];
        int max = Integer.MIN_VALUE;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (max < prices[i])
                max = prices[i];

            maximums[i] = max;
        }
        int maxDiff = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (maxDiff < maximums[i + 1] - prices[i]) {
                maxDiff = maximums[i + 1] - prices[i];
            }
        }
        return maxDiff;
    }
}
