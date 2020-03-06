package algorithm.top100medium.BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> res = new HashMap<>();
        preOrder(root, 0, res);
        return new ArrayList<>(res.values());
    }

    public void preOrder(TreeNode root, int level, Map<Integer, List<Integer>> maps) {
        if (root == null) return;
        if (!maps.containsKey(level)) maps.put(level, new ArrayList<>());
        maps.get(level).add(root.val);
        preOrder(root.left, level + 1, maps);
        preOrder(root.right, level + 1, maps);
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
