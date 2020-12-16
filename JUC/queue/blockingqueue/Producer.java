package algorithm.JUC.queue.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private BlockingQueue blockingQueue;
    private String id;
    public Producer(String id, BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
        this.id = id;
    }
    @Override
    public void run() {
        try {
            int index = 10;
            while (index-- > 0) {
                System.out.println("∑≈»Î" + id);
                blockingQueue.put(id);
            }
        } catch (InterruptedException e) {
            //todo
        }
    }
}
