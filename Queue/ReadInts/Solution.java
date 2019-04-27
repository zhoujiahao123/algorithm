package Queue.ReadInts;

import java.util.Scanner;

public class Solution {
    public static void main(String []args){
        Scanner input = new Scanner(System.in);

        while(true){
            if(input.hasNext()){
                int a = input.nextInt();
                System.out.println(a);
            }
        }
    }
}
