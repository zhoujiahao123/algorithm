package algorithm.DpQuestion.MinimumPathSum;

class Solution {
    int dp[][];

    public static void main(String[] args) {
        int a[][] = {{1,2,5},{3,2,1}};
        new Solution().minPathSum(a);
    }
    public int minPathSum(int[][] grid) {
        //初始化dp数组
        dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        //动态规划解决
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[grid.length-1].length-1];
    }
}
