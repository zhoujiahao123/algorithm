package algorithm.designPattern.singleton;

/**
 * 针对前一个懒汉式的线程不安全的问题，
 * 对其static方法加一个类锁
 * 其存在的问题：
 * 性能低下，大量线程可能会阻塞在等待锁的过程中。
 * -------------------
 * 实际上spring也是采用这种方式做的单例模式
 */
public class Singleton_02 {
    private static Singleton_02 instance;

    private Singleton_02() {
    }

    //枷锁之后每次只有一个线程能进入方法，导致大量的线程需要等待，性能不高
    public synchronized static Singleton_02 getInstance() {
        if (instance == null) {
            instance = new Singleton_02();
        }
        return instance;
    }
}
