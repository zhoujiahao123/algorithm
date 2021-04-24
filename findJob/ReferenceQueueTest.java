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
            System.out.println("我要被gc搞了");
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
                    System.out.println("有对象加入引用队列了" + u);
                }
            }
        }).start();
        user = null;
        System.out.println("GC之前" + queue.poll());
        System.gc();
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("第一次GC之后" + queue.poll());
        System.gc();
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("第二次GC之后" + queue.poll());
    }
}
