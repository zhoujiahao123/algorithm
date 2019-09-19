package algorithm.ArrayQuestion.meituan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        String s = "MPMPCPMCMDEFEGDEHINHKLIN";
        Map<Character, Poster> maps = new HashMap<>();
        List<Poster2> lists = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            //如果该外卖员已经出现国一次，更新其结束时间
            if (maps.containsKey(s.charAt(i))) {
                Poster poster = new Poster();
                poster.setEnd(i);
                poster.setStart(maps.get(s.charAt(i)).getStart());
                maps.put(s.charAt(i), poster);
            } else {
                //若没有出现，则开始时间和结束时间都是当前
                Poster poster = new Poster(i, i);
                maps.put(s.charAt(i), poster);
            }
        }
        for (Map.Entry<Character, Poster> entry : maps.entrySet()) {
            lists.add(new Poster2(entry.getKey(), entry.getValue().getStart(), entry.getValue().getEnd()));
        }
        Sort.SortByendTime((ArrayList<Poster2>) lists, 0, lists.size() - 1);
        int latestStartTime[] = new int[lists.size()];
        latestStartTime[lists.size() - 1] = Integer.MAX_VALUE;
        int nowMin = Integer.MAX_VALUE;
        for (int i = lists.size() - 2; i >= 0; i--) {
            if (lists.get(i + 1).getStart() < nowMin) {
                nowMin = lists.get(i + 1).getStart();
                latestStartTime[i] = nowMin;
            } else {
                latestStartTime[i] = nowMin;
            }
        }
        List<Integer> ans = new ArrayList<>();
        int totalNumber = 0;
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).getEnd() < latestStartTime[i]) {
                ans.add(lists.get(i).getEnd() + 1 - totalNumber);
                totalNumber += ans.get(ans.size() - 1);
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
