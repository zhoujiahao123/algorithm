package algorithm.javatest.Thread.apple;



import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AppleText {
    static AppleGenerator mGenerator;
    static ExecutorService exec;
    public AppleText(AppleGenerator generator) {
        mGenerator = generator;
    }

    public static void main(String[] args) {
        exec  = Executors.newCachedThreadPool();
        new AppleText(new AppleGenerator(exec));
        exec.execute(new ThreadOne());
        exec.execute(new ThreadTwo());
        exec.execute(new ThreadThree());
    }

    static class ThreadOne implements Runnable {
        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    synchronized (mGenerator) {
                        while (mGenerator.count % 3 != 0) {
                            mGenerator.wait();
                        }
                        int  i = mGenerator.next();
                        if(i>100) continue;
                        System.out.println("线程1拿" + i);
                        if(mGenerator.count == 100){
                            exec.shutdownNow();
                        }else{
                            mGenerator.notifyAll();
                        }
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("InterruptedException1");
                String s = "aaa";

            }finally {


            }
        }
    }

    static class ThreadTwo implements Runnable {

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    synchronized (mGenerator) {
                        while (mGenerator.count % 3 != 1) {
                            mGenerator.wait();
                        }
                        int  i = mGenerator.next();
                        if(i>100) continue;
                        System.out.println("线程2拿" + i);
                        if(mGenerator.count == 100){
                            exec.shutdownNow();
                        }else{
                            mGenerator.notifyAll();
                        }
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("InterruptedException2");
            }finally {

            }
        }
    }

    static class ThreadThree implements Runnable {

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    synchronized (mGenerator) {
                        while (mGenerator.count % 3 != 2) {
                            mGenerator.wait();
                        }
                        int  i = mGenerator.next();
                        if(i>100) continue;
                        System.out.println("线程3拿" + i);
                        if(mGenerator.count == 100){
                            exec.shutdownNow();
                        }else{
                            mGenerator.notifyAll();
                        }
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("InterruptedException3");
            }finally {

            }
        }
    }
}
