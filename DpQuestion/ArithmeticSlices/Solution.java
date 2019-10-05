package algorithm.DpQuestion.ArithmeticSlices;

public class Solution {
    int dp[];

    public int numberOfArithmeticSlices(int[] A) {
        dp = new int[A.length];
        for (int i = 2; i < dp.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int total = 0;
        for (int i = 2; i < dp.length; i++) {
            total += dp[i];
        }
        return total;
    }
}
