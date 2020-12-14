package algorithm.bitOperation;

public class CountOne {
    public static void main(String[] args) {
        fun1(5456456);
        fun2(5456456);
        fun3(5456456);
    }

    //������λ�ķ�������Ҫ��������λ������int�Ͷ��Խ���32λ
    public static void fun1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) count++;
            n >>>= 1;//ע�����޷������ƣ����⸺����ʱ����ֲ�1�������������ѭ��
        }
        System.out.println(count);
    }
    //��������1��λ
    public static void fun2(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        System.out.println(count);
    }
    //��������1��λ
    public static void fun3(int n) {
        int count = 0;
        while (n != 0) {
            n -= (n & (~n + 1));
            count++;
        }
        System.out.println(count);
    }
}
