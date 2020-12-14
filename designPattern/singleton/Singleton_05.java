package algorithm.designPattern.singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 利用CAS的自旋操作实现单例
 */
public class Singleton_05 {
    private static AtomicReference<Singleton_05> reference = new AtomicReference<>();

    private Singleton_05() {
    }

    public static Singleton_05 getInstance() {
        if (null == reference.get()) {
            reference.compareAndSet(null, new Singleton_05());
        }
        return reference.get();

    }
}
