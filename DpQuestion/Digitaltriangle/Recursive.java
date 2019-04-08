package Digitaltriangle;

import java.util.Scanner;

/**
 * 以递归形式实现数字三角形问题，
 * 5
 * 7
 * 3 8
 * 8 1 0
 * 2 7 4 4
 * 4 5 2 6 5
 */
public class Recursive {
    int graph[][] = new int[50][50];
    //用一个数组来装结果，例如： ans[1][1]代表从1,1开始的最大结果
    int ans[][] = new int[50][50];
    Scanner input = new Scanner(System.in);
    //构建图
    public void bulidGraph(int len) {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                graph[i][j] = input.nextInt();
            }
        }
    }
    //递归实现求最大和问题，直接使用递归的问题在于会出现很多遍历过的结点被再次遍历。
    public int solve(int i,int j ,int len){
        //选择(i+1,j)和(i+1,j+1)中大的一个数
        return graph[i][j] + (i == len?0:Math.max(solve(i+1,j,len),solve(i+1,j+1,len)));
    }
    //重载方法，利用有记忆的递归实现最大和问题，时间会被减少
    public int solve(int i,int j ,int len ,int [][] vis){
        //用一个vis数组来标志该节点是否已经访问过了，如果访问过了，直接给出当时给出的答案即可
        if(vis[i][j] == 1) return ans[i][j];
        //区别在于用一个ans数组存储了某一个点已经算出来的结果
        return ans[i][j] = graph[i][j] + (i == len?0:Math.max(solve(i+1,j,len,vis),solve(i+1,j+1,len,vis)));
    }
    //利用递推解决
    public void solve(int len){
        //递推的关键在于要找到边界条件
        for(int k = 0;k<len;k++) ans[len-1][k] =graph[len-1][k];
        //注意开始的位置
        for(int i = len-2;i>=0;i--){
            for(int j = 0;j<=i;j++){
                //因为i是逆序，所以才能保证i+1已经被求出来了
                ans[i][j] = graph[i][j] + Math.max(ans[i+1][j],ans[i+1][j+1]);
            }
        }
    }
    public static void main(String []args){
        Recursive rc = new Recursive();
        int len = rc.input.nextInt();
        rc.bulidGraph(len);
        int vis[][] = new int[50][50];
        rc.solve(len);
        System.out.println(rc.ans[0][0]);
    }
}
