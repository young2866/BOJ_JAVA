import java.util.*;

import static java.lang.Math.min;


public class Main {

    static int N;
    static int L;
    static long I;

    static long[][] dp;
    static String ans = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();
        I = sc.nextLong();

        dp = new long[N+1][N+1];
        dp[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        skip(N, L, I);
        System.out.println(ans);

    }

    public static void skip(int N, int L, long I) {
        if (N == 0) return;
        if (L == 0) {
            for (int i = 0; i < N; i++) {
                ans += '0';
            }
            return;
        }

        long pivot = 0;
        for (int i = 0; i <= L; i++) {
            pivot += dp[N - 1][i];
        }
        if (pivot >= I) {
            ans += '0';
            skip(N-1, L, I);
        } else {
            ans += '1';
            skip(N-1, L - 1, I-pivot);
        }
    }

}


