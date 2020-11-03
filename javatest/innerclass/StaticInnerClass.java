package algorithm.javatest.innerclass;

public class StaticInnerClass {
    int i = 0;
    static int j = 0;
    public void inc(){
        i = i++;
        System.out.println(i);
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-4));
        System.out.println(-4>>1);
        System.out.println(Integer.toBinaryString(-4>>1));
        System.out.println(-4>>>1);
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.toBinaryString(5>>1));
        System.out.println(Integer.toBinaryString(5>>>1));

    }
    private class innerClass{
        public void fun(){
            System.out.println(i);
            System.out.println(j);
        }
    }
    private static class staticInnerClass{

    }
}
