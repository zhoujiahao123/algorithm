package algorithm.top100medium.UniquePaths;

/**
 * 超时，不通过
 */
public class Solution {
    int total;

    public int uniquePaths(int m, int n) {
        boolean[][] visited = new boolean[m][n];
        dp(visited, 0, 0);
        return total;
    }

    public void dp(boolean[][] visited, int i, int j) {
        visited[i][j] = true;
        if (i == visited.length - 1 && j == visited[0].length - 1) {
            total++;
            return;
        }
        if (j + 1 < visited[0].length && !visited[i][j + 1]) {
            dp(visited, i, j + 1);
            visited[i][j + 1] = false;
        }
        if (i + 1 < visited.length && !visited[i + 1][j]) {
            dp(visited, i + 1, j);
            visited[i + 1][j] = false;
        }
    }
}
