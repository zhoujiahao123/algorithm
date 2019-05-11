package BinaryTree.FindModeinBinarySearchTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
class Solution1 {
    int max = 0;
    int num = 0;
    boolean isFirst = true;
    int pre;
    int ans[] = new int[1024];
    int length = -1;
    public int[] findMode(TreeNode root) {
        if(root ==null) return new int[]{};
        inOrder(root);
        if(max<num){
            ans = new int[1024];
            length = -1;
            ans[++length] = pre;
        }else if(max ==num){
            ans[++length] = pre;
        }
        return Arrays.copyOfRange(ans,0,length+1);
    }
    //中序遍历树
    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        if(isFirst){
            isFirst = false;
            num = 1;
            pre = root.val;
        }else{
            if(pre == root.val){
                num++;
            }else{
                if(max<num){
                    ans = new int[1024];
                    length = -1;
                    ans[++length] = pre;
                    max = num;
                }else if(max ==num){
                    ans[++length] = pre;
                    max = num;
                }
                num = 1;
            }
            pre = root.val;
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
