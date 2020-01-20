package algorithm.csp.que2019122;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int ans[] = new int[5];
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            int xi = input.nextInt();
            int yi = input.nextInt();
            list.add(xi + "," + yi);
        }
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            String str = (String) it.next();
            String[] strs = str.split(",");
            int xi = Integer.valueOf(strs[0]);
            int yi = Integer.valueOf(strs[1]);
            if (isGarbageStation(xi + 1, yi, list) && isGarbageStation(xi, yi + 1, list) && isGarbageStation(xi - 1, yi, list) && isGarbageStation(xi, yi - 1, list)) {
                int num = 0;
                if(isGarbageStation(xi+1,yi+1,list)) num++;
                if(isGarbageStation(xi+1,yi-1,list)) num++;
                if(isGarbageStation(xi-1,yi+1,list)) num++;
                if(isGarbageStation(xi-1,yi-1,list)) num++;
                ans[num]++;
            }
        }
        for(int i :ans){
            System.out.println(i);
        }
    }

    private static boolean isGarbageStation(int xi, int yi, List list) {
        String str = xi + "," + yi;
        if (list.contains(str)) {
            return true;
        } else {
            return false;
        }
    }

}
