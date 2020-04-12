package algorithm.ArrayQuestion.LastStoneWeight;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int a[] = {2, 7, 4, 1, 8, 1};
        new Solution().lastStoneWeight(a);
    }

    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        while (stones.length > 1) {
            if (stones.length == 2) return stones[1] - stones[0];
            //ȡ��������
            int a = stones[stones.length - 1];
            //ȡ���ڶ������
            int b = stones[stones.length - 2];
            //����һ���µ�����
            if (a != b) {
                int[] temp = new int[stones.length - 1];
                int k = -1;
                for (int i = 0; i < stones.length - 2; i++) {
                    if (a - b > stones[i]) {
                        temp[i] = stones[i];
                    } else {
                        k = i;
                        break;
                    }
                }
                if (k == -1) k = temp.length - 1;
                temp[k] = a - b;
                for (int i = k; i < stones.length - 2; i++) {
                    temp[k + 1] = stones[i];
                    k++;
                }
                stones = temp;
            } else {
                int[] temp = new int[stones.length - 2];
                //������������
                for (int i = 0; i < stones.length - 2; i++) {
                    temp[i] = stones[i];
                }
                stones = temp;
            }
        }
        return stones.length == 0 ? 0 : stones[0];
    }
}