import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {
    static boolean[][] dp;
    static int[] arr;
    static public class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
    static int N;
    static int M;

    static int[] dx = {1, 0};
    static int[] dy = {0, 1};


    static Queue<Pair> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int S = sc.nextInt();
        M = sc.nextInt();

        dp = new boolean[N + 1][1001];
        arr = new int[N + 1];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        DP(0, S);
        int ans = -1;
        for (int i = 0; i <= M; i++) {
            if (dp[N][i]) {
                ans = i;
            }
        }
        System.out.println(ans);
   }

    public static void DP(int a, int b) {
        if (a> N) {
            return;
        }
        if(dp[a][b])
            return;
        dp[a][b] = true;
        if (b + arr[a] <= M) {
            DP(a + 1, b + arr[a]);
        }
        if (b - arr[a] >= 0) {
            DP(a + 1, b - arr[a]);
        }

        return;
    }

}
