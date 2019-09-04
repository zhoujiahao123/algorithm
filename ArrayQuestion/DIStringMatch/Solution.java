package ArrayQuestion.DIStringMatch;

import java.util.Arrays;

/**
 * Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.
 *
 * Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:
 *
 * If S[i] == "I", then A[i] < A[i+1]
 * If S[i] == "D", then A[i] > A[i+1]
 * Example 1:
 *
 * Input: "IDID"
 * Output: [0,4,1,3,2]
 * Example 2:
 *
 * Input: "III"
 * Output: [0,1,2,3]
 * Example 3:
 *
 * Input: "DDI"
 * Output: [3,2,0,1]
 *
 */
public class Solution {
    int ans[];

    /**
     * 直接利用全排列方式
     * 运行超时
     * @param S
     * @return
     */
    public int[] diStringMatch(String S) {
        int a[] = new int[S.length() + 1];
        for (int i = 0; i < S.length() + 1; i++) {
            a[i] = i;
        }
        try {
            slove(S.toCharArray(), a, 0);
        } catch (Exception e) {
            return ans;
        }
        throw null;
    }

    public void slove(char c[], int a[], int k) {
        if (k == a.length) {
            boolean isOK = true;
            for (int i = 0; i < k - 1; i++) {
                if (c[i] == 'I') {
                    if (a[i] >= a[i + 1]) {
                        isOK = false;
                        break;
                    }
                } else {
                    if (a[i] <= a[i + 1]) {
                        isOK = false;
                        break;
                    }
                }
            }
            if (isOK) {
                ans = Arrays.copyOfRange(a, 0, a.length);
                throw null;
            }
        }
        for (int i = k; i < a.length; i++) {
            int temp = a[k];
            a[k] = a[i];
            a[i] = temp;
            slove(c, a, k + 1);
            a[i] = a[k];
            a[k] = temp;
        }
    }
}
