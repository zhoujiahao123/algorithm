package BinaryTree.FindModeinBinarySearchTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 Both the left and right subtrees must also be binary search trees.


 For example:
 Given BST [1,null,2,2],

 1
 \
 2
 /
 2


 return [2].
 */
class Solution {
    int max = 0;
    int ans[] = new int[1024];
    int length = 0;
    Map<Integer,Integer> map = new HashMap<>();
    public int[] findMode(TreeNode root) {
        if(root ==null) return new int[]{0};
        inOrder(root);
        return Arrays.copyOfRange(ans,0,length+1);
    }
    //中序遍历树
    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        if(map.containsKey(root.val)){
            int temp = map.get(root.val);
            map.put(root.val,temp+1);
            if(max<temp+1){
                max = temp+1;
                ans = new int[1024];
                ans[0] = root.val;
                length = 0;
            }else if(max == temp+1){
                ans[++length] = root.val;
            }
        }else{
            map.put(root.val,1);
            if(max<1){
                max = 1;
                ans = new int[1024];
                ans[0] = root.val;
                length = 0;
            }else if(max==1){
                ans[++length] = root.val;
            }
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
