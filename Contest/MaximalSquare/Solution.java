package algorithm.Contest.MaximalSquare;

/**
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 1 1 1
 * <p>
 * 1 1 1 0 0
 * 1 1 1 0 0
 * 1 1 1 1 1
 * 0 1 1 1 1
 * 0 1 1 1 1
 * 0 1 1 1 1
 * <p>
 *     0 0 0 0 0
 *     1 1 1 1 1
 *     1 1 1 1 0
 *     0 1 1 1 0
 *     1 1 0 1 0
 *     0 1 1 0 1
 *
 *
 */
class Solution {
    public static void main(String[] args) {
        char[][] matrix = {{'0', '1', '1', '0', '1'}, {'1', '1', '0', '1', '0'}, {'0', '1', '1', '1', '0'}, {'1', '1', '1', '1', '0'},{'1', '1', '1', '1', '1'},{'0', '0', '0', '0', '0'}};

        System.out.println(new Solution().maximalSquare(matrix));
    }

    public int maximalSquare(char[][] matrix) {
        int res = 0;
        //dp:表示以当前字符为矩阵右上角能组成的正方形的最大边长
        if(matrix.length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            if (dp[i][0] == 1) res = 1;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
            if (dp[0][i] == 1) res = 1;
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    res = Math.max(res,1);
                    if (dp[i - 1][j] == dp[i][j - 1] && dp[i - 1][j] != 0) {
                        int gap = dp[i - 1][j];
                        if (matrix[i - gap][j - gap] == '1') {
                            dp[i][j] = 1 + gap;
                            res = Math.max(res, dp[i][j]);

                        } else {
                            dp[i][j] = dp[i - 1][j];
                        }
                    } else if ((dp[i - 1][j] != 0 && dp[i][j - 1] != 0) && dp[i - 1][j] != dp[i][j - 1]) {
                        dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                        res = Math.max(res, dp[i][j]);
                    } else {
                        dp[i][j] = 1;
                    }
                }
            }
        }
        return res * res;
    }
}
