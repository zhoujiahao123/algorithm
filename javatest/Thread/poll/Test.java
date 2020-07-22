package algorithm.javatest.Thread.poll;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Test {
    public static void main(String[] args) {
        Integer i = 0x7fffffff;
        Integer j = 0x80000000;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(i).length());
        System.out.println(Integer.toBinaryString(j));
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        System.out.println(returnJudge());
    }
    public static int returnJudge(){
        try {
            return 0;
        }finally {
            return 1;
        }
    }
}
