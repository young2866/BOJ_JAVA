import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {
    static int[] dp;
    static int[]arr;
    static public class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    static int N;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        arr = new int[N + 1];
        dp = new int[N + 1];
        for (int i = 0; i < N; i++) {
            arr[i + 1] = sc.nextInt();
        }
        dp[0] = 1;
        for (int i = N; i > 0; i--) {
            DP(i);
        }

        int MAX = 0;
        for (int i = 1; i <= N; i++) {
            MAX = max(MAX, dp[i]);
        }
        System.out.println(N - MAX);



   }

    static public int DP(int x) {
        if (dp[x] == 0) {
            dp[x] = 1;
            for (int i = x - 1; i > 0; i--) {
                if (arr[x] > arr[i]) {
                    dp[x] = max(dp[x], DP(i) + 1);
                }
            }
        }
        return dp[x];
    }

}
