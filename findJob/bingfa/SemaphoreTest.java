package algorithm.findJob.bingfa;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    Semaphore semaphore = new Semaphore(14);
    void fun() throws InterruptedException {
        semaphore.release(5);
        semaphore.acquire();
    }
}
