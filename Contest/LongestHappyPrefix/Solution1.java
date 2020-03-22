package algorithm.Contest.LongestHappyPrefix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {
    /**
     * ÄÚ´æ³¬³ö
     *
     * @param s
     * @return
     */
    public String longestPrefix(String s) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i++) {
            sb.append(s.charAt(i));
            list.add(sb.toString());
        }
        sb.delete(0, sb.length());
        sb.append(s.substring(1));
        for (int i = 1; i < s.length(); i++) {
            if (list.contains(sb.toString())) {
                return sb.toString();
            }
            sb.delete(0, 1);
        }
        return "";
    }
}
