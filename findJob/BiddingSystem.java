package algorithm.findJob;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class BiddingSystem {
    private volatile int pre = 0;//表示上一个竞拍的客户的编号
    private volatile int count = 1;
    private volatile int money = 4000;//起拍价
    private static final ReentrantLock lock = new ReentrantLock();
    private static final ExecutorService executors = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        BiddingSystem bs = new BiddingSystem();
        int n = new Random().nextInt(10) + 2;//随机生成多个客户进行竞拍
        for (int i = 1; i <= n; ++i) {
            executors.execute(bs.new BiddingThread("客户"+i+"：", i));
        }
        executors.shutdown();
    }

    class BiddingThread implements Runnable {
        String name;//名字
        int number;//编号
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
                            lock.wait();//有可能等待在这儿的时候已经不满足外层条件了。
                        }
                        if (count > 1000) {
                            break;
                        }
                        int add = bidding();
                        money += add;
                        System.out.println("第" + count + "次出价： " + name + money+"  加价："+add);
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
