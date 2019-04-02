package MoveZeroes;

class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                for (int j = i; j < len - 1; j++) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}