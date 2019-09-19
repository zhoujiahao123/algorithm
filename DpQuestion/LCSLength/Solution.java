package algorithm.DpQuestion.LCSLength;

public class Solution {
    public static void main(String[] args) {
        char x[] = {0,'A','B','C','B','D'};
        char y[] = {0,'B','D','C','A','B'};
        int m = x.length;
        int n = y.length;
        int length[][] = new int[m][n];
        int path[][] = new int[m][n];
        LCSLength(m-1,n-1,x,y,length,path);
        LCS(m-1,n-1,x,path);
    }

    /**
     * @param m      x序列长度
     * @param n      y序列长度
     * @param x
     * @param y
     * @param length length[i][j]代表的是x序列前i个字符与y序列前j个字符的最长子序列长度
     * @param path   存放当前最长子序列的路径，为1代表当前的字符在最长子序列中，为2代表最长子序列来自前一行，为3代表来自前一列
     */
    public static void LCSLength(int m, int n, char x[], char y[], int length[][], int path[][]) {
        for (int i = 0; i <= m; i++) length[i][0] = 0;
        for (int j = 0; j <= n; j++) length[0][j] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i] == y[j]) {
                    length[i][j] = length[i - 1][j - 1] + 1;
                    path[i][j] = 1;
                } else if (length[i - 1][j] >= length[i][j - 1]) {
                    length[i][j] = length[i - 1][j];
                    path[i][j] = 2;
                } else {
                    length[i][j] = length[i][j - 1];
                    path[i][j] = 3;
                }
            }
        }
    }

    public static void LCS(int i, int j, char x[], int path[][]) {
        if (i == 0 || j == 0) {
            return;
        }
        if (path[i][j] == 1) {
            LCS(i - 1, j - 1, x, path);
            System.out.print(x[i]);
        } else if (path[i][j] == 2) {
            LCS(i-1,j,x,path);
        }else {
            LCS(i,j-1,x,path);
        }
    }
}
