package algorithm.DpQuestion.LCSLength;

public class SolutionForLeetcode {
    public int longestCommonSubsequence(String text1, String text2) {
        char c1[] = text1.toCharArray();
        char c2[] = text2.toCharArray();
        int path[][] = new int[c1.length+1][c2.length+1];
        int length[][] = new int[c1.length+1][c2.length+1];
        lengthLcs(c1,c2,path,length);
        return length[c1.length][c2.length];
    }

    /**
     * @param x
     * @param y
     * @param path   用于路径记录
     * @param length 每个对应的长度
     */
    public void lengthLcs(char x[], char y[], int path[][], int length[][]) {
        //初始化第一行第一列为0
        int m = x.length;
        int n = y.length;
        for (int i = 0; i <= m; i++) length[i][0] = 0;
        for (int i = 0; i <= n; i++) length[0][i] = 0;
        //开始动态规划
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (x[i] == y[j]) {
                    //注意这里是i+1，因为默认length的0行0列是0。
                    length[i + 1][j + 1] = 1 + length[i][j];
                    path[i + 1][j + 1] = 1;
                } else if (length[i][j + 1] > length[i + 1][j]) {
                    length[i + 1][j + 1] = length[i][j + 1];
                    path[i + 1][j + 1] = 2;
                } else {
                    length[i + 1][j + 1] = length[i + 1][j];
                    path[i + 1][j + 1] = 3;
                }
            }
        }
    }

    public void Lcs(char x[], int i, int j, int path[][]) {
        if (path[i][j] == 1) {
            System.out.println(x[i]);
            Lcs(x, i - 1, j - 1, path);
        } else if (path[i][j] == 2) {
            Lcs(x, i - 1, j, path);
        } else {
            Lcs(x, i, j - 1, path);
        }
    }
}
