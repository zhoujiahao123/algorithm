package algorithm.javatest.init;

public class Father {
    int a = 0;
    static {
        System.out.println("Father��̬������");
    }
    {
        System.out.println("Father��ͨ������");
    }
    public Father(){
        System.out.println("father is create");
    }
}

