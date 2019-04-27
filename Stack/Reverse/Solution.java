package Stack.Reverse;

import java.util.Stack;

/**
 * 利用栈做数组的翻转（感觉还没数组做好。。。。。）
 */
public class Solution {
    public static void main(String[] args){

    }
    public static void reverse(int a[]){
        Stack<Integer> stack = new Stack<Integer>();
        for(int i :a){
            stack.push(i);
        }
        for(int i:stack){
            System.out.print(i);
        }
    }
}
