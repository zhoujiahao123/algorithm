package algorithm.Coruse.connected_component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DFS {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //节点数
        int n = input.nextInt();
        //邻接矩阵
        int[][] adjacencyMatrix = new int[n][n];
        //备忘录,记录一个节点是否已被访问
        boolean[] isVisited = new boolean[n];
        //结果集合
        List<List<Integer>> connectedComponentList = new ArrayList<>();
        //输入邻接矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjacencyMatrix[i][j] = input.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                List<Integer> list = new ArrayList<>();
                dfs(adjacencyMatrix, isVisited, i, list);
                connectedComponentList.add(list);
            }
        }
        Iterator iterator = connectedComponentList.iterator();
        int num = 1;
        while (iterator.hasNext()) {
            List<Integer> list = (List<Integer>) iterator.next();
            Iterator connectedComponent = list.iterator();
            System.out.println("连通分量" + num + ":");
            num++;
            StringBuilder sb = new StringBuilder();
            while (connectedComponent.hasNext()) {
                Integer i = (Integer) connectedComponent.next();
                sb.append(i).append(",");
            }
            System.out.println(sb.substring(0, sb.length() - 1));
        }
    }
    public static void dfs(int[][] adjacencyMatrix, boolean[] isVisited, int pos, List<Integer> res) {
        //设置节点已被访问
        isVisited[pos] = true;
        //遍历与当前节点相连接的节点，并且要求该节点未被访问过
        for (int i = 0; i < adjacencyMatrix[pos].length; i++) {
            if (pos == i) continue;
            //如果相连接且未被访问过
            if (adjacencyMatrix[pos][i] == 1 && !isVisited[i]) {
                dfs(adjacencyMatrix, isVisited, i, res);
            }
        }
        res.add(pos);
    }
}
