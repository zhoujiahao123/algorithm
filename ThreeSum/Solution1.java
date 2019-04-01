package ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        //判断是否合法
        if (nums == null || nums.length < 3)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            //不能和前一个相同，例如前一个为0,那么让twosum也去找0，如果这次还是让twosum去找0，则会出现重复。
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            twoSum(nums, i + 1, nums.length - 1, -nums[i], result);
        }
        return result;
    }

    public void twoSum(int nums[], int startIndex, int endIndex, int target, List<List<Integer>> result) {
        //因为已经排好序了，直接按小数+大数是否等于0来判断即可
        while (startIndex < endIndex) {
            if (nums[startIndex] + nums[endIndex] == target) {
                int num1 = nums[startIndex];
                int num2 = nums[endIndex];
                result.add(Arrays.asList(nums[startIndex], nums[endIndex],-target));
                //前后都应当改变，否则不平衡，就例如要找0，本来是-1 + 1 =0,若仅增大-1，那是找不到答案的，1也得减少。
                while (startIndex < endIndex && nums[startIndex] == num1) startIndex++;
                while (startIndex < endIndex && nums[endIndex] == num2) endIndex--;
            } else if (nums[startIndex] + nums[endIndex] < target) {
                startIndex++;
            } else {
                endIndex--;
            }
        }
    }
}
