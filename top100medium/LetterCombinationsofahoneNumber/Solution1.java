package algorithm.top100medium.LetterCombinationsofahoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {
    List<String> res = new ArrayList<>();
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return res;
        backtrace("", digits);
        return res;
    }

    public void backtrace(String combination, String string_index) {
        if (string_index.length() == 0) {
            res.add(combination);
            return;
        }
        for (int i = 0; i < phone.get(string_index.substring(0, 1)).length(); i++) {
            String letter = phone.get(string_index.substring(0, 1)).substring(i, i + 1);
            backtrace(combination + letter, string_index.substring(1));
        }

    }
}
