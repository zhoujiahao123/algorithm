package algorithm.BinaryTree.DiameterofBinaryTree;

import sun.nio.cs.ext.MacHebrew;

public class Solution {
    int max;

    public int diameterOfBinaryTree(TreeNode root) {

        getDeepLen(root);
        return max;
    }


    public int getDeepLen(TreeNode root) {
        if (root == null) return 0;
        int l = getDeepLen(root.left);
        int r = getDeepLen(root.right);
        max = Math.max(max, l + r + 1);
        return 1 + Math.max(l, r);
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
