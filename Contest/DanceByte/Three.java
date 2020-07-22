package algorithm.Contest.DanceByte;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Three {
    String res = "";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();
        long temp = n;
        List<Integer> list = new ArrayList<>();
        while (n != 0) {
            long a = n % 10;
            int b = (int) a;
            list.add(b);
            n /= 10;
        }
        Integer s[] = new Integer[list.size()];
        for (int i = 0; i < s.length; i++) {
            s[i] = list.get(i);
        }
        Three three = new Three();
        three.solve(s, 0, String.valueOf(temp), true);
        System.out.println(three.res);
//        StringBuilder
    }

    public void solve(Integer[] a, int pos, String target, boolean flag) {
        if (pos == a.length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < a.length; i++) {
                sb.append(a[i]);
            }
            String s = sb.toString();
            if (s.compareTo(target) < 0 && s.compareTo(res) > 0) {
                res = s;
            }
        }
        for (int i = pos; i < a.length; i++) {
            if (a[i] < target.charAt(i)) {
                flag = false;
            }
            int temp = a[pos];
            a[pos] = a[i];
            a[i] = temp;
            if (!(a[i] > target.charAt(i) - 48 && flag)){
                solve(a, pos + 1, target, flag);
            }
            a[i] = a[pos];
            a[pos] = temp;
        }
    }
}
