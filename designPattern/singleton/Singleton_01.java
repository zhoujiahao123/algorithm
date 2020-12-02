package algorithm.designPattern.singleton;

/**
 * ����ʽ�ĵ���ģʽ
 * ���ڵ����⣺
 * ��Ȼ���̲߳���ȫ�ģ����ܵ��²�ͬ�̴߳����Ĳ���ͬһ������
 */
public class Singleton_01 {
    private static Singleton_01 instance;

    private Singleton_01() {
    }

    public static Singleton_01 getInstance() {
        //����2���߳�A B ͬʱ�������A��������ڴ��������ﱻ���𣬴�ʱinstance��Ȼ��null���������ܻ���봴����һ������
        //��͵����˶���̲߳�ͬ�Ķ���
        if (instance == null) {
            instance = new Singleton_01();
        }
        return instance;
    }
}
