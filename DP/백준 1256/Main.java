import java.util.*;

import static java.lang.Math.min;


public class Main {

    static int N;
    static int M;
    static int K;
    static String s = "";
    static long[][] dp;
    static int MAX = Integer.MAX_VALUE;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        dp = new long[N + 1][M + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }

        if (K > Find(N, M)) {
            System.out.println("-1");
        } else {
            track(N, M, K-1);
            System.out.println(s);
        }

    }

    public static long Find(int n, int m) {

        if(n == 0 || m == 0) return 1;
        if(dp[n][m] != -1) return dp[n][m];

        return dp[n][m] = Math.min(Find(n - 1, m) + Find(n, m - 1), MAX);
    }

    public static void track(int n, int m, long k) {
        if (n == 0) {
            for(int i = 0; i < m; i++) s+='z';
            return;
        }
        if (m == 0) {
            for(int i = 0; i < n; i++) s+='a';
            return;
        }
        long pivot = Find(n-1, m);
        if (pivot > k) {
            s += 'a';
            track(n - 1, m, k);
        }
        else{
            s += 'z';
            track(n,m-1,k-pivot);
        }
    }


}

