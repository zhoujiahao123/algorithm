package algorithm.Coruse.connected_component;

import java.util.Arrays;

public class UnionFind {
    private int[] id;//id[pos]表示pos对应的根节点
    private int[] sz;//sz[pos]表示pos作为根节点的结点数量
    private int count;//连通分支的数量

    public UnionFind(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
        sz = new int[N];
        Arrays.fill(sz, 1);
    }

    public int getCount() {
        return count;
    }
    //判断结点P，q是否属于同一分支
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    //查找操作，取得p对应的根节点
    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }
    //合并操作
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        //将结点数量小的根节点链接到大的根节点
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }
}
