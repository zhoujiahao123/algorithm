package algorithm.getMoney.money5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for(int i = 0;i<4;++i){
            String temp = input.nextLine();
            char[] c = temp.toCharArray();
            int length = c.length;
            if('?' == c[length - 1]){
                if(length % 2 ==0){
                    System.out.println("Yes");
                }else {
                    System.out.println("No");
                }
            }else if('!' == c[length - 1]){
                System.out.println("Wow");
            }else{
                System.out.println("You always say\""+temp+"\"");
            }
        }
        System.out.println("program down");
    }
}
