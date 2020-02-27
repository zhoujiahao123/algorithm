package algorithm.BinaryTree.InvertBinaryTree;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        solve(root);
        return root;
    }

    public void solve(TreeNode root) {
        if(root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        solve(root.left);
        solve(root.right);
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
