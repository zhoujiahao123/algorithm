package algorithm.designPattern.singleton;

/**
 * 懒汉式的单例模式
 * 存在的问题：
 * 显然是线程不安全的，可能导致不同线程创建的不是同一个对象
 */
public class Singleton_01 {
    private static Singleton_01 instance;

    private Singleton_01() {
    }

    public static Singleton_01 getInstance() {
        //考虑2个线程A B 同时来到这里，A进入后正在创建对象里被挂起，此时instance仍然是null，因此其可能会进入创建另一个对象。
        //这就导致了多个线程不同的对象
        if (instance == null) {
            instance = new Singleton_01();
        }
        return instance;
    }
}
