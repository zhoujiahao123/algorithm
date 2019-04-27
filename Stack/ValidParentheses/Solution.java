package Stack.ValidParentheses;

import java.util.Stack;

/**
 * 用栈解决括号配对问题时要注意的问题：
 * 1.使用stack.pop之前要判断栈是否为空。
 * 2.只有当最后栈为空的时候才能说是一个正确的结果。
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char ch[] = s.toCharArray();
        for(int i = 0;i<ch.length;i++){
            switch (ch[i]){
                case '(':
                    stack.push('(');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case '{':
                    stack.push('{');
                    break;
                case ')':
                    if(stack.empty()||stack.pop()!='('){
                        return false;
                    }
                    break;
                case ']':
                    if(stack.empty()||stack.pop()!='['){
                        return false;
                    }
                    break;
                case '}':
                    if(stack.empty()||stack.pop()!='{'){
                        return false;
                    }
                    break;
                    default:
                        return false;
            }
        }
        //若栈为空才能说明是正确的
        return stack.empty();
    }
}