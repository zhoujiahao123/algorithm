package algorithm.findJob.wangyi;

import algorithm.ByteDance.Main;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main4 {
    public static void main(String[] args) {
        int[][] distancePairs = {{0, 1, 3}, {1, 2, 2}, {0, 2, 1}};
        int[][] distancePairs1 = {{0, 1, 3}, {1, 2, 2}};
        int[][] distancePairs2 = {{0, 2, 1}, {1, 2, 2}, {1, 3, 3}, {3, 5, 4},{5,4,2},{4,6,6}};
        System.out.println(new Main4().solve(distancePairs2, 7));
    }

    public int solve(int[][] distanceParis, int cityNums) {
        int[][] newDis = newDistanceParis(distanceParis, cityNums);
        int len = newDis.length;
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < len; ++i) {
            int res = bfs(newDis, i);
            if (res == -1) return -1;
            if (res < min) {
                min = res;
                minIndex = i;
            }
        }
        return minIndex;
    }
    public int[][] newDistanceParis(int[][] distanceParis, int cityNums) {
        int[][] newDis = new int[cityNums][cityNums];
        for (int i = 0; i < distanceParis.length; ++i) {
            newDis[distanceParis[i][0]][distanceParis[i][1]] = distanceParis[i][2];
        }
        for (int i = 0; i < distanceParis.length; ++i) {
            newDis[distanceParis[i][1]][distanceParis[i][0]] = distanceParis[i][2];
        }
        return newDis;
    }
    public int bfs(int[][] distanceParis, int pos) {
        Deque<Integer> queue = new LinkedList<>();
        int[] dis = new int[distanceParis.length];
        Arrays.fill(dis, Integer.MAX_VALUE / 2);
        dis[pos] = 0;
        queue.offer(pos);
        boolean[] visited = new boolean[distanceParis.length];
        visited[pos] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                size--;
                int next = queue.poll();
                //遍历我连接的
                for (int i = 0; i < distanceParis.length; ++i) {
                    if (next == i) continue;
                    //否则，把这些值suanchulai
                    if (distanceParis[next][i] != 0) {
                        dis[i] = Math.min(dis[next] + distanceParis[next][i], dis[i]);
                        if (!visited[i]) queue.offer(i);
                    }
                }
                visited[next] = true;
            }
        }
        int res = 0;
        for (int i = 0; i < dis.length; ++i) {
            if (dis[i] == Integer.MAX_VALUE / 2) return -1;
            res += dis[i];
        }
        return res;
    }
}
