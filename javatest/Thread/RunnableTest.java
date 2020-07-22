package algorithm.javatest.Thread;

import algorithm.Contest.DanceByte.Three;

import java.util.concurrent.TimeUnit;

public class RunnableTest {
    public static void main(String[] args) throws InterruptedException{
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (!Thread.interrupted()) {
                        System.out.println("!Thread.interrupted()");
                        TimeUnit.MILLISECONDS.sleep(10000);
                    }
                }catch (InterruptedException e){
                    System.out.println("InterruptedException");
                }finally {
                    System.out.println("threadOne :" + Thread.currentThread().isInterrupted());
                }
            }
        });
        thread.start();
        TimeUnit.MILLISECONDS.sleep(1000);
        thread.interrupt();
        thread.join();
        System.out.println("main over");
    }
}
