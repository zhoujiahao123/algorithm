package algorithm.top100medium.PalindromicSubstrings;

import algorithm.top100medium.DailyTemperatures.Solution2;

public class Solution {
    int count;

    public static void main(String[] args) {
        new Solution().countSubstrings("aaaa");
    }

    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += solve(s, i, i);
            count += solve(s, i, i + 1);
        }
        return count;
    }


    public int solve(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
