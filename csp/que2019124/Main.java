package algorithm.csp.que2019124;

import java.util.*;

public class Main {
    static int delay;
    static int startNode, terminateNode, baseTime;

    public static void main(String[] args) {
        int n, m;//nΪ�ڵ�����mΪ����
        int totalOpr;//��������
        int maxTime;//����ѯʱ��
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        int[][] graph = initGraph(n, m, input);
        delay = input.nextInt();
        totalOpr = input.nextInt();
        //map<�ڵ㡢ʱ��>
        Map<Integer, Integer> queryMap = new HashMap<>();
        //map<ʱ�䡢map<�ڵ㡢���>>
        Map<Integer, Map<Integer, Integer>> addMap = new HashMap<>();
        maxTime = getCommand(totalOpr, input, queryMap, addMap);
        String ans[][] = new String[n + 1][maxTime + 1];
        flood(maxTime, graph, startNode, terminateNode, ans, baseTime, addMap);
    }

    /**
     * @param input
     * @param queryMap ��ѯ��������
     * @param addMap   �������������
     */
    private static int getCommand(int totalOpr, Scanner input, Map<Integer, Integer> queryMap, Map<Integer, Map<Integer, Integer>> addMap) {
        Integer maxTime = Integer.MIN_VALUE;
        boolean isFirst = true;
        while (totalOpr != 0) {
            String line = input.nextLine();
            String[] s = line.split(" ");
            if (s.length == 2) {
                if (Integer.valueOf(s[1]) > maxTime) {
                    maxTime = Integer.valueOf(s[1]);
                }
                queryMap.put(Integer.valueOf(s[0]), Integer.valueOf(s[1]));
            }
            if (s.length == 3) {
                if (isFirst) {
                    startNode = Integer.valueOf(s[0]);
                    terminateNode = Integer.valueOf(s[2]);
                    baseTime = Integer.valueOf(s[1]);
                    isFirst = false;
                }
                Map<Integer, Integer> map = new HashMap<>();
                map.put(Integer.valueOf(s[0]), Integer.valueOf(s[2]));
                addMap.put(Integer.valueOf(s[1]), map);
            }
            totalOpr--;
        }
        return maxTime;
    }

    /**
     * �鷺������Ϣ�������Ϣ
     *
     * @param sendPos
     * @param terminatePos
     * @param ans
     * @param baseTime
     */
    private static void flood(int maxTime, int[][] graph, int sendPos, int terminatePos, String[][] ans, int baseTime, Map<Integer, Map<Integer, Integer>> addMap) {
        int num = 0;//�������ж��Ƿ�������ʱ
        while (true) {
            if (baseTime + num >= maxTime) {
                return;
            }
            //���num���ڵ���delay��˵���Ѿ�������
            if (num >= delay) {
                // TODO: 2020/2/14 �����ж��Ƿ��յ��ĳ��ڱ���ģ��Լ��Ƿ�ĩλ��С��
                if (ans[sendPos][baseTime + num].length() > ans[terminatePos][baseTime + num].length()) {
                    ans[terminatePos][baseTime + num] = ans[sendPos][baseTime + num];
                } else if (ans[sendPos][baseTime + num].length() == ans[terminatePos][baseTime + num].length()) {
                    if (ans[sendPos][baseTime + num].charAt(ans[sendPos][baseTime + num].length() - 1) <
                            ans[terminatePos][baseTime + num].charAt(ans[terminatePos][baseTime + num].length() - 1)) {
                        ans[terminatePos][baseTime + num] = ans[sendPos][baseTime + num];
                    }
                }
            }
            // TODO: 2020/2/14 ����Ҳ��Ҫ�ж��Ƿ�������¿�
            if (addMap.containsKey(baseTime + num)) {
                if (addMap.get(baseTime + num).containsKey(terminatePos)) {
                    //˵�����ڸýڵ�������µĿ�
                    for (int i = 1; i < graph[terminatePos].length; i++) {
                        if (graph[terminatePos][i] == 1) {
                            flood(maxTime, graph, terminatePos, graph[terminatePos][i], ans, baseTime + num, addMap);
                        }
                    }
                }
            }
            ++num;
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
