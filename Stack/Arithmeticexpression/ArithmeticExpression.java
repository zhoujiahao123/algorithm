package algorithm.Stack.Arithmeticexpression;

import algorithm.csp.que2019123.Main;

import java.util.Stack;

public class ArithmeticExpression {

    public static String toPostfix(String expression) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        int pos = 0;
        int len = expression.length();
        while (pos < len) {
            char ch = expression.charAt(pos);
            switch (ch) {
                case '+':
                case '-':
                    while (!stack.empty() && stack.peek() != '(') {
                        postfix.append(stack.pop());
                    }
                    stack.push(ch);
                    ++pos;
                    break;
                case '*':
                case '/':
                    while (!stack.empty() && (stack.peek() == '*' || stack.peek() == '/')) {
                        postfix.append(stack.pop());
                    }
                    stack.push(ch);
                    ++pos;
                    break;
                case '(':
                    stack.push(ch);
                    ++pos;
                    break;
                case ')':
                    char temp = stack.pop();
                    while ((Character) temp != null && temp != '(') {
                        postfix.append(temp);
                        temp = stack.pop();
                    }
                    ++pos;
                    break;
                default:
                    while (ch >= '0' && ch <= '9') {
                        postfix.append(ch);
                        ++pos;
                        if (pos == len) {
                            break;
                        }
                        ch = expression.charAt(pos);
                    }
                    postfix.append(" ");
                    break;
            }
        }
        while (!stack.empty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }

    public static int calculateValueByPostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();
        int pos = 0;
        int result = 0, len = postfix.length();
        while (pos < len) {
            char ch = postfix.charAt(pos);
            if (ch >= '0' && ch <= '9') {
                while (ch != ' ') {
                    result = result * 10 + (ch - 48);
                    ++pos;
                    ch = postfix.charAt(pos);
                }
                stack.push(result);
                result = 0;
                ++pos;
            } else {
                int after = stack.pop();
                int before = stack.pop();
                switch (ch) {
                    case '+':
                        result = after + before;
                        break;
                    case '-':
                        result = before - after;
                        break;
                    case '*':
                        result = after * before;
                        break;
                    case '/':
                        result = before / after;
                        break;
                }
                stack.push(result);
                result = 0;
                ++pos;
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String expstr = "1+3*(9-2)+90";
        String postfix = toPostfix(expstr);
        System.out.println("中缀表达式->expstr=  " + expstr);
        System.out.println("后缀表达式->postfix= " + postfix);
        System.out.println("计算结果->value= " + calculateValueByPostfix(postfix));
    }
}
