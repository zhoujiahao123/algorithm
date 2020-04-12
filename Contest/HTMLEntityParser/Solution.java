package algorithm.Contest.HTMLEntityParser;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        String text = "&amp; is an HTML entity but &ambassador; is not.";
        new Solution().entityParser(text);
    }

    public String entityParser(String text) {
        Map<String, String> patternMap = new HashMap<>();//HTML转换位符号
        patternMap.put("&quot;", "\"");
        patternMap.put("&apos;", "\'");
        patternMap.put("&amp;", "&");
        patternMap.put("&gt;", ">");
        patternMap.put("&lt;", "<");
        patternMap.put("&frasl;", "/");
        StringBuilder sb = new StringBuilder(text);
        for (String key : patternMap.keySet()) {
            int[] maxMatchLen = getMaxMatchLen(key);
            int count = 0;
            //对字符串做处理用sb较好
            for (int i = 0; i < sb.length(); i++) {
                while (count > 0 && sb.charAt(i) != key.charAt(count)) {
                    count = maxMatchLen[count - 1];
                }
                if (sb.charAt(i) == key.charAt(count)) {
                    count++;
                }
                if (key.length() == count) {
                    //找到开始的位置
                    int start = i - count + 1;
                    int end = i + 1;
                    //注意这里更改了sb的长度，因此i也应该回退.
                    sb.replace(start, end, patternMap.get(key));
                    i -= (key.length() - 1);
                    count = 0;
                }
            }
        }
        return sb.toString();
    }


    //获取最大自身匹配数组
    public int[] getMaxMatchLen(String pattern) {
        int maxLength = 0;
        int[] maxMatchLen = new int[pattern.length()];
        for (int i = 1; i < pattern.length(); i++) {
            while (maxLength > 0 && pattern.charAt(i) != pattern.charAt(maxLength)) {
                maxLength = maxMatchLen[maxLength - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(maxLength)) {
                maxLength++;
            }
            maxMatchLen[i] = maxLength;
        }
        return maxMatchLen;
    }
}
