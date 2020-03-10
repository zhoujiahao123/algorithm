package algorithm.top100medium.DecodeString;

public class Solution {
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        new Solution().decodeString(s);
    }

    public String decodeString(String s) {
        return decode(s, new StringBuilder()).toString();
    }

    public StringBuilder decode(String s, StringBuilder sb) {
        int pElement = 0;//字符串开始的位置，不包含系数
        int qElement = 0;//当前位置
        while (qElement < s.length()) {
            if (s.charAt(qElement) >= 'a' && s.charAt(qElement) <= 'z' || s.charAt(qElement) >= 'A' && s.charAt(qElement) <= 'Z') {
                sb.append(s.charAt(qElement));
            }
            if (s.charAt(qElement) >= '0' && s.charAt(qElement) <= '9') {
                //算系数
                int num = 0;
                while (s.charAt(qElement) >= '0' && s.charAt(qElement) <= '9') {
                    num = num * 10 + (s.charAt(qElement) - '0');
                    ++qElement;
                }
                int count = 0;
                pElement = qElement;
                while (qElement < s.length()) {
                    if (s.charAt(qElement) == '[') count++;
                    if (s.charAt(qElement) == ']') count--;
                    if (count == 0) break;
                    qElement++;
                }
                StringBuilder res = decode(s.substring(pElement + 1, qElement), new StringBuilder());
                while (num != 0) {
                    sb.append(res);
                    num--;
                }
            }
            qElement++;
        }
        return sb;
    }
}
