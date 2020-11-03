package algorithm.ByteDance.xiaotuandezhuangshiwu;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int a[] = {5,5,5,4,5,3,5,1};
        System.out.println(fun(8,2,4,a));

    }
    public static int fun(int n, int m, int k, int[] ai) {
        List<Integer> res = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (ai[i] >= k) {
                count++;
            } else {
                if (count >= m) {
                    res.add(count);
                }
                count=0;
            }
        }
        if (count >= m) {
            res.add(count);
        }
        int ans = 0;
        for (int i = 0; i < res.size(); i++) {
            ans += 1 + res.get(i) - m;
        }
        return ans;
    }
}
