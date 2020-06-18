package algorithm.DpQuestion.WordBreak2;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {


    public List<String> wordBreak(String s, List<String> wordDict) {
        List<Integer>[] starts = new List[s.length() + 1];
        starts[0] = new ArrayList<>();
        int max = getMaxLen(wordDict);
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j > 0 && i - j <= max; --j) {
                if (starts[j] == null) continue;
                if (wordDict.contains(s.substring(j, i))) {
                    if (starts[i] == null) {
                        starts[i] = new ArrayList<>();
                    }
                    starts[i].add(j);
                }
            }
        }
        List<String> resList = new ArrayList<>();
        if (starts[s.length()] == null) {
            return resList;
        }
        backtrace(s.length(), resList, starts, s, "");
        return resList;
    }

    public void backtrace(int end, List<String> resList, List<Integer>[] starts, String s, String path) {
        if (end == 0) {
            resList.add(path.substring(1));
            return;
        }
        for (Integer i : starts[end]) {
            String word = s.substring(i, end);
            backtrace(i, resList, starts, s, " " + word + path);
        }
    }

    private int getMaxLen(List<String> wordDict) {
        int max = 0;
        for (String s : wordDict) {
            max = Math.max(max, s.length());
        }
        return max;
    }

}
