package algorithm.getMoney.getmoney4.updownescalator;

import java.util.List;

/**
 * 扶梯对象
 */
public class Escalator {
    private volatile boolean status;//扶梯的运行状态，默认true为一楼到二楼；false为二楼到一楼
    private static final Object lock = new Object();
    private volatile boolean onlyOneDirect = false;

    public Escalator() {
        status = true;
    }

    /**
     * 从一楼到二楼
     */
    public void upEscalator(List<User> users) {
        int index = 0;
        synchronized (lock) {
            try {
                while (index < users.size()) {
                    while (!status && !onlyOneDirect) {
                        lock.wait();
                    }
                    int first = index;
                    for (int i = 0; i < 10; ++i) {
                        System.out.println(users.get(index) + "正在进入扶梯");
                        index++;
                        if (index == users.size()) {
                            onlyOneDirect = true;
                            break;
                        }
                    }
                    for (int i = 0; i < 10; ++i) {
                        System.out.println(users.get(first) + "正在离开扶梯");
                        first++;
                        if (first == index) break;
                    }
                    System.out.println("扶梯方向即将改变，以便从2楼开始行驶");
                    status = false;
                    lock.notify();
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("一楼的人已经全部通过扶梯来到了二楼");
            }
        }
    }

    public void downEscalator(List<User> users) {
        int index = 0;
        synchronized (lock) {
            try {
                while (index < users.size()) {
                    while (status && !onlyOneDirect) {
                        lock.wait();
                    }
                    int first = index;
                    for (int i = 0; i < 10; ++i) {
                        System.out.println(users.get(index) + "正在进入扶梯");
                        index++;
                        if (index == users.size()) {
                            onlyOneDirect = true;
                            break;
                        }
                    }
                    for (int i = 0; i < 10; ++i) {
                        System.out.println(users.get(first) + "正在离开扶梯");
                        first++;
                        if (first == index) break;
                    }
                    System.out.println("扶梯方向即将改变，以便从1楼开始行驶");
                    status = true;
                    lock.notify();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("二楼的人已经全部通过扶梯来到了一楼");
            }
        }
    }
}
