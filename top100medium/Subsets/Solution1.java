package algorithm.top100medium.Subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    List<List<Integer>> res = new ArrayList<>();
    int k;

    public List<List<Integer>> subsets(int[] nums) {
        for (k = 0; k <= nums.length; k++) {
            backtrack(0, new ArrayList<>(), nums);
        }
        return res;
    }

    public void backtrack(int first, List<Integer> cur, int[] nums) {
        if (k == cur.size()) {
            //一定记住都别直接用他给的list，容易出错
            res.add(new ArrayList<>(cur));
        }
        for (int i = first; i < nums.length; i++) {
            cur.add(nums[i]);
            backtrack(i + 1, cur, nums);
            cur.remove(cur.size() - 1);
        }
    }
}
