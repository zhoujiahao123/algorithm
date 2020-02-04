package algorithm.csp.que2019123;

import java.util.*;

public class Main {
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        boolean ans[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            String s = input.next();
            String left = s.split("=")[0];
            String right = s.split("=")[1];
            String leftArray[] = left.split("\\+");
            String rightArray[] = right.split("\\+");
            Map<String, Integer> rightMap = getMap(rightArray);
            Map<String, Integer> leftMap = getMap(leftArray);
            ans[i] = judge(rightMap, leftMap);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(ans[i]?"Y":"N");
        }
    }

    private static boolean judge(Map<String, Integer> rightMap, Map<String, Integer> leftMap) {
        for (Map.Entry<String, Integer> entry : leftMap.entrySet()) {
            if (!rightMap.containsKey(entry.getKey())) {
                return false;
            } else if (entry.getValue() != rightMap.get(entry.getKey())) {
                return false;
            }
        }
        return true;
    }

    private static Map getMap(String[] array) {
        Map<String, Integer> rightMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int k = 1;
            //数字可能不是一位
            if (array[i].charAt(0) >= 48 && array[i].charAt(0) <= 57) {
                k = array[i].charAt(0) - 48;
                array[i] = array[i].substring(1);
            }
            Map<String, Integer> map = compute(array[i], k);
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (rightMap.containsKey(entry.getKey())) {
                    rightMap.put(entry.getKey(), entry.getValue() + rightMap.get(entry.getKey()));
                } else {
                    rightMap.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return rightMap;
    }

    //k是系数
    private static Map compute(String str, int k) {
        str = getKuoHaoNum(str);
        int count = 0;
        String pre = "";
        boolean isFirst = true;
        Map<String, Integer> maps = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (!isFirst) {
                if (str.charAt(i) >= 65 && str.charAt(i) <= 90) {
                    //说明是大写字母
                    int num = maps.containsKey(pre) ? maps.get(pre) : 0;
                    if (!pre.equals("")) {
                        maps.put(pre, (num + 1) * k);
                    }
                    pre = "";
                }
                if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                    //说明是数字，但数字可能不止一位，要考虑到
                    int multiply = str.charAt(i) - 48;
                    int num = maps.containsKey(pre) ? maps.get(pre) : 0;
                    if (!pre.equals("")) {
                        maps.put(pre, (num + multiply) * k);
                    }
                    pre = "";
                    if (i == str.length() - 1) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (str.charAt(i) == '(') {
                    int num = maps.containsKey(pre) ? maps.get(pre) : 0;
                    if (!pre.equals("")) {
                        maps.put(pre, (num + 1) * k);
                    }
                    pre = "";
                    k = k * map.get(++count);
                }
                if (str.charAt(i) == ')') {
                    int num = maps.containsKey(pre) ? maps.get(pre) : 0;
                    if (!pre.equals("")) {
                        maps.put(pre, (num + 1) * k);
                    }
                    pre = "";
                    k = k / map.get(count--);
                }
            } else {
                isFirst = false;
            }
            if (str.charAt(i) != '(' && str.charAt(i) != ')') {
                pre = pre + str.charAt(i);
            }
            if (i == str.length() - 1 && str.charAt(i) != ')') {
                int num = maps.containsKey(pre) ? maps.get(pre) : 0;
                if (!pre.equals("")) {
                    maps.put(pre, (num + 1) * k);
                }
            }
        }
        return maps;
    }

    private static String getKuoHaoNum(String str) {
        if (!str.contains("(")) {
            return str;
        }

        int cur = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                cur++;
                while (map.containsKey(cur)) {
                    cur++;
                }
            } else if (str.charAt(i) == ')') {
                if (i != str.length() - 1) {
                    //数字可能不止一位
                    if (str.charAt(i + 1) >= 48 && str.charAt(i + 1) <= 57) {
                        map.put(cur, str.charAt(++i) - 48);
                        str = str.substring(0, i) + str.substring(i + 1);
                        i--;
                    } else {
                        map.put(cur, 1);
                    }
                } else {
                    map.put(cur, 1);
                }
                cur--;
                while (map.containsKey(cur)) {
                    cur--;
                }
            }
        }
        return str;
    }
}
