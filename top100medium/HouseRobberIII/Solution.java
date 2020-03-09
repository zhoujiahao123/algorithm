package algorithm.top100medium.HouseRobberIII;

public class Solution {
    public int rob(TreeNode root) {
        return Math.max(solve(root, true), solve(root, false));
    }

    public int solve(TreeNode node, boolean choose) {
        if (node == null) {
            return 0;
        }
        if (choose) {
            //不能选
            return node.val + solve(node.left, !choose) + solve(node.right, !choose);
        }
        //可选可不选
        int a = solve(node.left, true);
        int b = solve(node.left, false);
        int c = solve(node.right, true);
        int d = solve(node.right, false);
        int res1 = a + c;
        int res2 = a + d;
        int res3 = b + c;
        int res4 = b + d;
        int max = Math.max(res1, res2);
        max = Math.max(max, res3);
        max = Math.max(max, res4);
        return max;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
