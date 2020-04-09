package algorithm.Stack.BackspaceStringCompare;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        new Solution().backspaceCompare("oi###mupo##rszty#s#xu###bxx##dqc#gdjz", "oi###mupo##rszty#s#xu####bxx##dqc#gdjz");
    }

    public boolean backspaceCompare(String S, String T) {
        return preProcess(S).equals(preProcess(T));
    }

    public String preProcess(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(String.valueOf(s.charAt(i)));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
