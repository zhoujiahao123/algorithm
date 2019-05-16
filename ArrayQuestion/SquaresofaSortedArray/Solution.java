package ArrayQuestion.SquaresofaSortedArray;

import java.util.Arrays;

public class Solution {
    int ans[];
    public int[] sortedSquares(int[] A) {
        ans = new int[A.length];
        for(int i = 0;i<A.length;i++){
            ans[i] = (int) Math.pow(A[i],2);
        }
        Arrays.sort(ans);
        return (ans);
    }
}
