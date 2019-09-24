package algorithm.DpQuestion.HouseRobber;

public class SolutionForTwo {

    public int rob(int[] nums) {
        if(nums == null ||nums.length == 0) return 0;
        return Math.max(solve(0,nums.length-2,nums),solve(1,nums.length-1,nums));
    }

    public int solve(int first, int last, int nums[]) {
        int pre2 = nums[first];
        int pre1 = Math.max(nums[first + 1], nums[first]);
        for (int i = first + 2; i < nums.length; i++) {
            int cur = Math.max(pre1,pre2+nums[i]);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
