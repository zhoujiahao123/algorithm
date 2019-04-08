package ShortestUnsortedContinuousSubarray;

import java.util.Arrays;

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int temp[] = nums.clone();
        Arrays.sort(temp);
        int start = 0, end = 0;
        for (int i = 0; i < temp.length; i++) {
            if (nums[i] != temp[i]) {
                start = i;
                break;
            }
        }
        for (int i = temp.length - 1; i >= 0; i--) {
            if (nums[i] != temp[i]) {
                end = i;
                break;
            }
        }
        return (end + start) == 0 ? 0 : (end - start + 1);
    }
}