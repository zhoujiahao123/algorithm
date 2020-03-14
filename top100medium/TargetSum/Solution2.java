package algorithm.top100medium.TargetSum;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;

public class Solution2 {
    int res;

    public int findTargetSumWays(int[] nums, int S) {
        return res;
    }

    public int find(int[] nums, int S, int pos, int cur, int memo[][]) {
        if (pos == nums.length) {
            if (S == cur) return 1;
            else return 0;
        }
        if (memo[pos][cur + 1000] != Integer.MIN_VALUE) {
            return memo[pos][cur + 1000];
        }
        int add = find(nums, S, pos + 1, cur - nums[pos], memo);
        int subtract = find(nums, S, pos + 1, cur + nums[pos], memo);
        memo[pos][cur + 1000] = add + subtract;
        return memo[pos][cur + 1000];
    }
}
