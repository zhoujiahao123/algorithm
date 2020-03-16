package algorithm.top100medium.ConstructBinaryTreefromPreorderandInorderTraversal;

import java.util.Arrays;

public class Solution {
    int pos = -1;

    public static void main(String[] args) {
        int pre[] = {1, 2};
        int in[] = {1, 2};
        new Solution().buildTree(pre, in);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null) return null;
        if (preorder.length == 0) return null;
        return null;
    }

    public TreeNode solve(int[] preorder, int[] inorder, int start, int end) {
        if (inorder == null || inorder.length == 0) return null;
        pos++;
        if (inorder.length == 1) return new TreeNode(inorder[0]);
        int mid = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[pos] == inorder[i]) {
                mid = i;
                break;
            }
        }
        int[] aleft = Arrays.copyOfRange(inorder, 0, mid);
        int[] aright = mid + 1 < inorder.length ? Arrays.copyOfRange(inorder, mid + 1, inorder.length) : null;
        TreeNode node = new TreeNode(inorder[mid]);
        node.left = solve(preorder, aleft, 0, mid);
        node.right = solve(preorder, aright, mid + 1, inorder.length);
        return node;
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
