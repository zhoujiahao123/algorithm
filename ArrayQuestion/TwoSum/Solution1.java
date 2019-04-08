package TwoSum;

import java.util.Arrays;
import java.util.HashMap;

public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        int startIndex = 0, endIndex = nums.length - 1;
        while (startIndex < endIndex) {
            if (nums[startIndex] + nums[endIndex] == target) {
                int num1 = nums[startIndex];
                int num2 = nums[endIndex];
                return new int[]{map.get(num1), map.get(num2)};
            } else if (nums[startIndex] + nums[endIndex] < target) {
                startIndex++;
            } else {
                endIndex--;
            }
        }
        return null;
    }
}
