package algorithm.findJob.bingfa;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;

/**
 * 借助抽象队列同步器实现的独占锁
 */
public class Mutex {

    /**
     * state == 1表示当前锁已被获取
     * state == 0表示当前锁未被获取
     */
    private static class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());

                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if (getState() == 0) throw new IllegalStateException();
            setState(0);
            setExclusiveOwnerThread(null);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }
    }

    private final Sync sync = new Sync();

    public void lock() {
        sync.acquire(1);
    }

    public void unLock() {
        sync.release(1);
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threads);
        for (Thread t : threads) {
            System.out.println(t.getName());
        }

    }
}
