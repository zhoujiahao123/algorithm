package algorithm.csp.que2019124;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int delay;

    public static void main(String[] args) {
        int n, m;//n为节点数，m为边数
        int totalOpr;//操作次数
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        int[][] graph = initGraph(n, m, input);
        delay = input.nextInt();
        totalOpr = input.nextInt();
    }

    private static void flood(int sendPos,int terminatePos, String[][] ans, int baseTime) {
        int num = 1;//计数，判断是否满足延时
        while (true) {
            //如果num大于等于delay，说明已经传到了
            if (num >= delay) {
                // TODO: 2020/2/14 首先判断是否收到的长于本身的，以及是否末位更小。
                // TODO: 2020/2/14 这里也需要判断是否产生了新块
            } else {
                // TODO: 2020/2/14 这里也需要判断是否产生了新块
//                ans[terminatePos][baseTime + num] = ans[terminatePos][baseTime];
            }
        }
    }

    /**
     * 初始化图
     *
     * @param n
     * @param m
     * @param input
     * @return
     */
    private static int[][] initGraph(int n, int m, Scanner input) {
        int[][] graph = new int[n + 1][n + 1];
        Arrays.fill(graph, 0);
        for (int i = 1; i <= m; i++) {
            //相连的边置为1
            int ui = input.nextInt();
            int vi = input.nextInt();
            graph[ui][vi] = 1;
        }
        return graph;
    }

}
