package algorithm.designPattern.singleton;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ������1000���߳�ͬʱ��������������������ܣ�
 * ��Ҫ����ָ�꣺
 * 1. �����ĵ�ʱ��
 * 2. �����Ķ����Ƿ��ǵ���
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {

        long[] res2 = createInstance_02();
        boolean instance2 = res2[0] == 0;
        System.out.println("����ʽ�̰߳�ȫ�����Ķ���Ψһ�� ��" + instance2 + "  ����ʱ�䣺" + res2[1]);
        long[] res3 = createInstance_03();
        boolean instance3 = res3[0] == 0;
        System.out.println("����ʽ�̰߳�ȫ�����Ķ���Ψһ�� ��" + instance3 +"  ����ʱ�䣺"+res3[1]);
        long[] res4 = createInstance_04();
        boolean instance4 = res4[0] == 0;
        System.out.println("˫�ؼ��������̰߳�ȫ�����Ķ���Ψһ�� ��" + instance4 +"  ����ʱ�䣺"+res4[1]);
        long[] res1 = createInstance_01();
        boolean instance1 = res1[0] == 0;
        System.out.println("����ʽ���̰߳�ȫ�����Ķ���Ψһ�� ��" + instance1 +"  ����ʱ�䣺"+res1[1]);
        long[] res5 = createInstance_05();
        boolean instance5 = res5[0] == 0;
        System.out.println("CAS�̰߳�ȫ�����Ķ���Ψһ�� ��" + instance5 +"  ����ʱ�䣺"+res5[1]);
    }

    private static long[] createInstance_01() throws InterruptedException {
        int N = 10000;
        ExecutorService executors = Executors.newCachedThreadPool();
        long startTime = System.currentTimeMillis();
        final CountDownLatch countDownLatch = new CountDownLatch(N);
        final Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            executors.execute(() -> {
                Singleton_01 instance = Singleton_01.getInstance();
                set.add(instance.toString());
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executors.shutdown();
        long endTime = System.currentTimeMillis();
        Object[] objects = set.toArray();
        long singleton = objects.length == 1 ? 0L : -1L;
        return new long[]{singleton, endTime - startTime};
    }

    private static long[] createInstance_02() throws InterruptedException {
        ExecutorService executors = Executors.newCachedThreadPool();
        long startTime = System.currentTimeMillis();
        int N = 10000;
        final CountDownLatch countDownLatch = new CountDownLatch(N);
        final Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            executors.execute(() -> {
                Singleton_02 instance = Singleton_02.getInstance();
                set.add(instance.toString());
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executors.shutdown();
        long endTime = System.currentTimeMillis();
        Object[] objects = set.toArray();
        long singleton = objects.length == 1 ? 0L : -1L;
        return new long[]{singleton, endTime - startTime};
    }

    private static long[] createInstance_03() throws InterruptedException {
        ExecutorService executors = Executors.newCachedThreadPool();
        long startTime = System.currentTimeMillis();
        int N = 10000;
        final CountDownLatch countDownLatch = new CountDownLatch(N);
        final Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            executors.execute(() -> {
                Singleton_03 instance = Singleton_03.getInstance();
                set.add(instance.toString());
                countDownLatch.countDown();

            });
        }
        countDownLatch.await();
        executors.shutdown();
        long endTime = System.currentTimeMillis();
        Object[] objects = set.toArray();
        long singleton = objects.length == 1 ? 0L : -1L;
        return new long[]{singleton, endTime - startTime};
    }

    private static long[] createInstance_04() throws InterruptedException {
        ExecutorService executors = Executors.newCachedThreadPool();
        long startTime = System.currentTimeMillis();
        int N = 100000;
        final CountDownLatch countDownLatch = new CountDownLatch(N);
        final Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            executors.execute(() -> {
                Singleton_04 instance = Singleton_04.getInstance();
                set.add(instance.toString());
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executors.shutdown();
        long endTime = System.currentTimeMillis();
        Object[] objects = set.toArray();
        long singleton = objects.length == 1 ? 0L : -1L;
        return new long[]{singleton, endTime - startTime};
    }
    private static long[] createInstance_05() throws InterruptedException {
        ExecutorService executors = Executors.newCachedThreadPool();
        long startTime = System.currentTimeMillis();
        int N = 100000;
        final CountDownLatch countDownLatch = new CountDownLatch(N);
        final Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            executors.execute(() -> {
                Singleton_05 instance = Singleton_05.getInstance();
                set.add(instance.toString());
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executors.shutdown();
        long endTime = System.currentTimeMillis();
        Object[] objects = set.toArray();
        long singleton = objects.length == 1 ? 0L : -1L;
        return new long[]{singleton, endTime - startTime};
    }
}
