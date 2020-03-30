package algorithm.Contest.CountNumberofTeams;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int a[] = {2, 1, 3};
        new Solution().numTeams(a);
    }

        public int numTeams(int[] rating) {
            int res = 0;
            int dp[] = new int[rating.length];
            for (int i = 0; i < rating.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (rating[i] > rating[j]) dp[i]++;
                }
            }
            for (int i = 0; i < dp.length; i++) {
                if (dp[i] == 2) {
                    res++;
                }
                if (dp[i] > 2) {
                    int addPart = dp[i] - 1;
                    res += (addPart * (addPart - 1)) / 2;
                }
            }
            Arrays.fill(dp, 0);
            for (int i = 0; i < rating.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (rating[i] < rating[j]) dp[i]++;
                }
            }
            for (int i = 0; i < dp.length; i++) {
                if (dp[i] == 2) {
                    res++;
                }
                if (dp[i] > 2) {
                    int addPart = dp[i] - 1;
                    res += (addPart * (addPart - 1)) / 2;
                }
            }
            return res;
        }

}
