package algorithm.zidianxu;

/**
 * �������� n �� k���ҵ� 1 �� n ���ֵ���� k С�����֡�
 *
 * ע�⣺1 �� k �� n �� 109��
 */
public class Solution_440 {
    /**
     * ���ȸ�����ʱ��������˼·�ܼ򵥣��������10�������ҵ�������������Ϊֹ��
     * ˼·��ȷ�����ǻᳬʱ
     */
    class Solution {
        int max = 0;
        int target = 0;
        int res = -1;
        public int findKthNumber(int n, int k) {
            max = n;
            for(int i = 1;i<10;i++){
                if(constructTree(i,k)){
                    break;
                }
            }
            return res;
        }
        public boolean constructTree(int curVal,int k){
            if(curVal > max) return false;
            if(++target == k) {
                res = curVal;
                return true;
            }
            for(int i = 0;i<10;i++){
                int temp = curVal*10 + i;
                if(constructTree(temp,k)) return true;
            }
            return false;
        }
    }
}
