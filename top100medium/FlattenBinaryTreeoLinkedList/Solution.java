package algorithm.top100medium.FlattenBinaryTreeoLinkedList;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> list = new ArrayList<>();

    public void flatten(TreeNode root) {
        if(root == null) return;
        preOrder(root);
        TreeNode node = root;
        node.left = null;
        for (int i = 1; i < list.size(); i++) {
            node.right = new TreeNode(list.get(i));
            node = node.right;
        }
    }

    public void preOrder(TreeNode root) {
        if(root == null) return;
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
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
