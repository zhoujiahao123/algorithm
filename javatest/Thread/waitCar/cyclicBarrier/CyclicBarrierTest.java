package algorithm.javatest.Thread.waitCar.cyclicBarrier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.*;

public class CyclicBarrierTest {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException{
        int N = new Random().nextInt(50);
        System.out.println(N);
        ExecutorService executorService = Executors.newFixedThreadPool(N);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("CyclicBarrier 开始重用");
            }
        });
        while (N > 0) {
            for (int i = 0; i < N && i < 4; i++) {
                executorService.execute(new CyclicBarrierWorker(cyclicBarrier));
            }
            N -= 4;
            try {
                cyclicBarrier.await(1000,TimeUnit.MILLISECONDS);
            } catch (TimeoutException ignore) {
                System.out.println("超时退出");
            }
            System.out.println("--------------");
        }
        executorService.shutdown();
    }

    static class CyclicBarrierWorker implements Runnable {
        public CyclicBarrier cyclicBarrier;
        public CyclicBarrierWorker(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " 坐上车拉");
                cyclicBarrier.await();
            } catch (InterruptedException e) {

            } catch (BrokenBarrierException e) {

            }
        }
    }
}
