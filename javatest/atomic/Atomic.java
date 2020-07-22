package algorithm.javatest.atomic;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class Atomic {
    private static AtomicLong atomicLong = new AtomicLong();
    private static Integer[] arrayOne = new Integer[]{0, 1, 2, 3, 0, 5, 6, 0, 56, 0};
    private static Integer[] arrayOTwo = new Integer[]{10, 1, 2, 3, 0, 5, 6, 0, 56, 0};
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(() -> {
            int size = arrayOne.length;
            for (int i = 0; i < size; ++i) {
                if (arrayOne[i].intValue() == 0) {
                    atomicLong.incrementAndGet();
                }
            }
        });
        Thread threadTwo = new Thread(() -> {
            int size = arrayOTwo.length;
            for (int i = 0; i < size; ++i) {
                if (arrayOTwo[i].intValue() == 0) {
                    atomicLong.incrementAndGet();
                }
            }
        });
        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();
        System.out.print("count 0:" + atomicLong.get());
    }
}
