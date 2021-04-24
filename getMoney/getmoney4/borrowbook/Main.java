package algorithm.getMoney.getmoney4.borrowbook;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        Library library = new Library(20);
        int threadNum = 100;
        for (int i = 1; i <= threadNum; ++i) {
            User user = new User(i,library);
            threadPool.execute(user);
        }
        threadPool.shutdown();
    }
}
