package algorithm.top100medium.BestTimetoBuyandSellStockwithCooldown;

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int[] s1 = new int[prices.length];
        int[] s2 = new int[prices.length];
        int[] s3 = new int[prices.length];
        s1[0] = 0;
        s2[0] = -prices[0];
        s3[0] = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            s1[i] = Math.max(s1[i - 1], s3[i - 1]);
            s2[i] = Math.max(s2[i - 1], s1[i - 1] - prices[i]);
            s3[i] = s2[i - 1] + prices[i];
        }
        int max = Math.max(s1[prices.length-1],s2[prices.length-1]);
        max = Math.max(s3[prices.length-1],max);
        return max;
    }
}
