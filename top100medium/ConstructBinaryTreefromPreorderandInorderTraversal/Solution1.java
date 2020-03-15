package algorithm.top100medium.ConstructBinaryTreefromPreorderandInorderTraversal;

import java.util.Arrays;

public class Solution1 {
    int pos = -1;

    public static void main(String[] args) {
        int pre[] = {1, 2};
        int in[] = {1, 2};
        new Solution1().buildTree(pre, in);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null) return null;
        if (preorder.length == 0) return null;
        return solve(preorder, inorder, 0, inorder.length);
    }

    public TreeNode solve(int[] preorder, int[] inorder, int start, int end) {
        if (start >= end) return null;
        pos++;
        if (end - start == 1) return new TreeNode(inorder[start]);
        int mid = 0;
        for (int i = start; i < end; i++) {
            if (preorder[pos] == inorder[i]) {
                mid = i;
                break;
            }
        }
        TreeNode node = new TreeNode(inorder[mid]);
        node.left = solve(preorder, inorder, start, mid);
        node.right = solve(preorder, inorder, mid + 1, end);
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
