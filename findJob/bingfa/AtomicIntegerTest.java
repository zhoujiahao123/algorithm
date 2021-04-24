package algorithm.findJob.bingfa;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 设计一个简单的偏向锁
 */
public class AtomicIntegerTest {
    private static final AtomicLong atomicInteger = new AtomicLong(0);
    public void acquireLock(){
        long tId = Thread.currentThread().getId();
        while (!atomicInteger.compareAndSet(0,tId)){
            //todo
            atomicInteger.set(0);//使用完释放锁
        }
    }
}
