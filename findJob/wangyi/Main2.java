package algorithm.findJob.wangyi;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        int[] a = {10,10,5,10,20};
        Main2 main2 = new Main2();
        System.out.println(main2.billsChange(a));
    }

    public int billsChange(int[] a) {
        int fiveCount = 2, tenCount = 0, twlCount = 0;
        int res = 0;
        for (int i = 0; i < a.length; ++i) {
            if (a[i] == 5) {
                fiveCount++;
                res++;
            } else if (a[i] == 10) {
                if (fiveCount > 0) {
                    fiveCount--;
                    tenCount++;
                    res++;
                }else{
                    break;
                }

            } else if (a[i] == 20) {
                if (tenCount > 0 && fiveCount > 0) {
                    tenCount--;
                    fiveCount--;
                    twlCount++;
                    res++;
                } else if (fiveCount >= 3) {
                    fiveCount -= 3;
                    res++;
                    twlCount++;
                }else{
                    break;
                }
            }
        }
        return res;
    }
}
