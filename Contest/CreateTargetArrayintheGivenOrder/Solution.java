package algorithm.Contest.CreateTargetArrayintheGivenOrder;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int a[] = {1};
        int b[] = {0};
        int[] c = new Solution().createTargetArray(a, b);
        System.out.println(c);
    }

    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < index.length; i++) {
            res.add(index[i],nums[i]);
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
