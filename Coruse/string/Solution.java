package algorithm.Coruse.string;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> res = new ArrayList<>();
    String max = "255";

    public static void main(String[] args) {
        new Solution().restoreIpAddresses("255255");
    }
    public List<String> restoreIpAddresses(String s) {
        fun(s,4,new StringBuilder());
        return res;
    }
    public void fun(String s,int size,StringBuilder sb){
        if(s.length() > size * 3) return;
        if(s.length() < size) return;
        if(size == 1){
            if(s.compareTo(max)>0){
                return;
            }
            sb.append(s);
            res.add(sb.toString());
        }
        for(int i = 1;i<=3;i++){
            if(s.length() < i) break;
            int sbLen = sb.length();
            String temp = s.substring(0,i);
            if(temp.compareTo(max)>0) break;
            sb.append(temp).append(".");
            fun(s.substring(i),size-1,sb);
            sb.setLength(sbLen);
        }
    }
}