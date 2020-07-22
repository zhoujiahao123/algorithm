package algorithm.javatest.Thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SelfAdd implements Runnable {
    private int count = 0;
    static int size = 1000;
    static CountDownLatch countDownLatch = new CountDownLatch(size);
    public int get() {
        return count;
    }
    @Override
    public void run() {
        count++;
        countDownLatch.countDown();
    }
    public static void main(String[] args) {
        SelfAdd selfAdd = new SelfAdd();
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < size; i++) {
            exec.execute(selfAdd);
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        exec.shutdown();
        System.out.println(selfAdd.get());
    }
}