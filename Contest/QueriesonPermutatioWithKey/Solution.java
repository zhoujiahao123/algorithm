package algorithm.Contest.QueriesonPermutatioWithKey;

class Solution {
    public static void main(String[] args) {
        int a[] = {3,1,2,1};
        new Solution().processQueries(a,5);
    }
    public int[] processQueries(int[] queries, int m) {
        //�������
        int[] res = new int[queries.length];
        //��������ָ��
        int count = 0;
        //����p
        int[] p = new int[m];
        for(int i = 0;i<m;i++) p[i] = i+1;
        //����queries
        for(int i = 0;i<queries.length;i++){
            int num = queries[i];//ȡ����Ҫ������p�����е���.
            //�����Ľ����p����
            int[] newP = new int[m];
            newP[0] = num;
            int k = 1;//newP��ָ��
            for(int j = 0;j<m;j++){
                if(p[j]!=num){
                    newP[k++] = p[j];
                }else{
                    res[count++] = j;
                }
            }
            p = newP;
        }
        return res;
    }
}