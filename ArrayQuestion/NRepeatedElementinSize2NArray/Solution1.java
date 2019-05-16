package ArrayQuestion.NRepeatedElementinSize2NArray;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    Map<Integer,Integer> map = new HashMap<>();
    public int repeatedNTimes(int[] A) {
        for(int i :A){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int k :map.keySet()){
            if(map.get(k)>1){
                return k;
            }
        }
        throw null;
    }
}
