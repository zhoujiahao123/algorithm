package Brutal.division;

import java.util.Arrays;

/**
 * abcde/fghij = n
 * 其中a - j为0-9， 2<=n<=79
 * PS:要严格等于，应当用double而不是Int，用int会出错
 */
public class Solution {
    public static void main(String[] args) {
        solve(0, 62,new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
    }

    public static void solve(int a[], int k, int n) {
        if (k == a.length) {
            if (valid(a, n)) {
                print(a);
                System.out.print("/");
                print(Arrays.copyOfRange(a, 5, 10));
                System.out.println("=" + n);
            }
        }
        //全排列所有的情况
        for (int i = k; i < a.length; i++) {
            int temp = a[i];
            a[i] = a[k];
            a[k] = temp;
            solve(a, k + 1, n);
            //回溯
            a[k] = a[i];
            a[i] = temp;
        }
    }

    //同样采用全排列，但只做fghij的全排列，用其乘上n便可以得出结果
    public static void solve(int k, int n, int a[]) {
        if (k == 5) {
            valid(n,a);
            return ;
        }
        for (int i = k; i < a.length; i++) {
            int temp = a[i];
            a[i] = a[k];
            a[k] = temp;
            solve(k + 1, n, a);
            a[k] = a[i];
            a[i] = temp;
        }
    }

    public static void print(int a[]) {
        System.out.print("" + a[0] + a[1] + a[2] + a[3] + a[4]);
    }

    public static void valid(int n, int a[]) {
        int result = (a[0] * 10000 + a[1] * 1000 + a[2] * 100 + a[3] * 10 + a[4]) * n;
        int ans[] = new int[5];
        if (result > 98765) {
            return;
        }
        for (int i = 4; i >=0; i--) {
            ans[i] = result % 10;
            result /= 10;
        }
        int b[] = new int[10];
        for (int i = 0; i < 5; i++) {
            b[a[i]]++;
            if (b[a[i]] > 1) {
                return;
            }
        }
        for (int i = 0; i < 5; i++) {
            b[ans[i]]++;
            if (b[ans[i]] > 1) {
                return;
            }
        }
        print(ans);
        System.out.print("/");
        print(a);
        System.out.println("=" + n);
    }

    public static boolean valid(int a[], int n) {
        return (double) (a[0] * 10000 + a[1] * 1000 + a[2] * 100 + a[3] * 10 + a[4]) / (a[5] * 10000 + a[6] * 1000 + a[7] * 100 + a[8] * 10 + a[9]) == n;
    }
}
