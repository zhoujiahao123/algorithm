package algorithm.TwoPoint.ContainsDuplicate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i])){
                return true;
            }else {
                list.add(nums[i]);
            }
        }
        return false;
    }
}
