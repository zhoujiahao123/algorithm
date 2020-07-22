package algorithm.TwoPoint.MinimumWindowSubstring;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        String s = "cabwefgewcwaefgcf";
        String t = "cae";
        new Solution().minWindow(s,t);
    }
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        boolean find = false;
        if(s.length()==t.length()){
            char[] c1 = s.toCharArray();
            char[] c2 = t.toCharArray();
            Arrays.sort(c1);
            Arrays.sort(c2);
            for(int i = 0;i<c1.length;i++){
                if(c1[i]!=c2[i]) return "";
            }
        }
        int index = -1;
        int left = 0,right = 0;
        int min = Integer.MAX_VALUE;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        Set<Character> set = new HashSet<>();
        for(int i = 0;i<t.length();i++){
            set.add(t.charAt(i));
        }
        boolean flag = false;
        for(int i = 0;i<s.length();i++){
            while(!flag && index<s.length()-1){
                index++;
                if(set.contains(s.charAt(index))){
                    map.merge(s.charAt(index),1,Integer::sum);
                }
                if(set.size() == map.size()){
                    flag = check(map,t);
                }
                if(flag){
                    find = true;
                    if(index - i + 1 < min){
                        right = index;
                        left = i;
                    }
                }
            }
            flag = check(map,t);
            if(flag){
                find = true;
                if(index - i + 1 < min){
                    right = index;
                    left = i;
                }
            }
            if(map.containsKey(s.charAt(i))){
                int count = map.get(s.charAt(i));
                if(count == 1) map.remove(s.charAt(i));
                else map.put(s.charAt(i),count-1);
            }
        }
        return find?s.substring(left,right+1):"";
    }
    public boolean check(Map<Character,Integer> map,String t){
        Map<Character,Integer> tMap = new HashMap<>();
        for(int i = 0;i<t.length();i++){
            tMap.merge(t.charAt(i),1,Integer::sum);
        }
        for(Character key : tMap.keySet()){
            Integer count = map.get(key);
            if(count==null) return false;
            if(count<tMap.get(key)){
                return false;
            }
        }
        return true;
    }



}