package algorithm.findJob.xianchengchi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPollTest {
    ThreadPoolExecutor executor;
    ExecutorService executorService = Executors.newFixedThreadPool(50);
    ThreadPoolExecutor poolExecutor;
    LinkedBlockingQueue linkedBlockingQueue;
}
