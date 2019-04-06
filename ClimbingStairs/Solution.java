package ClimbingStairs;

import java.util.Scanner;

class Solution {
    //结果已算出来的组数
    int vis[];
    //结果数组
    int ans[];
    //数组长度,这里直接表示为楼梯阶数
    int length = 0;
    Scanner input = new Scanner(System.in);
    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 0) return 1;
        if(vis[n] == 1){
            return ans[n];
        }
        vis[n] = 1;
        return ans[n] = climbStairs(n-1) + climbStairs(n-2);
    }
    public void init(){
        length = input.nextInt();
        vis = new int[length+1];
        ans = new int[length+1];
    }
    public static void main(String []args){
        Solution sl = new Solution();
        sl.init();
        System.out.println(sl.climbStairs(3));
    }
}