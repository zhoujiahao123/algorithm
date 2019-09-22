package algorithm.DpQuestion.CoinChange;

public class Solution {
    int dp[][];

    public static void main(String[] args) {
        int coins[] = new int[]{2,5,10,1};
        new Solution().coinChange(coins, 27);
    }

    public int coinChange(int[] coins, int amount) {
        amount++;
        int len = coins.length;
        dp = new int[len][amount];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < amount; j++) {
                dp[i][j] = 11111;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < amount; j++) {
                if (i == 0) {
                    if (j % coins[i] == 0) {
                        //��ʼ����
                        dp[i][j] = j / coins[i];
                    }
                } else if (j == 0) {
                    //��ʼ����
                    dp[i][j] = 0;
                } else {
                    //�ж�ȡ�����ŵ�ǰ��Ʊ�ܴﵽ��ν����Сֵ��
                    for (int k = 0; k * coins[i] <= j; k++) {
                        dp[i][j] = Math.min(dp[i - 1][j - k * coins[i]] + k, dp[i][j]);
                    }
                }
            }
        }
        return dp[len - 1][amount - 1] == 11111 ? -1 : dp[len - 1][amount - 1];
    }
}
