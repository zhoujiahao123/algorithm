package algorithm.Greedy.findMoney;

import java.util.Scanner;

/**
 * Ǯ����������
 * ������������ǵ��ճ������о͸����ձ��ˡ�����1Ԫ��2Ԫ��5Ԫ��10Ԫ��20Ԫ��50Ԫ��100Ԫ
 * ��ֽ�ҷֱ���c0, c1, c2, c3, c4, c5, c6�š�����Ҫ����ЩǮ��֧��KԪ������Ҫ�ö�
 * ����ֽ�ң���̰���㷨��˼�룬����Ȼ��ÿһ������������ֵ���ֽ�Ҽ��ɡ����ճ���
 * ����������Ȼ��ȻҲ����ô���ġ��ڳ������Ѿ����Ƚ�Value���մ�С�����˳���źá�
 */
public class FindMoney {
    public static void main(String[] args) {
        int count[] = {3, 0, 2, 1, 0, 3, 5};
        int value[] = {1, 2, 5, 10, 20, 50, 100};
        int k;
        //��¼���˶�����ֽ�ҡ�
        int moneyCount = 0;
        Scanner input = new Scanner(System.in);
        k = input.nextInt();
        for (int i = value.length - 1; i >= 0; i--) {
            //0�������Ҫ��ô�����ֵ
            int temp = Math.min(k / value[i], count[i]);
            k -= temp * value[i];
            moneyCount += temp;
        }
        if (k != 0) {
            System.out.print("Ǯ��������");
        } else {
            System.out.print(moneyCount);
        }


    }
}
