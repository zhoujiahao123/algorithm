package algorithm.Contest.bytedanceOne711;

import sun.misc.Unsafe;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int n = input.nextInt();
            int[] a = new int[n];
            int[] ans = new int[n];
            Arrays.fill(ans,-1);
//            bruteforce(input, n, a, ans);
            maxStack(input,n,a,ans);

        }
    }

    private static void maxStack(Scanner input, int n, int[] a, int[] ans) {
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int tall = a[i];
            while (!stack.isEmpty() && tall < a[stack.peek()]) {
                int preIndex = stack.poll();
                ans[i] = a[preIndex];
            }
            stack.push(i);
        }
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]);
        }
    }

    private static void bruteforce(Scanner input, int n, int[] a, int[] ans) {
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        for (int i = 0; i < a.length; i++) {
            int canFind = -1;
            for (int j = i; j >= 0; j--) {
                if (a[j] > a[i]) {
                    canFind = a[j];
                    break;
                }
            }
            ans[i] = canFind;
        }
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]);
        }
    }

}
