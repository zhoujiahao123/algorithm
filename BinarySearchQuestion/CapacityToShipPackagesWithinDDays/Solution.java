package algorithm.BinarySearchQuestion.CapacityToShipPackagesWithinDDays;

class Solution {
    public static void main(String[] args) {
        new Solution().shipWithinDays(new int[]{3,2,2,4,1,4},3);
    }
    public int shipWithinDays(int[] weights, int D) {
        int max = 0;
        for(int i :weights){
            max += i;
        }
        int left = 1,right = 20;
        while(left<right){
            int mid = left + (right - left)/2;
            int capicity = mid;
            int count = 0;
            for(int i = 0;i<weights.length;i++){
                if(capicity - weights[i]>=0){
                    capicity -= weights[i];
                }else{
                    count++;
                    i--;
                    capicity = mid;
                    continue;
                }
            }
            if(capicity != mid) count++;
            if(count > D){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
