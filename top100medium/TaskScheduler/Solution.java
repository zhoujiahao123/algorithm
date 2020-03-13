package algorithm.top100medium.TaskScheduler;

import java.util.Arrays;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] ans = new int[26];
        int res = 0;
        if (n == 0) return tasks.length;
        for (char c : tasks) {
            ans[c - 'A']++;
        }
        Arrays.sort(ans);
        while (ans[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (ans[25] == 0) break;
                if (ans[25 - i] > 0 && i <= 25) {
                    ans[25 - i]--;
                }
                i++;
                res++;
            }
            Arrays.sort(ans);
        }
        return res;
    }
}
