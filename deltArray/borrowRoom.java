package algorithm.deltArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class borrowRoom {
    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public void init(InputStream inputStream) {
            reader = new BufferedReader(new InputStreamReader(inputStream));
            tokenizer = new StringTokenizer("");
        }

        public String next() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }

    public static void main(String[] args) throws IOException {
        InputReader reader = new InputReader();
        reader.init(System.in);
        int days = reader.nextInt();
        int orders = reader.nextInt();
        int[] couldBorrow = new int[days];
        int[] diff = new int[days];
        for (int i = 0; i < days; i++) {
            couldBorrow[i] = reader.nextInt();
        }
        for (int i = 1; i <= orders; i++) {
            int d = reader.nextInt();
            int startTime = reader.nextInt() - 1;//这里-1为了直接能索引数组
            int endTime = reader.nextInt();
            diff[startTime] += d;
            if (endTime < diff.length) diff[endTime] -= d;
            int[] sum = new int[days];
            sum[0] = diff[0];
            for (int j = 1; j < diff.length; j++) {
                if (sum[i] > couldBorrow[i]) {
                    System.out.println("-1");
                    System.out.println(i);
                }
                sum[j] = sum[j - 1] + diff[j];
            }
        }
        System.out.println("0");
    }
}
