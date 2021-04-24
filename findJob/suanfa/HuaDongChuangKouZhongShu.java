package algorithm.findJob.suanfa;

import java.util.*;

public class HuaDongChuangKouZhongShu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0, k = 0;
        n = sc.nextInt();
        k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        Map<Integer, Integer> timeMap = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(timeMap.get(o1) > timeMap.get(o2)){
                    return -1;
                }else if(timeMap.get(o1) < timeMap.get(o2)){
                    return 1;
                }else {
                    if(o1 < o2){
                        return -1;
                    }else if(o1 > o2){
                        return 1;
                    }else{
                        return 0;
                    }
                }
            }
        });
        for (int i = 0; i < k; ++i) {
            if (!timeMap.containsKey(arr[i])) {
                timeMap.put(arr[i], 1);
            } else {
                timeMap.merge(arr[i], 1, Integer::sum);
            }
        }
        for(Integer i : timeMap.keySet()){
            queue.offer(i);
        }
        List<Integer> res = new ArrayList<>();

        res.add(queue.peek());
        for (int i = k; i < n; i++) {
            int pre = i - k;
            if (timeMap.get(arr[pre]) > 1) {
                timeMap.merge(arr[pre], -1, Integer::sum);
                queue.remove(arr[pre]);
                queue.offer(arr[pre]);
            } else {
                timeMap.remove(arr[pre]);
                queue.remove(arr[pre]);
            }
            if (!timeMap.containsKey(arr[i])) {
                timeMap.put(arr[i], 1);
                queue.offer(arr[i]);
            } else {
                timeMap.merge(arr[i], 1, Integer::sum);
                queue.remove(arr[i]);
                queue.offer(arr[i]);
            }
            res.add(queue.peek());
        }
        for (Integer i : res) {
            System.out.println(i);
        }
    }
}
