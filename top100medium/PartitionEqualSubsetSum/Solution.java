package algorithm.top100medium.PartitionEqualSubsetSum;

import java.util.Arrays;

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[][] dp = new boolean[target + 1][nums.length];
        Arrays.fill(dp[0], true);
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = nums[0] == i;
        }
        for (int i = 1; i <= target; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i][j] = dp[i][j - 1] || dp[i - nums[j]][j-1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[target][nums.length - 1];
    }
}
