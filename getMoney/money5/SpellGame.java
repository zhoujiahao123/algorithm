package algorithm.getMoney.money5;

import java.util.Scanner;


import java.util.Scanner;

public class SpellGame {
    /**
     * Put the first character at the end, and then read it in reverse
     * @return
     */
    public static boolean judge(String word){
        String newWord = reverseString(word.substring(1) + word.charAt(0));
        if(word.equals(newWord)){
            return true;
        }else {
            return false;
        }
    }
    public static String reverseString(String word){
        char[] c = word.toCharArray();
        for(int i = 0;i<c.length/2;++i){
            char temp = c[i];
            c[i] = c[c.length - 1- i];
            c[c.length - 1- i] = temp;
        }
        return new String(c);
    }

    public static void main(String[] args) {
        System.out.println("Please enter a word£º");
        Scanner input = new Scanner(System.in);
        String temp=input.nextLine();
        while (!"quit".equals(temp)){
            temp = temp.toLowerCase();
            System.out.println("Meet the conditions£º"+judge(temp));
            System.out.println("Please enter a word£º");
            temp = input.nextLine();
        }
        System.out.println("End of program ");
    }
}