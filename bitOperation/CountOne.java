package algorithm.bitOperation;

public class CountOne {
    public static void main(String[] args) {
        fun1(5456456);
        fun2(5456456);
        fun3(5456456);
    }

    //采用移位的方法，需要遍历所有位，但对int型而言仅仅32位
    public static void fun1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) count++;
            n >>>= 1;//注意是无符号右移，以免负数的时候出现补1的情况而导致死循环
        }
        System.out.println(count);
    }
    //仅遍历有1的位
    public static void fun2(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        System.out.println(count);
    }
    //仅遍历有1的位
    public static void fun3(int n) {
        int count = 0;
        while (n != 0) {
            n -= (n & (~n + 1));
            count++;
        }
        System.out.println(count);
    }
}
