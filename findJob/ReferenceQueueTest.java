package algorithm.findJob;

import algorithm.javatest.Thread.programSchedule.ThreadA;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;

public class ReferenceQueueTest {
    static class User {
        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("��Ҫ��gc����");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        User user = new User();
        ReferenceQueue<User> queue = new ReferenceQueue();
        PhantomReference prf = new PhantomReference(user, queue);
        new Thread(() -> {
            while (true) {
                final Reference<? extends User> u = queue.poll();
                if (u != null) {
                    System.out.println("�ж���������ö�����" + u);
                }
            }
        }).start();
        user = null;
        System.out.println("GC֮ǰ" + queue.poll());
        System.gc();
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("��һ��GC֮��" + queue.poll());
        System.gc();
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("�ڶ���GC֮��" + queue.poll());
    }
}
