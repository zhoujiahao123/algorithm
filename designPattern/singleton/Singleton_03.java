package algorithm.designPattern.singleton;

/**
 * ����ģʽ,�̰߳�ȫ
 * ����������������ص�ʱ��ͻ������д���
 * ����һ���˵�����Main������ʹ�õ����࣬��ô����ᱻ���أ���Ҳ����˵��û��
 * ���е�����ʵ����ʱ�򣬸�ʵ���Ѿ���������
 * �ٸ�����˵��������Ϸ��ʱ�򣬲Ž�����Ϸ�Ͱ����е�ͼ���������ˣ������׵��³�����
 */
public class Singleton_03 {
    private static Singleton_03 instance = new Singleton_03();

    private Singleton_03() {
    }

    public static Singleton_03 getInstance() {
        return instance;
    }
}
