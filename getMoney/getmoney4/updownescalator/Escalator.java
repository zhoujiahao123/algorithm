package algorithm.getMoney.getmoney4.updownescalator;

import java.util.List;

/**
 * ���ݶ���
 */
public class Escalator {
    private volatile boolean status;//���ݵ�����״̬��Ĭ��trueΪһ¥����¥��falseΪ��¥��һ¥
    private static final Object lock = new Object();
    private volatile boolean onlyOneDirect = false;

    public Escalator() {
        status = true;
    }

    /**
     * ��һ¥����¥
     */
    public void upEscalator(List<User> users) {
        int index = 0;
        synchronized (lock) {
            try {
                while (index < users.size()) {
                    while (!status && !onlyOneDirect) {
                        lock.wait();
                    }
                    int first = index;
                    for (int i = 0; i < 10; ++i) {
                        System.out.println(users.get(index) + "���ڽ������");
                        index++;
                        if (index == users.size()) {
                            onlyOneDirect = true;
                            break;
                        }
                    }
                    for (int i = 0; i < 10; ++i) {
                        System.out.println(users.get(first) + "�����뿪����");
                        first++;
                        if (first == index) break;
                    }
                    System.out.println("���ݷ��򼴽��ı䣬�Ա��2¥��ʼ��ʻ");
                    status = false;
                    lock.notify();
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("һ¥�����Ѿ�ȫ��ͨ�����������˶�¥");
            }
        }
    }

    public void downEscalator(List<User> users) {
        int index = 0;
        synchronized (lock) {
            try {
                while (index < users.size()) {
                    while (status && !onlyOneDirect) {
                        lock.wait();
                    }
                    int first = index;
                    for (int i = 0; i < 10; ++i) {
                        System.out.println(users.get(index) + "���ڽ������");
                        index++;
                        if (index == users.size()) {
                            onlyOneDirect = true;
                            break;
                        }
                    }
                    for (int i = 0; i < 10; ++i) {
                        System.out.println(users.get(first) + "�����뿪����");
                        first++;
                        if (first == index) break;
                    }
                    System.out.println("���ݷ��򼴽��ı䣬�Ա��1¥��ʼ��ʻ");
                    status = true;
                    lock.notify();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("��¥�����Ѿ�ȫ��ͨ������������һ¥");
            }
        }
    }
}
