package algorithm.csp.que2019124;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int delay;

    public static void main(String[] args) {
        int n, m;//nΪ�ڵ�����mΪ����
        int totalOpr;//��������
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        int[][] graph = initGraph(n, m, input);
        delay = input.nextInt();
        totalOpr = input.nextInt();
    }

    private static void flood(int sendPos,int terminatePos, String[][] ans, int baseTime) {
        int num = 1;//�������ж��Ƿ�������ʱ
        while (true) {
            //���num���ڵ���delay��˵���Ѿ�������
            if (num >= delay) {
                // TODO: 2020/2/14 �����ж��Ƿ��յ��ĳ��ڱ���ģ��Լ��Ƿ�ĩλ��С��
                // TODO: 2020/2/14 ����Ҳ��Ҫ�ж��Ƿ�������¿�
            } else {
                // TODO: 2020/2/14 ����Ҳ��Ҫ�ж��Ƿ�������¿�
//                ans[terminatePos][baseTime + num] = ans[terminatePos][baseTime];
            }
        }
    }

    /**
     * ��ʼ��ͼ
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
            //�����ı���Ϊ1
            int ui = input.nextInt();
            int vi = input.nextInt();
            graph[ui][vi] = 1;
        }
        return graph;
    }

}
