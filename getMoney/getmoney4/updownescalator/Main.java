package algorithm.getMoney.getmoney4.updownescalator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService threadPoll = Executors.newCachedThreadPool();
        //随机生成100个用户，分布在商场两层
        Random random = new Random();
        int size = random.nextInt(100) + 1;
        List<User> _1FUsers = new ArrayList<>();
        List<User> _2FUsers = new ArrayList<>();
        int _1FIndex = 1;
        int _2FIndex = 1;
        for (int i = 1; i < size; ++i) {
            User user = new User("第1楼的第" + _1FIndex + "个人");
            _1FIndex++;
            _1FUsers.add(user);
        }
        for (int i = size; i <= 100; ++i) {
            User user = new User("第2楼的第" + _2FIndex + "个人");
            _2FIndex++;
            _2FUsers.add(user);
        }
        Escalator escalator = new Escalator();
        threadPoll.execute(new Runnable() {
            @Override
            public void run() {
                escalator.upEscalator(_1FUsers);
            }
        });
        threadPoll.execute(new Runnable() {
            @Override
            public void run() {
                escalator.downEscalator(_2FUsers);
            }
        });
        threadPoll.shutdown();
    }
}
