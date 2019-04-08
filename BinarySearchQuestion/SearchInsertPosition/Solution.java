package BinarySearchQuestion.SearchInsertPosition;

/**
 * 求插入的位置，其实也就是第一个比给定的target数大的数的问题，返回end +1 即可(在找不到这个数的情况下)。
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int length = nums.length;
        int end = nums.length - 1;
        int mid = start;
        while (start <= end) {
            mid = start + ((end - start) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end +1;
    }
}
