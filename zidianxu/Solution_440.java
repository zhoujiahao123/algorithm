package algorithm.zidianxu;

/**
 * 给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。
 *
 * 注意：1 ≤ k ≤ n ≤ 109。
 */
public class Solution_440 {
    /**
     * 首先给出超时的做法，思路很简单，先序遍历10叉树，找到满足条件的数为止。
     * 思路正确，但是会超时
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
