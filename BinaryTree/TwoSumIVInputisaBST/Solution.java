package BinaryTree.TwoSumIVInputisaBST;

import java.util.HashMap;

/**
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
 *
 * Example 1:
 *
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * Output: True
 *
 *
 * Example 2:
 *
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * Output: False
 */
class Solution {
    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    public boolean findTarget(TreeNode root, int k) {
        try{
            preOrder(root,k);
        }catch(Exception e){
            return true;
        }
        return false;
    }
    public void preOrder(TreeNode root,int k) throws Exception{
        if(root == null) return;
        int target = k - root.val;
        if(map.containsKey(target)){
            throw new Exception();
        }
        map.put(root.val,1);
        preOrder(root.left,k);
        preOrder(root.right,k);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}