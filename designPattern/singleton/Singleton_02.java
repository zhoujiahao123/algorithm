package algorithm.designPattern.singleton;

/**
 * ���ǰһ������ʽ���̲߳���ȫ�����⣬
 * ����static������һ������
 * ����ڵ����⣺
 * ���ܵ��£������߳̿��ܻ������ڵȴ����Ĺ����С�
 * -------------------
 * ʵ����springҲ�ǲ������ַ�ʽ���ĵ���ģʽ
 */
public class Singleton_02 {
    private static Singleton_02 instance;

    private Singleton_02() {
    }

    //����֮��ÿ��ֻ��һ���߳��ܽ��뷽�������´������߳���Ҫ�ȴ������ܲ���
    public synchronized static Singleton_02 getInstance() {
        if (instance == null) {
            instance = new Singleton_02();
        }
        return instance;
    }
}
