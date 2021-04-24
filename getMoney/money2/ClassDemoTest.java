package algorithm.getMoney.money2;
class ClassDemo {
    public static int sum = 1;
    public ClassDemo(){
        sum = sum + 5;
    }

}
public class ClassDemoTest {
    public static void main(String[] args) {
        ClassDemo demo1 = new ClassDemo();
        ClassDemo demo2 = new ClassDemo();
        System.out.println(demo1.sum);
    }
}