package ArrayQuestion.NRepeatedElementinSize2NArray;

import java.util.Arrays;

class Solution {
    public int repeatedNTimes(int[] A) {
        Arrays.sort(A);
        int len = A.length - 1;
        int mid = (len) / 2;
        if (A[mid + 1] == A[len]) {
            return A[len];
        }else {
            return A[mid];
        }
    }
}
