package algorithm.TwoPoint.RotateArray;

public class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int a[] = new int[len];
        int i = 0;
        while (i < k) {
            int temp = nums[len - 1];
            for (int j = len - 2; j >= 0; j--) {
                nums[j+1] = nums[j];
            }
            nums[0] = temp;
            i++;
        }
    }
}
