package algorithm.ArrayQuestion.JudgeWordNum;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        System.out.println(solve(s.toCharArray()));
    }

    public static int solve(String s) {
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(s);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count + 1;
    }

    public static int solve(char c[]) {
        int count = 0;
        boolean inWord = false;//表示当前字符是否在单词中，若在就是true，这用来表示一个新单词的开头
        for (Character item : c) {
            if (item != 32 && !inWord) {
                inWord = true;
                count++;
            }
            if (item == 32) {
                inWord = false;
            }
        }
        return count;
    }
}
