package algorithm.findJob.bingfa;

import java.util.concurrent.RecursiveTask;

public class ForkJoinTest extends RecursiveTask<Integer> {
    public int i = 0;
    public void add(){
        i = i++;
    }
    public void add1(){
        i = ++i;
    }
    public static void main(String[] args) {

    }
    @Override
    protected Integer compute() {
        return null;
    }
}
