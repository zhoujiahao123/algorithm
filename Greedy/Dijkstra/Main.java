package algorithm.Greedy.Dijkstra;

import java.util.Scanner;

/**
 * 0 12 -1 -1 -1 16 14
 * 12 0 10 -1 -1 7 -1
 * -1 10 0 3 5 6 -1
 * -1 -1 3 0 4 -1 -1
 * -1 -1 5 4 0 2 8
 * 16 7 6 -1 2 0 9
 * 14 -1 -1 -1 8 9 0
 */
public class Main {

    public static void main(String[] args) {
        int[][] weight = new int[7][7];
        int[] dist = new int[7];
        boolean[] flag = new boolean[7];
        init(weight);
        dijkstra(weight, 7, flag, dist, 0);
        printResult(dist, 0);
    }

    public static void init(int[][] weight) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j < weight[0].length; j++) {
                weight[i][j] = input.nextInt();
                if (weight[i][j] == -1) weight[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    public static void dijkstra(int[][] weight, int n, boolean[] flag, int[] dist, int startPos) {
        dist[startPos] = 0;
        for (int i = 0; i < n; i++) {
            dist[i] = weight[startPos][i];//i==startPos时为0
        }
        flag[startPos] = true;
        dist[startPos] = 0;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int minPos = -1;//minPos表示最小值的位置
            for (int j = 0; j < n; j++) {
                if (!flag[j] && dist[j] < Integer.MAX_VALUE) {
                    if (dist[j] < min) {
                        min = dist[j];
                        minPos = j;
                    }
                }
            }
            if (minPos != -1) {
                flag[minPos] = true;
                for (int j = 0; j < n; j++) {
                    int temp = weight[minPos][j] == Integer.MAX_VALUE ? Integer.MAX_VALUE : dist[minPos] + weight[minPos][j];
                    if (!flag[j] && temp < dist[j]) {
                        dist[j] = temp;
                    }
                }
            }
        }
    }

    public static void printResult(int[] dist, int startPos) {
        for (int i = 0; i < dist.length; i++) {
            System.out.println("the startPos:" + startPos + "to " + i + "距离是:" + dist[i]);
        }
    }
}
