package algorithm.findJob.bfs;

import java.util.*;
public class Main {
    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    Map<Node, Node> parentMap = new HashMap<Node,Node>();
    int[][] dis = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                matrix[i][j] = input.nextInt();
            }
        }
        Main instance = new Main();
        Node endNote = new Node(4, 4);
        instance.solve(matrix, 0, 0, endNote);
        List<String> res = new ArrayList<String>();
        while (instance.parentMap.containsKey(endNote)) {
            res.add("(" + endNote.x + ", " + endNote.y + ")");
            endNote = instance.parentMap.get(endNote);
        }
        res.add("(" + endNote.x + ", " + endNote.y + ")");
        for (int i = res.size() - 1; i >= 0; --i) {
            System.out.println(res.get(i));
        }
    }
    public void solve(int[][] matrix, int x, int y, Node endNode) {
        Deque<Node> queue = new LinkedList<Node>();
        queue.add(new Node(x, y));
        matrix[x][y] = 1;
        boolean cancel = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                size--;
                Node node = queue.poll();
                int curX = node.x;
                int curY = node.y;
                for (int i = 0; i < dis.length; ++i) {
                    curX += dis[i][0];
                    curY += dis[i][1];
                    if (curX >= 0 && curX < matrix.length && curY >= 0 && curY < matrix[0].length && matrix[curX][curY] == 0) {
                        Node nextNode = new Node(curX, curY);
                        if (nextNode.x == endNode.x && nextNode.y == endNode.y) {
                            parentMap.put(endNode, node);
                            cancel = true;
                            break;
                        }
                        queue.offer(nextNode);
                        parentMap.put(nextNode, node);
                    }
                }
                if (cancel) break;
            }
            if (cancel) break;
        }
    }
}
