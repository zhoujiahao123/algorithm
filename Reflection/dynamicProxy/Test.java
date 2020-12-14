package algorithm.Reflection.dynamicProxy;

public class Test {
    public static void main(String[] args) {
        MyInterface targetObject = new TargetObject();
        ProxyFactory proxyFactory = new ProxyFactory();
        MyInterface target = (MyInterface) proxyFactory.getInstance(targetObject);
        target.play();
        System.out.println(target.getClass());
    }
}
