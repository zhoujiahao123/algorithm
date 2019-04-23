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
        Integer ans[] = new Integer[1024];
        fun(candidates, 0, target,ans, target,-1);
        return result;
    }

    public void fun(int[] candidates, int k, int n, Integer ans[], int target,int len) {
        if (n == 0) {
            Integer[] newArray = Arrays.copyOfRange(ans, 0, len+1);
            List<Integer> list = Arrays.asList(newArray);
            result.add(list);
            return;
        }
        if (n < 0) return;
        if (k == candidates.length) {
            return;
        }
        for (int i = 0; i <= target / candidates[k]; i++) {
            fun(candidates, k + 1, n - i * candidates[k], ans, target,len);
            ans[++len] = candidates[k];
        }
    }
    //这段代码是有问题的。原因在此：list<list>这种类型，他指向的内部list会随内部List的变化而变化
    public void fun(int[] candidates, int k, int n, List<Integer> list,int target) {
        List<Integer> list1 = new ArrayList<>();
        if (n == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (n < 0) return;
        if (k == candidates.length) {
            return;
        }
        for (int i = 0; i <= target / candidates[k]; i++) {
            fun(candidates, k + 1, n - i * candidates[k], list1, target);
            list1.add(candidates[k]);
        }
    }
    //大佬的代码
    private void bt(List<List<Integer>> res, List<Integer> cur, int[] nums, int target, int index, int curSum) {
        if (curSum == target) {
            res.add(new ArrayList<>(cur)); return;
        }
        for (int i = index; i < nums.length; i ++) {
            if((curSum + nums[i]) > target) break;
            cur.add(nums[i]);
            curSum += nums[i];
            bt(res, cur, nums, target, i, curSum);
            cur.remove(cur.size() - 1);
            curSum -= nums[i];
        }
    }
}
