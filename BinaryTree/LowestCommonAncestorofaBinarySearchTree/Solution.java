package BinaryTree.LowestCommonAncestorofaBinarySearchTree;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 *
 *
 * Example 1:
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * Example 2:
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 */

/**
 * 能够解决，但运行速度太慢
 */
public class Solution {
    TreeNode ansNode = null;
    //判断p，q结点是否在其左子树
    boolean exist ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val>q.val){
            TreeNode temp = q;
            q = p;
            p = temp;
        }
        keys(root, p, q);
        return ansNode;
    }
    public void keys(TreeNode root, TreeNode p, TreeNode q){
        if(root == null||ansNode!=null) return;
        if(p.val<root.val){
            lowestCommonAncestor(root.left,p,q);
        }
        if(p.val<=root.val&&q.val>=root.val){
            if(p.val == root.val){
                exist = false;
                inOrder(root.right,q);
                if(exist) ansNode = root;
            }else if(q.val == root.val){
                exist = false;
                inOrder(root.left,p);
                if(exist) ansNode = root;
            }else {
                exist = false;
                inOrder(root.left,p);
                if(exist){
                    exist = false;
                    inOrder(root.right,q);
                    if(exist)
                        ansNode = root;
                }
            }
        }
        if(q.val>root.val){
            lowestCommonAncestor(root.right,p,q);
        }
    }
    //用遍历的方法判断左子树是否存在p结点，
    public void inOrder(TreeNode root,TreeNode node){
        if(root == null || exist) return;
        inOrder(root.left,node);
        if(root.val == node.val){
            exist = true;
        }
        inOrder(root.right,node);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
