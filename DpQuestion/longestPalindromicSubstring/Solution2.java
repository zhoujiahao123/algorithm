package algorithm.DpQuestion.longestPalindromicSubstring;

public class Solution2 {
    String ans[][];

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.longestPalindrome("a"));
    }

    public String longestPalindrome(String s) {
        if (s.equals("")) {
            return s;
        }

        ans = new String[s.length()][s.length()];
        int maxi = 0;
        int maxj = 0;
        int maxLength = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (i == len - 1 || j == 0) {
                    boolean is = isPalindromic(s.substring(j, i + 1));
                    if (is) {
                        ans[j][i] = s.substring(j, i + 1);
                        if (ans[j][i].length() > maxLength) {
                            maxi = i;
                            maxj = j;
                            maxLength = ans[j][i].length();
                        }
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (ans[j + 1][i - 1] == null) {
                            //j+1可能会大于i
                            boolean is = isPalindromic(s.substring(j + 1, i));
                            if (is) {
                                ans[j][i] = s.substring(j, i + 1);
                                if (ans[j][i].length() > maxLength) {
                                    maxi = i;
                                    maxj = j;
                                    maxLength = ans[j][i].length();
                                }
                            } else {
                                ans[j][i] = "not";
                            }
                        } else if (ans[j + 1][i - 1].equals("not")) {
                            ans[j][i] = "not";
                        } else {
                            ans[j][i] = s.substring(j, i + 1);
                            if (ans[j][i].length() > maxLength) {
                                maxi = i;
                                maxj = j;
                                maxLength = ans[j][i].length();
                            }
                        }
                    } else {
                        ans[j][i] = "not";
                    }
                }
            }
        }
        return ans[maxj][maxi]==null?s.charAt(0)+"":ans[maxj][maxi];
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
