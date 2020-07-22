package algorithm.javatest.Thread;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.get();
    }
}
