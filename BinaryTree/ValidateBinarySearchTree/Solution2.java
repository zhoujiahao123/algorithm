package algorithm.BinaryTree.ValidateBinarySearchTree;


public class Solution2 {
    int pre = Integer.MIN_VALUE;
    boolean result = true;

    public boolean isValidBST(TreeNode root) {
        solve(root);
        return result;
    }
    private void solve(TreeNode root){
        if (root != null) {
            isValidBST(root.left);
            if(root.val<=pre){
                result = false;
            }
            pre = root.val;
            isValidBST(root.right);
        }
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
