package algorithm.Contest.NumberoftepsoReduceaNumberinBinaryRepresentationtoOne;

public class Solution {
    public static void main(String[] args) {
        new Solution().numSteps("1101");

    }

    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int total = 0;
        while (!sb.toString().equals("1")) {
            //���������
            if (sb.charAt(sb.length() - 1) == '1') {
                int k = sb.length() - 1;
                //ֱ������һ��0Ϊֹ
                while (k >= 0&&sb.charAt(k) != '0'  ) {
                    sb.replace(k, k + 1, "0");
                    k--;
                }
                if (k == -1) {
                    sb.insert(0,"1");
                }else {
                    sb.replace(k, k + 1, "1");
                }
            } else {
                //ż������111000100 -->  011100010 ��ÿһλ1������ƶ�һλ,ע�����λҪɾ��
                for (int i = sb.length() - 2; i >= 0; --i) {
                    if (sb.charAt(i) == '1') {
                        sb.replace(i, i + 2, "01");
                    }
                }
                sb.delete(0, 1);
            }
            total++;
        }
        return total;
    }
}
