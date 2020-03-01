package algorithm.top100medium.PalindromicSubstrings;

public class Solution2 {
    public static void main(String[] args) {
        new Solution2().countSubstrings("aaaa");
    }
    public int countSubstrings(String s) {
        boolean isVisited[][] = new boolean[s.length()][s.length()];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                isVisited[j][i] = (s.charAt(i) == s.charAt(j)) && (i - j < 3||isVisited[j + 1][i - 1] );
                if (isVisited[j][i]) count++;
            }
        }
        return count;
    }

}
