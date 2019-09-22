package algorithm.DpQuestion.longestPalindromicSubstring;

public class SolutionUseDP {
    int ans[][];
    int maxi = 0;
    int maxj = 0;
    int maxLength = 0;


    public static void main(String[] args) {
        new SolutionUseDP().longestPalindrome("cbbd");
    }

    public String longestPalindrome(String s) {
        if (s.equals("")) return "";
        ans = new int[s.length()][s.length()];
        char c[] = s.toCharArray();
        for (int j = c.length-1; j >=0; j--) {
            for (int i = 0; i <= j; i++) {
                if (i == j || i + 1 == j && c[i] == c[j]) {
                    ans[i][j] = 1;
                    if (maxLength <= j - i) {
                        maxLength = j - i + 1;
                        maxi = i;
                        maxj = j;
                    }
                } else {
                    if (ans[i + 1][j - 1] == 1 && c[i] == c[j]) {
                        ans[i][j] = 1;
                        if (maxLength <= j - i) {
                            maxLength = j - i + 1;
                            maxi = i;
                            maxj = j;
                        }
                    } else {
                        ans[i][j] = -1;
                    }

                }
            }
        }
        return s.substring(maxi, maxj + 1);
    }
}
