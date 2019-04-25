package Combination.GenerateParentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 排列解决，但当n>=5时运行超时
 */
class Solution {
    List<String> list = new ArrayList<>();
    List<String> wrongList = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generateParenthesis(5);
        for (int i = 0; i < solution.list.size(); i++) {
            System.out.println(solution.list.get(i));
        }
    }

    public List<String> generateParenthesis(int n) {
        String s = "";
        for (int i = 0; i < n; i++) {
            s += "(";
        }
        for (int i = n; i < 2 * n; i++) {
            s += ")";
        }
        solve(0, s);
        return list;
    }

    public void solve(int n, String s) {
        char ch[] = s.toCharArray();
        if (n == ch.length) {
            if (wrongList.contains(s) || list.contains(s)) {
                return;
            }
            Stack stack = new Stack();
            boolean flag = true;
            String ans = "";
            for (int i = 0; i < ch.length; i++) {
                ans += ch[i];
                if (ch[i] == '(') {
                    stack.push(ch[i]);
                } else {
                    if (!stack.empty()) {
                        stack.pop();
                    } else {
                        flag = false;
                    }
                }
            }
            if (flag) {
                list.add(ans);
            } else {
                wrongList.add(ans);
            }
        }
        for (int i = n; i < ch.length; i++) {
            char temp = ch[i];
            ch[i] = ch[n];
            ch[n] = temp;
            solve(n + 1, String.valueOf(ch));
            ch[n] = ch[i];
            ch[i] = temp;
        }
    }
}