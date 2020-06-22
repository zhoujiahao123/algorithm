package algorithm.Queue.topkfrequentelements;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Rule implements Comparator<Integer> {
    Map<Integer, Integer> map = new HashMap<>();
    public Rule(HashMap map) {
        this.map = map;
    }
    @Override
    public int compare(Integer o1, Integer o2) {

        return map.get(o1) - map.get(o2);
    }
}
