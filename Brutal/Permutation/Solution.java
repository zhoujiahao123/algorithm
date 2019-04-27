package Brutal.Permutation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String [] args){
        List<List<Integer>> lists = new Solution().permute(new int[]{1,2,3});
    }
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        Integer num[] = new Integer[nums.length];
        for(int i = 0;i<nums.length;i++){
            num[i] = nums[i];
        }
        solve(num,0);
        return result;
    }
    public void solve(Integer nums[],int k){
        if(k == nums.length){
            result.add(new ArrayList<>(Arrays.asList(nums)));
        }
        for(int i = k;i<nums.length;i++){
            Integer temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
            solve(nums,k+1);
            nums[k] = nums[i];
            nums[i] = temp;
        }
    }
}