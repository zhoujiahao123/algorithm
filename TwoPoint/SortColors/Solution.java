package algorithm.TwoPoint.SortColors;

public class Solution {
    public void sortColors(int[] nums) {
        int length = nums.length;
        int i = 0, j = 0, total1 = 0, total2 = 0;
        while (i < length) {
            if (nums[i] == 0) {
                nums[j++] = 0;
            } else if (nums[i] == 1) {
                total1++;
            } else {
                total2++;
            }
            i++;
        }
        i = 0;
        while (i < total1) {
            nums[j++] = 1;
            i++;
        }
        i = 0;
        while (i<total2){
            nums[j++] = 2;
            i++;
        }
    }
}
