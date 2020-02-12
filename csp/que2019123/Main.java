package algorithm.csp.que2019123;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        boolean ans[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            String s = input.next();
            String left = s.split("=")[0];
            String right = s.split("=")[1];
            String[] leftArray = left.split("\\+");
            String[] rightArray = right.split("\\+");
            Map<String, Integer> leftMap = new HashMap<>();
            Map<String, Integer> rightMap = new HashMap<>();
            for (String string : leftArray) {
                new Main().procExpressOnUnit(leftMap, string, 1);
            }
            for (String string : rightArray) {
                new Main().procExpressOnUnit(rightMap, string, 1);
            }
            ans[i] = judge(rightMap, leftMap);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(ans[i] ? "Y" : "N");
        }
    }

    private static boolean judge(Map<String, Integer> rightMap, Map<String, Integer> leftMap) {
        for (Map.Entry<String, Integer> entry : leftMap.entrySet()) {
            if (!rightMap.containsKey(entry.getKey())) {
                return false;
                //注意超过128的Integer不能用等号
            } else if (!entry.getValue().equals(rightMap.get(entry.getKey()))) {
                return false;
            } else if (rightMap.size() != leftMap.size()) {
                return false;
            }
        }
        return true;
    }

    private void procExpressOnUnit(Map<String, Integer> map, String s, int unit) {
        int i = 0, n = s.length();
        int base = unit * getNumberOrDefault(s, i, 1);
        i = getCurPos(s, i);
        int pNumber, pElement = i;//记录数字开始的位置和元素开始的位置
        while (i < n) {
            if (isAlpha(s.charAt(i))) {
                pElement = i;//记录元素的起始位置
                if (i < n - 1 && isLower(s.charAt(i + 1))) {
                    ++i;
                }
                pNumber = ++i;
                String strElement = s.substring(pElement, i);
                int entry_base = base;
                if (pNumber != n && isDigit(s.charAt(i))) {
                    entry_base = base * getNumberOrDefault(s, i, 1);
                    i = getCurPos(s, i);
                    pNumber = i;
                }
                if (map.containsKey(strElement)) {
                    map.put(strElement, map.get(strElement) + entry_base);
                } else {
                    map.put(strElement, entry_base);
                }
                if (pNumber == n)
                    break;
            }
            if (s.charAt(i) == '(') {
                int openCount = 1;
                pElement = ++i;
                while (true) {
                    if (s.charAt(i) == '(') {
                        openCount++;
                    } else if (s.charAt(i) == ')') {
                        openCount--;
                    }
                    if (openCount == 0)
                        break;
                    i++;
                }
                String strElement = s.substring(pElement, i);
                pNumber = ++i;
                procExpressOnUnit(map, strElement, base * getNumberOrDefault(s, pNumber, 1));
                i = getCurPos(s, i);
                pNumber = i;
                if (pNumber < n) {
                    procExpressOnUnit(map, s.substring(pNumber, n), base);
                }
                return;
            }
        }
    }

    /**
     * 获取系数
     *
     * @param s          化学式
     * @param startIndex 算系数开始的位置，因为有可能化学式是这样(Na(3OH)3)
     * @return
     */
    private int getNumberOrDefault(String s, int startIndex, int defaultVal) {
        int resetVal = 0;
        for (; startIndex < s.length(); startIndex++) {
            if (isDigit(s.charAt(startIndex))) {
                resetVal = resetVal * 10 + (s.charAt(startIndex) - '0');
            } else {
                break;
            }
        }
        return resetVal == 0 ? defaultVal : resetVal;
    }

    private int getCurPos(String s, int defaultPos) {
        while (defaultPos < s.length() && isDigit(s.charAt(defaultPos))) {
            defaultPos++;
        }
        return defaultPos;
    }

    /**
     * 判断c是否是一个数字
     *
     * @param c
     * @return
     */
    private boolean isDigit(char c) {
        return c >= 48 && c <= 57;
    }

    private boolean isAlpha(char c) {
        return c >= 65 && c <= 90 || c >= 97 && c <= 122;
    }

    private boolean isLower(char c) {
        return c >= 97 && c <= 122;
    }
}
