package algorithm.top100medium.GroupAnagrams;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> maps = new HashMap<>();
        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if (!maps.containsKey(key)) {
                maps.put(key, new ArrayList<>());
            }
            maps.get(key).add(s);
        }
        return new ArrayList<>(maps.values());
    }
}
