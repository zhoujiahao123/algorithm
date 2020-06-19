package algorithm.DFS.WordSearch;

class Solution {
    public static void main(String[] args) {
        char[][] a = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        String word = "ABCESEEEFS";
        new Solution().exist(a,word);
    }
    boolean flag = false;
    public boolean exist(char[][] board, String word) {
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                if(board[i][j] == word.charAt(0)){
                    try{
                        boolean[][] isVisited = new boolean[board.length][board[0].length];
                        dfs(board,isVisited,word,1,i,j);
                    }catch(Exception e){
                        return flag;
                    }
                }
            }
        }
        return flag;
    }
    public void dfs(char[][] board,boolean[][] isVisited,String word,int pos,int i,int j) throws Exception{
        if(isVisited[i][j]) return;
        isVisited[i][j] = true;
        if(pos == word.length()){
            flag = true;
            throw new Exception();
        }
        if(i+1<board.length&&!isVisited[i+1][j]&&word.charAt(pos)==board[i+1][j]){
            dfs(board,isVisited,word,pos+1,i+1,j);

        }
        if(j+1<board[i].length&&!isVisited[i][j+1]&&word.charAt(pos)==board[i][j+1]){
            dfs(board,isVisited,word,pos+1,i,j+1);
        }
        if(i-1>=0&&!isVisited[i-1][j]&&word.charAt(pos)==board[i-1][j]){
            dfs(board,isVisited,word,pos+1,i-1,j);
        }
        if(j-1>=0&&!isVisited[i][j-1]&&word.charAt(pos)==board[i][j-1]){
            dfs(board,isVisited,word,pos+1,i,j-1);
        }
        isVisited[i][j] = false;
    }
}