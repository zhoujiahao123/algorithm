package algorithm.top100medium.DailyTemperatures;

import java.util.Arrays;

public class Solution {
    int next[] = new int[101];

    public int[] dailyTemperatures(int[] T) {
        int ans[] = new int[T.length];
        Arrays.fill(next, Integer.MAX_VALUE);
        for (int i = T.length - 1; i >= 0; i--) {
            next[T[i]] = i;
            int min = Integer.MAX_VALUE;
            for (int j = T[i] + 1; j <= 100; j++) {
                if (next[j] < min) {
                    min = next[j] - i;
                }
            }
            ans[i] = min == Integer.MAX_VALUE ? 0 : min-i;
        }
        return ans;
    }
}
