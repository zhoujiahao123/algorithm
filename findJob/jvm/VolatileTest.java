package algorithm.findJob.jvm;

public class VolatileTest {
    public static volatile VolatileTest test;
    public volatile int c = 3;
    public static int d = 5;
    public int f = 6;

    public static void setTest() {
        test = new VolatileTest();
    }
    public void print(){
        System.out.println("i am coming");
    }
}
