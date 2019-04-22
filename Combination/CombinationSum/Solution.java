package Combination.CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * The same repeated number may be chosen from candidates unlimited number of times.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 */
class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public static void main(String args[]) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        Solution solution = new Solution();
        solution.combinationSum(candidates, target);
        for (int i = 0; i < solution.result.size(); i++) {
            for (int j = 0; j < solution.result.get(i).size(); j++) {
                System.out.print(solution.result.get(i).get(j));
            }
            System.out.println();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        fun(candidates, 0, target, "", target);
        return result;
    }

    public void fun(int[] candidates, int k, int n, String s, int target) {
        if (n == 0) {
            String str[] = s.split("-");
            int temp[] = new int[str.length];
            List<Integer> list = new ArrayList<>();
            for(int i = 1;i<temp.length;i++){
                temp[i] = Integer.valueOf(str[i]);
                list.add(temp[i]);
            }
            result.add(list);
            return;
        }
        if (n < 0) return;
        if (k == candidates.length) {
            return;
        }
        for (int i = 0; i <= target / candidates[k]; i++) {
            fun(candidates, k + 1, n - i * candidates[k], s, target);
            s = s + "-" + candidates[k];
        }
    }
}
