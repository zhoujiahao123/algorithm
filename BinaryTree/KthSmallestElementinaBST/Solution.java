package BinaryTree.KthSmallestElementinaBST;

public class Solution {
    int sizes = 0;
    public int kthSmallest(TreeNode root, int k) {
        return solve(root,k-1);
    }
    public int solve(TreeNode root, int k){
        if(root ==null) return 0;
        sizes = sizeNum(root.left);
        if(sizes>k){
            return kthSmallest(root.left,k);
        }else if(sizes<k){
            return kthSmallest(root.right,k-sizes-1);
        }else{
            return root.val;
        }
    }
    public int sizeNum(TreeNode root){
        if(root == null) return 0;
        return sizeNum(root.left)+1+sizeNum(root.right);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
