package algorithm.findJob.bingfa;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;

/**
 * �����������ͬ����ʵ�ֵĶ�ռ��
 */
public class Mutex {

    /**
     * state == 1��ʾ��ǰ���ѱ���ȡ
     * state == 0��ʾ��ǰ��δ����ȡ
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
