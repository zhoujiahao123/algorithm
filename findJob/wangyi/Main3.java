package algorithm.findJob.wangyi;

public class Main3 {
    public int solve(int[] elec, int[] cost) {
        int len = elec.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < len; i++) {
            spare += elec[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }
        return spare < 0 ? -1 : (minIndex + 1) % len;
    }
}
