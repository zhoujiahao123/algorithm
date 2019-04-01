package MaximumSubarray;

/**
 * 利用动态规划做，比用数组和要快很多。
 * 只是转移公式不好想。
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int thisSum = 0;
        for(int i = 0;i<nums.length;i++){
            thisSum = Math.max(nums[i],thisSum+nums[i]);
            maxSum = Math.max(thisSum,maxSum);
        }
        return  maxSum;
    }
}
