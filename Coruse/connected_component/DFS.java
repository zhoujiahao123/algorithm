package algorithm.Coruse.connected_component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DFS {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //�ڵ���
        int n = input.nextInt();
        //�ڽӾ���
        int[][] adjacencyMatrix = new int[n][n];
        //����¼,��¼һ���ڵ��Ƿ��ѱ�����
        boolean[] isVisited = new boolean[n];
        //�������
        List<List<Integer>> connectedComponentList = new ArrayList<>();
        //�����ڽӾ���
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
            System.out.println("��ͨ����" + num + ":");
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
        //���ýڵ��ѱ�����
        isVisited[pos] = true;
        //�����뵱ǰ�ڵ������ӵĽڵ㣬����Ҫ��ýڵ�δ�����ʹ�
        for (int i = 0; i < adjacencyMatrix[pos].length; i++) {
            if (pos == i) continue;
            //�����������δ�����ʹ�
            if (adjacencyMatrix[pos][i] == 1 && !isVisited[i]) {
                dfs(adjacencyMatrix, isVisited, i, res);
            }
        }
        res.add(pos);
    }
}
