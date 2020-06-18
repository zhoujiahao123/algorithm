package algorithm.DpQuestion.WordBreak2;

import java.util.*;

class Solution {
    Set<String> dict = new HashSet<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        //corner case
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        for(String word : wordDict) {
            dict.add(word);
        }
        boolean[] mem = new boolean[s.length()+1];
        Arrays.fill(mem,true);
        dfs(res, s, dict, mem, 0, new StringBuilder());
        return res;
    }

    private void dfs(List<String> res, String s, Set<String> dict, boolean[] mem, int index, StringBuilder sb) {
        if(index == s.length()) {
            sb.setLength(sb.length()-1);
            res.add(sb.toString());
            return;
        }

        if(mem[index] == false) return;

        int size = res.size();
        for(int i = index; i < s.length(); i ++) {
            int len = sb.length();
            //pruning
            if(mem[i+1]==false) continue;
            String newString = s.substring(index, i+1);
            if(dict.contains(newString)) {
                sb.append(newString + " ");
                dfs(res, s, dict, mem, i+1, sb);
                //setback
                sb.setLength(len);
            }
        }

        if(size == res.size()) {
            mem[index] = false;
        }
        return;
    }
}