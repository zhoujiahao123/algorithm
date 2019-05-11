package BinaryTree.ValidateBinarySearchTree;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */

/**
 * 这道题坑的在于其测试用例直接给到了Interger.Min_value,导致无法初始化max为该值。
 * 另外还要不太会处理边界条件
 */
class Solution {
    int max;
    boolean isFirst = true;
    boolean flag = false;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null)return true;
        try{
            inOrder(root);
        }catch (Exception e){
            return false;
        }
        return true;
    }
//抛出异常强行退出递归，中序遍历，若出现当前值小于前一个，则肯定不是一个BST
    public void inOrder(TreeNode root) throws Exception{
        if(root == null) return;
        inOrder(root.left);
        if(isFirst){
            max = root.val;
            isFirst = false;
        }else if(max >= root.val){
            throw new Exception();
        }else{
            max = root.val;
        }

        inOrder(root.right);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
