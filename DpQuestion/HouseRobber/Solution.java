package HouseRobber;

class Solution {
    //结果数组
    int ans[];

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        ans = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            ans[i] = -1;
        }
        return Math.max(solve(nums.length - 1, nums), solve(nums.length - 2, nums));
    }

    //递归形式动态规划解决
    public int solve(int i, int num[]) {
        if (i == 0) return num[0];
        if (i == 1) return num[1];
        //题目说了不能为0？
        if (ans[i] != -1) {
            return ans[i];
        }
        for (int j = 2; j <= i; j++) {
            ans[i] = Math.max(ans[i], num[i] + solve(i - j, num));
        }
        return ans[i];
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int x = sl.rob(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        System.out.println(x);
    }
}