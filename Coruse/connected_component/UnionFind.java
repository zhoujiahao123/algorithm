package algorithm.Coruse.connected_component;

import java.util.Arrays;

public class UnionFind {
    private int[] id;//id[pos]��ʾpos��Ӧ�ĸ��ڵ�
    private int[] sz;//sz[pos]��ʾpos��Ϊ���ڵ�Ľ������
    private int count;//��ͨ��֧������

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
    //�жϽ��P��q�Ƿ�����ͬһ��֧
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    //���Ҳ�����ȡ��p��Ӧ�ĸ��ڵ�
    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }
    //�ϲ�����
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        //���������С�ĸ��ڵ����ӵ���ĸ��ڵ�
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
