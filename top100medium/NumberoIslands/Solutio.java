package algorithm.top100medium.NumberoIslands;

public class Solutio {
    public int numIslands(char[][] grid) {
        int total = 0;
        if (grid.length == 0) return 0;
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    dfs(grid, isVisited, i, j);
                    total++;
                }
            }
        }
        return total;
    }

    public void dfs(char[][] grid, boolean[][] isVisited, int i, int j) {
        isVisited[i][j] = true;
        if (grid[i][j] == '0') return;
        if (j + 1 < grid[0].length && !isVisited[i][j + 1]) {
            dfs(grid, isVisited, i, j + 1);
        }
        if (i + 1 < grid.length && !isVisited[i + 1][j]) {
            dfs(grid, isVisited, i + 1, j);
        }
        if (i - 1 >= 0 && !isVisited[i - 1][j]) {
            dfs(grid, isVisited, i - 1, j);
        }
        if (j - 1 >= 0 && !isVisited[i][j - 1]) {
            dfs(grid, isVisited, i, j - 1);
        }
    }
}
