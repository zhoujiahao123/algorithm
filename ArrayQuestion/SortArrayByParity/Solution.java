package ArrayQuestion.SortArrayByParity;

/**
 * 将一个数组的偶数放在前面，奇数放在后面
 * 尝试采用双指针的方式
 */
public class Solution {
    public int[] sortArrayByParity(int[] A) {
        int end = A.length - 1;
        int start = 0;
        while (start < end) {
            while (A[start] % 2 == 0 && A[end] % 2 == 1) {
                start++;
                end--;
            }
            if(start>=end) break;
            if (A[start] % 2 == 1 && A[end] % 2 == 0) {
                int temp = A[start];
                A[start++] = A[end];
                A[end++] = temp;
            } else if (A[start] % 2 == 1) {
                end--;
            } else {
                start++;
            }
        }
        return A;
    }
}
