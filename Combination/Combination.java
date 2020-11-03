package Combination;

//4 A 2B 2C 1D 1E 3F 能组成多少种5个字母的字符串
public class Combination {
    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        int c[] = {4,2,2,1,1,3};
        long startTime=System.nanoTime();   //获取开始时间
        f(c, 0, 5, "");  //测试的代码段
        long endTime=System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ns");

    }
    //f函数功能为用[k,a.length - 1] 内的字母去组合成 n 个 字母（s）
    public static void f(int a[], int k, int n, String s) {
        if(n == 0 ){
            //当选好n个字母后就可以输出了
            System.out.println(s);
            return ;
        }
        //意味着可供选择的字母已经选完，此时必须返回，不然会数组溢出
        if (k == a.length) {
            return;
        }
        for (int i = 0; i <= a[k]; i++) {
            //当i等于0，意味着我不取当前的这个字母，让后面的去凑这个组合
            f(a, k + 1, n - i, s);
            //取一个这个字母再循环（PS），当i = 0 时，取一个字母，然后i = 1，意味着取了一个当前字母再调用递归
            s += (char) (k + 'A');
        }
    }
}
