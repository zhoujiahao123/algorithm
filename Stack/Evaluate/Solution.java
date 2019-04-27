package Stack.Evaluate;

import java.util.Stack;

/**
 * 双栈法解决算术问题
 * 注意：Double.valueOf（）
 * 针对的是String类型的数据，如果放char进去会错.
 */
public class Solution {
    public static void main(String args[]){
        String s = "(1+((2+3)*(4*5)))";
        sovle(s);
    }
    public static void sovle(String equlation){
        Stack<Character> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        char ch[] = equlation.toCharArray();
        for(char c :ch){
            switch (c){
                case '(':
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    ops.push(c);
                    break;
                case ')':
                    char op = ops.pop();
                    double v = vals.pop();
                    switch (op){
                        case '+':v = v + vals.pop();vals.push(v);
                        break;
                        case '-':v = vals.pop() - v;vals.push(v);
                        break;
                        case '*':v = vals.pop()*v;vals.push(v);
                        break;
                        case '/':v = vals.pop()/v;vals.push(v);
                        break;
                        default:
                            break;
                    }
                    break;
                default:
                    String s = c+"";
                    vals.push(Double.valueOf(s));

            }
        }
        System.out.print(vals.pop());
    }
}
