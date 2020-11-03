package algorithm.DFS.SudokuSolver;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private boolean[][] row = new boolean[9][9];//行
    private boolean[][] column = new boolean[9][9];//列
    private boolean[][][] block = new boolean[3][3][9];//每个块，（3，3）表示每个快的位置
    private List<int[]> space = new ArrayList<>();
    private boolean valid = false;
    public void solveSudoku(char[][] board) {
        init(board);
        dfs(0,board);
    }

    private void init(char[][] board){
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] == '.'){
                    space.add(new int[]{i,j});
                }else{
                    int num = board[i][j] - '0' - 1;
                    row[i][num] = column[j][num] = block[i/3][j/3][num] = true;
                }
            }
        }

    }

    private void dfs(int pos,char[][] board){
        if(pos == space.size()){
            valid = true;
            return;
        }
        int[] spot = space.get(pos);
        int i = spot[0],j = spot[1];
        for(int k = 0;k<9 && !valid;k++){
            if(!row[i][k] && !column[j][k] && !block[i/3][j/3][k]){
                row[i][k] = column[j][k] = block[i/3][j/3][k] = true;
                board[i][j] = (char)(k + 1 + '0');
                dfs(pos + 1,board);
                row[i][k] = column[j][k] = block[i/3][j/3][k] = false;
            }
        }
    }
}