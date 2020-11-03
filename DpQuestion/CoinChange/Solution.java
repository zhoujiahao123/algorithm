package algorithm.DpQuestion.CoinChange;

public class Solution {
    int dp[][];
    class Interval {
        private int number;
        private int startTime;
        private int endTime;
        private int weight;

        public Interval(int number, int startTime, int endTime, int weight) {
            this.number = number;
            this.startTime = startTime;
            this.endTime = endTime;
            this.weight = weight;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int coins[] = new int[]{1,4,16,64};
        System.out.println(new Solution().coinChange(coins, 824));
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
                        //初始条件
                        dp[i][j] = j / coins[i];
                    }
                } else if (j == 0) {
                    //初始条件
                    dp[i][j] = 0;
                } else {
                    //判断取多少张当前钞票能达到所谓的最小值。
                    for (int k = 0; k * coins[i] <= j; k++) {
                        dp[i][j] = Math.min(dp[i - 1][j - k * coins[i]] + k, dp[i][j]);
                    }
                }
            }
        }
        return dp[len - 1][amount - 1] == 11111 ? -1 : dp[len - 1][amount - 1];
    }
}
