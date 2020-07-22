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
        //�ж��Ƿ����ѱ�����
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }


        //����ȥ��ȡ��
        public boolean tryAcquire(int acquires) {
            assert acquires == 1;//�������������׳��쳣

            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        //�����ͷ�����������Ϊ0
        public boolean tryRelease(int release) {
            assert release == 1;
            if (getState() == 0) {
                throw new IllegalMonitorStateException();
            }
            //ʵ���϶�����state���ж��Ƿ񱻳���
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        //�ṩ�����ӿ�
        Condition newCondition() {
            return new ConditionObject();
        }
    }

    //��ȡһ������ͬ������
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
