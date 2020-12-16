package algorithm.JUC.queue.linkedblockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SetUp {
    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingQueue();
        BlockingQueue queue1 = new ArrayBlockingQueue(10);
    }
}
