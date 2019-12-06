package algorithm.ArrayQuestion.LongestSubstringWithoutRepeatingCharacters;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcdd"));
    }

    public int lengthOfLongestSubstring(String s) {
        return solveByBruteForce(s.toCharArray());
    }

    /**
     * �����ⷨ
     *
     * @param ch
     * @return
     */
    private int solveByBruteForce(char[] ch) {
        int count = 0;
        for (int i = 0; i < ch.length; i++) {
            for (int j = i + 1; j < ch.length; j++) {
                //�ж�i->j�������Ƿ����ظ����ַ�����
                boolean isExistDouble = false;
                Set<Character> set = new HashSet<>();
                for (int k = i; k <= j; k++) {
                    if (set.contains(ch[k])) {
                        isExistDouble = true;
                        break;
                    } else {
                        set.add(ch[k]);
                    }
                }
                if (!isExistDouble) {
                    count = Math.max(count, j - i + 1);
                }
            }
        }
        return count;
    }

    private int solveBySlidingWindow(String s) {
        int len = s.length();
        int i = 0, j = 0;
        int result = 0;
        Set<Character> set = new HashSet<>();
        while (i < len && j < len) {
            //�����ǰԪ�ز���ǰ�洰����
            if (!set.contains(s.charAt(j))) {
                //��ӽ�ȥ
                set.add(s.charAt(j));
                //�����󳤶�
                result = Math.max(result, j - i + 1);
                j++;
            } else {
                //����Ҫע�Ⱑ���ǰ�i�Ƴ��ˣ���Ϊi���λ�����Ѿ��������и����ĳ����ˡ�
                set.remove(s.charAt(i));
                i++;
            }
        }
        return result;
    }
}
