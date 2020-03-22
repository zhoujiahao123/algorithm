package algorithm.Contest.LongestHappyPrefix;

public class Solution2 {
    public String longestPrefix(String s) {
        int maxMatchLengths[] = new int[s.length()];
        int maxLength = 0;
        for (int i = 1; i < s.length(); i++) {
            while (maxLength > 0 && s.charAt(i) != s.charAt(maxLength)) {
                maxLength = maxMatchLengths[maxLength - 1];
            }
            if (s.charAt(i) == s.charAt(maxLength)) {
                maxLength++;
            }
            maxMatchLengths[i] = maxLength;
        }
        return s.substring(0, maxLength);
    }
}
