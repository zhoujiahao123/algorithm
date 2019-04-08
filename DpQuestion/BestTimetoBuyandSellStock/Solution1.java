package BestTimetoBuyandSellStock;

/**
 * 暴力破解的方式，缺点在于慢
 */
public class Solution1 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int max = 0;
        for (int i = 0; i < len - 1; i++) {
            int a = prices[i];
            for (int j = i+1; j < len; j++) {
                if (prices[j] - a > max) {
                    max = prices[j] - a;
                }
            }
        }
        return max;
    }
}
