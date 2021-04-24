package algorithm.findJob.huawei;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine().replaceAll(" ", "");
        str = str.substring(1, str.length() - 1);
        String[] strings = str.split(",");
        int size = strings.length;
        int[] a = new int[size];
        for (int i = 0; i < size; ++i) {
            a[i] = Integer.parseInt(strings[i]);
        }
        Arrays.sort(a);
        int pre = -1;
        int res = 0;
        int count = 1;
        int num = 0;
        for (int i = 0; i < a.length; ++i) {
            if (pre != -1) {
                if (pre == a[i]) {
                    count++;
                    if (count > a[i] + 1) {
                        res += num;
                        count = 1;
                    }
                } else {
                    res += num;
                    count = 1;
                }
            }
            num = a[i] + 1;
            pre = a[i];
        }
        res += num;
        System.out.println(res);
    }
}
