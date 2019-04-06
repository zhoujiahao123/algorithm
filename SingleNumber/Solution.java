package SingleNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [4,1,2,1,2]
 * Output: 4
 * 需要注意的是：仅说给数字，并没有说给的一定是正数，如果出现负数，则不能用数字的方法来做了。
 */
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            if (nums[i]!=nums[i+1])
                return nums[i];
        }
        return 0;
    }
    //用异或的思想，2个相同的数异或为0,0异或上任何数都等于该数本身
    public int solve(int[] nums) {
        int res = 0;
        for(int i = 0;i<nums.length;i++){
            res = res^nums[i];
        }
        return res;
    }
}

