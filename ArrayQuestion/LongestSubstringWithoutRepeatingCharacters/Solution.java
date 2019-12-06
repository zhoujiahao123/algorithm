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
     * 暴力解法
     *
     * @param ch
     * @return
     */
    private int solveByBruteForce(char[] ch) {
        int count = 0;
        for (int i = 0; i < ch.length; i++) {
            for (int j = i + 1; j < ch.length; j++) {
                //判断i->j这里面是否有重复的字符出现
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
            //如果当前元素不在前面窗口中
            if (!set.contains(s.charAt(j))) {
                //添加进去
                set.add(s.charAt(j));
                //算出最大长度
                result = Math.max(result, j - i + 1);
                j++;
            } else {
                //这里要注意啊，是把i移除了，因为i这个位置上已经不可能有更长的出现了。
                set.remove(s.charAt(i));
                i++;
            }
        }
        return result;
    }
}
