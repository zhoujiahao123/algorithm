package algorithm.javatest.Thread.thradLocalTest;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadLocalTest {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    static void print(String str) {
        System.out.println(str + ":" + threadLocal.get());
        threadLocal.remove();
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        executor.execute(() -> {
                    threadLocal.set("threadOne local value");
                    print("threadOne");
                    System.out.println("after Remove : " + threadLocal.get());
                }
        );
        executor.execute(() -> {
                    threadLocal.set("threadTwo local value");
                    print("threadTwo");
                    System.out.println("after Remove : " + threadLocal.get());
                }
        );
    }
}
