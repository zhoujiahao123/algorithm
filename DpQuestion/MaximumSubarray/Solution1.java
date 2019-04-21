package DpQuestion.MaximumSubarray;
//用递归的方式也能做，用递归的时候主要自己要从第一个开始推公式，这样好判断一点，一般从数组的开始或者结尾处开始推。
public class Solution1 {
    int ans[];

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (max < sovle(i, nums))
                max = ans[i];
        }
        return max;
    }

    public int sovle(int i, int[] nums) {
        if (i == 0) {
            return ans[i] = nums[0];
        }
        if (ans[i] != 0) {
            return ans[i];
        }
        return ans[i] = Math.max(nums[i],sovle(i-1,nums)+nums[i]);
    }
}
