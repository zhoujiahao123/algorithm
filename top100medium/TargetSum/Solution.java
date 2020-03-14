package algorithm.top100medium.TargetSum;

import java.util.Arrays;

public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int[][] memo = new int[nums.length][2001];
        for (int[] row: memo)
            Arrays.fill(row, Integer.MIN_VALUE);
        return findTarget(nums, S, 0,0 , memo);

    }
    public int findTarget(int[] nums, int target, int sum, int pos, int[][] memo) {
        if (pos == nums.length) {
            if (sum == target) return 1;
            else return 0;
        }else {
            if (memo[pos][sum + 1000] != Integer.MIN_VALUE) {
                return memo[pos][sum + 1000];
            }
            int add = findTarget(nums, target, sum + nums[pos], pos + 1, memo);
            int subtract = findTarget(nums, target, sum - nums[pos], pos + 1, memo);
            memo[pos][1000 + sum] = add + subtract;
            return memo[pos][1000 + sum];
        }
    }
}
