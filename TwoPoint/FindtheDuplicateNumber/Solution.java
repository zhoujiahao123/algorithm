package algorithm.TwoPoint.FindtheDuplicateNumber;

/**
 * 当一个数组中仅存在一对重复的数且满足该n+1个数属于1-n时
 * 下面的解法是最优解，即速度最快，空间最少。
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        boolean isFirst = true;
        int slow = 0, fast = 0;
        while (true) {
            if (!isFirst && slow == fast) {
                slow = 0;
                while (slow!=fast) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return fast;
            }else {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            isFirst = false;
        }
    }
}
