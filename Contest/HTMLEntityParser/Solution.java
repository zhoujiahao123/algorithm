package algorithm.Contest.HTMLEntityParser;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        String text = "&amp; is an HTML entity but &ambassador; is not.";
        new Solution().entityParser(text);
    }

    public String entityParser(String text) {
        Map<String, String> patternMap = new HashMap<>();//HTMLת��λ����
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
            //���ַ�����������sb�Ϻ�
            for (int i = 0; i < sb.length(); i++) {
                while (count > 0 && sb.charAt(i) != key.charAt(count)) {
                    count = maxMatchLen[count - 1];
                }
                if (sb.charAt(i) == key.charAt(count)) {
                    count++;
                }
                if (key.length() == count) {
                    //�ҵ���ʼ��λ��
                    int start = i - count + 1;
                    int end = i + 1;
                    //ע�����������sb�ĳ��ȣ����iҲӦ�û���.
                    sb.replace(start, end, patternMap.get(key));
                    i -= (key.length() - 1);
                    count = 0;
                }
            }
        }
        return sb.toString();
    }


    //��ȡ�������ƥ������
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
