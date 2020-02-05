package algorithm.csp.que2019123;

import java.util.*;

public class Main {
    static Map<Integer, Integer> map;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        boolean ans[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            map = new HashMap<>();
            String s = input.next();
            String left = s.split("=")[0];
            String right = s.split("=")[1];
            String[] leftArray = left.split("\\+");
            String[] rightArray = right.split("\\+");
            Map<String, Integer> leftMap = getMap(leftArray);
            map.clear();
            Map<String, Integer> rightMap = getMap(rightArray);
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

    private static Map getMap(String[] array) {
        Map<String, Integer> rightMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int k = 1;
            //数字可能不是一位
            int count = 0;
            if (array[i].charAt(count) >= 48 && array[i].charAt(count) <= 57) {
                k = array[i].charAt(count) - 48;
                count++;
                while (array[i].length() - 1 != count && array[i].charAt(count) >= 48 && array[i].charAt(count) <= 57) {
                    k = k * 10 + (array[i].charAt(count) - 48);
                    count++;
                }
            }
            array[i] = array[i].substring(count);
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
        boolean isVisited[] = new boolean[map.size()+1];
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
                        maps.put(pre, num + k);
                    }
                    pre = "";
                }
                if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                    //说明是数字，但数字可能不止一位，要考虑到
                    int multiply = str.charAt(i) - 48;
                    while (i != str.length() - 1 && str.charAt(i + 1) >= 48 && str.charAt(i + 1) <= 57) {
                        i++;
                        multiply = multiply * 10 + (str.charAt(i) - 48);
                    }
                    int num = maps.containsKey(pre) ? maps.get(pre) : 0;
                    if (!pre.equals("")) {
                        maps.put(pre, num + multiply * k);
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
                        maps.put(pre, num + k);
                    }
                    pre = "";
                    count++;
                    while (count!=isVisited.length&&isVisited[count]) {
                        count++;
                    }
                    k = k * map.get(count);

                }
                if (str.charAt(i) == ')') {
                    int num = maps.containsKey(pre) ? maps.get(pre) : 0;
                    if (!pre.equals("")) {
                        maps.put(pre, num + k);
                    }
                    pre = "";
                    k = k / map.get(count);
                    isVisited[count] = true;
                    count--;
                    while (isVisited[count]) {
                        count--;
                    }
                }
            } else {
                isFirst = false;
                if (str.charAt(i) == '(') {
                    count++;
                    k = k * map.get(count);
                }
            }
            if (str.charAt(i) != '(' && str.charAt(i) != ')') {
                pre = pre + str.charAt(i);
            }
            if (i == str.length() - 1 && str.charAt(i) != ')') {
                int num = maps.containsKey(pre) ? maps.get(pre) : 0;
                if (!pre.equals("")) {
                    maps.put(pre, num + k);
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
                        i++;
                        int count = str.charAt(i) - 48;
                        while (i != str.length() - 1 && str.charAt(i + 1) >= 48 && str.charAt(i + 1) <= 57) {
                            i++;
                            count = count * 10 + (str.charAt(i) - 48);
                        }
                        map.put(cur, count);
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
