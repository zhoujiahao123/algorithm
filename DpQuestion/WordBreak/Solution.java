package algorithm.DpQuestion.WordBreak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DP + backtrace
 */
public class Solution {
    boolean canBreak = false;
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] breakAble = new boolean[s.length()];
        Arrays.fill(breakAble, true);
        backtrace(0, s, wordDict,  breakAble);
        return canBreak;
    }

    public void backtrace(int pos, String s, List<String> wordDict, boolean[] breakAble) {
        if (pos == s.length()) {
            canBreak = true;
            return;
        }
        if (!breakAble[pos]) {
            return;
        }
        for (int i = pos + 1; i <= s.length(); i++) {
            String word = s.substring(pos, i);
            if (!wordDict.contains(word)) continue;
            backtrace(i, s, wordDict, breakAble);
        }
    }
}

