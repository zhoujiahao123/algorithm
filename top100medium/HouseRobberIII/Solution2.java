package algorithm.top100medium.HouseRobberIII;

import algorithm.top100medium.HouseRobberIII.Solution.TreeNode;

import java.util.HashMap;
import java.util.Map;


public class Solution2 {
    public int rob(TreeNode root) {
        return subRob(root, new HashMap<>());
    }

    public int subRob(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int val = 0;
        if (root.left != null) val += subRob(root.left.left, map) + subRob(root.left.right, map);
        if (root.right != null) val += subRob(root.right.left, map) + subRob(root.right.right, map);
        int ans = Math.max(val + root.val, subRob(root.left, map) + subRob(root.right, map));
        map.put(root, ans);
        return ans;
    }
}
