package algorithm.javatest.bytedance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1,2},{1,3},{2,4}};
        System.out.println(new Solution().solve(a,4));
    }
    public boolean solve(int[][] dislike, int N) {
        if (N == 0) return true;
        Map<Integer, List<Integer>> map = new HashMap<>();
        //每个人不喜欢的人
        for (int i = 0; i < dislike.length; i++) {
            List list = map.getOrDefault(dislike[i][0], new ArrayList<>());
            list.add(dislike[i][1]);
            map.put(dislike[i][0], list);
        }
        boolean result = true;
        for (int i = 1; i <= N; i++) {
            if(map.get(i)!=null) {
                result = check(map.get(i), map);
                if(!result) return false;
            }
        }
        return true;
    }
    public boolean check(List<Integer> list, Map<Integer, List<Integer>> map) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if(map.get(list.get(i))!=null) {
                    if (map.get(list.get(i)).contains(list.get(j))) return false;
                }
            }
        }
        return true;
    }
}
