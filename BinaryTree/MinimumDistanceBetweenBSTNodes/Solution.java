package BinaryTree.MinimumDistanceBetweenBSTNodes;

/**
 * Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.
 *
 * Example :
 *
 * Input: root = [4,2,6,1,3,null,null]
 * Output: 1
 * Explanation:
 * Note that root is a TreeNode object, not an array.
 *
 * The given tree [4,2,6,1,3,null,null] is represented by the following diagram:
 *
 *           4
 *         /   \
 *       2      6
 *      / \
 *     1   3
 */
class Solution {
    int min = Integer.MAX_VALUE;
    int pre = -1;
    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return min;
    }
    public void inOrder(TreeNode root){
        if(root == null) return ;
        inOrder(root.left);
        if(pre != -1) {
            min = Math.min(min,root.val - pre);
        }
        pre = root.val;
        inOrder(root.right);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
