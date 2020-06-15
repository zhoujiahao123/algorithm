package algorithm.DpQuestion.StudentAttendanceRecordII;

import java.util.ArrayList;

public class SolutionWithDp {
    public int checkRecord(int n) {
        int m = 1000000007;
        int[]
                A = new int[n + 1],
                P = new int[n + 1],
                L = new int[n + 1],
                noAP = new int[n + 1],
                noAL = new int[n + 1];
        A[1] = 1;
        P[1] = 1;
        L[1] = 1;
        noAP[1] = 1;
        noAL[1] = 1;
        for (int i = 2; i <= n; i++) {

            A[i] = (noAL[n - 1]%m + noAP[n - 1]%m)%m;
            P[i] = (A[i - 1]%m + P[i - 1]%m + L[i - 1]%m)%m;
            L[i] = (A[i - 1]%m + P[i - 1]%m + A[i - 2]%m + P[i - 2]%m)%m;
            noAP[i] = (noAP[i - 1]%m + noAL[i - 1]%m)%m;
            noAL[i] = (noAP[i - 1]%m + noAP[i - 2]%m)%m;
        }
        return (A[n] + P[n] + L[n])%m;
    }
}
