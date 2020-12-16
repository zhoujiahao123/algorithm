package algorithm.JUC.queue.blockingqueue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 根据官方文档写的例子，主要设计用于生产消费者模型
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
