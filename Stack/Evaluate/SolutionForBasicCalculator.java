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
        int result = 0;//��ʾ��ǰ���
        int operand = 0;//��ʾ��ǰ����С
        int sign = 1;//1��ʾ�Ӻ�,-1��������
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
