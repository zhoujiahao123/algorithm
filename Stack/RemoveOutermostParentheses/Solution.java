package Stack.RemoveOutermostParentheses;

import java.util.Stack;

/**
 * Input: "(()())(())"
 * Output: "()()()"
 * Explanation:
 * The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
 * After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
 */
public class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder builder = new StringBuilder();
        int open = 0;
        for (char c : S.toCharArray()) {
            if (c == '(' && open++ > 0) builder.append('(');
            if (c == ')' && open-- > 1) builder.append(')');
        }
        return builder.toString();
    }
}
