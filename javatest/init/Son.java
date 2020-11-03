package algorithm.javatest.init;

public class Son extends Father{
    int a = 1;
    static {
        System.out.println("Son静态方法块");
    }
    {
        System.out.println("Son普通方法块");
    }
    public Son(){
        System.out.println("Son is create");
    }
    public void fun(){}


    public static void main(String[] args) {
        Father son = new Son();
        System.out.println(son.a);
    }
}
