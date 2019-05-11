package BinaryTree.ConvertSortedArraytoBinarySearchTree;

import java.util.Arrays;

class Solution {
    TreeNode root ;
    public TreeNode sortedArrayToBST(int[] nums) {
        generateBST(nums,0,nums.length-1);
        return root;
    }
    public void generateBST(int[] nums,int lo,int hi){
        if(lo > hi) return ;
        int mid = lo + ((hi - lo)>>1);
        root = insertIntoBST(root,nums[mid]);
        generateBST(nums,lo,mid-1);
        generateBST(nums,mid +1,hi);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        } else if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.val = val;
        }
        return root;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
