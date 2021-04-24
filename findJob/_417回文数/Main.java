package algorithm.findJob._417回文数;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        int len = str.length();
        char[] c = str.toCharArray();
        if (len == 1) System.out.println(0);
        int[][] change = new int[5][5];
        change[1][2] = 120 + 200;
        change[1][3] = 120 + 360;
        change[1][4] = 120 + 220;
        change[2][1] = 350 + 100;
        change[2][3] = 350 + 360;
        change[2][4] = 350 + 220;
        change[3][1] = 200 + 100;
        change[3][2] = 200 + 200;
        change[3][4] = 200 + 220;
        change[4][1] = 320 + 100;
        change[4][2] = 320 + 200;
        change[4][3] = 320 + 360;
        int[] add = new int[5];
        add[1] = 100;
        add[2] = 200;
        add[3] = 360;
        add[4] = 220;
        if (len == 2) {
            int min = solve(c[0], c[1], change, add);
            int[] delete = {0, 120, 350, 200, 320};
            min = Math.min(min, delete[c[0] - '0']);
            min = Math.min(min, delete[c[1] - '0']);
            System.out.println(min);
        } else {
            int start = len / 2 - 1;
            int end = (len % 2) == 0 ? len / 2 : len / 2 + 1;
            int res = 0;
            for (; start >= 0; start--, end++) {
                if (c[start] != c[end]) {
                    res += solve(c[start], c[end], change, add);
                }
            }
            System.out.println(res);
        }

    }

    /**
     * 考虑几种情况：
     * 1：1->2
     * 2：2->1
     * 3: 添加1和2
     * 取最小值即可
     *
     * @param left
     * @param right
     * @return
     */
    public static int solve(char left, char right, int[][] change, int[] add) {
        int min = Integer.MAX_VALUE;
        min = Math.min(min, change[left - '0'][right - '0']);
        min = Math.min(min, change[right - '0'][left - '0']);
        min = Math.min(min, add[left - '0'] + add[right - '0']);
        return min;
    }
}
