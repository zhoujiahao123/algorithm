package algorithm.top100medium.LetterCombinationsofahoneNumber;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        List<String>[] lists = new List[10];
        init(lists);
        List<String> res = new ArrayList<>(lists[digits.charAt(0) - 48]);
        for (int i = 1; i < digits.length(); i++) {
            res = combine(res, lists[digits.charAt(i) - 48]);
        }
        return res;
    }

    public List<String> combine(List<String> list1, List<String> list2) {
        List<String> res = new ArrayList<>();
        for (String s1 : list1) {
            for (String s2 : list2) {
                res.add(s1 + s2);
            }
        }
        return res;
    }

    public void init(List<String>[] lists) {
        for (int i = 2; i < 10; i++) {
            lists[i] = new ArrayList<>();
        }
        lists[2].add("a");
        lists[2].add("b");
        lists[2].add("c");
        lists[3].add("d");
        lists[3].add("e");
        lists[3].add("f");
        lists[4].add("g");
        lists[4].add("h");
        lists[4].add("i");
        lists[5].add("j");
        lists[5].add("k");
        lists[5].add("l");
        lists[6].add("m");
        lists[6].add("n");
        lists[6].add("o");
        lists[7].add("p");
        lists[7].add("q");
        lists[7].add("r");
        lists[7].add("s");
        lists[8].add("t");
        lists[8].add("u");
        lists[8].add("v");
        lists[9].add("w");
        lists[9].add("x");
        lists[9].add("y");
        lists[9].add("z");
    }
}
