package Combination;

//4 A 2B 2C 1D 1E 3F ����ɶ�����5����ĸ���ַ���
public class Combination {
    public static void main(String[] args) {
        // TODO �Զ����ɵķ������
        int c[] = {4,2,2,1,1,3};
        long startTime=System.nanoTime();   //��ȡ��ʼʱ��
        f(c, 0, 5, "");  //���ԵĴ����
        long endTime=System.nanoTime(); //��ȡ����ʱ��
        System.out.println("��������ʱ�䣺 "+(endTime-startTime)+"ns");

    }
    //f��������Ϊ��[k,a.length - 1] �ڵ���ĸȥ��ϳ� n �� ��ĸ��s��
    public static void f(int a[], int k, int n, String s) {
        if(n == 0 ){
            //��ѡ��n����ĸ��Ϳ��������
            System.out.println(s);
            return ;
        }
        //��ζ�ſɹ�ѡ�����ĸ�Ѿ�ѡ�꣬��ʱ���뷵�أ���Ȼ���������
        if (k == a.length) {
            return;
        }
        for (int i = 0; i <= a[k]; i++) {
            //��i����0����ζ���Ҳ�ȡ��ǰ�������ĸ���ú����ȥ��������
            f(a, k + 1, n - i, s);
            //ȡһ�������ĸ��ѭ����PS������i = 0 ʱ��ȡһ����ĸ��Ȼ��i = 1����ζ��ȡ��һ����ǰ��ĸ�ٵ��õݹ�
            s += (char) (k + 'A');
        }
    }
}
