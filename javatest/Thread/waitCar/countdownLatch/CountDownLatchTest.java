package algorithm.javatest.Thread.waitCar.countdownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        int N = new Random().nextInt(50);
        System.out.println(N);
        ExecutorService executorService = Executors.newFixedThreadPool(N);
        while (N > 0) {
            CountDownLatch countDownLatch = new CountDownLatch(N>=4?4:N);
            for (int i = 0; i < 4 && i < N; i++) {
                executorService.execute(new CountDownLatchWorker(countDownLatch));
            }
            N -= 4;
            countDownLatch.await();
            System.out.println("-----------");
        }
        executorService.shutdown();
    }
    static class CountDownLatchWorker implements Runnable {
        public CountDownLatch countDownLatch;
        public CountDownLatchWorker(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " ×øÉÏ³µÁË");
            countDownLatch.countDown();
        }
    }
}
