package algorithm.DpQuestion.WeightedIntervalScheduling;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Interval> intervalList = new ArrayList<>();
        intervalList.add(new Interval(1, 1, 4, 2));
        intervalList.add(new Interval(2, 3, 5, 2));
        intervalList.add(new Interval(3, 0, 6, 5));
        intervalList.add(new Interval(4, 5, 7, 3));
        intervalList.add(new Interval(5, 3, 8, 1));
        intervalList.add(new Interval(6, 5, 9, 4));
        intervalList.add(new Interval(7, 6, 10, 7));
        intervalList.add(new Interval(8, 8, 11, 2));
        intervalList.add(new Interval(9, 8, 12, 3));
        intervalList.add(new Interval(10, 2, 13, 3));
        intervalList.add(new Interval(11, 12, 14, 4));

        int p[] = new int[intervalList.size()];//p(i)表示第i个任务的前面第一个不相交的任务
        p[0] = 0;
        for (int i = 1; i < p.length; i++) {
            p[i] = setP(intervalList, i);
        }
        int opt[] = new int[intervalList.size()];
        opt[0] = 2;
        for (int i = 1; i < p.length; i++) {
            if (p[i] != -1) {
                opt[i] = Math.max(opt[p[i]] + intervalList.get(i).getWeight(), opt[i - 1]);
            } else {
                opt[i] = Math.max(intervalList.get(i).getWeight(), opt[i - 1]);
            }
        }
        System.out.println(opt[opt.length - 1]);
        showAns(opt, p);
    }

    /**
     * @param intervalList
     * @param pos          表示当前的活动
     * @return 返回-1表示前面没有与它不相交的活动
     */
    private static int setP(List<Interval> intervalList, int pos) {
        for (int i = pos - 1; i >= 0; i--) {
            if (intervalList.get(i).getEndTime() <= intervalList.get(pos).getStartTime()) {
                return i;
            }
        }
        return -1;
    }

    private static void showAns(int opt[], int p[]) {
        for (int i = opt.length - 1; i >= 0; ) {
            if (opt[i] != opt[i - 1]) {
                System.out.println(i);
                i = p[i];
            } else {
                i--;
            }
        }
    }
}
