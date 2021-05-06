package algorithm.getMoney.getmoney4.updownescalator;

import java.util.List;

/**
 * Escalator object
 */
public class Escalator {
    private volatile boolean status;//The running status of the escalator is from the first floor to the second floor by default; False means from the second floor to the first floor
    private static final Object lock = new Object();
    private volatile boolean onlyOneDirect = false;

    public Escalator() {
        status = true;
    }

    /**
     * From the first floor to the second floor
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
                        System.out.println(users.get(index) + " Entering the escalator");
                        index++;
                        if (index == users.size()) {
                            onlyOneDirect = true;
                            break;
                        }
                    }
                    for (int i = 0; i < 10; ++i) {
                        System.out.println(users.get(first) + " Leaving the escalator");
                        first++;
                        if (first == index) break;
                    }
                    System.out.println("The direction of the escalator is about to be changed to start from the second floor");
                    status = false;
                    lock.notify();
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("All the people on the first floor have come to the second floor by escalator");
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
                        System.out.println(users.get(index) + " Entering the escalator");
                        index++;
                        if (index == users.size()) {
                            onlyOneDirect = true;
                            break;
                        }
                    }
                    for (int i = 0; i < 10; ++i) {
                        System.out.println(users.get(first) + " Leaving the escalator");
                        first++;
                        if (first == index) break;
                    }
                    System.out.println("The direction of the escalator is about to change to start from the first floor");
                    status = true;
                    lock.notify();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("The people on the second floor have all come to the first floor through the escalator");
            }
        }
    }
}
