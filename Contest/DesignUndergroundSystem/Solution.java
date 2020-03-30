package algorithm.Contest.DesignUndergroundSystem;

import java.util.*;

public class Solution {
    private Map<String, List<Integer>> mapIn = new HashMap<>();
    private Map<String, List<Integer>> mapOut = new HashMap<>();
    private Map<Integer, Integer> mapIdInTime = new HashMap<>();
    private Map<Integer, Integer> mapIdOutTime = new HashMap<>();

    public static void main(String[] args) {

    }
    public Solution() {

    }

    public void checkIn(int id, String stationName, int t) {
        mapIdInTime.put(id, t);
        if (mapIn.get(stationName) != null) {
            mapIn.get(stationName).add(id);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(id);
            mapIn.put(stationName, list);
        }
    }

    public void checkOut(int id, String stationName, int t) {
        mapIdOutTime.put(id, t);
        if (mapOut.get(stationName) != null) {
            mapOut.get(stationName).add(id);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(id);
            mapOut.put(stationName, list);
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        List<Integer> listIn = mapIn.get(startStation);
        List<Integer> listOut = mapOut.get(endStation);
        double total = 0, count = 0;
        if (listIn != null && listOut != null) {
            Iterator it = listIn.iterator();
            while (it.hasNext()) {
                Integer id = (Integer) it.next();
                if (listOut.contains(id)) {
                    count++;
                    total += mapIdOutTime.get(id) - mapIdInTime.get(id);
                }
            }
        }
        return count == 0 ? 0 : total / count;
    }
}
