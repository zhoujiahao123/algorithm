package algorithm.ByteDance;

import java.util.ArrayList;
import java.util.List;

public class Main {
    int res = 0;

    public static void main(String[] args) {
        Main main = new Main();
        main.fun(2, 1, 3, 0, 0);
        int count = 0;
        for (int i = 1; i <= 3; i++) {
            if (i % 3 == 0) count++;
        }
        main.res -= count;
        int ans = 1;
        for (int i = 1; i < 2; i++) {
            ans *= i;
        }
        System.out.println(ans);
    }

    public void fun(int n, int l, int r, int pos, int total) {
        if (n == pos) {
            if (total % 3 == 0) {
                res++;
            }
            return;
        }
        for (int i = l; i < r; i++) {
            total += i;
            fun(n, l, r, pos + 1, total);
            total -= i;
        }
    }
}
