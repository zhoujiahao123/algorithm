package algorithm.Contest.DisplayTableofFoodOrdersinaRestaurant;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList();
        list.add(new ArrayList<String>(){{add("David");add("3");add("Ceviche");}});
        list.add(new ArrayList<String>(){{add("Corina");add("10");add("Beef Burrito");}});
        list.add(new ArrayList<String>(){{add("David");add("3");add("Fried Chicken");}});
        list.add(new ArrayList<String>(){{add("Carla");add("5");add("Water");}});
        list.add(new ArrayList<String>(){{add("Carla");add("5");add("Ceviche");}});
        list.add(new ArrayList<String>(){{add("Rous");add("3");add("Ceviche");}});
        new Solution().displayTable(list);
    }
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<String,Integer> foodNum = new HashMap<>();
        Set<String> titleSet = new HashSet<>();
        Set<String> tableNumSet = new HashSet<>();
        for(int i = 0;i<orders.size();i++){
            titleSet.add(orders.get(i).get(2));//取到food的名字
            tableNumSet.add(orders.get(i).get(1));//取到table编号
            foodNum.put(orders.get(i).get(1)+orders.get(i).get(2),foodNum.getOrDefault(orders.get(i).get(1)+orders.get(i).get(2),0)+1);
        }
        //排序foodName
        String[] foodName = new String[titleSet.size()];
        int m = 0;
        for(String s :titleSet){
            foodName[m++] = s;
        }
        Arrays.sort(foodName);//按字典序排序
        //tableNumSet
        Integer[] tableNum = new Integer[tableNumSet.size()];
        m=0;
        for(String s :tableNumSet){
            tableNum[m++] = Integer.valueOf(s);
        }
        Arrays.sort(tableNum);//按字典序排序
        //创建第一行
        List<String> foodNameList = new ArrayList<>();
        foodNameList.add("Table");
        for(int i = 0;i<foodName.length;i++){
            foodNameList.add(foodName[i]);
        }
        //做好预备工作后
        //结果List
        List<List<String>> res = new ArrayList<>();
        res.add(foodNameList);
        for(int i = 0;i<tableNum.length;i++){
            Integer num = tableNum[i];
            //遍历foodName,用num+foodName查询value
            List<String> list = new ArrayList<>();
            list.add(String.valueOf(num));
            for(int j = 1;j<foodNameList.size();j++){
                list.add(String.valueOf(foodNum.getOrDefault(num+foodNameList.get(j),0)));
            }
            res.add(list);
        }
        return res;
    }
}
