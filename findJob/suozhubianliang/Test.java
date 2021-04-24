package algorithm.findJob.suozhubianliang;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static Object tag = new Object();
    int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        test.dosome();
    }
    public void dosome() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            synchronized (tag){
                for (int i = 0;i<50000;i++) count++;
            }
            latch.countDown();
        });
        executorService.execute(()->{
            synchronized (tag){
                for (int i = 0;i<50000;i++) count++;
            }
            latch.countDown();
        });
        executorService.shutdown();
        latch.await();
        System.out.println(count);
    }
}
