package algorithm.javatest.Final;

import java.util.Random;

public class FinalData {
    private static Random rand = new Random(47);
    private String id;
    public FinalData(String id){
        this.id = id;
    }
    public FinalData(){}
    private final int valueOne = 19;//编译器常量
    private static final int VALUE_TWO = 29;
    public static final int VALUE_THREE = 39;
    private final int i4 = rand.nextInt(20);//运行时初始化常量
    static final int INT_5 = rand.nextInt(20);
    private Value v1 = new Value(11);
    private final Value v2 = new Value(22);
    private static final Value VAL_3 = new Value(33);
    private final int[] a = {1,2,3,4,5,6};
    public final void f(){
        System.out.println("FinalData");
    }
    @Override
    public String toString() {
        return id + ":" + "i4="+i4+"  INT_5="+INT_5;
    }
    private void finalMethod(){
        System.out.println("FinalMethod");
    }
    public static void main(String[] args) {
        FinalData fd1 = new FinalData("fd1");
        fd1.v2.i++;
        fd1.v1 = new Value(8);
        System.out.println(fd1);
        FinalData fd2 = new FinalData("fd2");
        System.out.println(fd2);
    }
}
class FinalDateSon extends FinalData{

    private void finalMethod(){

    }
}
 class Value{
    int i;
    public Value(int i){
        this.i = i;
    }
}
