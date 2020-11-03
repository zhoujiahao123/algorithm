package algorithm.javatest.init;

public class Father {
    int a = 0;
    static {
        System.out.println("Father静态方法块");
    }
    {
        System.out.println("Father普通方法块");
    }
    public Father(){
        System.out.println("father is create");
    }
}

