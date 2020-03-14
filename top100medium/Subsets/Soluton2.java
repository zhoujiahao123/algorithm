package algorithm.top100medium.Subsets;

import java.util.ArrayList;
import java.util.List;

public class Soluton2 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(new ArrayList<>(), nums, 0);
        return res;
    }

    public void backtrack(List<Integer> cur, int[] nums, int i) {
        if (i == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[i]);
        backtrack(cur, nums, i + 1);
        cur.remove(cur.size() - 1);
        backtrack(cur, nums, i + 1);
    }
}
