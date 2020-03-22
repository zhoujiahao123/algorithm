package algorithm.Contest.LongestHappyPrefix;

public class Solution {
    /**
     * ±©Á¦ÆÆ½â-³¬Ê±
     * @param s
     * @return
     */
    public String longestPrefix(String s) {
        for (int i = 1, j = s.length() - 2; j >= 0; i++, j--) {
            String left = s.substring(0, j+1);
            String right = s.substring(i);
            if (left.equals(right)) {
                return left;
            }
        }
        return "";
    }
}
