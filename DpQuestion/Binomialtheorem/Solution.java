package algorithm.DpQuestion.Binomialtheorem;

/**
 * ��c(n,k)��ֵ��
 * ת�ƹ�ʽ��c(n,k) = c(n-1,k-1) + c(n-1 , k)
 */
public class Solution {
    public static void main(String[] args) {
        int n = 7, k = 4;
        int c[][] = new int[n+1][k+1];
        //��ʼ������
        for (int i = 0; i < n + 1; i++) {
            //����С�����ǵ���С������Ϊ��k������ò���
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (i == j || j == 0) {
                    c[i][j] = 1;
                } else {
                    c[i][j] = 0;
                }
            }
        }
        System.out.println(solve(n,k,c,new int[n+1][k+1]));
    }

    public static int solve(int n, int k, int c[][], int ans[][]) {
        if (k == n || k == 0) {
            return 1;
        }
        return ans[n][k] = solve(n - 1, k - 1, c, ans) + solve(n - 1, k, c, ans);
    }
}
