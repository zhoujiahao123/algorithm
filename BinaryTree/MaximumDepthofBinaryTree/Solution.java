package BinaryTree.MaximumDepthofBinaryTree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public int maxDepth(TreeNode root) {
        return findDeep(root);
    }

    public int findDeep(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        } else {
            int liftDeep = findDeep(treeNode.left);
            int rightDeep = findDeep(treeNode.right);
            return liftDeep > rightDeep ? liftDeep + 1 : rightDeep + 1;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}