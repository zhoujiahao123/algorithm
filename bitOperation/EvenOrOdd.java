package algorithm.bitOperation;

/**
 * 判断一个数的奇偶性
 */
public class EvenOrOdd {
    public static void main(String[] args) {
        int a = 1;
        if((a & 1) == 1){
            System.out.println("奇数");
        }else {
            System.out.println("偶数");
        }
    }
}
