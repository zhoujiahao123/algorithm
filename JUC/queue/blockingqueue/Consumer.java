package algorithm.JUC.queue.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    public BlockingQueue blockingQueue;
    public Consumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }
    @Override
    public void run() {
        try {
            while (true) {
                String id = (String) blockingQueue.take();
                System.out.println("È¡³ö" + id);
            }
        } catch (InterruptedException e) {

        }
    }
}
