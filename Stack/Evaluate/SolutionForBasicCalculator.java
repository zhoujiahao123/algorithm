package algorithm.Stack.Evaluate;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SolutionForBasicCalculator {
    public static void main(String[] args) {
        String s = "1+1";
        System.out.println(new SolutionForBasicCalculator().calculate(s));
    }

    public int calculate(String s) {
        s = s.replaceAll(" ","");
        Stack<Integer> stack = new Stack<>();
        int result = 0;//表示当前结果
        int operand = 0;//表示当前数大小
        int sign = 1;//1表示加号,-1则代表减号
        char ch[] = s.toCharArray();
        for (char item : ch) {
            switch (item) {
                case '+':
                    result += operand*sign;
                    sign = 1;
                    operand = 0;
                    break;
                case '-':
                    result += operand*sign;
                    sign = -1;
                    operand = 0;
                    break;
                case '(':
                    stack.push(result);
                    stack.push(sign);
                    result = 0;
                    sign = 1;
                    break;
                case ')':
                    result += operand*sign;
                    operand = 0;
                    result *= stack.pop();
                    result += stack.pop();
                    break;
                default:
                    operand = operand*10 + (item-'0');
                    break;
            }
        }
        return result + operand*sign;
    }
}
