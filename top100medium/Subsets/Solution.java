package algorithm.top100medium.Subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> newList = new ArrayList<>();
            for (List<Integer> list : output) {
                newList.add(new ArrayList<Integer>(list) {{
                    add(num);
                }});
            }
            for (List<Integer> cur : newList) {
                output.add(cur);
            }
        }
        return output;
    }
}
