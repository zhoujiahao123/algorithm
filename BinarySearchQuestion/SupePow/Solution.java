package algorithm.BinarySearchQuestion.SupePow;

class Solution {
    public static void main(String[] args) {
        new Solution().superPow(78267,new int[]{2,0,0,0,0});
    }
    public int superPow(int a, int[] b) {
        int sum = 1;
        a = a%1337;
        for(int i = b.length-1;i>=0;--i){
            int y = b[i];
            y = y*(int)Math.pow(10,b.length-1-i);
            int res = pow(a,y);
            sum = (sum * res)%1337;
        }
        return sum;
    }
    public int pow(int x,int y){
        if(y == 1) return x;
        if(y == 0) return 1;
        int res = pow(x,y/2);
        return y%2==1?(((res*res)%1337)*x)%1337:((res)*(res))%1337;
    }
}
