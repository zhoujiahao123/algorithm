package algorithm.Greedy.findMoney;

import java.util.Scanner;

/**
 * 钱币找零问题
 * 这个问题在我们的日常生活中就更加普遍了。假设1元、2元、5元、10元、20元、50元、100元
 * 的纸币分别有c0, c1, c2, c3, c4, c5, c6张。现在要用这些钱来支付K元，至少要用多
 * 少张纸币？用贪心算法的思想，很显然，每一步尽可能用面值大的纸币即可。在日常生
 * 活中我们自然而然也是这么做的。在程序中已经事先将Value按照从小到大的顺序排好。
 */
public class FindMoney {
    public static void main(String[] args) {
        int count[] = {3, 0, 2, 1, 0, 3, 5};
        int value[] = {1, 2, 5, 10, 20, 50, 100};
        int k;
        //记录用了多少张纸币。
        int moneyCount = 0;
        Scanner input = new Scanner(System.in);
        k = input.nextInt();
        for (int i = value.length - 1; i >= 0; i--) {
            //0则代表不需要那么大的面值
            int temp = Math.min(k / value[i], count[i]);
            k -= temp * value[i];
            moneyCount += temp;
        }
        if (k != 0) {
            System.out.print("钱不够找零");
        } else {
            System.out.print(moneyCount);
        }


    }
}
