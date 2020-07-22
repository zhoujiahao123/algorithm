package algorithm.javatest.Thread.apple;

import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class AppleGenerator {
    public static int count = 0;
    static ExecutorService executor;
    public AppleGenerator(ExecutorService executor) {
        this.executor = executor;
    }

    public int next() {
        return ++count;

    }
}
