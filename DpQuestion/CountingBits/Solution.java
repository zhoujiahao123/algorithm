package CountingBits;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num
 * calculate the number of 1's in their binary representation and return them as an array.
 *
 * Example 1:
 *
 * Input: 2
 * Output: [0,1,1]
 * Example 2:
 *
 * Input: 5
 * Output: [0,1,1,2,1,2]
 * 这道题找到规律十分重要，0-1,2-3,4-7,8-15,这里的区别都在于在前一个的基础上添1就可以了。所以以递推形式很好解决问题
 */
class Solution {
    int ans[];

    public int[] countBits(int num) {
        if(num == 0) return new int[]{0};
        ans = new int[num + 1];
        ans[0] = 0;
        ans[1] = 1;
        int i = 1;
        boolean breakFlag = false;
        while (true) {
            int a = (int) Math.pow(2, i);
            int b = (int) Math.pow(2, i + 1);
            for (int j = a; j < b; j++) {
                if (j == ans.length) {
                    breakFlag = true;
                    break;
                }
                ans[j] = ans[j - a] + 1;
            }
            if (breakFlag) {
                break;
            }
            i++;
        }
        return ans;
    }
}