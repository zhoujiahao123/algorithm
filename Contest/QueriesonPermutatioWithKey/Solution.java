package algorithm.Contest.QueriesonPermutatioWithKey;

class Solution {
    public static void main(String[] args) {
        int a[] = {3,1,2,1};
        new Solution().processQueries(a,5);
    }
    public int[] processQueries(int[] queries, int m) {
        //结果数组
        int[] res = new int[queries.length];
        //结果数组的指针
        int count = 0;
        //创建p
        int[] p = new int[m];
        for(int i = 0;i<m;i++) p[i] = i+1;
        //遍历queries
        for(int i = 0;i<queries.length;i++){
            int num = queries[i];//取出需要操作的p数组中的数.
            //创建改进后的p数组
            int[] newP = new int[m];
            newP[0] = num;
            int k = 1;//newP的指针
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