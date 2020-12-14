package algorithm.Reflection.dynamicProxy;

public class TargetObject implements MyInterface{
    @Override
    public void play() {
        System.out.println("方法调用");
    }
}
