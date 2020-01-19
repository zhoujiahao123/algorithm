package algorithm.csp.que2019121;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        int ans[] = new int[4];
        int count = 1;
        for (int i = 1; ; i++) {
            if (i % 7 == 0||contain7(i)) {
                switch (i % 4) {
                    case 0:
                        ans[3]++;
                        break;
                    case 1:
                        ans[0]++;
                        break;
                    case 2:
                        ans[1]++;
                        break;
                    case 3:
                        ans[2]++;
                        break;
                }
            }else {
                count++;
            }
            if(count>n){
                break;
            }
        }
        for(int i : ans){
            System.out.println(i);
        }
    }

    private static boolean contain7(int i) {
        while (i / 10 != 0) {
            int lowPos = i % 10;
            if (lowPos == 7) {
                return true;
            }
            i = i / 10;
        }
        return i % 10 == 7;
    }
}
