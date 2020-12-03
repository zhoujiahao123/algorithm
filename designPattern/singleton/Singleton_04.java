package algorithm.designPattern.singleton;

/**
 * 双重检索机制下的懒汉单例模式
 */
public class Singleton_04 {
    private volatile static Singleton_04 instance;

    private Singleton_04() {
    }

    public static Singleton_04 getInstance() {
        if (null == instance) {
            synchronized (Singleton_04.class) {
                if (null == instance) {
                    instance = new Singleton_04();
                }
            }
        }
        return instance;
    }
}
