package algorithm.bitOperation;

/**
 * ����������
 */
public class exchangeNum {
    public static void main(String[] args) {
        int a = 1;
        int b = -1;
        a = a^b;
        b = a^b;//ʵ���Ͼ���b = (a^b)^b = a^0 = a;
        a = a^b;//ʵ���Ͼ���a = (a^b)^a = b^0 = b
        System.out.println(a);
        System.out.println(b);
    }
}
