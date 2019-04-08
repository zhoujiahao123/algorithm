package DAGModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 嵌套矩形问题。有n个矩形，每个矩形可以用两个整数a、b描述，表示它的长和宽。矩
 * 形X(a,b)可以嵌套在矩形Y(c, d)中，当且仅当a＜c，b＜d，或者b＜c，a＜d（相当于把矩
 * 形X旋转90°）。例如，(1, 5)可以嵌套在(6, 2)内，但不能嵌套在(3, 4)内。你的任务是选出尽
 * 量多的矩形排成一行，使得除了最后一个之外，每一个矩形都可以嵌套在下一个矩形内。如
 * 果有多解，矩形编号的字典序应尽量小。
 */
public class Solution {
    Scanner input = new Scanner(System.in);
    //用来装矩形对象
    List<Rectangle> list = new ArrayList<>();
    //数据对象矩形的个数
    int length = 0;
    //连接图
    int G[][];
    //访问数组
    int vis[];
    //结果数组
    int ans[];

    //建图，G[i][j]表示i可被J包含
    public void buildGraph() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                //如果不是本身且i的x与y都小于j的x与y
                if (i != j && list.get(i).getX() < list.get(j).getX() && list.get(i).getY() < list.get(j).getY()) {
                    G[i][j] = 1;
                }
            }
        }
    }

    //初始化数据，把矩形数据都装进来
    public void init() {
        //输入数据数量
        length = input.nextInt();
        int x;
        int y;
        //添加矩形到集合中
        for (int i = 0; i < length; i++) {
            x = input.nextInt();
            y = input.nextInt();
            //确保x一定大于y
            if (x < y) {
                int temp = x;
                x = y;
                y = temp;
            }
            list.add(new Rectangle(x, y));
        }
        G = new int[length][length];
        vis = new int[length];
        ans = new int[length];
    }

    //开始寻找最长路径,以递归方式进行
    public int solve(int i) {
        //如果已经得出了结果
        if (vis[i] == 1) {
            return ans[i];
        }
        vis[i] = 1;
        ans[i] = 1;
        for (int j = 0; j < length; j++) {
            if (G[i][j] == 1) {
                ans[i] = Math.max(ans[i], solve(j) + 1);
            }
        }
        return ans[i];
    }

    //输出编号,仅输出字典序最小的那种方案
    public void print(int i) {
        System.out.print(i+"-");
        for (int j = 0; j < length; j++)
            if (G[i][j] == 1 && ans[i] == ans[j] + 1){
                print(j);break;
            }
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        sl.init();
        sl.buildGraph();
        System.out.println(sl.solve(0));
        sl.print(0);
    }
}
