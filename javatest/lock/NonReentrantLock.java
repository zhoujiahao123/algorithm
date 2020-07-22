package algorithm.javatest.lock;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

public class NonReentrantLock implements Lock, Serializable {

    private static class Sync extends AbstractQueuedSynchronizer {
        //判断是否锁已被持有
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }


        //尝试去获取锁
        public boolean tryAcquire(int acquires) {
            assert acquires == 1;//如果不满足则会抛出异常

            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        //尝试释放锁，并设置为0
        public boolean tryRelease(int release) {
            assert release == 1;
            if (getState() == 0) {
                throw new IllegalMonitorStateException();
            }
            //实际上都是用state来判断是否被持有
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        //提供变量接口
        Condition newCondition() {
            return new ConditionObject();
        }
    }

    //获取一个抽象同步队列
    private final Sync sync = new Sync();



    @Override
    public void lock() {
        sync.acquire(1);
    }


    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }
    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
