package algorithm.getMoney.money5;

import java.util.Random;
import java.util.Scanner;

public class PasswordEncoder {
    private static int[] realPas = {1,2,3,4,5};
    public static int[] getRandom(){
        Random random = new Random();
        int[] randomArray = new int[10];
        for(int i = 0;i<randomArray.length;++i){
            randomArray[i] = random.nextInt(3) + 1;
        }
        return randomArray;
    }
    public static boolean judge(int[] a,int[] randomArray){
        int[] real = new int[realPas.length];
        for(int i = 0;i<real.length;++i){
            real[i] = randomArray[realPas[i]];
        }
        for(int i = 0;i<real.length;++i){
            if(a[i] != real[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] randomArray = getRandom();
        System.out.print("PIN   ");
        for(int i = 0;i<10;++i){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.print("NUM   ");
        for(int i = 0;i<randomArray.length;++i){
            System.out.print(randomArray[i]+" ");
        }
        for(int j = 0;j<2;++j){
            System.out.println();
            System.out.println("Please enter the password£º");
            int[] a = new int[5];
            for(int i = 0;i<5;++i){
                a[i] = input.nextInt();
            }
            System.out.println("Is the password correct:"+judge(a,randomArray));
        }
    }
}

