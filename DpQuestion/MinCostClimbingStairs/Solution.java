package MinCostClimbingStairs;

class Solution {
    int ans[];
    int vis[];

    public int minCostClimbingStairs(int[] cost) {
        //结果数组
        ans = new int[cost.length];
        //是否访问数组
        vis = new int[cost.length];
        return solve(cost, cost.length);
    }

    //递归实现问题
    public int solve(int[] cost, int i) {
        //边界条件，递归的关键之一
        if (i == 0) return cost[0];
        if (i == 1) return cost[1];
        //由题目决定
        if (i == cost.length) {
            return Math.min(solve(cost, i - 1), solve(cost, i - 2));
        }
        if (vis[i] == 1) {
            return ans[i];
        }
        vis[i] = 1;
        if (i == cost.length) {
            return Math.min(solve(cost, i - 1), solve(cost, i - 2));
        }
        return ans[i] = cost[i] + Math.min(solve(cost, i - 1), solve(cost, i - 2));
    }

    //以递推的形式实现???为什么递推时间反而消耗多于递归？
    public int solve(int cost[]) {
        ans[0] = cost[0];
        ans[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            ans[i] = Math.min(ans[i - 1], ans[i - 2]) + cost[i];
        }
        return Math.min(ans[cost.length-1],ans[cost.length-2]);
    }
}