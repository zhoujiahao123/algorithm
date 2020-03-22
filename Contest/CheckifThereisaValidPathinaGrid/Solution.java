package algorithm.Contest.CheckifThereisaValidPathinaGrid;

public class Solution {
    int res = 0;

    public boolean hasValidPath(int[][] grid) {
        dfs(0, 0, grid, new boolean[grid.length][grid[0].length]);
        return res == 1;
    }

    public void dfs(int i, int j, int[][] grid, boolean[][] isVisited) {
        isVisited[i][j] = true;
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            res = 1;
        }
        if (grid[i][j] == 1) {
            if (j - 1 >= 0 && !isVisited[i][j - 1] &&
                    (grid[i][j - 1] == 4 || grid[i][j - 1] == 6 || grid[i][j - 1] == 1)) {
                dfs(i, j - 1, grid, isVisited);
            }
            if (j + 1 < grid[0].length && !isVisited[i][j + 1] &&
                    (grid[i][j + 1] == 3 || grid[i][j + 1] == 5 || grid[i][j + 1] == 1)) {
                dfs(i, j + 1, grid, isVisited);
            }
        } else if (grid[i][j] == 2) {
            if (i - 1 >= 0 && !isVisited[i - 1][j] &&
                    (grid[i - 1][j] == 4 || grid[i - 1][j] == 3 || grid[i - 1][j] == 2)) {
                dfs(i - 1, j, grid, isVisited);
            }
            if (i + 1 < grid.length && !isVisited[i + 1][j] &&
                    (grid[i + 1][j] == 6 || grid[i + 1][j] == 5 || grid[i + 1][j] == 2)) {
                dfs(i + 1, j, grid, isVisited);
            }
        } else if (grid[i][j] == 3) {
            if (j - 1 >= 0 && !isVisited[i][j - 1] &&
                    (grid[i][j - 1] == 1 || grid[i][j - 1] == 6 || grid[i][j - 1] == 4)) {
                dfs(i, j - 1, grid, isVisited);
            }
            if (i + 1 < grid.length && !isVisited[i + 1][j] &&
                    (grid[i + 1][j] == 6 || grid[i + 1][j] == 5 || grid[i + 1][j] == 2)) {
                dfs(i + 1, j, grid, isVisited);
            }
        } else if (grid[i][j] == 4) {
            if (i + 1 < grid.length && !isVisited[i + 1][j] &&
                    (grid[i + 1][j] == 6 || grid[i + 1][j] == 5 || grid[i + 1][j] == 2)) {
                dfs(i + 1, j, grid, isVisited);
            }
            if (j + 1 < grid[0].length && !isVisited[i][j + 1] &&
                    (grid[i][j + 1] == 3 || grid[i][j + 1] == 5 || grid[i][j + 1] == 1)) {
                dfs(i, j + 1, grid, isVisited);
            }
        } else if (grid[i][j] == 5) {
            if (i - 1 >= 0 && !isVisited[i - 1][j] &&
                    (grid[i - 1][j] == 4 || grid[i - 1][j] == 3 || grid[i - 1][j] == 2)) {
                dfs(i - 1, j, grid, isVisited);
            }
            if (j - 1 >= 0 && !isVisited[i][j - 1] &&
                    (grid[i][j - 1] == 1 || grid[i][j - 1] == 6 || grid[i][j - 1] == 4)) {
                dfs(i, j - 1, grid, isVisited);
            }
        } else {
            if (i - 1 >= 0 && !isVisited[i - 1][j] &&
                    (grid[i - 1][j] == 4 || grid[i - 1][j] == 3 || grid[i - 1][j] == 2)) {
                dfs(i - 1, j, grid, isVisited);
            }
            if (j + 1 < grid[0].length && !isVisited[i][j + 1] &&
                    (grid[i][j + 1] == 3 || grid[i][j + 1] == 5 || grid[i][j + 1] == 1)) {
                dfs(i, j + 1, grid, isVisited);
            }
        }
    }
}
