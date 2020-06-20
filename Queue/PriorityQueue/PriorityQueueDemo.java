package algorithm.Queue.PriorityQueue;

import java.util.*;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        //��ͨ���У�������Ϊ������˳�����
        Queue<Integer> queue = new LinkedList<>();
        Random random = new Random(1);
        for (int i = 0; i < 10; i++) {
            queue.offer(random.nextInt(i + 10));
        }
        printQueue(queue);
        //���ȶ��У����˳��Ϊ����С����˳�����
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < 10; i++) {
            priorityQueue.offer(random.nextInt(i + 10));
        }
        printQueue(priorityQueue);
        //����������ת��Ϊqueue
        List<Integer> ints = Arrays.asList(25, 22, 20, 18, 14, 9, 3, 1, 1, 2, 3, 9, 14, 18, 21, 23, 25);
        priorityQueue = new PriorityQueue<>(ints);
        printQueue(priorityQueue);
        //�����ȶ��е�����˳���Ϊ�Ӵ�С
        priorityQueue = new PriorityQueue<>(ints.size(), Collections.reverseOrder());
        priorityQueue.addAll(ints);
        printQueue(priorityQueue);
    }

    public static void printQueue(Queue queue) {
        while (queue.peek() != null) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }
}
