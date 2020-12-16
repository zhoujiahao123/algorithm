package algorithm.JUC.queue.blockingqueue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ���ݹٷ��ĵ�д�����ӣ���Ҫ�����������������ģ��
 */
public class SetUp {
    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(10);
        Producer producer = new Producer("producer1",queue);
        Producer producer1 = new Producer("producer2",queue);
        Consumer consumer = new Consumer(queue);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.execute(producer);
        executorService.execute(producer1);
        executorService.execute(consumer);
        executorService.shutdown();
    }
}
