package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InputReader {
    BufferedReader reader;
    StringTokenizer tokenizer;
    public void init(InputStream inputStream){
        reader = new BufferedReader(new InputStreamReader(inputStream));
        tokenizer = new StringTokenizer("");
    }
    public String next() throws IOException{
        while (!tokenizer.hasMoreTokens()){
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }
    public int nextInt() throws IOException{
        return Integer.parseInt(next());
    }
    public double nextDouble() throws IOException{
        return Double.parseDouble(next());
    }
}
