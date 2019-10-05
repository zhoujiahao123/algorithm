package algorithm.DpQuestion.LIS;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int a[] = new int[]{11,3,6,9,13,14,18,12,15,2,16,20,8,19};
        new Solution().lengthOfLIS(a);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        return solveByDp(nums);
    }

    public int bruteForce(int nums[], int pre, int curPos) {
        if (curPos == nums.length) {
            return 0;
        }
        int taken = 0;
        if (nums[curPos] > pre) {
            taken = 1 + bruteForce(nums, nums[curPos], curPos + 1);
        }
        int notTaken = bruteForce(nums, pre, curPos + 1);
        return Math.max(taken, notTaken);
    }

    public int solveByDp(int nums[]) {
        int dp[] = new int[nums.length];
        int max = 1;
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }
}