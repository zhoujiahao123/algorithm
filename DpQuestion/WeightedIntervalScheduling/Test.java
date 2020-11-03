package algorithm.DpQuestion.WeightedIntervalScheduling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Test {
    static class Interval {
        private int number;
        private int startTime;
        private int endTime;
        private int weight;
        public Interval(int number, int startTime, int endTime, int weight) {
            this.number = number;
            this.startTime = startTime;
            this.endTime = endTime;
            this.weight = weight;
        }
        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }
        public int getWeight() {
            return weight;
        }
    }
    static class Reader {
        BufferedReader reader;
        StringTokenizer tokenizer;
        void init(InputStream input) {
            reader = new BufferedReader(
                    new InputStreamReader(input) );
            tokenizer = new StringTokenizer("");
        }
        String next() throws IOException {
            while ( ! tokenizer.hasMoreTokens() ) {
                tokenizer = new StringTokenizer(
                        reader.readLine() );
            }
            return tokenizer.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt( next() );
        }
    }
    public static void main(String[] args) throws Exception{
        List<Interval> intervalList = new ArrayList<>();
        Reader reader = new Reader();
        reader.init(System.in);
        int n = reader.nextInt();
        for(int i = 1;i<=n;i++){
            int start = reader.nextInt();
            int end = reader.nextInt();
            int weight = reader.nextInt();
            intervalList.add(new Interval(i,start,end,weight));
        }
        Collections.sort(intervalList, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.getEndTime() - o2.getEndTime();
            }
        });
        int p[] = new int[intervalList.size()];//p(i)表示第i个任务的前面第一个不相交的任务
        p[0] = 0;
        for (int i = 1; i < p.length; i++) {
            p[i] = setP(intervalList, i);
        }
        int opt[] = new int[intervalList.size()];
        opt[0] = intervalList.get(0).weight;
        for (int i = 1; i < p.length; i++) {
            if (p[i] != -1) {
                opt[i] = Math.max(opt[p[i]] + intervalList.get(i).getWeight(), opt[i - 1]);
            } else {
                opt[i] = Math.max(intervalList.get(i).getWeight(), opt[i - 1]);
            }
        }
        System.out.println(opt[opt.length - 1]);
    }
    private static int setP(List<Interval> intervalList, int pos) {
        for (int i = pos - 1; i >= 0; i--) {
            if (intervalList.get(i).getEndTime() <= intervalList.get(pos).getStartTime()) {
                return i;
            }
        }
        return -1;
    }
}
