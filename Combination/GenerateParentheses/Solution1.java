package Combination.GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * 暴力破解法
 * 注意括号配对的规则，
 * 只要当前开括号（大于闭括号）就是一个正确的括号配对
 * 因为只有两个元素“（”，“）”，所以不必用全排列的方式，那样会比较复杂。
 */
public class Solution1 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        char[] ch = new char[2 * n];
        generateAll(result, "", 0, 0, n);
        return result;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    public void generateAll(List<String> result, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            result.add(cur);
            return;
        }
        if (open < max) {
            generateAll(result, cur + "(", open + 1, close, max);
        }
        //必须保证闭括号小于开括号
        if (close < open) {
            generateAll(result, cur + ")", open, close + 1, max);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return balance == 0;
    }
}
