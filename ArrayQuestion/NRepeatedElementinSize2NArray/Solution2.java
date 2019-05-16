package ArrayQuestion.NRepeatedElementinSize2NArray;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    Map<Integer,Integer> map = new HashMap<>();
    public int repeatedNTimes(int[] A) {
        for(int i :A){
            if(map.getOrDefault(i,0) == 1)
                return i;
            else
                map.put(i,1);
        }
        throw null;
    }
}
