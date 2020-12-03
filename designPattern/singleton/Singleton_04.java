package algorithm.designPattern.singleton;

/**
 * ˫�ؼ��������µ���������ģʽ
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
