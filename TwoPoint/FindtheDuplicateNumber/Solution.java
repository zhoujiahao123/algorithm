package algorithm.TwoPoint.FindtheDuplicateNumber;

/**
 * ��һ�������н�����һ���ظ������������n+1��������1-nʱ
 * ����Ľⷨ�����Ž⣬���ٶ���죬�ռ����١�
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
