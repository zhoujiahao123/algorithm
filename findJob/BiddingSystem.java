package algorithm.findJob;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class BiddingSystem {
    private volatile int pre = 0;//��ʾ��һ�����ĵĿͻ��ı��
    private volatile int count = 1;
    private volatile int money = 4000;//���ļ�
    private static final ReentrantLock lock = new ReentrantLock();
    private static final ExecutorService executors = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        BiddingSystem bs = new BiddingSystem();
        int n = new Random().nextInt(10) + 2;//������ɶ���ͻ����о���
        for (int i = 1; i <= n; ++i) {
            executors.execute(bs.new BiddingThread("�ͻ�"+i+"��", i));
        }
        executors.shutdown();
    }

    class BiddingThread implements Runnable {
        String name;//����
        int number;//���
        public BiddingThread(String name, int number) {
            this.name = name;
            this.number = number;
        }
        @Override
        public void run() {
            try {
                synchronized (lock) {
                    while (count <= 1000) {
                        while (pre == number) {
                            lock.wait();//�п��ܵȴ��������ʱ���Ѿ���������������ˡ�
                        }
                        if (count > 1000) {
                            break;
                        }
                        int add = bidding();
                        money += add;
                        System.out.println("��" + count + "�γ��ۣ� " + name + money+"  �Ӽۣ�"+add);
                        ++count;
                        pre = number;
                        lock.notifyAll();
                    }
                }
            } catch (Exception ignore) {
            }
        }

        public int bidding() {
            Random random = new Random();
            return 1 + random.nextInt(200);
        }
    }
}
