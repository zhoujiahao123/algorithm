package algorithm.DpQuestion.longestPalindromicSubstring;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution {
    List<String> listPalindromic = new ArrayList<>();
    List<String> listUnPalindromic = new ArrayList<>();
    boolean isFind = false;
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("civilwartestingwhetheleshallnotperishfromtheearth"));
    }

    public String longestPalindrome(String s) {
        solve(s);
        String max = "";
        for (Iterator<String> it = listPalindromic.iterator(); it.hasNext(); ) {
            String str = it.next();
            if (str.length() > max.length()) {
                max = str;
            }
        }
        return max;
    }

    public void solve(String s) {
        if (s.equals("") || listUnPalindromic.contains(s) || listPalindromic.contains(s)) return;
        boolean flag = isPalindromic(s);
        if (flag) {
            listPalindromic.add(s);
        } else {
            listUnPalindromic.add(s);
        }
        solve(s.substring(0, s.length() - 1));
        solve(s.substring(1, s.length()));
    }

    public boolean isPalindromic(String s) {
        char[] c = s.toCharArray();
        int len = c.length;
        for (int i = 0; i < len; i++) {
            if (c[i] != c[len - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
