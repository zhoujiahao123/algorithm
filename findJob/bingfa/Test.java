package algorithm.findJob.bingfa;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    static final ReentrantLock LOCK = new ReentrantLock(false);
    static final Condition CONDITION = LOCK.newCondition();
    static final CyclicBarrier BARRIER = new CyclicBarrier(5,()->{
        System.out.println("Í»ÆÆÆÁÕÏ......");
    });
    static final Semaphore SEMAPHORE = new Semaphore(5);
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        Runnable r = ()->{
            try {
                SEMAPHORE.acquire(1);
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName());
                SEMAPHORE.release(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        for (int i = 0; i < 5; i++) {
            pool.execute(r);
        }
        while (SEMAPHORE.availablePermits() != 10){
            TimeUnit.SECONDS.sleep(5);
        }
        pool.shutdown();
    }
}