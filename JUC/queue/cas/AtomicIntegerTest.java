package algorithm.JUC.queue.cas;

import java.util.concurrent.atomic.*;

public class AtomicIntegerTest {
    private AtomicLong atomicLong;
    private void acquireLock() {
        long t = Thread.currentThread().getId();
        while (!atomicLong.compareAndSet(0, t)) {
            //todo
            atomicLong.set(0);
        }
    }
    public static void main(String[] args) {
    }
}
