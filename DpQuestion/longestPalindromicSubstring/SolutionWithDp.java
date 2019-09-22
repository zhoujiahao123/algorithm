package algorithm.DpQuestion.longestPalindromicSubstring;

public class SolutionWithDp {
    public String longestPalindrome(String s) {
        if(s.equals("")) return "";
        String res = null;
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i,j+1);
                }
            }
        }
        return res;
    }
}
