package algorithm.findJob.bingfa;

import java.util.concurrent.atomic.AtomicLong;

/**
 * ���һ���򵥵�ƫ����
 */
public class AtomicIntegerTest {
    private static final AtomicLong atomicInteger = new AtomicLong(0);
    public void acquireLock(){
        long tId = Thread.currentThread().getId();
        while (!atomicInteger.compareAndSet(0,tId)){
            //todo
            atomicInteger.set(0);//ʹ�����ͷ���
        }
    }
}
