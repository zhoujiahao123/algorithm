package algorithm.javatest.Thread.deadThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DeadLockThread {
    private static String lock1 = "Lock1";
    private static String lock2 = "Lock2";
    public static void main(String[] args) {
        ExecutorService executors = Executors.newCachedThreadPool();
        executors.execute(new DeadLockOne());
        executors.execute(new DeadLockTwo());
        executors.shutdown();
    }
    static class DeadLockOne implements Runnable {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("�߳�1��ȡ����1");
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                synchronized (lock2) {
                    System.out.println("�߳�1��ȡ����2");
                }
            }
        }
    }
    static class DeadLockTwo implements Runnable {
        @Override
        public void run() {
            synchronized (lock2){
                System.out.println("�߳�2��ȡ����2");
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                synchronized (lock1) {
                    System.out.println("�߳�2��ȡ����1");
                }
            }
        }
    }
}
