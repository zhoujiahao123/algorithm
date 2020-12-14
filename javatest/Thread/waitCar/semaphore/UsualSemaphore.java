package algorithm.javatest.Thread.waitCar.semaphore;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class UsualSemaphore {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(0);
        int N = new Random().nextInt(50);
        System.out.println(N);
        ExecutorService executorService = Executors.newFixedThreadPool(N);
        for (int i = 0; i < N; i++) {
            executorService.execute(new SemaphoreWorker(semaphore));
        }
        while (N > 0) {
            if (N >= 4) {
                N -= 4;
                semaphore.release(4);
            } else {
                semaphore.release(N);
                N = 0;
            }
            while (semaphore.availablePermits() != 0) {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            System.out.println("wait for permit");
        }
        executorService.shutdown();
    }
    static class SemaphoreWorker implements Runnable {
        private Semaphore semaphore;
        public SemaphoreWorker(Semaphore semaphore) {
            this.semaphore = semaphore;
        }
        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + "  execute");
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
