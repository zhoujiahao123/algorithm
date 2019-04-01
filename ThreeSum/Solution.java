package ThreeSum;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //用map来装可以防止get时获得当前这个数
        HashMap<Integer,Integer> map = new HashMap<>();
        //用来装结果的List
        List<List<Integer>> ansList = new ArrayList<>();
        List<String> list = new ArrayList<>();
        int a,b,c;
        for(int i =0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i = 0;i<nums.length-1;i++){
            for(int j = i+1;j<nums.length;j++){
                a = nums[i];b = nums[j];
                c = 0-a-b;
                //如果找到了，装入大的List
                Integer numInContainer = map.get(c);
                //防止获得当前这个数，用>J是为了避免重复的工作
                if(numInContainer!=null&&numInContainer>j){
                        int temp[] = {a,b,c};
                        Arrays.sort(temp);
                        String str = temp[0]+","+temp[1]+","+temp[2]+",";
                        if(!list.contains(str)){
                            list.add(str);
                        }
                }
            }
        }
        for(int i =0;i<list.size();i++){
            List<Integer> listInt = new ArrayList<>();
            String[] strings = list.get(i).split(",");
            listInt.add(Integer.valueOf(strings[0]));
            listInt.add(Integer.valueOf(strings[1]));
            listInt.add(Integer.valueOf(strings[2]));
            ansList.add(listInt);
        }
        return ansList;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        int [] nums = {-1,0,1,2,-1,-4};
        solution.threeSum(nums);
    }
}
