package algorithm.top100medium.ProductofArrayExceptSelf;

public class Solution {
    public static void main(String[] args) {
        int a[] = {1,2,3,4};
        new Solution().productExceptSelf(a);
    }
    public int[] productExceptSelf(int[] nums) {
        boolean hasOneZero = false, hasMoreZero = false;
        int total = 1;
        int pos = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (!hasOneZero) {
                    hasOneZero = true;
                    pos = i;
                } else {
                    hasMoreZero = true;
                    break;
                }
            } else {
                total = total * nums[i];
            }
        }
        int[] output = new int[nums.length];
        if (hasMoreZero) {

        } else if (hasOneZero) {
            output[pos] = total;
        } else {
            for (int i = 0; i < nums.length; i++) {
                output[i] = total/nums[i];
            }
        }
        return output;
    }
}
