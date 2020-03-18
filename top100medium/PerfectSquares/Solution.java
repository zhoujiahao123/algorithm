package algorithm.top100medium.PerfectSquares;

public class Solution {
    /**
     * ³¬Ê±
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (isPerfectSquares(i)) {
                dp[i] = 1;
            } else {
                int min = Integer.MAX_VALUE;
                for (int j = i - 1; j >= 1; j--) {
                    if (isPerfectSquares(j)) {
                        min = Math.min(min, 1 + dp[i - j]);
                    }
                }
                dp[i] = min;
            }
        }
        return dp[n];
    }

    public boolean isPerfectSquares(int i) {
        double temp = Math.sqrt(i);
        return temp - (int) temp == 0;
    }
}
