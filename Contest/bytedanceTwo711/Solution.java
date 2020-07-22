package algorithm.Contest.bytedanceTwo711;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int i = 1; i <= T; i++) {
            int n = input.nextInt();
            int k = input.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = input.nextInt();
            }
            System.out.print(getPn(a, k));
        }
    }

    public static int getPn(int[] a, int k) {
        int[] p = new int[a.length];
        p[0] = a[0];
        for (int i = 1; i < p.length; i++) {
            p[i] = a[i] ^ findKth(p, k, i);
        }
        return p[p.length - 1];
    }

    public static int findKth(int[] p, int k, int len) {
        int newP[] = Arrays.copyOfRange(p, 0, len);
        if (len < k) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < len; i++) {
                min = Math.min(min, p[i]);
            }
            return min;
        } else {
            Arrays.sort(newP);
            return newP[newP.length- k];
        }
    }
}
