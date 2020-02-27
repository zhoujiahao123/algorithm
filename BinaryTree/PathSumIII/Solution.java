package algorithm.BinaryTree.PathSumIII;

public class Solution {
    int total;

    public int pathSum(TreeNode root, int sum) {
        preOrder(root, sum);
        return total;
    }

    public void preOrder(TreeNode root, int sum) {
        if (root == null) return;
        solve(root, 0, sum);
        preOrder(root.left, sum);
        preOrder(root.right, sum);
    }

    public void solve(TreeNode node, int num, int sum) {
        if (node == null) return;
        num = num + node.val;
        if (num == sum) {
            ++total;
        }
        solve(node.left, num, sum);
        solve(node.right, num, sum);
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
